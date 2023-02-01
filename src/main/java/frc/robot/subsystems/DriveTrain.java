package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

public class DriveTrain extends SubsystemBase{
    private final TalonFX FrontRight = new TalonFX(Constants.FrontRightID);
    private final TalonFX FrontLeft = new TalonFX(Constants.FrontRightID);
    private final TalonFX BackRight = new TalonFX(Constants.BackRightID);
    private final TalonFX BackLeft = new TalonFX(Constants.BackLeftID);

     //PIDturn variables
  private double turnTarget;
  private double turnError;
  private double turnPrevError;
  private double turnP;
  private double turnI;
  private double turnD;
  private double turnOutput;
  

  //PIDdrive variables
  private double driveTarget;
  private double driveError;
  private double drivePrevError;
  private double driveP;
  private double driveI;
  private double driveD;
  private double driveOutput;
  private double potDriveOutput;
  private double prevDriveOutput;

  public DriveTrain(){
    FrontRight.setInverted(false);
    FrontLeft.setInverted(true);
    BackRight.setInverted(false);
    BackLeft.setInverted(true);
    FrontRight.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
    FrontLeft.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
    BackRight.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
    BackLeft.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
    FrontLeft.configReverseSoftLimitEnable(false);
    FrontLeft.configForwardSoftLimitEnable(false);
    FrontRight.configReverseSoftLimitEnable(false);
    FrontRight.configForwardSoftLimitEnable(false);
    BackLeft.configReverseSoftLimitEnable(false);
    BackLeft.configForwardSoftLimitEnable(false);
    BackRight.configReverseSoftLimitEnable(false);
    BackRight.configForwardSoftLimitEnable(false);

     //turn variables
     turnTarget = 0;
     turnError = 0;
     turnPrevError = 0;
     turnP = 0;
     turnI = 0;
     turnD = 0;
     turnOutput = 0;
     //drive variables
     driveTarget = 0;
     driveError = 0;
     drivePrevError = 0;
     driveP = 0;
     driveI = 0;
     driveD = 0;
     driveOutput = 0;
     potDriveOutput = 0;
     prevDriveOutput = 0;
  }

}
