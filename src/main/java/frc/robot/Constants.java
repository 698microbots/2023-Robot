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


  //general xbox pins
  public static final int XBOX_R_XAXIS = 4;
  public static final int XBOX_R_YAXIS = 5;
  public static final int XBOX_L_XAXIS = 0;
  public static final int XBOX_L_YAXIS = 1;
  public static final int Xbox_LT = 2;
  public static final int Xbox_RT = 3;

  //We need some flight stick constants I guess
  //Controller Button IDs CONTROLLER 1 (port 0)
  public static final int Xbox_Button_A = 1;
  public static final int Xbox_Button_B = 2;
  public static final int Xbox_Button_X = 3;
  public static final int Xbox_Button_Y = 4;
  public static final int Xbox_Button_LB = 5;
  public static final int Xbox_Button_RB = 6;
  public static final int Xbox_Button_LS = 9;
  public static final int Xbox_Button_RS = 10;
  
  //Controller Button IDs FOR CONTROLLER 2 (port 1)
  public static final int Xbox_Button_AX2 = 1;
  public static final int Xbox_Button_BX2 = 2;
  public static final int Xbox_Button_XX2 = 3;
  public static final int Xbox_Button_YX2 = 4;
  public static final int Xbox_Button_LBX2 = 5;
  public static final int Xbox_Button_RBX2 = 6;
  public static final int Xbox_Button_LSX2 = 9;
  public static final int Xbox_Button_RSX2 = 10;

  public static final int XBOX_R_XAXISX2 = 4;
  public static final int XBOX_R_YAXISX2 = 5;
  public static final int XBOX_L_XAXISX2 = 0;
  public static final int XBOX_L_YAXISX2 = 1;
  public static final int XBOX_pinX2 = 0;
  public static final int Xbox_LTX2 = 2;
  public static final int Xbox_RTX2 = 3;
  
  //Also some motor id constant for the intake

  public static final int deviceIdIntakeM1 = 9;
  public static final int deviceIdIntakeM2 = 10;
  public static final double intakeMotorSpeed = .2;
  public static final int ampSpike= 8;
  public static final int logitechPort6 = 6;
  public static final int logitechPort7 = 7;
  //Controller Stick Constants
  public static final int kDriverControllerPort = 0;
  public static final int talonArmPivot = 1;
  public static final int talonLift1 = 2;
  public static final int talonLift2 = 3;
  public static final int extensionMotorID = 0;
  //arm constant
  public static final int armMotorID = 7;
  public static final double armFrontEncoderLimit = -70000;
  public static final double armBackEncoderLimit = 0;
  public static final double kArmP = 0.00005;
  public static final double kArmI = 0.00000001;
  public static final double kArmD = 0;
  public static final double armGearRatio = 75;// 75:1
  public static final double kArmPID = 30000;

  //DriveTrain Motor ID's
  public static final int FRid = 2;
  public static final int BLid = 3;
  public static final int FLid = 0;
  public static final int BRid = 5;
  // public static final int FRid = 0;
  // public static final int BLid = 1;
  // public static final int FLid = 3;
  // public static final int BRid = 6;
  //DriveTrain Constants
  public static final double turnAdjustment = 0.5;
  public static final double powerAdjustment = 0.5;

  //Controller ID's
  public static final int xBoxControllerid = 0;
  public static final int xRightid = 4;
  public static final int yRightid = 5;
  public static final int xLeftid = 0;
  public static final int yLeftid = 1;

 //Controller 2 ID's
 public static final int xBoxControllerid2 = 1;
 public static final int xRightidX2 = 4;
 public static final int yRightidX2 = 5;
 public static final int xLeftidX2 = 0;
 public static final int yLeftidX2 = 1;

  // turn PID constants
  public static final double turnkP = 0.0034;
  public static final double turnkI = 0.0328;
  public static final double turnkD = 0;
  public static final double maximumDriveError = 1000.0;

  // balance PID constants
  public static final double balancekP = 0.001;
  public static final double balancekI = 0;
  public static final double balancekD = 0;
  public static final double levelConstant = 2;

  // auton drive PID constants
  //public static final int kTimeoutMs = 20;
  public static final double driveAdjustment = 0.85;
  public static final int kPIDLoopIdx = 0;//run primary loop
  public static final double kDriveF = 0;
  public static final double kDriveP = 0.00005;
  public static final double kDriveI = 0.0;
  public static final double kDriveD = 0;

  public static final double IactZone = 0;//was 0.5

  //pi constants
  public static final double CAMERA_HEIGHT_METERS = 0;
  public static final double TARGET_HEIGHT_METERS = 0;
  public static final double CAMERA_PITCH_RADIANS = 0;

  //limelight constants
  public static final double goalHeight = 23.375; //what are the units????
  public static final double limeLightHeight = 16;
  public static final double limeLightInitAngle = 0;
  public static double balanceTarget = 0.9;
  public static final double cameraOffset = 0; // degrees horizontal angle
}