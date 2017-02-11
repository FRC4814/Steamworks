package com.team4814.frc2017.commands;

import com.team4814.frc2017.InputManager;
import com.team4814.frc2017.Robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ClimbCommand extends Command
{
	public ClimbCommand()
	{
		requires(Robot.climber);
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
		double speed = InputManager.driverController.getTriggerAxis(Hand.kRight);
		
		InputManager.driverController.setRumble(RumbleType.kRightRumble, speed);
		
		Robot.climber.climb(speed);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		return false;
	}

	// Called once after isFinished returns true
	protected void end()
	{
		Robot.climber.climb(0.0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{
		end();
	}
}
