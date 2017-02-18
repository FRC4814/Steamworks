package com.team4814.frc2017.subsystems;

import com.team4814.frc2017.RobotMap;
import com.team4814.frc2017.commands.HaloDriveCommand;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTrain extends Subsystem
{
	protected Victor[] leftMotors;
	protected Victor[] rightMotors;
	
	protected Encoder leftEncoder;
	protected Encoder rightEncoder;

	public DriveTrain()
	{
		leftMotors = new Victor[RobotMap.LEFT_MOTORS.length];
		for (int i = 0; i < leftMotors.length; i++)
		{
			leftMotors[i] = new Victor(RobotMap.LEFT_MOTORS[i]);
		}
		
		rightMotors = new Victor[RobotMap.RIGHT_MOTORS.length];
		for (int i = 0; i < rightMotors.length; i++)
		{
			rightMotors[i] = new Victor(RobotMap.RIGHT_MOTORS[i]);
			rightMotors[i].setInverted(true);
		}
		
		leftEncoder = new Encoder(RobotMap.LEFT_MOTOR_ENCODERS[0], RobotMap.LEFT_MOTOR_ENCODERS[1], false, EncodingType.k4X);
		rightEncoder = new Encoder(RobotMap.RIGHT_MOTOR_ENCODERS[0], RobotMap.RIGHT_MOTOR_ENCODERS[1], true, EncodingType.k4X);
		
		LiveWindow.addSensor(this.getName(), "Left Encoder", leftEncoder);
		LiveWindow.addSensor(this.getName(), "Right Encoder", rightEncoder);
	}

	public void initDefaultCommand()
	{
		setDefaultCommand(new HaloDriveCommand());
	}
	
	public void resetEncoders()
	{
		leftEncoder.reset();
		rightEncoder.reset();
	}
	
	public void drive(double leftSpeed, double rightSpeed)
	{
		SmartDashboard.putNumber("Left Encoder", leftEncoder.get());
		SmartDashboard.putNumber("Right Encoder", rightEncoder.get());
		
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
}
