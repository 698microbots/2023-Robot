// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.navXSubsystem;

public class AutoTurn extends CommandBase {
  /** Creates a new AutoTurn. */
  private final DriveTrain driveTrain;
  private final navXSubsystem navX;
  private final double turnTarget;
  private int counter;
  public AutoTurn(DriveTrain driveTrain, navXSubsystem navX, double turnTarget) {
    this.driveTrain = driveTrain;
    this.navX = navX;
    this.turnTarget = turnTarget;
    counter = 0;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveTrain);
    addRequirements(navX);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    counter = 0;
    driveTrain.setTurnTarget(turnTarget);
    driveTrain.setLeftSpeed(0);
    driveTrain.setRightSpeed(0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    driveTrain.PIDturn(navX.getYaw());
    driveTrain.setLeftSpeed(-driveTrain.getTurnOutput());
    driveTrain.setRightSpeed(driveTrain.getTurnOutput());
    counter++;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveTrain.setLeftSpeed(0);
    driveTrain.setRightSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(driveTrain.getTurnError()<5){
      return true;
    }else{
    return false;
    }
  }
}
