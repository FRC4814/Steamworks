package com.team4814.frc2017.subsystems;

import com.team4814.frc2017.RobotMap;
import com.team4814.frc2017.commands.HaloDriveCommand;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTrain extends Subsystem
{
	protected Victor[] leftMotors;
	protected Victor[] rightMotors;

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
	}

	public void initDefaultCommand()
	{
		setDefaultCommand(new HaloDriveCommand());
	}
	
	public void drive(double leftSpeed, double rightSpeed)
	{
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
