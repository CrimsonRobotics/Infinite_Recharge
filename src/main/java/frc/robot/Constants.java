/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.I2C;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants. This class should not be used for any other
 * purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the constants are needed, to reduce verbosity.
 */
public final class Constants {
    //Joysticks
    // public static final int driverRight = 1;
    public static final int driverLeft = 0;
    // public static final int coDriver = 4;

    // Control Panel Variables
    //public static final int cpMotorID = 0;
    public static final int controlPanelSpinner = 57;
    public static final int controlPanelSolenoidF = 6;
    public static final int controlPanelSolenoidR = 7;

    public static final int pcm1ID = 0;
    //public static final int cpSoliniodID = 0;
    // Color sensor port definition
    public static final I2C.Port i2c = I2C.Port.kOnboard;
}
