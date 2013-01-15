/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hcrhs.frc2012.commands;

import edu.hcrhs.frc2012.utils.MathUtil;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author amorawski
 */
public class PrecissionDriving extends CommandBase {
    
    public PrecissionDriving() {
        requires(driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
        if(driveTrain.isPrecissionDriving())
            driveTrain.setPrecssionDriving(false);
        else
            driveTrain.setPrecssionDriving(true);
        
        oi.setPrecissionDrivingStatus(driveTrain.isPrecissionDriving());
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    
    
    
}
