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
// import com.ctre.phoenix.sensors.PigeonIMU;

public class DriveTrain extends PIDSubsystem {
  /**
   * Creates a new ExampleSubsystem.
   */
  public Timer timer = new Timer();

  public CANSparkMax can = new CANSparkMax(Constants.fLID, MotorType.kBrushless);
  public CANSparkMax can2 = new CANSparkMax(Constants.bLID, MotorType.kBrushless);
  public CANSparkMax can3 = new CANSparkMax(Constants.fRID, MotorType.kBrushless);
  public CANSparkMax can4 = new CANSparkMax(Constants.bRID, MotorType.kBrushless);

  // public TalonSRX talon = new TalonSRX(4);
  // public PigeonIMU gyro = new PigeonIMU(Constants.gyroID);

  //public final CANEncoder leftEncoder = new CANEncoder(Constants.leftEncoders[0], Constants.leftEncoders[1]);
  public final CANEncoder leftEncoder = new CANEncoder(can);
  public final CANEncoder rightEncoder = new CANEncoder(can3);

  public SpeedControllerGroup leftControllerGroup = new SpeedControllerGroup(can, can2);
  public SpeedControllerGroup rightControllerGroup = new SpeedControllerGroup(can3, can4);

  public DifferentialDrive differentialDrive = new DifferentialDrive(leftControllerGroup, rightControllerGroup);

  public double rightStickTime = 0;

  public DriveTrain() {
    super(new PIDController(Constants.P, Constants.I, Constants.D));
    // getController().setTolerance(Constants.driveTolerance);

    // setSetpoint(Constants.DriveTargetPID);

    timer.start();
  }

  public void DriveRob(Joystick leftStick, Joystick rightStick) {
    SmartDashboard.putNumber("Left Stick", leftStick.getY());
    SmartDashboard.putNumber("Right Stick", rightStick.getX());
    SmartDashboard.putNumber("Right Encoder", rightEncoder.getVelocity());
    SmartDashboard.putNumber("Left Encoder", leftEncoder.getVelocity());
    SmartDashboard.putNumber("RightMotor", rightControllerGroup.get());
    SmartDashboard.putNumber("LeftMotor", leftControllerGroup.get());

    double[] ypr = new double[3]; //Three outputs of the PigeonIMU
    // gyro.getYawPitchRoll(ypr);
    SmartDashboard.putNumber("Gyro Yaw", ypr[0]);
    SmartDashboard.putNumber("Gyro Pitch", ypr[1]);
    SmartDashboard.putNumber("Gyro Roll", ypr[2]);

    SmartDashboard.putNumber("Time", timer.get());
    SmartDashboard.putNumber("Cooldown", timer.get() - rightStickTime); //only corrects when going forward, not during turn

    differentialDrive.arcadeDrive(-rightStick.getX(), -leftStick.getY()); //Left stick is forward and backward, right stick is turning

    if((Math.abs(rightStick.getX()) <= .1) == false) {
      rightStickTime = timer.get();
    }

    if((Math.abs(rightStick.getX()) <= .1) == true && timer.get() - rightStickTime >= .5 && Math.abs(leftEncoder.getVelocity() - rightEncoder.getVelocity()) >= 50) {
      final double leftVel = Math.abs(leftEncoder.getVelocity()); //RPM of the encoders
      final double rightVel = Math.abs(rightEncoder.getVelocity());
      final double difference = Math.abs(rightVel) - Math.abs(leftVel);
      

      // SmartDashboard.putNumber("PID Output", getController().calculate(difference));

      SmartDashboard.putBoolean("Compensating", true);

      if(difference <= 0) {
        //Left side is moving faster, left side would be max, right side would be minimum
        SmartDashboard.putNumber("Right Encoder", rightEncoder.getVelocity());

        double max = leftVel;
        double min = rightVel;

        double percent = Math.abs(max / min);
        SmartDashboard.putNumber("Percentage faster", percent);
        rightControllerGroup.set(rightControllerGroup.get() + (leftControllerGroup.get() * (percent / 100)));
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
    SmartDashboard.putNumber("PID Output", output);
    SmartDashboard.putNumber("PID Setpoint", setpoint);
    //differentialDrive.arcadeDrive(.5 + 1 * setpoint, .5 - 1 * setpoint);
  }

  @Override
  protected double getMeasurement() {
    // TODO Auto-generated method stub
    return 0;
  }
}
