/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.AlternateEncoderType;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.*;
import com.revrobotics.CANDigitalInput.LimitSwitch;

public class Climber extends SubsystemBase {
  /**
   * Creates a new Climber.
   */
public static double lastEncoderPosition;

  static CANSparkMax elevatorMotor;
  static CANSparkMax winchMotor;
  static CANSparkMax lateralMotor;
  private static double goalPoint;
  private static int variance = 450;
  private static boolean goalPointSet;

  public static CANEncoder elevatorEncoder;
  public static CANEncoder winchEncoder;

  public static LimitSwitch limitSwitch;

  public double winchStartPosition;

  public Climber(int elevatorMotorID) {
    elevatorMotor = new CANSparkMax(elevatorMotorID, MotorType.kBrushed);
    winchMotor = new CANSparkMax(Constants.WINCH_MOTOR, MotorType.kBrushless);
    // limitSwitch = new LimitSwitch();
   // hello = new Solenoid(0,1);

    winchEncoder = new CANEncoder(winchMotor);
    winchStartPosition = winchEncoder.getPosition();

    lateralMotor = new CANSparkMax(Constants.lateralMotor, MotorType.kBrushed);
    elevatorEncoder = elevatorMotor.getAlternateEncoder(AlternateEncoderType.kQuadrature, 4096);
  }

  public static void elevatorUp() {
    elevatorMotor.set(-.4);
    goalPointSet = false;
    SmartDashboard.putNumber("Encoder is at pos: ", elevatorEncoder.getPosition());
  }

  public static void elevatorDown() {
    elevatorMotor.set(0.1);
    goalPointSet = false;
    SmartDashboard.putNumber("Encoder is at pos: ", elevatorEncoder.getPosition());
  }

  public static void elevatorStop() {
    elevatorMotor.set(-0.17);
  }

  public void ElevatorZero(){
    elevatorMotor.set(0);
  }

  public void winchStart() {
    winchMotor.set(-.6);
  }

  public void winchStop() {
    winchMotor.set(0);
  }

  public void lateralRight() {
    lateralMotor.set(.4);
  }
  
  public void lateralLeft() {
    lateralMotor.set(-.4);
  }

  public void lateralRightFast() {
    lateralMotor.set(.7);
  }
  
  public void lateralLeftFast() {
    lateralMotor.set(-.7);
  }

  public void lateralStop() {
    lateralMotor.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
