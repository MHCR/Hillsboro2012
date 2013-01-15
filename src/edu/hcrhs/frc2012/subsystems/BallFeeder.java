/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hcrhs.frc2012.subsystems;

import edu.hcrhs.frc2012.RobotMap;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author amorawski
 */
public class BallFeeder extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    Victor ballFeederMotor;
    
    private boolean ballFeederOn; 
    
    public BallFeeder()
    {
        super("BallFeeder");
        ballFeederMotor = new Victor(RobotMap.OtherMotors.ballFeederMotor);
        ballFeederOn = false;
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void setBrushOn()
    {
        ballFeederMotor.set(1.0);
        ballFeederOn = true;
    }
    
    public void setBrushOff()
    {
        ballFeederMotor.set(0);
        ballFeederOn = false;
    }
    
    public boolean isBallFeederOn()
    {
        return ballFeederOn;
    }
}
