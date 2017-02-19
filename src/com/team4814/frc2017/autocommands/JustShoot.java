package com.team4814.frc2017.autocommands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class JustShoot extends CommandGroup
{
	public JustShoot()
	{
		addParallel(new AutoShooter(true));
		addSequential(new WaitCommand(5.0));
		addParallel(new AutoShooter(false));
	}
}
