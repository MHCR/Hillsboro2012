/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hcrhs.frc2012.subsystems;

import edu.hcrhs.frc2012.RobotMap;
import edu.hcrhs.frc2012.commands.RampArmControl;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author amorawski
 */
public class RampArm extends Subsystem {
    
    Jaguar rampArmMotor;
    DigitalInput frontLimit, rearLimit;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    
    public RampArm()
    {
        super("RampArm");
        rampArmMotor = new Jaguar(RobotMap.OtherMotors.rampArmMotor);
        
        frontLimit = new DigitalInput(RobotMap.digitalModuleSlot,
                                     RobotMap.Feedback.rampArmDown);
        rearLimit = new DigitalInput(RobotMap.digitalModuleSlot,
                                     RobotMap.Feedback.rampArmUp);
    }

    public void initDefaultCommand() {
        
        setDefaultCommand(new RampArmControl());
    }
    
    
    public void moveArm(double speed)
    {
        
        
        if((isArmInForwardPosition() && getOriginalSign(speed) < 0) 
            || (isArmInBackwardPosition()) && getOriginalSign(speed) > 0)
        {
            rampArmMotor.stopMotor();
        }
        else
            rampArmMotor.set(speed);
    }
    
    
    public boolean isArmInForwardPosition()
    {
        return !frontLimit.get();
    }
    
    
    public boolean isArmInBackwardPosition()
    {
        return !rearLimit.get();
    }
    
    private double getOriginalSign(double x)
    {
        return x < 0 ? -1d : 1d; 
    }
}
