package com.team4814.frc2017.subsystems;

import com.team4814.frc2017.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Intake extends Subsystem
{
	protected Talon mainMotor;

	public Intake()
	{
		mainMotor = new Talon(RobotMap.INTAKE_MOTOR);
	}

	public void initDefaultCommand()
	{
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public void setSpeed(double speed)
	{
		mainMotor.setSpeed(speed);
		
		SmartDashboard.putNumber("Intake Speed", speed);
	}
}
