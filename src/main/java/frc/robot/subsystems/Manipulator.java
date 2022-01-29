// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsControlModule;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Manipulator extends SubsystemBase {
  CANSparkMax mecanumTopMotor;
  CANSparkMax conveyorMotor;
  CANSparkMax mecanumBottomMotor;
  
  public DoubleSolenoid intakeSolenoid;
  public Solenoid outtakeSolenoid;
  public Solenoid testSolenoid;
  public boolean doorOpen = false;

  double csSpeed = 0.25;
  double mecSpeed = -0.15;
  double outtakeSpeed = 0.7;
  /** Creates a new Manipulator. */
  
  


    /** Creates a new Intake. */
  
    public Manipulator() {

      mecanumTopMotor = new CANSparkMax(Constants.mecTID, MotorType.kBrushless);
      conveyorMotor = new CANSparkMax(Constants.conID, MotorType.kBrushless);
      mecanumBottomMotor = new CANSparkMax(Constants.mecBID, MotorType.kBrushless);

      conveyorMotor.setInverted(true);
      mecanumTopMotor.setInverted(true);
      mecanumBottomMotor.setInverted(false);

      intakeSolenoid = new DoubleSolenoid(Constants.PCM, PneumaticsModuleType.CTREPCM, Constants.intakeSolenoid1, Constants.intakeSolenoid2);
      outtakeSolenoid = new Solenoid(Constants.PCM, PneumaticsModuleType.CTREPCM, Constants.outtakeSolenoid);


      doorOpen = false;
      
    }
  

    public void intakeIn(){
      mecanumTopMotor.set(mecSpeed);
      conveyorMotor.set(csSpeed);
      mecanumBottomMotor.set(mecSpeed);
    }

    public void intakeStop(){
      mecanumBottomMotor.set(0);
      mecanumTopMotor.set(0);
      conveyorMotor.set(0);
    }

    public void outtake(){
      conveyorMotor.set(outtakeSpeed);
      outtakeSolenoid.set(true);
      doorOpen = true;
    }

    public void outtakeStop(){
      conveyorMotor.set(0);
      outtakeSolenoid.set(false);
      doorOpen = false;
    }
    
    public void intakeArmDown() {
      intakeSolenoid.set(Value.kForward);
    }

    public void intakeArmUp() {
      intakeSolenoid.set(Value.kReverse);
    }
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  } 
}
