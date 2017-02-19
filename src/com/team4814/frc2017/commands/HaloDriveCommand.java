package com.team4814.frc2017.commands;

import com.team4814.frc2017.InputManager;
import com.team4814.frc2017.Robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class HaloDriveCommand extends Command
{
	public HaloDriveCommand()
	{
		// Use requires() here to declare subsystem dependencies
		requires(Robot.driveTrain);
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
		double forwardPower = -InputManager.driverController.getY(Hand.kLeft);
		double turnMod = InputManager.driverController.getX(Hand.kRight);
		double leftPower = forwardPower;
		double rightPower = forwardPower;

		//System.out.println(forwardPower);

		if (forwardPower < 0) // switches directions when moving backwards
			turnMod *= -1;

		if (turnMod > 0) // reduce power of opposite side by the turnMod
			rightPower *= 1 - Math.abs(turnMod);

		if (turnMod < 0)
			leftPower *= 1 - Math.abs(turnMod);

		if (forwardPower == 0) // if forward = 0, then zero point turn
		{
			leftPower = turnMod * 0.6;
			rightPower = -turnMod * 0.6;
		}
		else if (forwardPower > 0)
		{
			rightPower *= 1.15;
		}
		else
		{
			leftPower *= 1.15;
		}

		Robot.driveTrain.drive(leftPower, rightPower);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		return false;
	}

	// Called once after isFinished returns true
	protected void end()
	{
		Robot.driveTrain.drive(0.0, 0.0); // stop motors when not using joystick
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{
		end();
	}
}
