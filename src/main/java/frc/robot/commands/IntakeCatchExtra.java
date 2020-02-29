/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Constants;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class IntakeCatchExtra extends SequentialCommandGroup {
  /**
   * Creates a new IntakeCatchExtra.
   */
  public IntakeCatchExtra() {
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());
    super(
      new OuttakeStop(),
      new IntakeIn(Constants.INTAKE_SPEED / 2), 
      new WaitCommand(.1),
      new IntakeIn(Constants.INTAKE_SPEED / 4), 
      new WaitCommand(.1),
      new IntakeStop(), 
      new WaitCommand(.1), 
      new IntakeReverse(Constants.INTAKE_SPEED / 4), 
      new WaitCommand(.1), 
      new IntakeReverse(Constants.INTAKE_SPEED / 2), 
      new WaitCommand(.1), 
      new IntakeReverse(Constants.INTAKE_SPEED), 
      new WaitCommand(.2), 
      new IntakeStop()
    );
  }
}
