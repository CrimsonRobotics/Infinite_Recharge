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
  public final double outtakeMoveSpeed = .5;
  public final double outtakeShootSpeed = .8;

  public final double intakeSpeed =  -.5;

  public CANSparkMax intakeLeft = new CANSparkMax(Constants.INTAKE_LEFT, MotorType.kBrushless);
  public CANSparkMax intakeRight = new CANSparkMax(Constants.INTAKE_RIGHT, MotorType.kBrushless);

  // public CANSparkMax outtake = new CANSparkMax(Constants.OUTTAKE, MotorType.kBrushless);

  // public DoubleSolenoid outtakeDoorSolenoid = new DoubleSolenoid(Constants.INTAKE_MODULE, 0, 1);

  public Intake() {
  }

  public void IntakeIn(double speed) {
    intakeLeft.set(speed);
    intakeRight.set(speed);
  }

  public void IntakeStop() {
    intakeLeft.set(0);
    intakeRight.set(0);
  }

  public void IntakeOut(double speed) { //Spit out balls via intake
    intakeLeft.set(-speed);
    intakeRight.set(-speed);
  }

  public void OuttakeForward() { //For moving balls forward without shooting
    // outtake.set(outtakeMoveSpeed);
  }

  public void OuttakeShoot() { //Outtake forwards
    // outtake.set(outtakeShootSpeed);
  }

  public void OuttakeReverse() { //Outtake reverse
    // outtake.set(-outtakeMoveSpeed);
  }

  public void OuttakeStop() { //Stops conveyor
    // outtake.set(0);
  }

  public void OuttakeDoorOpen() { //Opens outtake door
    // outtakeDoorSolenoid.set(Value.kForward);
  }

  public void OuttakeDoorClose() { //Closes outtake door
    // outtakeDoorSolenoid.set(Value.kReverse);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
