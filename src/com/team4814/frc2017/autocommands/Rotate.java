package com.team4814.frc2017.autocommands;

import com.team4814.frc2017.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Rotate extends Command
{
	double rotate;
	double mainSpeed;

	public Rotate(double rotation, double speed)
	{
		requires(Robot.driveTrain);
		rotate = rotation;
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

		if (rotate < 0)
		{
			double leftSpeed = -mainSpeed;
			double rightSpeed = mainSpeed;

			if ((-rightDistance - 0.1 < leftDistance) && (leftDistance < -rightDistance + 0.1))
			{

			}
			else if (-rightDistance > leftDistance)
			{
				double per = leftDistance / -rightDistance;

				rightSpeed *= 1 + per;
			}
			else
			{
				double per = -rightDistance / leftDistance;

				leftSpeed *= 1 + per;
			}

			Robot.driveTrain.drive(leftSpeed, rightSpeed);

			System.out.println(leftSpeed + " " + rightSpeed);
		}
		else if (rotate > 0)
		{
			double leftSpeed = mainSpeed;
			double rightSpeed = -mainSpeed;

			if ((rightDistance - 0.1 < -leftDistance) && (-leftDistance < rightDistance + 0.1))
			{

			}
			else if (rightDistance > -leftDistance)
			{
				double per = -leftDistance / rightDistance;

				rightSpeed *= 1 + per;
			}
			else
			{
				double per = rightDistance / -leftDistance;

				leftSpeed *= 1 + per;
			}

			Robot.driveTrain.drive(leftSpeed, rightSpeed);

			System.out.println(leftSpeed + " " + rightSpeed);

		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		if (rotate > 0)
		{
			if ((Robot.driveTrain.leftEncoder.getDistance() >= rotate)
					|| (Robot.driveTrain.rightEncoder.getDistance() <= rotate))
				return true;
		}
		else
		{
			if ((Robot.driveTrain.leftEncoder.getDistance() <= rotate)
					|| (Robot.driveTrain.rightEncoder.getDistance() >= rotate))
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
