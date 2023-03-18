// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.lang.annotation.Target;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.fasterxml.jackson.annotation.JacksonInject.Value;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  /** Creates a new DriveTrain. */
  private final TalonFX FR = new TalonFX(Constants.FRid);
  private final TalonFX BR = new TalonFX(Constants.BRid);
  private final TalonFX FL = new TalonFX(Constants.FLid);
  private final TalonFX BL = new TalonFX(Constants.BLid);
  
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

  //BalancePID variables
  private double balanceTarget;
  private double balanceError;
  private double balancePrevError;
  private double balanceP;
  private double balanceI;
  private double balanceD;
  private double balanceOutput;

  public DriveTrain() {
    FR.setInverted(false);
    BR.setInverted(false);
    FL.setInverted(true);
    BL.setInverted(true);
    FR.setNeutralMode(NeutralMode.Coast);
    BR.setNeutralMode(NeutralMode.Coast);
    FL.setNeutralMode(NeutralMode.Coast);
    BL.setNeutralMode(NeutralMode.Coast);
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
        //BalancePID variables
        balanceTarget = 0;
        balanceError = 0;
        balancePrevError = 0;
        balanceP = 0;
        balanceI = 0;
        balanceD = 0;
        balanceOutput = 0;
  }

  public void setRightSpeed(double speed){
    FR.set(ControlMode.PercentOutput, speed);
    BR.set(ControlMode.PercentOutput, speed);
  }
  public void setLeftSpeed(double speed){
    FL.set(ControlMode.PercentOutput, speed);
    BL.set(ControlMode.PercentOutput, speed);
  }

  // PIDs reset
  public void resetDrivePID(){
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

  public void resetTurnPID(){
    turnTarget = 0;
    turnError = 0;
    turnPrevError = 0;
    turnP = 0;
    turnI = 0;
    turnD = 0;
    turnOutput = 0;
  }

  //takes in sensor input to turn robot into the correct angle
  public void PIDturn(double sensorInput){
    turnError = turnTarget - sensorInput;
    turnP = turnError;
    turnD = turnError - turnPrevError;

    turnOutput = Constants.turnkP*turnP + Constants.turnkI*turnI + Constants.turnkD*turnD;
    turnPrevError = turnError;
  }

  public void resetEncoders(){
    FR.setSelectedSensorPosition(0);
    FL.setSelectedSensorPosition(0);
    BR.setSelectedSensorPosition(0);
    BL.setSelectedSensorPosition(0);

  }
  public void PIDdrive(double sensorInput, double limit) {
    driveError = driveTarget - sensorInput;
    driveP = driveError;
    driveI += driveError;
    driveD = driveError - drivePrevError;
    
    
    driveOutput = Constants.kP*driveP + Constants.kI*driveI + Constants.kD*driveD;
    if(driveOutput > limit){
      driveOutput = limit;
    }
    if(driveOutput < -limit){
      driveOutput = -limit;
    }

    drivePrevError = driveError;
    prevDriveOutput = driveOutput;
  }  

  public double getTurnOutput()
  {
    return turnOutput;
  }

  //Balance PIDs
  public void PIDBalance(double sensorInput)
  {
    balanceError = balanceTarget - sensorInput;
    balanceP = balanceError;
    balanceI += balanceError;
    balanceD = balanceError - balancePrevError;
    balanceOutput = Constants.balancekP*balanceP + Constants.balancekI*balanceI + Constants.balancekD*balanceD;
    balancePrevError = balanceError;
  }

//getters
  public double getBalanceOutput(){
    return balanceOutput;
  }
  
  public double getDriveOutput(){
    return driveOutput;
  }

  public double getDriveError(){
    return driveError;
  }

  public double getTurnError(){
    return turnError;
  }

  public double getTurnPrevError(){
    return turnPrevError;
  }

  public double getFRid(){
    return FR.getSelectedSensorPosition();
  }
  public double getFLid(){
    return FL.getSelectedSensorPosition();
  }
  public double getBRid(){
    return BR.getSelectedSensorPosition();
  }
  public double getBLid(){
    return BL.getSelectedSensorPosition();
  }
  public void setDriveTarget(double encoderUnit){
    driveTarget = encoderUnit;
  }

  public void setTurnTarget(double degrees){
    turnTarget = degrees;
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
