// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.PneumaticsModuleType;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public final static int mecTID = 56;
    public final static int mecBID = 57;
    public final static int conID = 59;
    // public static int[] driveMotorIDS = { 58, 45, 50, 51 };
    
    public final static int l1ID = 58;
    public final static int l2ID = 45;
    public final static int r1ID = 50;
    public final static int r2ID = 50;


    public final static int PCM = 0;

    
    public final static int intakeSolenoid1 = 0;
    public final static int intakeSolenoid2 = 1;
    public final static int outtakeSolenoid = 2;
}
