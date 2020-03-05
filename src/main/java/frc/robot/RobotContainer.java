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
  private final DriveTrain drivetrain = new DriveTrain(
    Constants.fLID, Constants.mLID, Constants.bLID, Constants.fRID, Constants.mRID, Constants.bRID,
    Constants.mod1ID, Constants.mod2ID,
    Constants.shiftyLIDF, Constants.shiftyLIDR, Constants.shiftyRIDF, Constants.shiftyRIDR);

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  public Joystick driverR = new Joystick(1);
  public Joystick driverL = new Joystick(0);

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
    this.driverR = new Joystick(1);
    this.driverL = new Joystick(0);

    shiftyButton.whenPressed(new ShiftHigh());
    shiftyButton.whenReleased(new ShiftLow());

    configureButtonBindings();
    drivetrain.setDefaultCommand(new Drive(drivetrain, leftJoystick(), rightJoystick()));
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
