package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import edu.wpi.first.wpilibj.SPI;//SPI is a smaller connection.
import edu.wpi.first.wpilibj.I2C;


public class navXSubsystem extends SubsystemBase{
    /* Create a new navX subsystem */
    
    //Sets up new AHRS navX with the serial communication as SPI/USB
    private final AHRS navX = new AHRS(I2C.Port.kMXP); //Uses MXP port (the large port in the middle of the RoboRIO), use I2C, not SPI

    //Position Variables
    private double x_Pos;
    private double y_Pos;
    private boolean displacementReset;

    //PID Variables
    double balP;
    double balI;
    double balD;
    double balError;
    double balPrevError;

    //Constructors
    public navXSubsystem() {
        navX.calibrate();
        navX.resetDisplacement();
        x_Pos = 0;
        y_Pos = 0;
        displacementReset = false;
    }

    //Getters
    public boolean isConnected() {
        return navX.isConnected();
    }

    public boolean isCalibrating() {
        return navX.isCalibrating();
    }

    public double getYaw() {
        return navX.getAngle();
    }

    public float getPitch() {
        return navX.getRoll();
    }

    public float getRoll() {
        return navX.getPitch();
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

    public double getCompass(){
        return navX.getCompassHeading();
    }

    public double getXPosition(){
        return x_Pos;
    }

    public double getYPosition(){
        return y_Pos;
    }
    //setters
    public void calibrate(){
        navX.calibrate();
    }

    public void resetYaw(){
        navX.reset();
    }

    public void resetDisplacement(){
        navX.resetDisplacement();
    }

    //PID
    // public double autoBalancingPIDCalculation(){//pitch is negative for down and pitch is positve for up
    //     balError = getRoll();
    // }
    @Override
  public void periodic() {
    // This method will be called once per scheduler run
    x_Pos = getDisplacementX();
    y_Pos = getDisplacementY();

    // if(displacementReset){
    //     resetDisplacement();
    // }else{
    //     displacementReset = true;
    // }
  }
}