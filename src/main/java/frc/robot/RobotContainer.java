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

  public Joystick joystickR = new Joystick(0);
  public Joystick joystickL = new Joystick(1);


  public JoystickButton elevatorUpButton = new JoystickButton(joystickR, 3);
  public JoystickButton elevatorDownButton = new JoystickButton(joystickR, 1);

  public JoystickButton latMotorRightButton = new JoystickButton(joystickR, 5);
  public JoystickButton latMotorLeftButton = new JoystickButton(joystickR, 6);
  //public JoystickButton latMotorStopButton = new JoystickButton(joystickR, 7);
  
  public JoystickButton winchStartButton = new JoystickButton(joystickR, 8);

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
    elevatorUpButton.whenPressed(new ElevatorUp());
    elevatorUpButton.whenReleased(new ElevatorStop());
    elevatorDownButton.whenPressed(new ElevatorDown());
    elevatorDownButton.whenReleased(new ElevatorStop());
    winchStartButton.whenPressed(new WinchStart());
    winchStartButton.whenReleased(new WinchStop());

    latMotorLeftButton.whenPressed(new LateralMotorLeft());
    latMotorLeftButton.whenReleased(new LateralMotorStop());
    latMotorRightButton.whenPressed(new LateralMotorRight());
    latMotorRightButton.whenReleased(new LateralMotorStop());

    // latMotorLeftButton.whenPressed(new LateralMotorLeft());


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
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   */
  public void getAutonomousCommand() {
    
    Command m_autoCommand;
  
    
  }
}
