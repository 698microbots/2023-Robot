// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import frc.robot.subsystems.LimeLightSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.*;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
// import frc.robot.subsystems.RasberryPiCamera;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public LimeLightSubsystem LimeLightSubsystem = new LimeLightSubsystem();
  public ArmSubsystem armSubsystem = new ArmSubsystem();
  public XboxController Xbox = new XboxController(Constants.xBoxControllerid);
  public XboxController Xbox2 = new XboxController(Constants.xBoxControllerid2);
  public final DriveTrain driveTrain = new DriveTrain();
  public navXSubsystem navX = new navXSubsystem();
  private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();

  //button definitions
  private final JoystickButton Xbutton = new JoystickButton(Xbox, Constants.Xbox_Button_X);
  private final JoystickButton Ybutton = new JoystickButton(Xbox, Constants.Xbox_Button_Y);
  private final JoystickButton Abutton = new JoystickButton(Xbox, Constants.Xbox_Button_A);
  private final JoystickButton Bbutton = new JoystickButton(Xbox, Constants.Xbox_Button_B);
  private final JoystickButton RBbutton = new JoystickButton(Xbox, Constants.Xbox_Button_RB);
  private final JoystickButton LBbutton = new JoystickButton(Xbox, Constants.Xbox_Button_LB);
  private final JoystickButton AbuttonX2 = new JoystickButton(Xbox2, Constants.Xbox_Button_A);
  private final JoystickButton BbuttonX2 = new JoystickButton(Xbox2, Constants.Xbox_Button_B);
  private final JoystickButton YbuttonX2 = new JoystickButton(Xbox2, Constants.Xbox_Button_Y);
  private final JoystickButton XbuttonX2 = new JoystickButton(Xbox2, Constants.Xbox_Button_X);
  private final JoystickButton RBbuttonX2 = new JoystickButton(Xbox2, Constants.Xbox_Button_RB);
  private final JoystickButton LBbuttonX2 = new JoystickButton(Xbox2, Constants.Xbox_Button_LB);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    driveTrain.setDefaultCommand(new XboxDrive(driveTrain, () -> Xbox.getRightX(), () -> Xbox.getLeftY(), () -> Xbox.getRightTriggerAxis()));
    armSubsystem.setDefaultCommand(new XboxArm(()-> Xbox2.getRawAxis(Constants.XBOX_L_YAXIS), armSubsystem));
    // armSubsystem.setDefaultCommand(new PIDAssistedArmMovement(armSubsystem, () -> Xbox2.getLeftY()));
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    AbuttonX2.onTrue(new ResetEncoders(driveTrain, armSubsystem));
    LBbuttonX2.whileTrue(new IntakeCube(intakeSubsystem, Xbox2));
    RBbuttonX2.whileTrue(new IntakeCone(intakeSubsystem, Xbox2));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous

      // return new AutoBalancin navX, driveTrain);

      // return new SequentialCommandGroup(
      //   //limelight testing
      // new SetPipeline(LimeLightSubsystem, 0),
      // new Wait(10000),
      // new SetPipeline(LimeLightSubsystem, 1),
      // new Wait(10000),
      // new SetPipeline(LimeLightSubsystem, 2)
      // );
    //auto driving test
    return new SequentialCommandGroup(
      new PIDAssistedArmMovement(armSubsystem, () -> Xbox2.getLeftY(), -66000, 5000),//the arm is capable of 0 to 70,000 range of motion
      new AutoIntakeCone(intakeSubsystem, true, 1000),
      new PIDAssistedArmMovement(armSubsystem, () -> Xbox2.getLeftY(), 0, 5000),//the arm is capable of 0 to 70,000 range of motion
      new EncoderAutoDrive(driveTrain, -220, navX)
      // new DriveToBalance(navX, driveTrain, -0.25),
      // new EncoderAutoDrive(driveTrain, 20, navX)
      // new AutoBalancing(navX, driveTrain)
      // new PIDAssistedArmMovement(armSubsystem, ()-> Xbox2.getLeftY()), 0, 0)
    );
    // return new EncoderAutoDrive(driveTrain, 20000, navX);
    //auto turning test
    // return new SequentialCommandGroup(
    //   new AutoTurn(driveTrain, navX, 180, 2000),
    //   new AutoTurn(driveTrain, navX, 0, 2000),
    //   new AutoTurn(driveTrain, navX, -90, 2000)
    // );
  }
}
