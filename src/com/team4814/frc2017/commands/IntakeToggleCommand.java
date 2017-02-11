package com.team4814.frc2017.commands;

import com.team4814.frc2017.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeToggleCommand extends Command
{
	private boolean toggle;

	public IntakeToggleCommand(boolean toggle)
	{
		this.toggle = toggle;
		requires(Robot.intake);
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
		if (toggle)
		{
			Robot.intake.setSpeed(1.0);
		} else
		{
			Robot.intake.setSpeed(0.0);
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		return true;
	}

	// Called once after isFinished returns true
	protected void end()
	{
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{
	}
}