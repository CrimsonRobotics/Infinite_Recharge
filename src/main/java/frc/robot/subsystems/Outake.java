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

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ODoorOpen;

public class Outake extends SubsystemBase {
  /**
   * Creates a new Outake.
   */
  //Name motor
  CANSparkMax conveyerBelt;
  //name of solenoid
  DoubleSolenoid DoubleSolenoid; 
  //set speed
  public final double Speed = .8;
  public final double SpeedReverse = -.8;
  public Outake(int mod, int omID, int sol1ID, int sol2ID) {
    conveyerBelt = new CANSparkMax(omID, MotorType.kBrushless);
    // Use addRequirements() here to declare subsystem dependencies.
   DoubleSolenoid = new DoubleSolenoid(mod, sol1ID, sol2ID);
  }
//set speed to motors for different commandtype stuff

//reverse of shooter
public void OutakeReverse() {
      conveyerBelt.set(SpeedReverse);
  }

  //shooter
  public void OutakeShoot(){
      conveyerBelt.set(Speed);
  }

  //Shut down incase of emergencies
  public void OutakeShutDown(){
      conveyerBelt.set(0);
  }

  //door close
  public void ODoorClose(){
   DoubleSolenoid.set(Value.kReverse);
  }

  //door open
  public void ODoorOpen(){
    DoubleSolenoid.set(Value.kForward);
  }
  // Called when the command is initially scheduled.
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
