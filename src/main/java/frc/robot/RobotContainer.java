// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import frc.robot.subsystems.LimeLightSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.*;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj2.command.Command;
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

  // public RasberryPiCamera rasberryPiCamera = new RasberryPiCamera();
  //Intake
  private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  public final JoystickButton Xbutton = new JoystickButton(Xbox, Constants.Xbox_Button_X);
  public final JoystickButton Ybutton = new JoystickButton(Xbox, Constants.Xbox_Button_Y);

  public final JoystickButton Abutton = new JoystickButton(Xbox, Constants.Xbox_Button_A);
  public final JoystickButton Bbutton = new JoystickButton(Xbox, Constants.Xbox_Button_B);

  public final JoystickButton AbuttonX2 = new JoystickButton(Xbox2, Constants.Xbox_Button_AX2);

  // Replace with CommandPS4Controller or CommandJoystick if needed

  public final DriveTrain driveTrain = new DriveTrain();
  public navXSubsystem navX = new navXSubsystem();
  



  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    driveTrain.setDefaultCommand(new XboxDrive(driveTrain, () -> Xbox.getRightX(), () -> Xbox.getLeftY()));
    armSubsystem.setDefaultCommand(new XboxArm(() -> Xbox2.getLeftY(), armSubsystem));
    intakeSubsystem.setDefaultCommand(new XboxIntake(intakeSubsystem, () -> Xbox2.getRightY()));
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

    // Xbutton.toggleWhenPressed(new XboxIntake(intakeSubsystem, false));
    // Ybutton.toggleWhenPressed(new XboxIntake(intakeSubsystem, true));
    AbuttonX2.whenPressed(new ResetEncoders(driveTrain, armSubsystem));



    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    // return new AutoBalancing(navX, driveTrain);
    // return new SequentialCommandGroup(
    //   new SetPipeline(LimeLightSubsystem, 0),
    //   new Wait(10000),
    //   new SetPipeline(LimeLightSubsystem, 1),
    //   new Wait(10000),
    //   new SetPipeline(LimeLightSubsystem, 2)
    // );

    return new SequentialCommandGroup(
      return 



    )
  }

    // return new SequentialCommandGroup(
    //   new AutoVisionPitch(driveTrain, LimeLightSubsystem, navX, 0.5)
    // );

    


    // return new SequentialCommandGroup(
    //   new SetPipeline(LimeLightSubsystem, 0),
    //   new Wait(10000),
    //   new SetPipeline(LimeLightSubsystem, 1),
    //   new Wait(10000),
    //   new SetPipeline(LimeLightSubsystem, 2)
    // );
    
    // return new SequentialCommandGroup(
    //   new AutoTurn(driveTrain, navX, 180, 2000),
    //   new AutoTurn(driveTrain, navX, 0, 2000),
    //   new AutoTurn(driveTrain, navX, -90, 2000)
    // );

    // return new SequentialCommandGroup(
    //   new EncoderAutoDrive(driveTrain, navX, 30000)
    // );
    // return new SequentialCommandGroup(
    //   new testRightLeftMotor(driveTrain)
    // );


  }
