/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.climbyboi;
import frc.robot.commands.comeDown;
// import edu.wpi.first.wpilibj.XboxController;
// import frc.robot.commands.ExampleSubsystem;
// import frc.robot.commands.climbyboi;
import frc.robot.subsystems.climberSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
// import edu.wpi.first.wpilibj2.command.Subsystem;
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
  // The robot's subsystems and commands are defined here...
  private final climberSubsystem m_exampleSubsystem = new climberSubsystem(climberMotor1, climberMotor2, lateralMotor);
  private final Joystick driverLeft = new Joystick(0);
  private final Joystick driverRight = new Joystick(1);
  private final Joystick coDriver = new Joystick(2);

  private final JoystickButton button1 = new JoystickButton(coDriver, 1);
  private final JoystickButton button2 = new JoystickButton(coDriver, 2);
  private final JoystickButton button4 = new JoystickButton(coDriver, 4);
  private final JoystickButton button5 = new JoystickButton(coDriver, 5);
  // private final climbyboi m_autoCommand = new climbyboi();

  public Joystick getdriverLeft(){

    return driverLeft;
  }

  public Joystick driverRight(){

    return driverRight;
  }

  public Joystick coDriver(){
    return coDriver;
  }
  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {

    button1.whenPressed(new climbyboi(m_exampleSubsystem));
    button2.whenPressed(new comeDown(m_exampleSubsystem));
    
    
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
   */
  public void getAutonomousCommand() {
    
    Command m_autoCommand;
  
    
  }
}
