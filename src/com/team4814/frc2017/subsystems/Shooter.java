package com.team4814.frc2017.subsystems;

import com.team4814.frc2017.RobotMap;
import com.team4814.frc2017.utils.DashboardVariable;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class Shooter extends Subsystem
{
	public static final DashboardVariable<Double> shooterSpeed = new DashboardVariable<>("Shooter Speed", 1.0);

	protected VictorSP mainMotor;

	public Shooter()
	{
		mainMotor = new VictorSP(RobotMap.SHOOTER_MOTOR);
		mainMotor.setInverted(true);

		LiveWindow.addSensor(this.getName(), "Shooter Motor", mainMotor);
	}

	public void initDefaultCommand()
	{
		// setDefaultCommand(new MySpecialCommand());
	}

	public void setSpeed(double speed)
	{
		mainMotor.set(speed);
	}
}
