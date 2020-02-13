/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.*;

public class Climber extends SubsystemBase {
  /**
   * Creates a new Climber.
   */
  static CANSparkMax winchMotor;

  public Climber(int bRID) {
    winchMotor = new CANSparkMax(bRID, MotorType.kBrushed);
  }

  public static void WinchUp() {
    winchMotor.set(0.3);
  }

  public static void WinchDown() {
    winchMotor.set(-0.3);
  }

  public static void WinchStop() {
    winchMotor.set(0.15);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
