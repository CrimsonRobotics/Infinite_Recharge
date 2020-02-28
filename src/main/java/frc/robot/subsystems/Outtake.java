/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Outtake extends SubsystemBase {
  /**
   * Creates a new Intake.
   */
  public final double outtakeMoveSpeed = -.2;
  public final double outtakeShootSpeed = -.8;

  public CANSparkMax outtake;

  public Solenoid outtakeDoorSolenoid;

  public boolean doorOpen = false;

  public Outtake() {
    doorOpen = false;

    outtakeDoorSolenoid = new Solenoid(Constants.OUTTAKE_PCM1, Constants.OUTTAKE_SOLENOID);
    outtake = new CANSparkMax(Constants.OUTTAKE_SPARK, MotorType.kBrushless);
  }

  public void OuttakeShoot() { //Outtake forwards
    if(doorOpen == false) {
      System.out.println("Cannot shoot outtake, door is closed");
      return;
    }
    outtake.set(outtakeShootSpeed);
  }

  public void OuttakeReverse() { //Outtake reverse
    System.out.println("Reverse outtake");
    outtake.set(-outtakeMoveSpeed);
  }

  public void OuttakeStop() { //Stops conveyor
    // System.out.println("Stopping outtake");
    outtake.set(0);
  }

  public void OuttakeSlowIn() {
    System.out.println("Outtake slow in");
    outtake.set(outtakeMoveSpeed);
  }

  public void OuttakeDoorOpen() { //Opens outtake door
    outtakeDoorSolenoid.set(true);
    System.out.println("Opening outtake door");
    doorOpen = true;
  }

  public void OuttakeDoorClose() { //Closes outtake door
    outtakeDoorSolenoid.set(false);
    System.out.println("Closing outtake door");
    doorOpen = false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}