/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hcrhs.frc2012.subsystems;

import edu.hcrhs.frc2012.RobotMap;
import edu.hcrhs.frc2012.commands.TubeIdle;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author amorawski
 */
public class Tube extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private int 
            ballLimit1 = 0,
            ballLimit2 = 0,
            ballLimit3 = 0;
    
    
    DigitalInput limit1, limit2, limit3;
    Jaguar brushMotor;
      
    public Tube()
    {
        super("Tube");
        limit1 = new DigitalInput(RobotMap.digitalModuleSlot, RobotMap.Feedback.ballOneSensor);
        limit2 = new DigitalInput(RobotMap.digitalModuleSlot, RobotMap.Feedback.ballTwoSensor);
        limit3 = new DigitalInput(RobotMap.digitalModuleSlot, RobotMap.Feedback.ballThreeSensor);
        
        brushMotor = new Jaguar(RobotMap.OtherMotors.brushMotor);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new TubeIdle());
    }
    
    public void doNothing()
    {
        
    }
    
    public int getAmountOfBalls()
    {
        updateBalls();
        return ballLimit1 + ballLimit2 + ballLimit3;
    }
    
    
    public void setBrushOn()
    {
        brushMotor.set(.8);
    }
    
    
    public void setBrushOff()
    {
        brushMotor.set(0d);
    }
    
    
   /* public int[] getBallStates()
    {
        updateBalls();
        
        int[] al = new int[3];
        al[0] = ballLimit1;
        al[1] = ballLimit2;
        al[2] = ballLimit3;
        
       return al;
    }
    */
    private void updateBalls()
    {
        if(limit1.get())
            ballLimit1 = 1;
        else
            ballLimit1 = 0;
        if(limit2.get())
            ballLimit2 = 1;
        else
            ballLimit2 = 0;
        if(limit3.get())
            ballLimit3 = 1;
        else
            ballLimit3 = 0;
    }
    
    
    public boolean getBallSensorStatus(int ballSensorId)
    {
        switch(ballSensorId)
        {
            case RobotMap.Feedback.ballOneSensor:
                return limit1.get();
            case RobotMap.Feedback.ballTwoSensor:
                return limit2.get();
            case RobotMap.Feedback.ballThreeSensor:
                return limit3.get();
            default:
                return false;
        }
    }
}
