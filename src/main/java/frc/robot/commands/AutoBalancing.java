// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.navXSubsystem;

public class AutoBalancing extends CommandBase {
  /** Creates a new AutoBalancing. */
  private final navXSubsystem navX;
  private final DriveTrain driveTrain;
  public AutoBalancing(navXSubsystem navX, DriveTrain driveTrain) {
    this.navX = navX;
    this.driveTrain = driveTrain;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(navX);
    addRequirements(driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    driveTrain.resetTurnPID();
    driveTrain.setTurnTarget(navX.getYaw());
    driveTrain.setLeftSpeed(0);
    driveTrain.setRightSpeed(0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    driveTrain.PIDBalance(navX.getRoll());
    driveTrain.PIDturn(navX.getYaw());
    driveTrain.setLeftSpeed(driveTrain.getBalanceOutput() - driveTrain.getTurnOutput());
    driveTrain.setRightSpeed(driveTrain.getBalanceOutput() + driveTrain.getTurnOutput());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveTrain.setLeftSpeed(0);
    driveTrain.setRightSpeed(0);
    driveTrain.setMotorsLocked();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
