// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.DriveTrain;

public class AutoArmMove extends CommandBase {
  /** Creates a new autoArmPickup. */
  private final ArmSubsystem armSubsystem; 
  private double target, timeOut, distanceMove;
  private int errorCounter, cycleCounter;
  
  public AutoArmMove(ArmSubsystem armSubsystem, double target, double timeOut) {
    this.armSubsystem = armSubsystem;
    this.target = target;
    this.timeOut = timeOut;
    errorCounter = 0;
    cycleCounter = 0;
    distanceMove = 0;
    addRequirements(armSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    armSubsystem.armMove(0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  
  public void execute() {
    distanceMove = armSubsystem.getArmPosition() - target;
    if(distanceMove > 0){
      armSubsystem.armMove(-.1);
    } else if(distanceMove < 0){
      armSubsystem.armMove(.1);
    }
    cycleCounter++;
  }
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    armSubsystem.armMove(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (armSubsystem.getArmPosition() == target || cycleCounter > timeOut/20){
      return true;
    } else {
      return false;
    }
  }
}
