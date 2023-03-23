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
  private double value;
  private int limit, counter, target;
  public PIDAssistedArmMovement(ArmSubsystem arm, Supplier<Double> xbox, int target, int millis) {
    this.arm = arm;
    this.xbox = xbox;
    value = 0;
    this.target = target;
    limit = millis;
    counter = 0;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(arm);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    arm.resetArmPID();
    arm.setPIDtarget(target);
    arm.armMove(0);
    counter = 0;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    SmartDashboard.putNumber("Arm PID Target:", target);
    arm.moveArmPID(arm.getArmPosition(), 0.2);
    if(arm.getArmPosition()<Constants.armFrontEncoderLimit && arm.getArmPosition()>Constants.armBackEncoderLimit){
      arm.armMove(arm.getArmMoveOutput());
    }else{
      arm.armMove(0);
    }
    if(Math.abs(arm.getArmMoveError())<1000){
      counter++;
    }else{
      counter = 0;
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
    if(counter > 10){
      return true;
    }else{
      return false;
    }
  }
}
