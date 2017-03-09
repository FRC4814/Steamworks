package com.team4814.frc2017.subsystems;

import com.team4814.frc2017.RobotMap;
import com.team4814.frc2017.commands.ClimbCommand;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Climber extends Subsystem
{
	protected Talon mainMotor;

	public Climber()
	{
		mainMotor = new Talon(RobotMap.CLIMBER_MOTOR);
	}

	public void initDefaultCommand()
	{
		setDefaultCommand(new ClimbCommand());
	}

	public void setSpeed(double speed)
	{
		// The climber can be damaged if reversed
		if (speed < 0.0)
		{
			speed = 0.0;
			DriverStation.reportWarning("Trying to reverse the climber!", true);
		}

		mainMotor.set(speed);

		SmartDashboard.putNumber("Climber Speed", speed);
	}
}
