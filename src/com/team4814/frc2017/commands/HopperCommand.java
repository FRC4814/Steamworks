package com.team4814.frc2017.commands;

import com.team4814.frc2017.Robot;
import com.team4814.frc2017.utils.DashboardVariable;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class HopperCommand extends Command
{
	
	private static DashboardVariable<Double> hopperSpeed = new DashboardVariable<Double>("Hopper Speed", 1.0);

	public HopperCommand()
	{
		requires(Robot.hopper);
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
		Robot.hopper.setSpeed(hopperSpeed.get());
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		return false;
	}

	// Called once after isFinished returns true
	protected void end()
	{
		Robot.hopper.setSpeed(0.0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{
		end();
	}
}
