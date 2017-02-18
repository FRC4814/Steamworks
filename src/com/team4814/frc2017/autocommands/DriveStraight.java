package com.team4814.frc2017.autocommands;

import com.team4814.frc2017.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveStraight extends Command
{

	double targetDistance;
	double mainSpeed;

	public DriveStraight(double distance, double speed)
	{
		requires(Robot.driveTrain);
		targetDistance = distance;
		mainSpeed = speed;

	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
		Robot.driveTrain.resetEncoders();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
		double rightDistance = 0;
		double leftDistance = 0;
		double leftSpeed = mainSpeed;
		double rightSpeed = mainSpeed;
		double per = 0;
		rightDistance = Robot.driveTrain.getRightDistnace();
		leftDistance = Robot.driveTrain.getLeftDistnace();

		if ((rightDistance - 0.1 < leftDistance) && (leftDistance < rightDistance + 0.1))
		{

		}
		else if (rightDistance < leftDistance)
		{
			per = rightDistance / leftDistance;

			leftSpeed -= (1 - per);
		}
		else
		{
			per = leftDistance / rightDistance;
			rightSpeed -= (1 - per);

		}

		Robot.driveTrain.setLeftSpeed(leftSpeed);
		Robot.driveTrain.setRightSpeed(rightSpeed);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		if ((Robot.driveTrain.leftEncoder.getDistance() >= targetDistance)
				|| (Robot.driveTrain.rightEncoder.getDistance() >= targetDistance))
			return true;
		return false;
	}

	// Called once after isFinished returns true
	protected void end()
	{
		Robot.driveTrain.drive(0, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{
		end();
	}
}
