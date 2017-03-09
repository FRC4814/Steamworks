package com.team4814.frc2017.autocommands;

import com.team4814.frc2017.Robot;
import com.team4814.frc2017.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoShooter extends Command
{

	private boolean toggle;
	//private static DashboardVariable<Double> shooterSpeed = new DashboardVariable<Double>("Shooter Speed", 1.0);

	public AutoShooter(boolean on)
	{

		requires(Robot.shooter);
		toggle = on;
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{

	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
		if (toggle)
			Robot.shooter.setSpeed(Shooter.shooterSpeed.get());
		else
			Robot.shooter.setSpeed(0.0);
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
		end();
	}
}
