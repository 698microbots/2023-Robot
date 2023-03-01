// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;

  }

  public static final int talonArmPivot = 1;
  public static final int talonLift1 = 2;
  public static final int talonLift2 = 3;
  public static final int extensionMotorID = 0;

  //DriveTrain Motor ID's
  public static final int FRid = 0;
  public static final int BLid = 1;
  public static final int FLid = 3;
  public static final int BRid = 6;

  //DriveTrain Constants
  public static final double turnAdjustment = 0.5;
  public static final double powerAdjustment = 0.5;

  //Controller ID's
  public static final int xBoxControllerid = 0;
  public static final int xRightid = 4;
  public static final int yRightid = 5;
  public static final int xLeftid = 0;
  public static final int yLeftid = 1;

  // turn PID constants
  public static final double turnkP = 0.005;
  public static final double turnkI = 0.0008;
  public static final double turnkD = 0.007;

  // balance PID constants
  public static final double balancekP = 0.007;
  public static final double balancekI = 0;
  public static final double balancekD = 0;

  // auton drive PID constants
  //public static final int kTimeoutMs = 20;
  public static final double driveAdjustment = 0.85;
  public static final int kPIDLoopIdx = 0;//run primary loop
  public static final double kF = 0;
  public static final double kP = 0.00005;
  public static final double kI = 0.0;
  public static final double kD = 0;

  public static final double IactZone = 0;
}
