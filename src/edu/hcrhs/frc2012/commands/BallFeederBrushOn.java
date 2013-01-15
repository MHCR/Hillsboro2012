/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hcrhs.frc2012.commands;

/**
 *
 * @author Szymon Morawski
 */
public class BallFeederBrushOn extends CommandBase {
    
    public BallFeederBrushOn() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(ballFeeder);
        requires(tubeGate);
        setTimeout(.1);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
        if(!tubeGate.isGateClosed())
            tubeGate.closeGate();
        
        ballFeeder.setBrushOn();
        oi.setBallFeederStatus(true);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
        tubeGate.valveOff();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
