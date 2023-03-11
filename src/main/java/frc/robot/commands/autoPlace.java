// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LimeLightSubsystem;
import frc.robot.subsystems.RasberryPiCamera;



public class autoPlace extends CommandBase {
  /** Creates a new autoPlace. */
  private final LimeLightSubsystem limeLightSubsystem;
  private final RasberryPiCamera rasberryPiCamera;
  
  
  public autoPlace(LimeLightSubsystem limeLightSubsystem, RasberryPiCamera rasberryPiCamera) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.limeLightSubsystem = limeLightSubsystem;
    this.rasberryPiCamera = rasberryPiCamera;
    addRequirements(limeLightSubsystem);
    addRequirements(rasberryPiCamera);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}