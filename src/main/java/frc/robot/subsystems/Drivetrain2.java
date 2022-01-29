// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.ArcadeDriver;

public class Drivetrain2 extends SubsystemBase {
  /** Creates a new Drivetrain2. */
  public static CANSparkMax leftMotor1;
  public static CANSparkMax leftMotor2;
  public static CANSparkMax rightMotor1;
  public static CANSparkMax rightMotor2;

  public static MotorControllerGroup leftMotors;
  public static MotorControllerGroup rightMotors;

  DifferentialDrive drive;

  
  public Drivetrain2() {
    
    leftMotor1 = new CANSparkMax (Constants.l1ID, MotorType.kBrushless);
    leftMotor2 = new CANSparkMax (Constants.l2ID, MotorType.kBrushless);
    rightMotor1 = new CANSparkMax(Constants.r1ID, MotorType.kBrushless);
    rightMotor2 = new CANSparkMax(Constants.r2ID, MotorType.kBrushless);

    leftMotor1.setInverted(false);
    leftMotor2.setInverted(false);
    rightMotor1.setInverted(false);
    rightMotor2.setInverted(false);

    leftMotors = new MotorControllerGroup(leftMotor1, leftMotor2);
    rightMotors = new MotorControllerGroup(rightMotor1, rightMotor2);

    drive = new DifferentialDrive(leftMotors, rightMotors);
    
    // leftMotor1 = new CANSparkMax(52, MotorType.kBrushless);
    // rightMotor1 = new CANSparkMax(53, MotorType.kBrushless);

    // rightMotor1.setInverted(false);
    // leftMotor1.setInverted(false);

    // drive = new DifferentialDrive(leftMotor1, rightMotor1);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void ArcadeDriver(double forward, double turn) {
    drive.arcadeDrive(-forward, turn);
  }
}