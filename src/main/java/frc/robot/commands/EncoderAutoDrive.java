// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import frc.robot.Constants;
import frc.robot.subsystems.navXSubsystem;

public class EncoderAutoDrive extends CommandBase {
  /** Creates a new EncoderAutoDrivve. */
  private final DriveTrain driveTrain;
  private int counter;
  private final double target;
  private final navXSubsystem navx;
  public EncoderAutoDrive(DriveTrain driveTrain, navXSubsystem navx, double target) { //target in inches
    this.driveTrain = driveTrain;
    this.navx = navx;
    counter = 0;
    this.target = target;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveTrain);
    addRequirements(navx);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    driveTrain.resetDrivePID();
    driveTrain.resetTurnPID();
    driveTrain.resetEncoders();
    driveTrain.setDriveTarget(-target);
    driveTrain.setTurnTarget(navx.getYaw());
    driveTrain.setLeftSpeed(0);
    driveTrain.setRightSpeed(0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // SmartDashboard.putNumber("turn target", driveTrain.getTurnTarget());
    driveTrain.PIDdrive(driveTrain.getEncoderPosition(), 1);
    driveTrain.PIDturn(navx.getYaw());
    
    if (Math.abs(driveTrain.getRightEncoders()) > 1000-Math.abs(driveTrain.getLeftEncoders()) && Math.abs(driveTrain.getRightEncoders()) < 1000+Math.abs(driveTrain.getLeftEncoders())){
    driveTrain.setRightSpeed(driveTrain.getDriveOutput());
    driveTrain.setLeftSpeed(driveTrain.getDriveOutput());    
    } else {
    driveTrain.setRightSpeed(driveTrain.getTurnOutput());
    driveTrain.setLeftSpeed(driveTrain.getTurnOutput());
    }
    // driveTrain.setRightSpeed(driveTrain.getDriveOutput());
    // driveTrain.setLeftSpeed(driveTrain.getDriveOutput());
    // driveTrain.setRightSpeed(driveTrain.getTurnOutput());
    // driveTrain.setLeftSpeed(-driveTrain.getTurnOutput());

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
