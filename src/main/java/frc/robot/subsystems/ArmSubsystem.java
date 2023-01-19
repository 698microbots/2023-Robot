// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenixpro.configs.TalonFXConfiguration;
import frc.robot.Constants;
import com.ctre.phoenixpro.hardware.TalonFX;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import edu.wpi.first.wpilibj.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.IMotorController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.IMotorControllerEnhanced;
import com.ctre.phoenix.motorcontrol.can.BaseMotorController;
import com.ctre.phoenix.motorcontrol.can.BaseTalon;

public class ArmSubsystem extends SubsystemBase {
  /** Creates a new ArmSubsystem. */
  private  final TalonFX FrontRight = new TalonFX(Constants.talonArmPivot);
  private final TalonFX elevatorLiftMotor1 = new TalonFX(Constants.talonLift1);
  private final TalonFX elevatorLiftMotor2 = new TalonFX(Constants.talonLift2);

  public ArmSubsystem() 
  {
    FrontRight.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

  }
}
