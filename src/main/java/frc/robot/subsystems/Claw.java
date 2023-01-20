// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants;

public class Claw extends SubsystemBase {
  /** Creates a new Claw. */
  private final CANSparkMax leftSpark;
  private final CANSparkMax rightSpark;

  private final DoubleSolenoid clawExtension;

  // 
  public Claw() {
    leftSpark = new CANSparkMax(Constants.leftSparkID, MotorType.kBrushless);
    rightSpark = new CANSparkMax(Constants.rightSparkID, MotorType.kBrushless);
    leftSpark.setInverted(true);

    clawExtension = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.clawSolenoidForwardID, Constants.clawSolenoidReverseID);
  }

  public void setSpeed(double speed) {
    leftSpark.set(speed);
    rightSpark.set(speed);
  }

  public void setClawExtended(boolean state) {
    if (state == true) {
      clawExtension.set(DoubleSolenoid.Value.kForward);
    } else {
      clawExtension.set(DoubleSolenoid.Value.kReverse);
    }
  }

  public void ventClaw() {
    clawExtension.set(DoubleSolenoid.Value.kOff);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
