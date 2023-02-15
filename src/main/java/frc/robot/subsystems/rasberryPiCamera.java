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

import java.lang.invoke.VarHandle;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



public class rasberryPiCamera extends SubsystemBase {
  /** Creates a new rasber  ryPiCamera. */
  private PhotonCamera photonCamera = new PhotonCamera("OV5647");
  private PhotonPipelineResult result;
  private PhotonTrackedTarget target;
  private List<PhotonTrackedTarget> targets;
  private int aprilID;

  
  public rasberryPiCamera() {
    
    
    // piCam = NetworkTableInstance.getDefault().getTable("photonvision");
    // hasTarget = piCam.getEntry("hasTarget");
    // targetArea = piCam.getEntry("targetArea");
    // targetPose = piCam.getEntry("targetPose");
    this.result = photonCamera.getLatestResult();

  }


  public double aprilTagID(){
    aprilID = target.getFiducialId();
    return aprilID;
  }


  public boolean getHasTarget(){
    return result.hasTargets();
  }
  
  public double getTargetArea(){
      target = result.getBestTarget();
      return target.getArea();
  }

  // public double getTargetPose(){
  //   // target = result.getBestTarget();

  //   return 0;
  // }
  


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    result = photonCamera.getLatestResult();
    targets = result.getTargets();
    System.out.println(aprilID);
    SmartDashboard.putNumber("april ID", aprilID);
  }
}
