// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ArcadeDriver;
import frc.robot.commands.intakeArmDown;
import frc.robot.commands.intakeArmUp;
import frc.robot.commands.intakeIn;
import frc.robot.commands.intakeStop;
import frc.robot.commands.outtake;
import frc.robot.commands.outtakeStop;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  public static Joystick operatorR = new Joystick(3);
  public static Joystick operatorL = new Joystick(2);
  public static Joystick m_lstick = new Joystick(0);
  public static Joystick m_rstick = new Joystick(1);
  
  public static JoystickButton intakeButton = new JoystickButton(operatorL, 1);
  public static JoystickButton outtakeButton = new JoystickButton(operatorR, 1);
  public static JoystickButton intakeArmDownButton = new JoystickButton(operatorL, 2);
  public static JoystickButton intakeArmUpButton = new JoystickButton(operatorR, 2);
  


  // The robot's subsystems and commands are defined here...

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    Robot.m_drivetrain2.setDefaultCommand(new ArcadeDriver(Robot.m_drivetrain2));
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    //intake
    intakeButton.whenPressed(new intakeIn());
    intakeButton.whenReleased(new intakeStop());

    outtakeButton.whenPressed(new outtake());
    outtakeButton.whenReleased(new outtakeStop());

    intakeArmDownButton.whenPressed(new intakeArmDown());
    intakeArmUpButton.whenPressed(new intakeArmUp());
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  /*
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
  */
}
