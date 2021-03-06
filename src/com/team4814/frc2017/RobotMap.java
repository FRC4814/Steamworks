package com.team4814.frc2017;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap
{
	// PWM
	public static final int[] LEFT_MOTORS = { 1, 2, 3 };
	public static final int[] RIGHT_MOTORS = { 4, 5, 6 };
	public static final int SHOOTER_MOTOR = 7;
	public static final int CLIMBER_MOTOR = 8;
	public static final int INTAKE_MOTOR = 0;
	public static final int HOPPER_MOTOR = 9;

	// USB
	public static final int DRIVER_CONTROLLER = 1;

	// DIO
	public static final int[] LEFT_MOTOR_ENCODERS = { 0, 1 };
	public static final int[] RIGHT_MOTOR_ENCODERS = { 2, 3 };
}
