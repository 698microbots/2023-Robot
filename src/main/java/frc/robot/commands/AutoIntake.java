// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;

public class AutoIntake extends CommandBase {
  /** Creates a new AutoIntake. */
  private final IntakeSubsystem intakeSubsystem;
  private final double speed, timeout;
  private int counter;
  public AutoIntake(IntakeSubsystem intakeSubsystem, double speed, double timeout) {
    this.intakeSubsystem = intakeSubsystem;
    this.speed = speed;
    this.timeout = timeout;
    counter = 0;

    addRequirements(intakeSubsystem);
    
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    intakeSubsystem.intakeSetSpeed(speed);
    counter++;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intakeSubsystem.intakeSetSpeed(0);

  }
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (counter > timeout/20){
      return true;
    } else {
      return false;
    }
  }
}
