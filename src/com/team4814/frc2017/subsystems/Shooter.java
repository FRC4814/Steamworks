package com.team4814.frc2017.subsystems;

import com.team4814.frc2017.RobotMap;
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
public class Shooter extends Subsystem
{
	public static final DashboardVariable<Double> sooterDPP = new DashboardVariable<>("ShooterDPP", 0.192);
	public static final DashboardVariable<Double> shooterSpeed = new DashboardVariable<>("Shooter Speed", 0.785);

	public Encoder shooterEncoder;

	protected VictorSP mainMotor;

	public Shooter()
	{
		mainMotor = new VictorSP(RobotMap.SHOOTER_MOTOR);
		mainMotor.setInverted(true);

		shooterEncoder = new Encoder(RobotMap.LEFT_MOTOR_ENCODERS[0], RobotMap.LEFT_MOTOR_ENCODERS[1], false,
				EncodingType.k4X);

		shooterEncoder.setMaxPeriod(.1);
		shooterEncoder.setMinRate(10);
		shooterEncoder.setDistancePerPulse(0.192); // cm/pulse => 20 pulses/rev x 8.75 gear on a 4" dia wheel
		shooterEncoder.setReverseDirection(true);
		shooterEncoder.setSamplesToAverage(10);

		LiveWindow.addSensor(this.getName(), "Shooter Motor", mainMotor);
		LiveWindow.addSensor(this.getName(), "Shooter Encoder", shooterEncoder);
	}

	public void resetEncoders()
	{
		shooterEncoder.reset();
	}

	public void initDefaultCommand()
	{
		// setDefaultCommand(new MySpecialCommand());
	}

	public void setSpeed(double speed)
	{
		shooterEncoder.setDistancePerPulse(sooterDPP.get());

		SmartDashboard.putNumber("Shooter Encoder", shooterEncoder.get());
		mainMotor.set(speed);
	}

	public double getShooterDistance()
	{
		return shooterEncoder.getDistance();
	}
}
