// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  /** Creates a new DriveTrain. */
  private final TalonFX FR = new TalonFX(Constants.FRid);
  private final TalonFX BR = new TalonFX(Constants.BRid);
  private final TalonFX FL = new TalonFX(Constants.FLid);
  private final TalonFX BL = new TalonFX(Constants.BLid);
  public DriveTrain() {
    
  }

  public void setRightSpeed(double speed){
    FR.set(ControlMode.PercentOutput, speed);
    BR.set(ControlMode.PercentOutput, speed);
  }
  public void setLeftSpeed(double speed){
    FL.set(ControlMode.PercentOutput, speed);
    BL.set(ControlMode.PercentOutput, speed);
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
