// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import java.util.List;

import org.opencv.photo.Photo;
import org.photonvision.PhotonCamera;
import org.photonvision.targeting.PhotonPipelineResult;
import org.photonvision.targeting.PhotonTrackedTarget;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.networktables.NetworkTable.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



public class rasberryPiCamera extends SubsystemBase {
  /** Creates a new rasber  ryPiCamera. */
  private PhotonCamera photonCamera = new PhotonCamera("photonvision");
  private NetworkTable piCam;
  private NetworkTableEntry hasTarget;
  private NetworkTableEntry targetArea;
  private NetworkTableEntry targetPose;
  private PhotonPipelineResult result;


  
  public rasberryPiCamera() {
    
    piCam = NetworkTableInstance.getDefault().getTable("photonvision");
    hasTarget = piCam.getEntry("hasTarget");
    targetArea = piCam.getEntry("targetArea");
    targetPose = piCam.getEntry("targetPose");
    this.result = photonCamera.getLatestResult();
    
  }

  public boolean getHasTarget(){
    return hasTarget.getBoolean(false);
  }
  
  public double getTargetArea(){
    return targetArea.getDouble(-0);
  }

  public double getTargetPose(){
    return targetPose.getDouble(-0);
  }
  


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putBoolean("Has Target", getHasTarget());
    SmartDashboard.putNumber("Target Area", getTargetArea());
    SmartDashboard.putNumber("Target Pose", getTargetPose());
  }
}
