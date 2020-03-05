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
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
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

  public Joystick driverR = new Joystick(1);
  public Joystick driverL = new Joystick(0);

  public Joystick operatorR = new Joystick(3);
  public Joystick operatorL = new Joystick(2);

  // Intake buttons
  public JoystickButton intakeIn = new JoystickButton(operatorL, 2);
  public JoystickButton unjamButton = new JoystickButton(operatorL, 4);
  public JoystickButton fullUnjam = new JoystickButton(operatorL, 3);
  public JoystickButton intakeToggleArm = new JoystickButton(operatorL, 1);

  // Outtake buttons
  public JoystickButton outtakeShoot = new JoystickButton(operatorR, 1);

  // Drive train buttons
  public JoystickButton shiftyButton = new JoystickButton(driverL, 1);

  public Joystick rightJoystick(){
    return driverR;
  }

  public Joystick leftJoystick(){
    return driverL;
  }
  
  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Intake
    intakeIn.whenPressed(new IntakeIn(Constants.INTAKE_SPEED));
    intakeIn.whenReleased(new IntakeCatchExtra());

    intakeToggleArm.whenPressed(new IntakeArmDown());
    intakeToggleArm.whenReleased(new IntakeCatchExtra());

    unjamButton.whenPressed(new IntakeReverse(.4));
    unjamButton.whenReleased(new IntakeStop());

    fullUnjam.whenPressed(new FullUnjam());
    fullUnjam.whenReleased(new IntakeStop());

    // Outtake
    outtakeShoot.whenPressed(new OuttakeSequence());
    
    // Drive train
    shiftyButton.whenPressed(new ShiftHigh());
    shiftyButton.whenReleased(new ShiftLow());

    configureButtonBindings();
    
    Robot.drivetrain.setDefaultCommand(new Drive());
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
