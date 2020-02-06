/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  /**
   * Creates a new Intake.
   */

  public CANSparkMax intakeLeft = new CANSparkMax(Constants.IntakeLeft, MotorType.kBrushless);
  public CANSparkMax intakeRight = new CANSparkMax(Constants.IntakeRight, MotorType.kBrushless);

  public DoubleSolenoid solenoid = new DoubleSolenoid(0, 1);
  public DoubleSolenoid solenoid2 = new DoubleSolenoid(2, 3);

  public Intake() {

  }

  public void IntakeIn() {
    solenoid.set(Value.kForward);
    solenoid2.set(Value.kForward);
    intakeLeft.set(.5);
    intakeRight.set(.5);
  }

  public void IntakeStop() {
    solenoid.set(Value.kOff);
    solenoid2.set(Value.kOff);
    intakeLeft.set(0);
    intakeRight.set(0);
  }

  public void IntakeOut() {
    solenoid.set(Value.kReverse);
    solenoid2.set(Value.kReverse);
    intakeLeft.set(-.5);
    intakeRight.set(-.5);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
