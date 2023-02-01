// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.networktables.NetworkTable.*;

public class rasberryPiCamera extends SubsystemBase {
  /** Creates a new rasber  ryPiCamera. */
  private NetworkTable piCam;
  private NetworkTableEntry hasEntry;
  private NetworkTableEntry aprilTagCoords;
  private NetworkTableEntry targets;
  
  public rasberryPiCamera() {
    piCam = NetworkTableInstance.getDefault().getTable("photonvision");
    hasEntry = piCam.getEntry("hasTarget");
    aprilTagCoords = piCam.getEntry("camtran");
    targets = piCam.getEntry("tv");
  }

  
  public boolean getHasEntry(){
    return hasEntry.getBoolean(getHasEntry());
  }
  
  public double getAprilCoords(){
    return aprilTagCoords.getDouble(getAprilCoords());
  }

   
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
