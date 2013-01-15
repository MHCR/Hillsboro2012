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
public class DisplayDirection extends CommandBase {
    
    public DisplayDirection() {
        // Use requires() here to declare subsystem dependencies
        requires(direction);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        //direction.setForwardDirection();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(direction.isDrivingForward())
        {
            SmartDashboard.putString("Driving direction:", "forward");
            direction.setForwardDirection();
        }
        else
        {
            SmartDashboard.putString("Driving direction:", "reverse");
            direction.setReverseDirection();
        }
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
