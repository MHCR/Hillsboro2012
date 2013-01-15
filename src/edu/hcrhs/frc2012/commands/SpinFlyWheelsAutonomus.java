/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hcrhs.frc2012.commands;

import edu.hcrhs.frc2012.RobotMap;

/**
 *
 * @author StageDoorLounge
 */
public class SpinFlyWheelsAutonomus extends CommandBase {
    
    public SpinFlyWheelsAutonomus() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(flyWheels);
        setTimeout(RobotMap.SPINNING_FLYWHEEL_TIMEOUT_AUTON);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //flyWheels.setFullSpeed();
        flyWheels.setFlyWheelSpeed(oi.getLowerFlyWheelSpeed(), 
                                   oi.getUpperFlyWheelSpeed());
        oi.setShootingStatus(true);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
