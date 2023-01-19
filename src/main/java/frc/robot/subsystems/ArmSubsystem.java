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

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class ArmSubsystem extends SubsystemBase {
  /** Creates a new ArmSubsystem. */
  private  final TalonFX armPivotMotor = new TalonFX(Constants.talonArmPivot);
  private final TalonFX elevatorLiftMotor1 = new TalonFX(Constants.talonLift1);
  private final TalonFX elevatorLiftMotor2 = new TalonFX(Constants.talonLift2);
  private final CANSparkMax extensionMotor = new CANSparkMax(Constants.extensionMotorID, MotorType.kBrushless);

  public ArmSubsystem() 
  {
    // armPivotMotor.configSelectedFeedbackSensor();
  }

  //setters
  public void elevatorMove(double speed){
    elevatorLiftMotor1.set(speed);
    elevatorLiftMotor2.set(speed);
  }

  public void armPivotMotor(double speed){
    armPivotMotor.set(speed);
  }

  public void extensionMotor (double speed){
    extensionMotor.set(speed);
  }

  //getters
  public double getElevatorPosition(){

  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run

  }
}
