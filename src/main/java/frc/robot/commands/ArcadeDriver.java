// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drivetrain2;

public class ArcadeDriver extends CommandBase {
  // private final Drivetrain2 m_drivetrain2;
  /** Creates a new ArcadeDriver. 
   * @param m_drivetrain2
   * */

  public ArcadeDriver(Drivetrain2 drivetrain2) {

    addRequirements(drivetrain2);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute()
  {
    Robot.m_drivetrain2.ArcadeDriver(RobotContainer.m_lstick.getY(), RobotContainer.m_rstick.getX());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
