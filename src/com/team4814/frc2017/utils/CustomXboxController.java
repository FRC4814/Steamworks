package com.team4814.frc2017.utils;

import edu.wpi.first.wpilibj.XboxController;

public class CustomXboxController extends XboxController
{
	protected double deadzone = 0.15;

	public CustomXboxController(int port)
	{
		super(port);
	}

	@Override
	public double getX(Hand hand)
	{
		double val = super.getX(hand);
		if (Math.abs(val) >= deadzone)
			return val;
		return 0;
	}

	@Override
	public double getY(Hand hand)
	{
		double val = super.getY(hand);
		if (Math.abs(val) >= deadzone)
			return val;
		return 0;
	}
}
