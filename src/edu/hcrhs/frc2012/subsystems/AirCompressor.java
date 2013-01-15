/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hcrhs.frc2012.subsystems;

import edu.hcrhs.frc2012.RobotMap;
import edu.hcrhs.frc2012.commands.PumpTheAir;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author amorawski
 */
public class AirCompressor extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    Compressor compressor;
    
    public AirCompressor()
    {
        super("AirCompressor");
        
        compressor = new Compressor(RobotMap.Pneumatic.pressureSwitch, 
                                    RobotMap.Pneumatic.compressorRelay);        
    }

    public void initDefaultCommand() {
          
        // Set the default command for a subsystem here.
        setDefaultCommand(new PumpTheAir());
    }
    
    
    
    public void start()
    {
        compressor.start();
       
    }
    
    
    public void stop()
    {
        compressor.stop();
    }
    
    
    public boolean isAirTankFull()
    {
        return compressor.getPressureSwitchValue();
        
    }
    
    
    public boolean isEnabled()
    {
        return compressor.enabled();
    }
}
