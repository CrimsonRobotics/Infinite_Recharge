/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends PIDSubsystem {
  /**
   * Creates a new ExampleSubsystem.
   */
  CANSparkMax FrontLeft;
  CANSparkMax FrontRight;
  CANSparkMax BackLeft;
  CANSparkMax BackRight;

  public DriveTrain(int FL, int FR, int BL, int BR) {
    super(new PIDController(Constants.P, Constants.I, Constants.D));
    // getController().setTolerance(Constants.driveTolerance);
    
    FrontLeft = new CANSparkMax(FL,MotorType.kBrushless);
    FrontRight = new CANSparkMax(FR,MotorType.kBrushless);
    BackLeft = new CANSparkMax(BL,MotorType.kBrushless);
    BackRight = new CANSparkMax(BR,MotorType.kBrushless);

  }
  public void arcadeDrive(){
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  protected void useOutput(double output, double setpoint) {
    // TODO Auto-generated method stub
    //differentialDrive.arcadeDrive(.5 + 1 * setpoint, .5 - 1 * setpoint);
  }

  @Override
  protected double getMeasurement() {
    // TODO Auto-generated method stub
    return 0;
  }
}
