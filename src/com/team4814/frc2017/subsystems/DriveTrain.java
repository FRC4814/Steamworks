package com.team4814.frc2017.subsystems;

import com.team4814.frc2017.RobotMap;
import com.team4814.frc2017.commands.HaloDriveCommand;
import com.team4814.frc2017.utils.DashboardVariable;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTrain extends Subsystem
{
	public static final DashboardVariable<Double> leftDPP = new DashboardVariable<>("LeftDPP", 0.197);
	public static final DashboardVariable<Double> rightDPP = new DashboardVariable<>("RightDPP", 0.192);

	protected VictorSP[] leftMotors;
	protected VictorSP[] rightMotors;

	public Encoder leftEncoder;
	public Encoder rightEncoder;

	public DriveTrain()
	{
		leftMotors = new VictorSP[RobotMap.LEFT_MOTORS.length];
		for (int i = 0; i < leftMotors.length; i++)
		{
			leftMotors[i] = new VictorSP(RobotMap.LEFT_MOTORS[i]);
		}

		rightMotors = new VictorSP[RobotMap.RIGHT_MOTORS.length];
		for (int i = 0; i < rightMotors.length; i++)
		{
			rightMotors[i] = new VictorSP(RobotMap.RIGHT_MOTORS[i]);
			rightMotors[i].setInverted(true);
		}

		leftEncoder = new Encoder(RobotMap.LEFT_MOTOR_ENCODERS[0], RobotMap.LEFT_MOTOR_ENCODERS[1], false,
				EncodingType.k4X);
		rightEncoder = new Encoder(RobotMap.RIGHT_MOTOR_ENCODERS[0], RobotMap.RIGHT_MOTOR_ENCODERS[1], true,
				EncodingType.k4X);

		leftEncoder.setMaxPeriod(.1);
		leftEncoder.setMinRate(10);
		leftEncoder.setDistancePerPulse(0.192); // cm/pulse => 20 pulses/rev x 8.75 gear on a 4" dia wheel
		leftEncoder.setReverseDirection(true);
		leftEncoder.setSamplesToAverage(10);

		rightEncoder.setMaxPeriod(.1);
		rightEncoder.setMinRate(10);
		rightEncoder.setDistancePerPulse(0.192); // cm/pulse => 20 pulses/rev x 8.75 gear on a 4" dia wheel
		rightEncoder.setReverseDirection(false);
		rightEncoder.setSamplesToAverage(10);

		LiveWindow.addSensor(this.getName(), "Left Encoder", leftEncoder);
		LiveWindow.addSensor(this.getName(), "Right Encoder", rightEncoder);
	}

	public void resetEncoders()
	{
		leftEncoder.reset();
		rightEncoder.reset();
	}

	public void initDefaultCommand()
	{
		setDefaultCommand(new HaloDriveCommand());
	}

	public void drive(double leftSpeed, double rightSpeed)
	{
		leftEncoder.setDistancePerPulse(leftDPP.get());
		rightEncoder.setDistancePerPulse(rightDPP.get());

		SmartDashboard.putNumber("Left Encoder", leftEncoder.get());
		SmartDashboard.putNumber("Right Encoder", rightEncoder.get());

		SmartDashboard.putNumber("Left Encoder D", leftEncoder.getDistance());
		SmartDashboard.putNumber("Right Encoder D", rightEncoder.getDistance());

		setLeftSpeed(leftSpeed);
		setRightSpeed(rightSpeed);
	}

	protected void setLeftSpeed(double speed)
	{
		for (int i = 0; i < leftMotors.length; i++)
			leftMotors[i].set(speed);

		SmartDashboard.putNumber("Drive Left Speed", speed);
	}

	protected void setRightSpeed(double speed)
	{
		for (int i = 0; i < rightMotors.length; i++)
			rightMotors[i].set(speed);

		SmartDashboard.putNumber("Drive Right Speed", speed);
	}

	public double getLeftDistance()
	{
		return leftEncoder.getDistance();
	}

	public double getRightDistance()
	{
		return rightEncoder.getDistance();
	}
}