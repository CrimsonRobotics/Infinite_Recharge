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
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  /**
   * Creates a new Intake.
   */

  public CANSparkMax intakeLeft = new CANSparkMax(Constants.INTAKE_LEFT, MotorType.kBrushless);
  public CANSparkMax intakeRight = new CANSparkMax(Constants.INTAKE_RIGHT, MotorType.kBrushless);

  public DoubleSolenoid solenoid = new DoubleSolenoid(Constants.INTAKE_MODULE, 0, 1);
  // public DoubleSolenoid solenoid2 = new DoubleSolenoid(Constants.INTAKE_MODULE, 2, 3);
  public Solenoid singleSolenoid = new Solenoid(Constants.INTAKE_MODULE, 3);

  public Intake() {

  }

  public void IntakeIn() {
    solenoid.set(Value.kForward);
    // solenoid2.set(Value.kForward);
    singleSolenoid.set(true);
    intakeLeft.set(.5);
    intakeRight.set(.5);
  }

  public void IntakeStop() {
    solenoid.set(Value.kOff);
    singleSolenoid.set(false);
    // solenoid2.set(Value.kOff);
    intakeLeft.set(0);
    intakeRight.set(0);
  }

  public void IntakeOut() {
    solenoid.set(Value.kReverse);
    singleSolenoid.set(false);
    // solenoid2.set(Value.kReverse);
    intakeLeft.set(-.5);
    intakeRight.set(-.5);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
