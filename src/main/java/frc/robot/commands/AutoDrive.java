// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.navXSubsystem;

public class AutoDrive extends CommandBase {
  /** Creates a new AutoDrive. */
  private final DriveTrain driveTrain;
  private final navXSubsystem navX;
  private double counter;
  private final int millis;
  public AutoDrive(DriveTrain driveTrain, navXSubsystem navX, double target, int millis) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.driveTrain = driveTrain;
    this.navX = navX;
    this.counter = 0;
    this.millis = millis;
    addRequirements(driveTrain);
    addRequirements(navX);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    driveTrain.setLeftSpeed(0);
    driveTrain.setRightSpeed(0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // driveTrain.PIDdrive(driveTrain.get, counter);
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
