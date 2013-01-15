/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hcrhs.frc2012.subsystems;

import edu.hcrhs.frc2012.RobotMap;
import edu.hcrhs.frc2012.commands.GearBoxIdle;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author amorawski
 */
public class GearBox extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    DoubleSolenoid gear;
    
    public static final int 
            HIGH_GEAR = 2,
            LOW_GEAR = 1;
    
    private int selectedGear;
    
    
    public GearBox()
    {
        super("GearBox");
        
        gear = new DoubleSolenoid(RobotMap.solenoidModuleSlot,
                                  RobotMap.Pneumatic.highGearPosition, 
                                  RobotMap.Pneumatic.lowGearPosition);
        
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        
        
        setDefaultCommand(new GearBoxIdle());
    }
    
    
    public void shiftUp()
    {
        gear.set(DoubleSolenoid.Value.kForward);
        selectedGear = HIGH_GEAR;
        
    }
    
    public void shiftDown()
    {
        gear.set(DoubleSolenoid.Value.kReverse);
        selectedGear = LOW_GEAR;
    }
    
    
    public void valveOff()
    {
        gear.set(DoubleSolenoid.Value.kOff);
    }
    
    
    public void doNothing()
    {
        
    }
    
    public int getSelectedGear()
    {
        return selectedGear;
    }
    
    public String getSelectedGearName()
    {
        return translateGear();
    }
    
    
    private String translateGear()
    {
        String ret = "";
        
        
        switch(selectedGear)
        {
            case LOW_GEAR:
                return "Low gear";
            case HIGH_GEAR:
                return "High gear";
            default:
                return "invalid status";
        }
    }
}
