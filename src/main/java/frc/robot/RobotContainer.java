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
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  private int climberMotor1;
  private int lateralMotor;
  private int climberMotor2;

  public Joystick Joystick1;
  public Joystick Joystick2;

  public JoystickButton elevatorUpButton;
  public JoystickButton elevatorDownButton;

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
    this.Joystick1 = new Joystick(0);
    this.Joystick2 = new Joystick(1);

    elevatorUpButton = new JoystickButton(Joystick1, 3);
    elevatorDownButton = new JoystickButton(Joystick1, 1);

    // Configure the button bindings
    configureButtonBindings();

    // Robot.climber.setDefaultCommand(new ElevatorStop());
  }


  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    elevatorUpButton.whenPressed(new ElevatorUp());
    elevatorUpButton.whenReleased(new ElevatorStop());
    elevatorDownButton.whenPressed(new ElevatorDown());
    elevatorDownButton.whenReleased(new ElevatorStop());
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   */
  public void getAutonomousCommand() {
    
    Command m_autoCommand;
  
    
  }
}
