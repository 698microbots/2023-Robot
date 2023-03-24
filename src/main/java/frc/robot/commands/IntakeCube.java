// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.RobotContainer;

public class IntakeCube extends CommandBase {
  /** Creates a new IntakeSwitch. */
  private final IntakeSubsystem intakeSubsystem;
  private final XboxController xbox2;
  public IntakeCube(IntakeSubsystem intakeSubsystem, XboxController xbox2) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.intakeSubsystem = intakeSubsystem;
    this.xbox2 = xbox2;
    addRequirements(intakeSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    intakeSubsystem.intakeSetSpeed(0);
    xbox2.setRumble(RumbleType.kLeftRumble, 1);
    intakeSubsystem.setBrakeMode(true);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    intakeSubsystem.intakeSetSpeed(Constants.intakeMotorSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intakeSubsystem.stopMotor();
    xbox2.setRumble(RumbleType.kBothRumble, 0);
    intakeSubsystem.setBrakeMode(true);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
