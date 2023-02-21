// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.*;
/*
 * We need to sort out the constants for this subsystem, everything else looks pretty decent rn
 */
public class IntakeSubsystem extends SubsystemBase {
    /** Creates a new Intake Motor. */
    //IntakeMoterL is the lower intake motor
    //IntakeMoterh is the Higher intake motor -  goes opposite direction of lower intake motor
    private final CANSparkMax intakeMotorM1;
    private final CANSparkMax intakeMotorM2;  
  /*
   * Instansiates intakeMotor to allow us to control the motor of the intake
   */
    public IntakeSubsystem() {
      intakeMotorM1 = new CANSparkMax(Constants.deviceIdIntakeM1, CANSparkMax.MotorType.kBrushless);
      intakeMotorM2 = new CANSparkMax(Constants.deviceIdIntakeM2, CANSparkMax.MotorType.kBrushless);
    }
  
    public void intakeGP()
    {
      intakeMotorM1.set(Constants.intakeMotorSpeed);
      intakeMotorM2.set(Constants.intakeMotorSpeed);
    }
  
  
    public void stopMotor()
    {
      intakeMotorM1.set(0);
      intakeMotorM2.set(0);
    }

    //This method is kinda useless since we don't really take anything out throught the intake but its here
    // incase we need to 
    public void outputGP()
    {
      intakeMotorM1.set(-Constants.intakeMotorSpeed);
      intakeMotorM2.set(-Constants.intakeMotorSpeed);
    }
  
  //The current should be the same between motors since they are moving at the same speed. 
    public double getElectricCurrentM1()
    {
      return intakeMotorM1.getOutputCurrent();
    }

    
  
    
    @Override
    public void periodic() {
      // This method will be called once per scheduler run
    }
}
