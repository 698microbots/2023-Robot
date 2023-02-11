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
  private PhotonCamera photonCamera = new PhotonCamera("OV5647");
  private NetworkTable piCam;
  private NetworkTableEntry hasTarget;
  private NetworkTableEntry targetArea;
  private NetworkTableEntry targetPose;
  private PhotonPipelineResult result;
  private PhotonTrackedTarget target;
  private List<PhotonTrackedTarget> targets;


  
  public rasberryPiCamera() {
    
    
    // piCam = NetworkTableInstance.getDefault().getTable("photonvision");
    // hasTarget = piCam.getEntry("hasTarget");
    // targetArea = piCam.getEntry("targetArea");
    // targetPose = piCam.getEntry("targetPose");
    this.result = photonCamera.getLatestResult();
  }


  public double aprilTagID(){
    return target.getFiducialId();
  }


  public boolean getHasTarget(){
    return result.hasTargets();
  }
  
  public double getTargetArea(){
    if (result.hasTargets() == true){
      target = result.getBestTarget();
      return target.getArea();
    }else {
      return 0;
    }
  }

  public double getTargetPose(){
    // target = result.getBestTarget();

    return 0;
  }
  


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    result = photonCamera.getLatestResult();
    target = photonCamera.getLatestResult().getBestTarget();
  }
}
