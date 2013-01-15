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
public class GearBoxIdle extends CommandBase {
    
    public GearBoxIdle() {
        // Use requires() here to declare subsystem dependencies
        requires(transmission);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        //transmission.shiftUp();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        transmission.valveOff();
        transmission.doNothing();
        SmartDashboard.getString("Selected gear", transmission.getSelectedGearName());
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
