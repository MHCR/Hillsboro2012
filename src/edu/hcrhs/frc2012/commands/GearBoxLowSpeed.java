/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hcrhs.frc2012.commands;

/**
 *
 * @author amorawski
 */
public class GearBoxLowSpeed extends CommandBase {
    
    public GearBoxLowSpeed() {
        // Use requires() here to declare subsystem dependencies
        requires(transmission);
        setTimeout(.1);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        transmission.shiftDown();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
        transmission.valveOff();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
