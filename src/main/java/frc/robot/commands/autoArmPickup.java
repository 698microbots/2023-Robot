// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.DriveTrain;

public class AutoArmPickup extends CommandBase {
  /** Creates a new autoArmPickup. */
  private final ArmSubsystem armSubsystem; 
  private double target, timeOut;
  private int errorCounter, cycleCounter;
  
  public AutoArmPickup(ArmSubsystem armSubsystem, double target, double timeOut) {
    this.armSubsystem = armSubsystem;
    this.target = target;
    this.timeOut = timeOut;
    errorCounter = 0;
    cycleCounter = 0;
    addRequirements(armSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    armSubsystem.resetArmPID();
    armSubsystem.armMove(0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    armSubsystem.moveArmPID(armSubsystem.getArmPosition(), 0.5);
    armSubsystem.armMove(armSubsystem.getArmMoveOutput());
    if (armSubsystem.getArmMoveError() <= 5000){
      errorCounter++;
    } else{
      errorCounter = 0;
    }
    
  }
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (errorCounter > 10 || cycleCounter > (timeOut/20)){
      return true;
    } else {
      return false;
    }
  }
}
