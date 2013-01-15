/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hcrhs.frc2012.subsystems;

import edu.hcrhs.frc2012.RobotMap;
import edu.hcrhs.frc2012.commands.DriveWithJoysticks;
import edu.hcrhs.frc2012.utils.MathUtil;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 * @author amorawski
 */
public class DriveTrain extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    private RobotDrive drive;
    private volatile int drivingMode;
    private volatile boolean precissionDriving;
    
    public static final int 
            NORMAL_MODE = 0,
            REVERSED_MODE = 1;
    
    
    public DriveTrain()
    {
        super("DriveTrain");
        drive = new RobotDrive(new Jaguar(RobotMap.digitalModuleSlot, RobotMap.Traction.leftMotor_1), 
                               new Jaguar(RobotMap.digitalModuleSlot, RobotMap.Traction.leftMotor_2), 
                               new Jaguar(RobotMap.digitalModuleSlot, RobotMap.Traction.rightMotor_1), 
                               new Jaguar(RobotMap.digitalModuleSlot, RobotMap.Traction.rightMotor_2));
        
        drive.setSafetyEnabled(false);
        precissionDriving = false;
       
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveWithJoysticks());
       
    }
    
    
    public int getDrivingMode()
    {
        return drivingMode;
    }
    
    
    public void setReversedMode()
    {
        drivingMode = REVERSED_MODE;
        //System.out.println("Driving reversed");
    }
    
    
    public void setNormalMode()
    {
        drivingMode = NORMAL_MODE;
        //System.out.println("Driving Forward");
    }
    
    public void setPrecssionDriving(boolean b)
    {
        precissionDriving = b;
    }
    
    
    public String getDrivingModeName()
    {
        switch(drivingMode)
        {
            case NORMAL_MODE:
                return "Normal mode";
            case REVERSED_MODE:
                return "Reversed mode";
            default:
                return "Unknown";    
        }
    }
    
    
    public boolean isPrecissionDriving()
    {
        return precissionDriving;
    }
    
    
    public void stop()
    {
       drive.stopMotor();
    }
            
    
    
    //public void tankDrive(Joystick left, Joystick right)
    //{
    //    
    //    drive.tankDrive(left, right);
    //}
    
    public void tankDrive(double left, double right)
    {
        
        double leftS = 0, rightS = 0;
      
        switch(drivingMode)
        {
            case NORMAL_MODE:
                leftS = -left;
                rightS = -right;
                break;
            case REVERSED_MODE:
                leftS = right;
                rightS = left;
                break;
        }
        
        
        
        
        if(!this.isPrecissionDriving())
            drive.tankDrive(leftS, rightS);
        else
        {
            
            drive.tankDrive(leftS/3.0,rightS/3.0); 
        }
    }
    
    
    private double getOriginalSign(double x)
    {
        return x < 0 ? -1d : 1d; 
    }
}
