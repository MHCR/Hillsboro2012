/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hcrhs.frc2012.subsystems;

import edu.hcrhs.frc2012.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Szymon Morawski
 */
public class TubeGate extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    private DoubleSolenoid gate;
    private boolean gateClosed;
    
    public TubeGate()
    {
        super("TubeGate");
        gate = new DoubleSolenoid(RobotMap.solenoidModuleSlot, 
                                  RobotMap.Pneumatic.gateOpenPosition, 
                                  RobotMap.Pneumatic.gateClosedPosition);
        gateClosed = true;
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void openGate()
    {
        gate.set(DoubleSolenoid.Value.kForward);
    }
    
    public void closeGate()
    {
        gate.set(DoubleSolenoid.Value.kReverse);
    }
    
    
    public void valveOff()
    {
        gate.set(DoubleSolenoid.Value.kOff);
    }
    
    
    public boolean isGateClosed()
    { 
        return gateClosed;
    }
}
