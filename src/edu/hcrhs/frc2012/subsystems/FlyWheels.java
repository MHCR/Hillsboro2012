/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hcrhs.frc2012.subsystems;

import edu.hcrhs.frc2012.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Jaguar;


/**
 * 
 * @author Szymon Morawski
 */
public class FlyWheels extends Subsystem {  

    Jaguar flyWheelMotor_1, flyWheelMotor_2;
    
    private volatile boolean flyWheelsOn;
    
    public FlyWheels()
    {
        super("FlyWheels");
        flyWheelMotor_1 = new Jaguar(RobotMap.OtherMotors.flyWheelMotor_1);
        flyWheelMotor_2 = new Jaguar(RobotMap.OtherMotors.flyWheelMotor_2);
        flyWheelsOn = false;
    }
    

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public double getSpeedOfMotorOne()
    {
        return flyWheelMotor_1.get();
    }
    
    public double getSpeedOfMotorTwo()
    {
        return flyWheelMotor_2.get();
    }
    
    public void setFullSpeed()
    {
        flyWheelMotor_1.set(1.0);
        flyWheelMotor_2.set(1.0);
        flyWheelsOn = true;
    }
    
    public void setHalfSpeed()
    {
        flyWheelMotor_1.set(.5);
        flyWheelMotor_2.set(.5);
        flyWheelsOn = true;
    }
    
    public void stopFlyWheel()
    {
        flyWheelMotor_1.set(0);
        flyWheelMotor_2.set(0);
        flyWheelsOn = false;
    }
    
    public void setLowerMotorSpeed(double v)
    {
        flyWheelMotor_1.set(v);
    }
    
    public void setUpperMotorSpeed(double v)
    {
        flyWheelMotor_2.set(v);
        
    }
    
    public void setFlyWheelsOn(boolean b)
    {
        flyWheelsOn = b;
    }
    
    public void setFlyWheelSpeed(double lower, double upper)
    {
        this.setLowerMotorSpeed(-lower);
        this.setUpperMotorSpeed(upper);
    }
    
    
    public boolean isFlyWheelOn()
    {
        return flyWheelsOn;
    }
}
