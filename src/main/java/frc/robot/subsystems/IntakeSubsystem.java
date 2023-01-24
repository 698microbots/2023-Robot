// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
/*
 * We need to sort out the constants for this subsystem, everything else looks pretty decent rn
 */
public class IntakeSubsystem extends SubsystemBase {
    /** Creates a new Intake Motor. */
    private final CANSparkMax intakeMotor;  
  /*
   * Instansiates intakeMotor to allow us to control the motor of the intake
   */
    public IntakeSubsystem() {
      intakeMotor = new CANSparkMax(Constants.deviceIdIntake, CANSparkMax.MotorType.kBrushless);
    }
  
    public void inputCone()
    {
      intakeMotor.set(Constants.intakeMotorSpeed);
    }
  
  
    public void stopMotor()
    {
      if(getElectricCurrent() >= Constants.ampSpike)
        intakeMotor.set(0);
      
    }
  
    public void outputBall()
    {
      intakeMotor.set(-Constants.intakeMotorSpeed);
    }
  
    public double getElectricCurrent()
    {
      return intakeMotor.getOutputCurrent();
    }
  
    
    @Override
    public void periodic() {
      // This method will be called once per scheduler run
    }
}
