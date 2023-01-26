// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.cscore.VideoMode;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class LimeLightSubsystem extends SubsystemBase {
  /** Creates a new LimelightSubSystem. */
  private NetworkTable limeLight;
  private NetworkTableEntry aprilTagID;
  private NetworkTableEntry aprilTagCoords;
  private NetworkTableEntry targets;
  
  public LimeLightSubsystem() {
    limeLight = NetworkTableInstance.getDefault().getTable("limelight");
    aprilTagID = limeLight.getEntry("tid");
    aprilTagCoords = limeLight.getEntry("camtran");
    targets = limeLight.getEntry("tv");

  }
  public double getAprilId(){
    return aprilTagID.getDouble(0);
  }

  public double getAprilCoords(){
    return aprilTagCoords.getDouble(0);
  }

  public double getTargets(){
    return targets.getDouble(0);
  } 
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
