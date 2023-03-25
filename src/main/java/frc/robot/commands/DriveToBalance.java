// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.navXSubsystem;
import frc.robot.subsystems.DriveTrain;
import frc.robot.Constants;

public class DriveToBalance extends CommandBase {
  /** Creates a new DriveToBalance. */
  private final navXSubsystem navX;
  private final double initialSpeed;
  private final DriveTrain driveTrain;
  private int counter;
  private boolean firstTilted;
  public DriveToBalance(navXSubsystem navX, DriveTrain driveTrain, double initialSpeed) {
    this.initialSpeed = initialSpeed;
    this.navX = navX;
    this.driveTrain = driveTrain;
    counter = 0;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(navX);
    addRequirements(driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    driveTrain.setTurnTarget(0);
    driveTrain.setTurnTarget(navX.getYaw());
    driveTrain.setMotorsLocked();
    driveTrain.setLeftSpeed(initialSpeed);
    driveTrain.setRightSpeed(initialSpeed);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    driveTrain.PIDturn(navX.getYaw());
    driveTrain.setRightSpeed(initialSpeed + driveTrain.getTurnOutput());
    driveTrain.setLeftSpeed(initialSpeed - driveTrain.getTurnOutput());
    if(Math.abs(navX.getPitch())>12){
      firstTilted = true;
    }
    counter++;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveTrain.setMotorsLocked();
    // driveTrain.setLeftSpeed(0);
    // driveTrain.setRightSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(/*firstTilted && Math.abs(navX.getPitch())*/Math.abs(navX.getPitch())>13){
      return true;
    }else{
      return false;
    }
  }
}
