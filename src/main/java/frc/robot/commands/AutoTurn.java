// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.navXSubsystem;

public class AutoTurn extends CommandBase {
  /** Creates a new AutoTurn. */
  private final DriveTrain driveTrain;
  private final navXSubsystem navX;
  private final double turnTarget;
  private int counter;
  private final int timeout;
  private int errorCounter;
  public AutoTurn(DriveTrain driveTrain, navXSubsystem navX, double turnTarget, int timeout) {
    this.driveTrain = driveTrain;
    this.navX = navX;
    this.turnTarget = turnTarget;
    counter = 0;
    errorCounter = 0;
    this.timeout = timeout;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveTrain);
    addRequirements(navX);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    counter = 0;
    driveTrain.setTurnTarget(turnTarget);
    driveTrain.setLeftSpeed(0);
    driveTrain.setRightSpeed(0);
    System.out.println("Auto Turn Initiated");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    driveTrain.PIDturn(navX.getYaw());
    driveTrain.setLeftSpeed(-driveTrain.getTurnOutput());
    driveTrain.setRightSpeed(driveTrain.getTurnOutput());
    // if(Math.abs(driveTrain.getTurnError())<3){
    //   errorCounter++;
    // }else{
    //   errorCounter = 0;
    // }
    counter++;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveTrain.setLeftSpeed(0);
    driveTrain.setRightSpeed(0);
    System.out.println("Autoturn has ended");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(errorCounter>10 || counter > timeout/20){
      return true;
    }else{
    return false;
    }
  }
}
