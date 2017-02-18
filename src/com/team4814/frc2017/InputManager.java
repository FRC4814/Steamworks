package com.team4814.frc2017;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import com.team4814.frc2017.commands.*;
import com.team4814.frc2017.utils.CustomXboxController;
import com.team4814.frc2017.utils.XboxButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class InputManager
{
	public static CustomXboxController driverController = new CustomXboxController(RobotMap.DRIVER_CONTROLLER);

	public InputManager()
	{
		driverController.setDeadzone(0.13);
		
		Button shooterButton = new JoystickButton(driverController, XboxButton.kButtonA.getValue());
		shooterButton.toggleWhenPressed(new ShooterToggleCommand(true));

		Button intakeButton = new JoystickButton(driverController, XboxButton.kButtonB.getValue());
		intakeButton.whenActive(new IntakeToggleCommand(true));
		intakeButton.whenInactive(new IntakeToggleCommand(false));
	}
}
