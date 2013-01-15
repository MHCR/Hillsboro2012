/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hcrhs.frc2012.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author amorawski
 */
public class RampArmControl extends CommandBase {
    
    public RampArmControl() {
        requires(rampArm);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
        double s = oi.getRampArmSpeed();
        
        SmartDashboard.putDouble("Ramp Arm Speed", s);
        SmartDashboard.putBoolean("Ramp Arm Forward Max", 
                                  rampArm.isArmInForwardPosition());
        SmartDashboard.putBoolean("Ramp Arm Backward Max", 
                                  rampArm.isArmInBackwardPosition());
        
        rampArm.moveArm(s);
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
