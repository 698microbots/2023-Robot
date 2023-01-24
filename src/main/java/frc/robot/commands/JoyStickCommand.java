// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.*;
import java.util.function.Supplier;

public class JoyStickCommand extends CommandBase {
  /** Creates a new JoyStickCommand. */
  private DriveTrain driveTrain;
  private Supplier <Double> x_value, y_value;

  public JoyStickCommand(DriveTrain driveTrain,Supplier <Double> x_value, Supplier <Double> y_value) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.driveTrain = driveTrain;
    this.x_value = x_value;
    this.y_value = y_value;
    addRequirements(driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    driveTrain.setRightSpeed(0);
    driveTrain.setLeftSpeed(0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double x = x_value.get();
    double y = y_value.get();
    driveTrain.setRightSpeed(y-x);
    driveTrain.setLeftSpeed(y+x);


  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveTrain.setRightSpeed(0);
    driveTrain.setLeftSpeed(0);

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
