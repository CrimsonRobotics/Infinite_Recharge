/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  /**
   * Creates a new Intake.
   */
  public final double intakeSpeed =  -.5;

  public CANSparkMax intakeTop;
  public CANSparkMax intakeBottom;
  public CANSparkMax moveTest;

  public boolean armUp = true;

  public Intake() {
    armUp = true;
    intakeTop = new CANSparkMax(Constants.INTAKE_TOP, MotorType.kBrushless);
    intakeBottom = new CANSparkMax(Constants.INTAKE_BOTTOM, MotorType.kBrushless);
    // moveTest.set(.2);
  }

  public void IntakeIn(double speed) {
    // System.out.println("Intake in");
    intakeTop.set(speed);
    intakeBottom.set(-speed);

    double encoderRpm = intakeTop.getEncoder().getVelocity();
    SmartDashboard.putNumber("Intake Encoder RPM", encoderRpm);
    if (encoderRpm <= 100) {
      // System.out.println("Intake may be jammed");
    }
  }

  public void IntakeStop() {
    intakeTop.set(0);
    intakeBottom.set(0);
  }

  public void IntakeOut(double speed) { //Spit out balls via intake
    intakeTop.set(-speed);
    intakeBottom.set(speed);
  }

  public void IntakeArmToggle() { //If arm is down, send it up and vice-versa
    if (armUp == true) {
      LowerIntakeArm();
    } else {
      RaiseIntakeArm();
    }
  }

  public void RaiseIntakeArm() {
    System.out.println("Raising intake arm");
  }

  public void LowerIntakeArm() {
    System.out.println("Lowering intake arm");
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
