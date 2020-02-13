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
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class climberSubsystem extends SubsystemBase {

  public CANSparkMax climberMotor1;
  public CANSparkMax climberMotor2;
  public CANSparkMax lateralMotor;

  SpeedControllerGroup Up;
  /**
   * Creates a new ExampleSubsystem.
   */
  public climberSubsystem(int climberMotor1ID, int climberMotor2ID, int lateralMotorID) {

    climberMotor1 = new CANSparkMax(1, MotorType.kBrushless);
    climberMotor2 = new CANSparkMax(2, MotorType.kBrushless);
    lateralMotor = new CANSparkMax(3, MotorType.kBrushless);
    Up = new SpeedControllerGroup(climberMotor1, climberMotor2);

    climberMotor2.follow(climberMotor1);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

public void climbyboi(Joystick coDriver) {
}

public void comeDown(Joystick coDriver) {
}
}
