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
import frc.robot.commands.FullUnjam;
import frc.robot.commands.IntakeArmDown;
import frc.robot.commands.IntakeArmUp;
import frc.robot.commands.IntakeCatchExtra;
import frc.robot.commands.IntakeIn;
import frc.robot.commands.IntakeReverse;
import frc.robot.commands.IntakeStop;
import frc.robot.commands.OuttakeSequence;
import frc.robot.commands.OuttakeShoot;
import frc.robot.commands.OuttakeSlowIn;
import frc.robot.commands.OuttakeStop;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Outtake;
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

  public Joystick joystickR = new Joystick(1);
  public Joystick joystickL = new Joystick(0);

  public Joystick operatorR = new Joystick(3);
  public Joystick operatorL = new Joystick(2);

  public JoystickButton intakeIn = new JoystickButton(operatorL, 2);
  public JoystickButton unjamButton = new JoystickButton(operatorL, 4);
  public JoystickButton fullUnjam = new JoystickButton(operatorL, 3);
  public JoystickButton intakeToggleArm = new JoystickButton(operatorL, 1);
  // public JoystickButton outtakeSlowIn = new JoystickButton(operatorL, 4);

  public JoystickButton outtakeShoot = new JoystickButton(operatorR, 1);

  public boolean intakeArmUp = true;

  public OuttakeSequence currentOuttakeSequence;

  public Joystick rightJoystick(){
    return joystickR;
  }

  public Joystick leftJoystick(){
    return joystickL;
  }
  
  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    intakeArmUp = true;
    
    //Intake
    intakeIn.whenPressed(new IntakeIn(Constants.INTAKE_SPEED));
    intakeIn.whenReleased(new IntakeCatchExtra());

    intakeToggleArm.whenPressed(new IntakeArmDown());
    intakeToggleArm.whenReleased(new IntakeArmUp());

    unjamButton.whenPressed(new IntakeReverse(.4));
    unjamButton.whenReleased(new IntakeStop());

    fullUnjam.whenPressed(new FullUnjam());
    fullUnjam.whenReleased(new IntakeStop());

    //Outtake
    outtakeShoot.whenPressed(new OuttakeSequence());

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
