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

public class Outtake extends SubsystemBase {
  /**
   * Creates a new Intake.
   */
  public final double outtakeMoveSpeed = .3;
  public final double outtakeShootSpeed = .8;

  public CANSparkMax outtake = new CANSparkMax(Constants.OUTTAKE, MotorType.kBrushless);

  public DoubleSolenoid outtakeDoorSolenoid = new DoubleSolenoid(Constants.INTAKE_MODULE, 0, 1);

  public boolean doorOpen = false;

  public Outtake() {
    doorOpen = false;
  }

  public void OuttakeForward() { //For moving balls forward without shooting
    outtake.set(outtakeMoveSpeed);
  }

  public void OuttakeShoot() { //Outtake forwards
    if(doorOpen == false) {
      System.out.println("Cannot shoot outtake, door is closed");
      return;
    }
    outtake.set(outtakeShootSpeed);
  }

  public void OuttakeReverse() { //Outtake reverse
    outtake.set(-outtakeMoveSpeed);
  }

  public void OuttakeStop() { //Stops conveyor
    outtake.set(0);
  }

  public void OuttakeSlowIn() {
    outtake.set(outtakeMoveSpeed);
  }

  public void OuttakeDoorOpen() { //Opens outtake door
    outtakeDoorSolenoid.set(Value.kForward);
    doorOpen = true;
  }

  public void OuttakeDoorClose() { //Closes outtake door
    outtakeDoorSolenoid.set(Value.kReverse);
    doorOpen = false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
