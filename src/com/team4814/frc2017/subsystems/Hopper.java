package com.team4814.frc2017.subsystems;

import com.team4814.frc2017.RobotMap;
import com.team4814.frc2017.utils.DashboardVariable;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Hopper extends Subsystem
{
	public static final DashboardVariable<Double> hopperSpeed = new DashboardVariable<>("Hopper Speed", 1.0);

	protected VictorSP mainMotor;

	public Hopper()
	{
		mainMotor = new VictorSP(RobotMap.HOPPER_MOTOR);
	}

	public void initDefaultCommand()
	{
		//setDefaultCommand(new HopperCommand());
	}

	public void setSpeed(double speed)
	{
		mainMotor.set(speed);
	}
}
