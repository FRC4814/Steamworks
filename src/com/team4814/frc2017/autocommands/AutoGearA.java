package com.team4814.frc2017.autocommands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoGearA extends CommandGroup
{
	public AutoGearA()
	{
		/*
		 * a.go forward 2m
		 * rotate 45 DEG
		 * go forward 1m
		 */
		addSequential(new DriveStraight(200, 0.5));
		addSequential(new WaitCommand(0.5));
		addSequential(new Rotate(45, 0.5));
		addSequential(new WaitCommand(0.5));
		addSequential(new DriveStraight(100, 0.5));
	}
}
