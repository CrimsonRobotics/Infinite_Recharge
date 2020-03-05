/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.BeginCPSpin;
import frc.robot.commands.ColorDetect;
import frc.robot.commands.EndCPSpin;
import frc.robot.commands.LowerPanelSpinner;
import frc.robot.commands.RaisePanelSpinner;
import frc.robot.commands.SpinLeft;
import frc.robot.commands.SpinRight;
import frc.robot.commands.StartCPSpin;
import frc.robot.subsystems.ControlPanel;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  //private final ControlPanel controlPanel = new ControlPanel();
  //private final ColorDetect colorDetect = new ColorDetect(controlPanel);
  
  //Joysticks and buttons
  private final Joystick operatorL = new Joystick(2);

  private final JoystickButton raisePanelSpinner = new JoystickButton(operatorL, 13);
  private final JoystickButton rotationControl = new JoystickButton(operatorL, 11);
  private final JoystickButton positionControl = new JoystickButton(operatorL, 16);
  private final JoystickButton spinnerLeftFast = new JoystickButton(operatorL, 7);
  private final JoystickButton spinnerRightFast = new JoystickButton(operatorL, 6);
  private final JoystickButton spinnerLeft = new JoystickButton(operatorL, 8);
  private final JoystickButton spinnerRight = new JoystickButton(operatorL, 9);
  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Control panel
    raisePanelSpinner.whenPressed(new RaisePanelSpinner());
    raisePanelSpinner.whenReleased(new LowerPanelSpinner());

    spinnerLeftFast.whenPressed(new SpinLeft(.6));
    spinnerLeftFast.whenReleased(new SpinLeft(0));
    spinnerRightFast.whenPressed(new SpinRight(.6));
    spinnerRightFast.whenReleased(new SpinRight(0));

    spinnerLeft.whenPressed(new SpinLeft(.3));
    spinnerLeft.whenReleased(new SpinLeft(0));
    spinnerRight.whenPressed(new SpinRight(.3));
    spinnerRight.whenReleased(new SpinRight(0));

    configureButtonBindings();
   // controlPanel.setDefaultCommand(new ColorDetect(controlPanel));
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
}
