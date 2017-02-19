package com.team4814.frc2017.subsystems;

import com.team4814.frc2017.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Hopper extends Subsystem
{
	protected VictorSP mainMotor;

	public Hopper()
	{
		mainMotor = new VictorSP(RobotMap.HOPPER_MOTOR);
	}

	public void initDefaultCommand()
	{

		//setDefaultCommand(new HopperCommand());;
	}

	public void setSpeed(double speed)
	{
		mainMotor.set(speed);
	}
}
