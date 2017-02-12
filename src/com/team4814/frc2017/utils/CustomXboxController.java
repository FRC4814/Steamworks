package com.team4814.frc2017.utils;

import edu.wpi.first.wpilibj.XboxController;

public class CustomXboxController extends XboxController
{
	protected double deadzone = 0.0;

	public CustomXboxController(int port)
	{
		super(port);
	}
	
	public void setDeadzone(double deadzone)
	{
		this.deadzone = deadzone;
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
