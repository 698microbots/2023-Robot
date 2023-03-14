// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.LimeLightSubsystem;

import frc.robot.subsystems.navXSubsystem;
import frc.robot.Constants;

public class AutoVisionDrive extends CommandBase {
  /** Creates a new AutoVisionDrive. */
  private final DriveTrain driveTrain;
  private final LimeLightSubsystem limelight;
  private final navXSubsystem navX;
  private final double initialSpeed;
  private int counter;
  private boolean triggered;

  public AutoVisionDrive(DriveTrain driveTrain, LimeLightSubsystem limelight, navXSubsystem navX, double initialSpeed) {
    this.driveTrain = driveTrain;
    this.limelight = limelight;
    this.navX = navX;
    this.initialSpeed = initialSpeed;
    this.triggered = false;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveTrain);
    // addRequirements(rasberryPiCamera);
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    driveTrain.setTurnTarget(0);
    driveTrain.setLeftSpeed(initialSpeed);
    driveTrain.setRightSpeed(initialSpeed);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    driveTrain.PIDturn(limelight.getH_angle());
    driveTrain.setLeftSpeed(driveTrain.getTurnOutput());
    driveTrain.setRightSpeed(driveTrain.getTurnOutput());
    if(navX.getPitch() > Constants.levelConstant){
      triggered = true;
    }
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
    if(triggered == true && navX.getPitch() < Constants.levelConstant){
      return true;
    }else{
      return false;
    }
  }
}