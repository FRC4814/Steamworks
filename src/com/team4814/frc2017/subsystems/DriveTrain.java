package com.team4814.frc2017.subsystems;

import com.team4814.frc2017.RobotMap;
import com.team4814.frc2017.commands.HaloDriveCommand;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

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
			leftMotors[i] = new Victor(RobotMap.LEFT_MOTORS[i]);
		
		rightMotors = new Victor[RobotMap.RIGHT_MOTORS.length];
		for (int i = 0; i < rightMotors.length; i++)
			rightMotors[i] = new Victor(RobotMap.RIGHT_MOTORS[i]);
	}

	public void initDefaultCommand()
	{
		setDefaultCommand(new HaloDriveCommand());
	}
	
	public void drive(double leftPower, double rightPower)
	{
		setLeftPower(leftPower);
		setRightPower(rightPower);
	}
	
	protected void setLeftPower(double power)
	{
		for (int i = 0; i < leftMotors.length; i++)
			leftMotors[i].set(power);
	}
	
	protected void setRightPower(double power)
	{
		for (int i = 0; i < rightMotors.length; i++)
			rightMotors[i].set(-power);
	}
}
