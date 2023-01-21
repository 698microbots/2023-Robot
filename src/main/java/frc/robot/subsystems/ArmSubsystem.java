// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class ArmSubsystem extends SubsystemBase {
  /** Creates a new ArmSubsystem. */
  private final TalonFX armPivotMotor = new TalonFX(Constants.talonArmPivot);
  private final TalonFX elevatorLiftMotor1 = new TalonFX(Constants.talonLift1);
  private final TalonFX elevatorLiftMotor2 = new TalonFX(Constants.talonLift2);
  private final TalonFX extensionMotor = new TalonFX(Constants.talonLift2);


  public ArmSubsystem() 
  {
     armPivotMotor.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
     elevatorLiftMotor1.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
     elevatorLiftMotor2.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
    
  }

  //setters
  public void elevatorMove(double speed){
    elevatorLiftMotor1.set(ControlMode.PercentOutput, speed);
    elevatorLiftMotor2.set(ControlMode.PercentOutput, speed);
  }

  public void armPivotMotor(double speed){
    armPivotMotor.set(ControlMode.PercentOutput, speed);
  }

  public void extensionMotor (double speed){
   // extensionMotor.set(speed);
  }

  //getters
  public double getElevatorPosition(){//one revolution is 2048 encoder units.
    double position1 = elevatorLiftMotor1.getSelectedSensorPosition();
    double position2 = elevatorLiftMotor2.getSelectedSensorPosition();
    if(Math.abs(position1 - position2) < 100){
      return (position1 + position2)/2;
    }else{
      return -1;//return '-1' if the two sensor positions vary too much.
    }
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run

  }
}
