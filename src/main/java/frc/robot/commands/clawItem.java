// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Claw;
import frc.robot.Constants;

public class clawItem extends CommandBase {
  /** Creates a new clawItem. */
  private Claw claw;
  public clawItem(Claw claw) {
    this.claw = claw;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(this.claw);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    claw.setSpeed(Constants.clawMotorspeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    claw.setSpeed(0);
    return false;
  }
}
