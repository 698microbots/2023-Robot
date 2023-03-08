// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeSwitch extends CommandBase {
  /** Creates a new IntakeSwitch. */
  private final IntakeSubsystem intakeSubsystem;
  private final boolean reverse;

  public IntakeSwitch(IntakeSubsystem intakeSubsystem, boolean reverse) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.intakeSubsystem = intakeSubsystem;
    this.reverse = reverse;
    addRequirements(intakeSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // Put xbox input here
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (reverse == true) {
      intakeSubsystem.outputGP();
    } else {
      intakeSubsystem.intakeGP();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intakeSubsystem.stopMotor();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
