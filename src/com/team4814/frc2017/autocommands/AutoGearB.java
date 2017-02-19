package com.team4814.frc2017.autocommands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoGearB extends CommandGroup
{
	public AutoGearB()
	{
		/*
		 * b.go forward 1m
		 */

		addSequential(new DriveStraight(100, 0.5));
	}
}
