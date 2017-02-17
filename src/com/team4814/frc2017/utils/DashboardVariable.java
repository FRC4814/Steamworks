package com.team4814.frc2017.utils;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DashboardVariable<T>
{
	protected String name;
	protected T defaultValue;

	public DashboardVariable(String name, T defaultValue)
	{
		this.name = name;
		this.defaultValue = defaultValue;

		set(defaultValue);
	}

	@SuppressWarnings("unchecked")
	public T get()
	{
		try
		{
			if (Double.class.isInstance(defaultValue))
			{
				return (T)(Object)SmartDashboard.getNumber(name, (Double)defaultValue);
			}
			else if (Integer.class.isInstance(defaultValue))
			{
				return (T)(Object)SmartDashboard.getNumber(name, (Integer)defaultValue);
			}
			else if (Boolean.class.isInstance(defaultValue))
			{
				return (T)(Object)SmartDashboard.getBoolean(name, (Boolean)defaultValue);
			}
			else if (String.class.isInstance(defaultValue))
			{
				return (T)(Object)SmartDashboard.getString(name, (String)defaultValue);
			}
		}
		catch (Exception e)
		{
			DriverStation.reportError(e.getMessage(), true);
		}
		
		return defaultValue;
	}

	public void set(T value)
	{
		try
		{
			if (Double.class.isInstance(value))
			{
				SmartDashboard.putNumber(name, (Double)value);
			}
			else if (Integer.class.isInstance(value))
			{
				SmartDashboard.putNumber(name, (Integer)value);
			}
			else if (Boolean.class.isInstance(value))
			{
				SmartDashboard.putBoolean(name, (Boolean)value);
			}
			else if (String.class.isInstance(value))
			{
				SmartDashboard.putString(name, (String)value);
			}
		}
		catch (Exception e)
		{
			DriverStation.reportError(e.getMessage(), true);
		}
	}
}