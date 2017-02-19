package com.team4814.frc2017.autocommands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class WaitCommand extends Command
{
	private double seconds;
	private Timer timer;

	public WaitCommand(double seconds)
	{
		this.seconds = seconds;
		timer = new Timer();
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
		timer.start();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		return timer.get() >= seconds;
	}

	// Called once after isFinished returns true
	protected void end()
	{
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{
		end();
	}
}
