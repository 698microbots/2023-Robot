// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.LimeLightSubsystem;
import frc.robot.subsystems.RasberryPiCamera;

public class VisionAutoDrive extends CommandBase {
  /** Creates a new VisionAutoDrive. */
  private final DriveTrain driveTrain;
  private final RasberryPiCamera rasberryPiCamera;
  private final LimeLightSubsystem limeLightSubsystem;
  private final double target;
  private final int aprilID;
  private int counter;

  public VisionAutoDrive(DriveTrain driveTrain, RasberryPiCamera rasberryPiCamera, LimeLightSubsystem limeLightSubsystem, double target, int aprilID) {
    this.driveTrain = driveTrain;
    this.limeLightSubsystem = limeLightSubsystem;
    this.rasberryPiCamera = rasberryPiCamera;
    this.target = target;
    this.aprilID = aprilID;
    counter = 0;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveTrain);
    addRequirements(rasberryPiCamera);
    addRequirements(limeLightSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    driveTrain.setDriveTarget(target);
    driveTrain.resetDrivePID();
    driveTrain.setLeftSpeed(0);
    driveTrain.setRightSpeed(0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
