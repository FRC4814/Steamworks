package com.team4814.frc2017.subsystems;

import com.team4814.frc2017.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem
{
	protected Victor mainMotor;

	public Shooter()
	{
		mainMotor = new Victor(RobotMap.SHOOTER_MOTOR);
	}

	public void initDefaultCommand()
	{

		// setDefaultCommand(new MySpecialCommand());
	}

	public void setSpeed(double speed)
	{
		mainMotor.set(speed);
	}
}
