package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.SPI;


public class navXSubsystem extends SubsystemBase{
    /* Create a new navX subsystem */
    
    //Sets up new AHRS navX with the serial communication as SPI/USB
    private final AHRS navX = new AHRS(SPI.Port.kMXP); //Uses MXP port (the large port in the middle of the RoboRIO)
    //  private final AHRS navX = new AHRS(SerialPort.Port.kUSB); //Uses USB 

    //Constructors
    public navXSubsystem() {
        navX.calibrate();
        navX.resetDisplacement();
    }



    //Getters
    public boolean isConnected() {
        return navX.isConnected();
    }

    public boolean isCalibrating() {
        return navX.isCalibrating();
    }


    public float getYaw() {
        return navX.getYaw();
    }

    public float getPitch() {
        return navX.getPitch();
    }

    public float getRoll() {
        return navX.getRoll();
    }

    public double getYawRate() { //Return the rate of rotation of the yaw (Z-axis) gyro, in degrees per second.
        return navX.getRate();
    }

    public float getDisplacementX() { //Returns the displacement (in meters) of the X axis since resetDisplacement() was last invoked [Experimental].
        return navX.getDisplacementX();
    }

    public float getDisplacementY() {
        return navX.getDisplacementY();
    }

    public float getDisplacementZ() {
        return navX.getDisplacementZ();
    }
}