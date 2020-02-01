/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.PIDSubsystem;
//import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
// import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.Timer;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class DriveTrain extends PIDSubsystem {
  /**
   * Creates a new ExampleSubsystem.
   */
  public Timer timer = new Timer(); //Timer to track cooldowns for right and left stick

  public CANSparkMax can = new CANSparkMax(Constants.fLID, MotorType.kBrushless);
  public CANSparkMax can2 = new CANSparkMax(Constants.bLID, MotorType.kBrushless);
  public CANSparkMax can3 = new CANSparkMax(Constants.fRID, MotorType.kBrushless);
  public CANSparkMax can4 = new CANSparkMax(Constants.bRID, MotorType.kBrushless);

  public final CANEncoder leftEncoder = new CANEncoder(can);
  public final CANEncoder rightEncoder = new CANEncoder(can3);

  public SpeedControllerGroup leftControllerGroup = new SpeedControllerGroup(can, can2);
  public SpeedControllerGroup rightControllerGroup = new SpeedControllerGroup(can3, can4);

  public DifferentialDrive differentialDrive = new DifferentialDrive(leftControllerGroup, rightControllerGroup);

  public double rightStickTime = 0;
  public double leftStickTime = 0;

  public DriveTrain() {
    super(new PIDController(Constants.P, Constants.I, Constants.D)); //Initialize PID values (not currently being used)
    timer.start();
  }

  public void DriveRob(Joystick leftStick, Joystick rightStick) {
    //Various monitored values
    SmartDashboard.putNumber("Left Stick", leftStick.getY());
    SmartDashboard.putNumber("Right Stick", rightStick.getX());
    SmartDashboard.putNumber("Right Encoder", rightEncoder.getVelocity());
    SmartDashboard.putNumber("Left Encoder", leftEncoder.getVelocity());
    SmartDashboard.putNumber("RightMotor", rightControllerGroup.get());
    SmartDashboard.putNumber("LeftMotor", leftControllerGroup.get());

    differentialDrive.arcadeDrive(-rightStick.getX(), -leftStick.getY()); //Left stick is forward and backward, right stick is turning

    if((Math.abs(rightStick.getX()) <= .1) == false) { //If right stick is being touched
      rightStickTime = timer.get(); //Set the last time the stick was used to the current time
    }
    if((Math.abs(leftStick.getY()) <= .1) == false) { //If left stick is being touched
      leftStickTime = timer.get(); //Set the last time the stick was used to the current time
    }

    //CONDITIONS:
    //left stick is being touched (so it doesn't try to correct itself while stopping)
    //left stick has not been touched for .3 seconds (avoid correction immediately)
    //right stick is not being touched
    //right stick has not been touched for .4 seconds
    //one encoder is going at least 50 ticks faster than the other
    if((Math.abs(leftStick.getY()) >= .1) && timer.get() - leftStickTime >= .3 && (Math.abs(rightStick.getX()) <= .1) == true && timer.get() - rightStickTime >= .4 && Math.abs(Math.abs(leftEncoder.getVelocity()) - Math.abs(rightEncoder.getVelocity())) >= 50) {
      final double leftVel = Math.abs(leftEncoder.getVelocity()); //RPM of the encoders
      final double rightVel = Math.abs(rightEncoder.getVelocity());
      final double difference = Math.abs(rightVel) - Math.abs(leftVel);
      
      SmartDashboard.putBoolean("Compensating", true);

      if(difference <= 0) {
        //Left side is moving faster, left side would be max, right side would be minimum
        SmartDashboard.putNumber("Right Encoder", rightEncoder.getVelocity());

        double max = leftVel;
        double min = rightVel;

        double percent = Math.abs(max / min); //Find how much faster the left side is moving than the right
        SmartDashboard.putNumber("Percentage faster", percent);
        rightControllerGroup.set(rightControllerGroup.get() + (leftControllerGroup.get() * (percent / 100))); //Apply corrective force
      } else{
        //Right side is moving faster
        SmartDashboard.putNumber("Left Encoder", leftEncoder.getVelocity());

        double max = rightVel;
        double min = leftVel;

        double percent = Math.abs(max / min);
        SmartDashboard.putNumber("Percentage faster", percent);
        leftControllerGroup.set(leftControllerGroup.get() + (rightControllerGroup.get() * (percent / 100)));
      }
    } else {
      //If any of the above conditions are not met, run this
      SmartDashboard.putBoolean("Compensating", false);
      differentialDrive.arcadeDrive(-rightStick.getX(), -leftStick.getY());
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  protected void useOutput(double output, double setpoint) {
    // TODO Auto-generated method stub
    SmartDashboard.putNumber("PID Output", output); //Not currently being used
    SmartDashboard.putNumber("PID Setpoint", setpoint); //Not currently being used
  }

  @Override
  protected double getMeasurement() {
    // TODO Auto-generated method stub
    return 0;
  }
}
