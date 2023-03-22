// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.CAN;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.revrobotics.CANSparkMax;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class ArmSubsystem extends SubsystemBase {
  /** Creates a new ArmSubsystem. */
  // private final CANSparkMax armMotor = new CANSparkMax(Constants.armMotorID, MotorType.kBrushless);
  private final TalonFX armMotor = new TalonFX(Constants.armMotorID);
  private double armTarget;
  private double armError;
  private double armPrevError;
  private double armP;
  private double armI;
  private double armD;
  private double armOutput;
  private double prevArmOutput;


  public ArmSubsystem() 
  {
    armTarget = 0;
    armError = 0;
    armPrevError = 0;
    armP = 0;
    armI = 0;
    armD = 0;
    armOutput = 0;
    prevArmOutput = 0;
  }

  //setters
  public void armMove(double speed){
    // armMotor.set(speed);
    armMotor.set(ControlMode.PercentOutput, speed);
  }

  public void resetArmEncoders(){
    armMotor.setSelectedSensorPosition(0);
  }

  public double getArmPosition(){
    // return armMotor.getEncoder().getPosition();
    return armMotor.getSelectedSensorPosition();
  }

  // public double getArmSpeed(){
  //   return armMotor.get();

  // }

  public void resetArmPID(){
    armTarget = 0;
    armError = 0;
    armPrevError = 0;
    armP = 0;
    armI = 0;
    armD = 0;
    armOutput = 0;
    prevArmOutput = 0;
  }

  public void moveArmPID(double sensorInput, double limit){
    armError = armTarget - sensorInput;
    armP = armError;
    armI += armError;
    armD = armError - armPrevError;
    
    
    armOutput = Constants.kArmP*armP + Constants.kArmI*armI + Constants.kArmD*armD;
    if(armOutput > limit){
      armOutput = limit;
    }

    if(armOutput < -limit){
      armOutput = -limit;
    }

    armPrevError = armError;
    prevArmOutput = armOutput;
  }
  
  public double getArmMoveOutput(){
    return armOutput;
  }

  public double getArmMoveError(){
    return armError;
  }
  //getters
  // public double getElevatorPosition(){//one revolution is 2048 encoder units.
  //   double position1 = elevatorLiftMotor1.getSelectedSensorPosition();
  //   double position2 = elevatorLiftMotor2.getSelectedSensorPosition();
  //   if(Math.abs(position1 - position2) < 100){
  //     return (position1 + position2)/2;
  //   }else{
  //     return -1;//return '-1' if the two sensor positions vary too much.
  //   }
  // }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run

  }
}
