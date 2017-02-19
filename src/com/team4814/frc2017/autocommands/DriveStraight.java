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
		double rightDistance = Robot.driveTrain.getRightDistance();
		double leftDistance = Robot.driveTrain.getLeftDistance();
		double leftSpeed = mainSpeed;
		double rightSpeed = mainSpeed;

		if (mainSpeed > 0)
		{

			if ((rightDistance - 0.1 < leftDistance) && (leftDistance < rightDistance + 0.1))
			{

			}
			else if (rightDistance < leftDistance)
			{
				double per = rightDistance / leftDistance;

				rightSpeed *= 1 + per;
			}
			else
			{
				double per = leftDistance / rightDistance;

				leftSpeed *= 1 + per;
			}
		}
		else
		{
			if ((rightDistance - 0.1 < leftDistance) && (leftDistance < rightDistance + 0.1))
			{

			}
			else if (rightDistance > leftDistance)
			{
				double per = leftDistance / rightDistance;

				rightSpeed *= 1 + per;
			}
			else
			{
				double per = rightDistance / leftDistance;

				leftSpeed *= 1 + per;
			}
		}

		Robot.driveTrain.drive(leftSpeed, rightSpeed);

		System.out.println(leftSpeed + " " + rightSpeed);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		if (mainSpeed > 0)
		{
			if ((Robot.driveTrain.leftEncoder.getDistance() >= targetDistance)
					|| (Robot.driveTrain.rightEncoder.getDistance() >= targetDistance))
				return true;
		}
		else
		{
			if ((Robot.driveTrain.leftEncoder.getDistance() <= targetDistance)
					|| (Robot.driveTrain.rightEncoder.getDistance() <= targetDistance))
				return true;
		}
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
