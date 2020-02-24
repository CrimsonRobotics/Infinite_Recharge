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
import frc.robot.commands.IntakeArmToggle;
import frc.robot.commands.IntakeCatchExtra;
import frc.robot.commands.IntakeIn;
import frc.robot.commands.OuttakeSequence;
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
  // private final DriveTrain drivetrain = new DriveTrain(Constants.fLID, Constants.fRID, Constants.bLID, Constants.bRID);

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  public Joystick Joystick1 = new Joystick(0);
  public Joystick Joystick2 = new Joystick(1);

  public JoystickButton intakeIn = new JoystickButton(Joystick1, Constants.INTAKE_IN_BUTTON);
  public JoystickButton intakeToggleArm = new JoystickButton(Joystick1, Constants.INTAKE_ARM_BUTTON);
  public JoystickButton outtakeButton = new JoystickButton(Joystick1, Constants.OUTTAKE_BUTTON);

  public boolean intakeArmUp = true;

  public Joystick rightJoystick(){
    return Joystick1;
  }

  public Joystick leftJoystick(){
    return Joystick2;
  }
  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    intakeArmUp = true;

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
    //Intake
    intakeIn.whileHeld(new IntakeIn(Constants.INTAKE_SPEED));
    intakeIn.whenReleased(new IntakeCatchExtra());

    intakeToggleArm.whenPressed(new IntakeArmToggle());

    //Outtake
    outtakeButton.whenPressed(new OuttakeSequence());
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
