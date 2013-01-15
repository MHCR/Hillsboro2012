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
public class PumpTheAir extends CommandBase {
    
    public PumpTheAir() {
        // Use requires() here to declare subsystem dependencies
        requires(compressor);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        compressor.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
        SmartDashboard.putBoolean("Compressor Presure Sensor", compressor.isAirTankFull());
        SmartDashboard.putBoolean("Compressor enabled", compressor.isEnabled());
        
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
