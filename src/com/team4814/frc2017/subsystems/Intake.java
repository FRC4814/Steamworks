package com.team4814.frc2017.subsystems;

import com.team4814.frc2017.RobotMap;
import com.team4814.frc2017.utils.DashboardVariable;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem
{
	public static final DashboardVariable<Double> intakeSpeed = new DashboardVariable<>("Intake Speed", 0.8);

	protected Talon mainMotor;

	public Intake()
	{
		mainMotor = new Talon(RobotMap.INTAKE_MOTOR);
		mainMotor.setInverted(true);
	}

	public void initDefaultCommand()
	{
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public void setSpeed(double speed)
	{
		mainMotor.setSpeed(speed);
	}
}
