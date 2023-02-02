package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import java.util.function.Supplier;

import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrainSubSystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

public class JoyStickDrive 
{
    private final DriveTrainSubSystem driveTrain;
    private Supplier <Double> x_value, y_value;

    public JoyStickDrive(DriveTrainSubSystem driveTrain)
    {
        this.driveTrain = driveTrain;
    }   

    public void execute()
    {
        double x = x_value.get();
        double y = y_value.get();
        driveTrain.setLeftSpeed(x_value);
    }


}
