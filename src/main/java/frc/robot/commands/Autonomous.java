package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
//import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.DriveTrain;

public class Autonomous 
{
    DriveTrain driveTrain = new DriveTrain();
    int distance;
    int time;
    int limit;
    
    public Autonomous(DriveTrain driveTrain, int distance, int time, int limit)
    {
        this.driveTrain = driveTrain;
        this.distance = distance;
        this.time = time;
        this.limit = limit;
        //addRequirements(this.driveTrain);
    }

    public void initialize()
    {
        driveTrain.resetDrivePID();
        driveTrain.resetTurnPID();
        driveTrain.PIDturn(-distance*2048/2.75);


    }

    public void execute()
    {
        
    }


}
