// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import java.util.List;

import org.opencv.photo.Photo;
import org.photonvision.PhotonCamera;
import org.photonvision.PhotonUtils;
import org.photonvision.targeting.PhotonPipelineResult;
import org.photonvision.targeting.PhotonTrackedTarget;



public class RasberryPiCamera extends SubsystemBase {
  /** Creates a new rasber  ryPiCamera. */
  private PhotonCamera photonCamera = new PhotonCamera("698"); //original camera name is "OV5647"
  private PhotonPipelineResult result;
  private PhotonTrackedTarget target;
  private List<PhotonTrackedTarget> targets;
  private int aprilID;
  public RasberryPiCamera() {
    
    
    // piCam = NetworkTableInstance.getDefault().getTable("photonvision");
    // hasTarget = piCam.getEntry("hasTarget");
    // targetArea = piCam.getEntry("targetArea");
    // targetPose = piCam.getEntry("targetPose");
    this.result = photonCamera.getLatestResult();
    targets = result.getTargets();

  }


  public double getaprilTagID(){
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

  public double getTargetPose(){
      target = result.getBestTarget();
      return target.getPoseAmbiguity();
  }
  
  public double getTargetSkew(){
    target = result.getBestTarget();
    return target.getSkew();
  }

  public double getTargetYaw(){
    target = result.getBestTarget();
    return target.getYaw();
  }

  public double getTargetPitch(){
    target = result.getBestTarget();
    return target.getPitch();
  }

  public double targetDistance(){
    target = result.getBestTarget();
    return PhotonUtils.calculateDistanceToTargetMeters(Constants.CAMERA_HEIGHT_METERS, Constants.TARGET_HEIGHT_METERS, Constants.CAMERA_PITCH_RADIANS, Units.radiansToDegrees(target.getPitch()));
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    result = photonCamera.getLatestResult();
    target = result.getBestTarget();
  }
}
