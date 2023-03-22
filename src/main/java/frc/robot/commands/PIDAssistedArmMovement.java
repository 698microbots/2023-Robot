// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.ArmSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PIDAssistedArmMovement extends CommandBase {
  /** Creates a new PIDAssistedArmMovement. */
  private final ArmSubsystem arm;
  private Supplier<Double> xbox;
  private double target, value;
  public PIDAssistedArmMovement(ArmSubsystem arm, Supplier<Double> xbox) {
    this.arm = arm;
    this.xbox = xbox;
    value = 0;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(arm);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    arm.resetArmPID();
    arm.armMove(0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    value = xbox.get();
    if(Math.abs(value) > 0.04){
      target += value*Constants.kArmPID;
    }
    SmartDashboard.putNumber("Arm PID Target:", target);
    arm.setPIDtarget(target);
    arm.moveArmPID(arm.getArmPosition(), 1);
    if(arm.getArmPosition()<Constants.armFrontEncoderLimit & arm.getArmPosition()>Constants.armBackEncoderLimit){
      arm.armMove(arm.getArmMoveOutput());
    }else{
      arm.armMove(0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    arm.armMove(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
