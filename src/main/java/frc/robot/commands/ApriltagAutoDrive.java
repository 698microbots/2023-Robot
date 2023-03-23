// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.LimeLightSubsystem;
import frc.robot.subsystems.navXSubsystem;


public class ApriltagAutoDrive extends CommandBase {
  /** Creates a new autoDriveApriltag. */
  private DriveTrain driveTrain;
  private LimeLightSubsystem limeLightSubsystem;
  private double H_angle;
  private double distance;
  
  public ApriltagAutoDrive(DriveTrain driveTrain, LimeLightSubsystem limeLightSubsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.driveTrain = driveTrain;
    this.limeLightSubsystem = limeLightSubsystem;
    H_angle = limeLightSubsystem.getH_angle();
    distance = limeLightSubsystem.calculateXdistance();// distance to apriltag
    addRequirements(driveTrain);
    addRequirements(limeLightSubsystem);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    driveTrain.resetDrivePID();
    driveTrain.setDriveTarget(distance); // 
    driveTrain.setLeftSpeed(0);
    driveTrain.setRightSpeed(0);

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    driveTrain.PIDdrive(distance, H_angle);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
