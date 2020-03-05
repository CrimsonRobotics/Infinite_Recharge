/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public final static int INTAKE_TOP = 56;
    public final static int INTAKE_BOTTOM = 45;

    public final static double INTAKE_SPEED = .7;

    public final static int OUTTAKE_SPARK = 59;
    public final static int OUTTAKE_SOLENOID = 2;

    public final static int INTAKE_SOLENOID1 = 0;
    public final static int INTAKE_SOLENOID2 = 1;
    
    public final static int OUTTAKE_PCM1 = 0;

    public final static int INTAKE_IN_BUTTON = 8;
    public final static int INTAKE_ARM_BUTTON = 9;
    public final static int OUTTAKE_BUTTON = 10;
}