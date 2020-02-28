/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
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

  static DoubleSolenoid shiftyLeft;
  static DoubleSolenoid shiftyRight;

  public DriveTrain(
    int FL, int ML, int BL,  
    int FR, int MR, int BR,
    int mod1, int mod2, 
    int[] SHIFTYL_ID, int[] SHIFTYR_ID) {
    frontLeft = new CANSparkMax(FL,MotorType.kBrushless);
    middleLeft = new CANSparkMax(ML, MotorType.kBrushless);
    backLeft = new CANSparkMax(BL,MotorType.kBrushless);


    frontRight = new CANSparkMax(FR, MotorType.kBrushless);
    middleRight = new CANSparkMax(MR, MotorType.kBrushless);
    backRight = new CANSparkMax(BR,MotorType.kBrushless);

    leftMotors = new SpeedControllerGroup(middleLeft, frontLeft, backLeft);
    rightMotors = new SpeedControllerGroup(middleRight, frontRight, backRight);

    leftMotors.setInverted(true);
    rightMotors.setInverted(true);

    middleLeft.setInverted(true);
    middleRight.setInverted(true);

    diffDrive = new DifferentialDrive(leftMotors, rightMotors);
    
    shiftyLeft = new DoubleSolenoid(mod1, SHIFTYL_ID[0], SHIFTYL_ID[1]);
    shiftyRight = new DoubleSolenoid(mod1, SHIFTYR_ID[0], SHIFTYR_ID[1]);
  }

  public void arcadeDrive(final double forwardSpeed, final double turnSpeed){
    diffDrive.arcadeDrive(forwardSpeed, -turnSpeed);
  }

  public static void ShiftHigh() {
    // shiftyLeft.set(Value.kForward);
    shiftyRight.set(Value.kForward);
  }
  
  public static void ShiftLow() {
    // shiftyLeft.set(Value.kReverse);
    shiftyRight.set(Value.kReverse);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
