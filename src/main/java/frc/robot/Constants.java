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

  public static final int XBOX_R_XAXIS = 4;
  public static final int XBOX_R_YAXIS = 5;
  public static final int XBOX_L_XAXIS = 0;
  public static final int XBOX_L_YAXIS = 1;
  public static final int XBOX_pin = 0;
  public static final int Xbox_LT = 2;
  public static final int Xbox_RT = 3;


  //Controller Button IDs
  public static final int Xbox_Button_A = 1;
  public static final int Xbox_Button_B = 2;
  public static final int Xbox_Button_X = 3;
  public static final int Xbox_Button_Y = 4;
  public static final int Xbox_Button_LB = 5;
  public static final int Xbox_Button_RB = 6;
  public static final int Xbox_Button_LS = 9;
  public static final int Xbox_Button_RS = 10;
  //We need some flight stick constants I guess
  //Also some motor id constant for the intake
  public static final int deviceIdIntake = 8;
  public static final int intakeMotorSpeed = 8;
  public static final int ampSpike= 8;
  
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
    //Controller Stick Constants

  }
}
