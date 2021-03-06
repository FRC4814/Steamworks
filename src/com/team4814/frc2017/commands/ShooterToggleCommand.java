package com.team4814.frc2017.commands;

import com.team4814.frc2017.Robot;
import com.team4814.frc2017.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShooterToggleCommand extends Command
{
	private boolean toggle;

	public ShooterToggleCommand(boolean toggle)
	{
		this.toggle = toggle;
		requires(Robot.shooter);
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
			Robot.shooter.setSpeed(Shooter.shooterSpeed.get());
		}
		else
		{
			Robot.shooter.setSpeed(0.0);
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		return false;
	}

	// Called once after isFinished returns true
	protected void end()
	{
		Robot.shooter.setSpeed(0.0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{
		end();
	}
}
