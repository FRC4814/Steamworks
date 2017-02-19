package com.team4814.frc2017.autocommands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GoForward extends CommandGroup
{
	public GoForward()
	{
		addSequential(new DriveStraight(200, 0.5));
	}
}
