/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.*;
import frc.robot.commands.LowerPanelSpinner;
import frc.robot.commands.RaisePanelSpinner;
import frc.robot.commands.SpinLeft;
import frc.robot.commands.SpinRight;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  // private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  // private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  public Joystick driverR = new Joystick(1);
  public Joystick driverL = new Joystick(0);

  public Joystick operatorR = new Joystick(3);
  public Joystick operatorL = new Joystick(2);

  // Intake buttons
  public JoystickButton unjamButton = new JoystickButton(operatorL, 4);
  public JoystickButton fullUnjam = new JoystickButton(operatorL, 3);
  public JoystickButton intakeToggleArm = new JoystickButton(operatorL, 1);

  // Climber buttons
  public JoystickButton elevatorUpButton = new JoystickButton(operatorR, 7);
  public JoystickButton elevatorDownButton = new JoystickButton(operatorR, 8);
  public JoystickButton latMotorRightButton = new JoystickButton(operatorR, 14);
  public JoystickButton latMotorLeftButton = new JoystickButton(operatorR, 15);
  public JoystickButton latRightFast = new JoystickButton(operatorR, 13);
  public JoystickButton latLeftFast = new JoystickButton(operatorR, 12);
  public JoystickButton winchStartButton = new JoystickButton(operatorR, 5);

  // Control panel buttons
  private final JoystickButton raisePanelSpinner = new JoystickButton(operatorL, 13);
  private final JoystickButton rotationControl = new JoystickButton(operatorL, 11);
  private final JoystickButton positionControl = new JoystickButton(operatorL, 16);
  private final JoystickButton spinnerLeftFast = new JoystickButton(operatorL, 7);
  private final JoystickButton spinnerRightFast = new JoystickButton(operatorL, 6);
  private final JoystickButton spinnerLeft = new JoystickButton(operatorL, 8);
  private final JoystickButton spinnerRight = new JoystickButton(operatorL, 9);
  
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

  UsbCamera camera1;
  UsbCamera camera2;
  
  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Intake
    // intakeIn.whenPressed(new IntakeIn(Constants.INTAKE_SPEED));
    // intakeIn.whenReleased(new IntakeCatchExtra());

    
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

    //Elevator
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
    latRightFast.whenPressed(new LatRightFast());
    latRightFast.whenReleased(new LateralMotorStop());
    latLeftFast.whenPressed(new LatLeftFast());
    latLeftFast.whenReleased(new LateralMotorStop());

    // Control panel
    raisePanelSpinner.whenPressed(new RaisePanelSpinner());
    raisePanelSpinner.whenReleased(new LowerPanelSpinner());

    spinnerLeftFast.whenPressed(new SpinLeft(.5));
    spinnerLeftFast.whenReleased(new SpinLeft(0));
    spinnerRightFast.whenPressed(new SpinRight(.5));
    spinnerRightFast.whenReleased(new SpinRight(0));

    spinnerLeft.whenPressed(new SpinLeft(.3));
    spinnerLeft.whenReleased(new SpinLeft(0));
    spinnerRight.whenPressed(new SpinRight(.3));
    spinnerRight.whenReleased(new SpinRight(0));

    configureButtonBindings();
    
    Robot.drivetrain.setDefaultCommand(new Drive());
    Robot.outtake.setDefaultCommand(new OuttakeLoop());

    // Robot.climber.setDefaultCommand(new ElevatorStop());

    camera1 = CameraServer.getInstance().startAutomaticCapture(0);
    camera2 = CameraServer.getInstance().startAutomaticCapture(1);
    camera1.setFPS(10);
    camera2.setFPS(10);
    camera1.setResolution(640, 480);
    camera2.setResolution(640, 480);
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
