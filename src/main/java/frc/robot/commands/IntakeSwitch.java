// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeSwitch extends CommandBase {
  /** Creates a new IntakeSwitch. */
  private final IntakeSubsystem intakeSubsystem;
  private final XboxController xboxController;
  public IntakeSwitch(IntakeSubsystem intakeSubsystem, XboxController xboxController) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.intakeSubsystem = intakeSubsystem;
    this.xboxController = xboxController;

    addRequirements(intakeSubsystem);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    intakeSubsystem.inputCone();
    xboxController.setRumble(RumbleType.kBothRumble, 1.0);
    // Put xbox input here
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intakeSubsystem.stopMotor();
    xboxController.setRumble(RumbleType.kBothRumble, 0);
    //Put container stuff RobotContainer.Xbox.
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
