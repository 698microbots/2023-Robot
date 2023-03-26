 // Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.DriveToBalance;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.navXSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  private RobotContainer m_robotContainer;

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    m_robotContainer = new RobotContainer();
    m_robotContainer.LimeLightSubsystem.setPipeline(7);
  }

  /**
   * This function is called every 20 ms, no matter the mode. Use this for items like diagnostics
   * that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
    // SmartDashboard.putBoolean("Has Target", m_robotContainer.rasberryPiCamera.getHasTarget());
    // SmartDashboard.putNumber("Fiducial ID", m_robotContainer.rasberryPiCamera.getaprilTagID());

    // SmartDashboard.putNumber("Target Area", m_robotContainer.rasberryPiCamera.getTargetArea());
    // SmartDashboard.putNumber("Target Pose", m_robotContainer.rasberryPiCamera.getTargetPose());
    // SmartDashboard.putNumber("Target Yaw", m_robotContainer.rasberryPiCamera.getTargetYaw());
    // SmartDashboard.putNumber("Target Skew", m_robotContainer.rasberryPiCamera.getTargetSkew());
    // SmartDashboard.putNumber("Target Pitch", m_robotContainer.rasberryPiCamera.getTargetPitch());
    // SmartDashboard.putNumber("Target Distance", m_robotContainer.rasberryPiCamera.targetDistance());

    SmartDashboard.putNumber("V Angle", m_robotContainer.LimeLightSubsystem.getV_angle());
    SmartDashboard.putNumber("H Angle", m_robotContainer.LimeLightSubsystem.getH_angle());
    SmartDashboard.putNumber("Z Distance", m_robotContainer.LimeLightSubsystem.calculateXdistance());
    SmartDashboard.putNumber("X Distance", m_robotContainer.LimeLightSubsystem.calculateZdistance());
    SmartDashboard.putNumber("Bot Pose", m_robotContainer.LimeLightSubsystem.getBotPose());
    SmartDashboard.putNumber("AprilTag ID", m_robotContainer.LimeLightSubsystem.getaprilTagID());
    SmartDashboard.putNumber("NavX Yaw", m_robotContainer.navX.getYaw());
    SmartDashboard.putNumber("drive output", m_robotContainer.driveTrain.getDriveOutput());
    SmartDashboard.putNumber("getTurn output", m_robotContainer.driveTrain.getTurnOutput());
    SmartDashboard.putNumber("Right Encoder avg", m_robotContainer.driveTrain.getRightEncoders());
    SmartDashboard.putNumber("Left Encoder avg", m_robotContainer.driveTrain.getLeftEncoders());
    SmartDashboard.putBoolean("navx connected", m_robotContainer.navX.isConnected());
    SmartDashboard.putNumber("Arm Position", m_robotContainer.armSubsystem.getArmPosition());
  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {
    m_robotContainer.driveTrain.setMotorsLocked();
  }

  @Override
  public void disabledPeriodic() {
    m_robotContainer.driveTrain.setMotorsLocked();
  }

  /** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();
    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
    m_robotContainer.navX.calibrate();
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    SmartDashboard.putNumber("NavX Pitch:", (double) m_robotContainer.navX.getPitch());
    SmartDashboard.putNumber("NavX Roll:", (double)m_robotContainer.navX.getRoll());
    SmartDashboard.putNumber("NavX Yaw:", (double)m_robotContainer.navX.getYaw());
    SmartDashboard.putNumber("NavX Compass Heading:", (double)m_robotContainer.navX.getCompass());
    SmartDashboard.putNumber("X-Displacement:", (double)m_robotContainer.navX.getDisplacementX());
    SmartDashboard.putNumber("Y-Displacement:", (double)m_robotContainer.navX.getDisplacementY());
    SmartDashboard.putNumber("X Position:", m_robotContainer.navX.getXPosition());
    SmartDashboard.putNumber("Y Position:", m_robotContainer.navX.getYPosition());
    SmartDashboard.putNumber("FR: Position", m_robotContainer.driveTrain.getFRid());
    SmartDashboard.putNumber("FL: Position", m_robotContainer.driveTrain.getFLid());
    SmartDashboard.putNumber("BR: Position", m_robotContainer.driveTrain.getBRid());
    SmartDashboard.putNumber("BL: Position", m_robotContainer.driveTrain.getBLid());
    
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
    m_robotContainer.LimeLightSubsystem.setPipeline(7);
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    SmartDashboard.putNumber("NavX Pitch:", (double) m_robotContainer.navX.getPitch());
    SmartDashboard.putNumber("NavX Roll:", (double)m_robotContainer.navX.getRoll());
    SmartDashboard.putNumber("NavX Yaw:", (double)m_robotContainer.navX.getYaw());
    SmartDashboard.putNumber("NavX Compass Heading:", (double)m_robotContainer.navX.getCompass());
    SmartDashboard.putNumber("X-Displacement:", (double)m_robotContainer.navX.getDisplacementX());
    SmartDashboard.putNumber("Y-Displacement:", (double)m_robotContainer.navX.getDisplacementY());
    SmartDashboard.putNumber("X Position:", m_robotContainer.navX.getXPosition());
    SmartDashboard.putNumber("Y Position:", m_robotContainer.navX.getYPosition());
    SmartDashboard.putNumber("FR: Position", m_robotContainer.driveTrain.getFRid());
    SmartDashboard.putNumber("FL: Position", m_robotContainer.driveTrain.getFLid());
    SmartDashboard.putNumber("BR: Position", m_robotContainer.driveTrain.getBRid());
    SmartDashboard.putNumber("BL: Position", m_robotContainer.driveTrain.getBLid());
    SmartDashboard.putNumber("Arm Position", m_robotContainer.armSubsystem.getArmPosition());
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {}

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {}
}
