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

public class Outake extends SubsystemBase {

  public final double outakeForward = 0.5;
  public final double outakeReverse = -0.5;

  public CANSparkMax outakeMotor = new CANSparkMax(Constants.OUTAKE_MOTORID, MotorType.kBrushless);
  public DoubleSolenoid outakeSol = new DoubleSolenoid(3, 4);
  /**
   * Creates a new Outake.
   */
  public Outake() {

  }

  public void OutakeForward(){
    outakeMotor.set(outakeForward);
  }

  public void OutakeStop(){
    outakeMotor.set(0);
  }

  public void OutakeReverse(){
    outakeMotor.set(outakeReverse);
  }

  public void OutakeOpen(){
    outakeSol.set(Value.kForward);
  }

  public void OutakeClose(){
    outakeSol.set(Value.kReverse);
    }

@Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
