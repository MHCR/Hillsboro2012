/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hcrhs.frc2012.subsystems;

import edu.hcrhs.frc2012.RobotMap;
import edu.hcrhs.frc2012.commands.ControlDigiCam;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author amorawski
 */
public class DigitalCamera extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    
    private Servo yAxisServo;
    
    public DigitalCamera()
    {
        super("DigitalCamera");
        yAxisServo = new Servo(RobotMap.digitalModuleSlot, 
                               RobotMap.OtherMotors.digitalCameraYAxis);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ControlDigiCam());
    }
    
    
    public void setYAxis(double y)
    {
        yAxisServo.set(y);
    }
}
