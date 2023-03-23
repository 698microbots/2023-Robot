// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LimeLightSubsystem;

public class SetPipeline extends CommandBase {
  /** Creates a new AutoSetPipeline. */
  private final LimeLightSubsystem limeLightSubsystem;
  private final int pipeline;
  private boolean finish;

  public SetPipeline(LimeLightSubsystem limeLightSubsystem, int pipeline) {
    this.pipeline = pipeline;
    this.limeLightSubsystem = limeLightSubsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(limeLightSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    limeLightSubsystem.setPipeline(pipeline);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    finish = true;

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (finish == true){
      return true;
    }
    return false;
  }
}
