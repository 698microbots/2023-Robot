// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import frc.robot.Constants;

public class EncoderAutoDrive extends CommandBase {
  /** Creates a new EncoderAutoDrivve. */
  private final DriveTrain driveTrain;
  private int counter;
  private final double target;
  public EncoderAutoDrive(DriveTrain driveTrain, double target) {
    this.driveTrain = driveTrain;
    counter = 0;
    this.target = target;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    driveTrain.resetDrivePID();
    driveTrain.setDriveTarget(target);
    driveTrain.setLeftSpeed(0);
    driveTrain.setRightSpeed(0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    driveTrain.PIDdrive(target, 0);
    driveTrain.setRightSpeed(driveTrain.getDriveOutput());
    driveTrain.setLeftSpeed(driveTrain.getDriveOutput());
    if(driveTrain.getDriveError() < Constants.maximumDriveError){
      counter++;
    }else{
      counter = 0;
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
    if(counter > 10){
      return true;
    }else{
      return false;
    }
  }
}
