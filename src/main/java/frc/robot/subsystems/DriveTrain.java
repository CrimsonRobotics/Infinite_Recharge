/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.*;
import frc.robot.subsystems.DriveTrain;


public class DriveTrain extends SubsystemBase {
  /**
   * Creates a new ExampleSubsystem.
   */
  CANSparkMax FrontLeft;
  CANSparkMax FrontRight;
  CANSparkMax BackLeft;
  CANSparkMax BackRight;
  private final SpeedControllerGroup leftMotors;
  private final SpeedControllerGroup rightMotors;
  private final DifferentialDrive diffDrive; 
  public DriveTrain(int FL, int FR, int BL, int BR) {
    FrontLeft = new CANSparkMax(FL,MotorType.kBrushless);
    FrontRight = new CANSparkMax(FR,MotorType.kBrushless);
    BackLeft = new CANSparkMax(BL,MotorType.kBrushless);
    BackRight = new CANSparkMax(BR,MotorType.kBrushless);
    leftMotors = new SpeedControllerGroup(FrontLeft, BackLeft);
    rightMotors = new SpeedControllerGroup(FrontRight, BackRight);
    leftMotors.setInverted(true);
    diffDrive = new DifferentialDrive(leftMotors, rightMotors);
  }

  public void arcadeDrive(double forwardSpeed, double turnSpeed){
    diffDrive.arcadeDrive(turnSpeed, forwardSpeed);
  }

  public void drive(double leftSpeed, double rightSpeed) {
    rightMotors.set(rightSpeed);
    leftMotors.set(leftSpeed);
  }

  public void stopRobot(){
    rightMotors.set(0);
    leftMotors.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    
  }
}
