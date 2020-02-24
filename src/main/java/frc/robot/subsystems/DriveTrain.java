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
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.DriveTrain;


public class DriveTrain extends SubsystemBase {
  /**
   * Creates a new ExampleSubsystem.
   */
  CANSparkMax frontLeft;
  CANSparkMax middleLeft;
  CANSparkMax backLeft;

  CANSparkMax frontRight;
  CANSparkMax middleRight;
  CANSparkMax backRight;

  private final SpeedControllerGroup leftMotors;
  private final SpeedControllerGroup rightMotors;
  private final DifferentialDrive diffDrive;

  static Solenoid shiftyLeft;
  static Solenoid shiftyRight;

  public DriveTrain(int FL, int ML, int BL,  
    int FR, int MR, int BR, 
    int SHIFTYL_ID, int SHIFTYR_ID) {
    frontLeft = new CANSparkMax(FL,MotorType.kBrushless);
    middleLeft = new CANSparkMax(ML, MotorType.kBrushless);
    backLeft = new CANSparkMax(BL,MotorType.kBrushless);

    frontRight = new CANSparkMax(FR, MotorType.kBrushless);
    middleRight = new CANSparkMax(MR, MotorType.kBrushless);
    backRight = new CANSparkMax(BR,MotorType.kBrushless);

    leftMotors = new SpeedControllerGroup(frontLeft, backLeft, middleLeft);
    rightMotors = new SpeedControllerGroup(frontRight, backRight, middleRight);

    leftMotors.setInverted(true);
    middleRight.setInverted(true);

    diffDrive = new DifferentialDrive(leftMotors, rightMotors);
    
    shiftyLeft = new Solenoid(SHIFTYL_ID);
    shiftyRight = new Solenoid(SHIFTYR_ID);
  }

  public void arcadeDrive(final double forwardSpeed, final double turnSpeed){
    // backRight.set(forwardSpeed);
    rightMotors.set(forwardSpeed);
    // diffDrive.arcadeDrive(forwardSpeed, -turnSpeed);
  }

  public static void ShiftHigh() {
    shiftyLeft.set(true);
    shiftyRight.set(true);
  }

  public static void ShiftLow() {
    shiftyLeft.set(false);
    shiftyRight.set(false);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
