/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class DriveAutonomous extends CommandBase {
  /**
   * Creates a new DriveAutonomous.
   */
  double rightSpeed;
  double leftSpeed;

  double time;

  Timer timer;

  public DriveAutonomous(double lS, double rS, double runTime) {
    System.out.println("Creating new drive command running for " + runTime);
    leftSpeed = lS;
    rightSpeed = rS;
    time = runTime;

    timer = new Timer();

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.reset();
    timer.start();

    System.out.println(timer.get());
    System.out.println("Running for " + time + " seconds..");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.driveTrain.arcadeDrive(leftSpeed, rightSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(timer.get() < time) {
      return false;
    } else {
      return true;
    }
  }
}