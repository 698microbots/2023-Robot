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
    //IntakeMoterL is the lower intake motor
    //IntakeMoterh is the Higher intake motor -  goes opposite direction of lower intake motor
    private final CANSparkMax intakeMotorL;
    private final CANSparkMax intakeMotorH;  
  /*
   * Instansiates intakeMotor to allow us to control the motor of the intake
   */
    public IntakeSubsystem() {
      intakeMotorL = new CANSparkMax(Constants.deviceIdIntake, CANSparkMax.MotorType.kBrushless);
      intakeMotorH = new CANSparkMax(Constants.deviceIdIntake, CANSparkMax.MotorType.kBrushless);
    }
  
    public void inputCone()
    {
      intakeMotorL.set(Constants.intakeMotorSpeed);
      intakeMotorH.set(-Constants.intakeMotorSpeed);
    }
  
  
    public void stopMotor()
    {
      if(getElectricCurrent() >= Constants.ampSpike){
        intakeMotorL.set(0);
        intakeMotorH.set(0);
      }
    }

    //This method is kinda useless since we don't really take anything out throught the intake but its here
    // incase we need to 
    public void outputBall()
    {
      intakeMotorL.set(-Constants.intakeMotorSpeed);
      intakeMotorH.set(-Constants.intakeMotorSpeed);
    }
  
  //The current should be the same between motors since they are moving at the same speed. 
    public double getElectricCurrent()
    {
      return intakeMotorL.getOutputCurrent();
    }
  
    
    @Override
    public void periodic() {
      // This method will be called once per scheduler run
    }
}
