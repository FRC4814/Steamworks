package com.team4814.frc2017.subsystems;

import com.team4814.frc2017.RobotMap;
import com.team4814.frc2017.commands.ClimbCommand;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem
{
	protected Victor mainMotor;
	
	public Climber()
	{
		mainMotor = new Victor(RobotMap.CLIMBER_MOTOR);
	}
	
	public void initDefaultCommand()
	{
		setDefaultCommand(new ClimbCommand());
	}
	
	public void climb(double speed)
	{
		mainMotor.set(speed);
	}
}