/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ControlPanel extends SubsystemBase {
  /**
   * Creates a new ControlPanel.
   */

   //REMEMBER THAT THE COLOR SENSOR IS NOT DIRECTLY ABOVE THE CORRECT COLOR, IT WILL BE ONE SPACE OFF

  public ControlPanel() {

  }

  public void PositionControl() {
    //Retrieving the color sent to the robot by the field messaging system
    String gameData = DriverStation.getInstance().getGameSpecificMessage();
    if (gameData.length() > 0) {
      switch (gameData.charAt(0)) {
        case 'G' : 
          SmartDashboard.putString("Spining to color", "Green");
        break;
        case 'B' : 
          SmartDashboard.putString("Spining to color", "Blue");
        break;
        case 'Y' : 
          SmartDashboard.putString("Spining to color", "Yellow");
        break;
        case 'R' : 
          SmartDashboard.putString("Spining to color", "Red");
        break;
      }
    } else {
      System.out.println("No gamedata");
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
