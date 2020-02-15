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
    public final static int fLID = 55;
    public final static int fRID = 52;
    public final static int bLID = 54;
    public final static int bRID = 53;

    public final static int INTAKE_LEFT = 57;
    public final static int INTAKE_RIGHT = 56;
    public final static double INTAKE_SPEED = -.7;
    public final static int OUTTAKE = 0;
    public final static int INTAKE_MODULE = 10;

    public static int module = 0;
    //Don't know what module means, lauren just put it in her video
    public static int omID = 53;
    //ID for outake conveyer belt motor
    public static int sol1ID = 54;
    public static int sol2ID = 55;
    //ID for double solenoid which pushes the door both to open and close
}
