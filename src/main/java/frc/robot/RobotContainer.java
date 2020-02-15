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
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.ODoorClose;
import frc.robot.commands.ODoorOpen;
import frc.robot.commands.OutakeReverse;
import frc.robot.commands.OutakeShoot;
import frc.robot.commands.OutakeShutDown;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

   //operator joystick; spelling doesn't matter
   Joystick operator = new Joystick(3);
   //button for solenoid pushing door open and closing
   JoystickButton outakedoor = new JoystickButton(operator, 3);
   //button for outake shooter
   JoystickButton outakebuttonShoot = new JoystickButton(operator, 4);
   //button for reverse of outake shooter
   JoystickButton OReverseButton = new JoystickButton(operator, 5);
   //button to shut everything down, just for emergencies
   JoystickButton OStopButton = new JoystickButton(operator, 6);
   //button for solenoid closing door, not really needed but keep just incase
   JoystickButton Solclose = new JoystickButton(operator, 7);
   //button for solenoid opening door, not really needed but keep just incase
   JoystickButton Solopen = new JoystickButton(operator, 8);

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    outakedoor.whenPressed(new ODoorOpen());
    outakedoor.whenReleased(new ODoorClose());
    outakebuttonShoot.whenPressed(new OutakeShoot());
    OReverseButton.whenPressed(new OutakeReverse());
    OStopButton.whenPressed(new OutakeShutDown());
    // Configure the button bindings
    configureButtonBindings();
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
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
