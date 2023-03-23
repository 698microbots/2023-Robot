// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.IntakeSubsystem;

public class AutoIntakeCone extends CommandBase {
  /** Creates a new AutoIntakeCone. */
  private final IntakeSubsystem intakeSubsystem;
  private int counter;
  private boolean isReversed;
  private final int timeLimit;
  public AutoIntakeCone(IntakeSubsystem intakeSubsystem, boolean isReversed, int timeLimit) {
    this.intakeSubsystem = intakeSubsystem;
    this.isReversed = isReversed;
    counter = 0;
    this.timeLimit = timeLimit;
    addRequirements(intakeSubsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    intakeSubsystem.setBrakeMode(true);

    if (isReversed){
      intakeSubsystem.intakeSetSpeed(-Constants.intakeMotorSpeed);
    } else if (!isReversed){
      intakeSubsystem.intakeSetSpeed(Constants.intakeMotorSpeed);
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    counter++;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intakeSubsystem.intakeSetSpeed(0);
    intakeSubsystem.setBrakeMode(true);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (counter > timeLimit/20){
      return true;
    } else {
      return false;
    }
  }
}
