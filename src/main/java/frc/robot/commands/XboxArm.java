// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.ArmSubsystem;

public class XboxArm extends CommandBase {
  /** Creates a new XboxArm. */
  private final ArmSubsystem armSubsystem;
  private final Supplier <Double> y_Supplier;
  public XboxArm(Supplier<Double>  y_supplier, ArmSubsystem armSubsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.armSubsystem = armSubsystem;
    this.y_Supplier = y_supplier;
    addRequirements(armSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
    
    if (armSubsystem.getArmPosition() >= Constants.armBackEncoderLimit && armSubsystem.getArmPosition() <= Constants.armFrontEncoderLimit){
      if (Math.abs(y_Supplier.get()) <= 0.5){
        armSubsystem.armMove(y_Supplier.get());
      } else {
        armSubsystem.armMove(0);
      }
    }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    armSubsystem.armMove(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
