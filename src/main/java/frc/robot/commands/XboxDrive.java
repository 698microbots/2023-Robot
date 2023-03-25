// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import frc.robot.Constants;

public class XboxDrive extends CommandBase {
  /** Creates a new XboxDrive. */
  private DriveTrain driveTrain;
  private Supplier <Double> x_Supplier, y_Supplier, tSupplier;
  public XboxDrive(DriveTrain driveTrain, Supplier <Double> x_Supplier, Supplier <Double> y_Supplier, Supplier <Double> tSupplier) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.driveTrain = driveTrain;
    this.x_Supplier = x_Supplier;
    this.y_Supplier = y_Supplier;
    this.tSupplier = tSupplier;
    addRequirements(driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    driveTrain.setMotorsCoast();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double L = y_Supplier.get();
    double R = x_Supplier.get();
    // driveTrain.setRightSpeed(Math.pow(Constants.powerAdjustment*(L+R*Constants.turnAdjustment), 3.0));
    // driveTrain.setLeftSpeed(Math.pow(Constants.powerAdjustment*(L-R*Constants.turnAdjustment), 3.0));
    driveTrain.setRightSpeed(Constants.powerAdjustment*(L-0.5*tSupplier.get()+R*Constants.turnAdjustment));
    driveTrain.setLeftSpeed(Constants.powerAdjustment*(L-0.5*tSupplier.get()-R*Constants.turnAdjustment));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveTrain.setRightSpeed(0);
    driveTrain.setLeftSpeed(0);
    driveTrain.setMotorsLocked();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
