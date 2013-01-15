/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hcrhs.frc2012.commands;

/**
 *
 * @author Szymon Morawski
 */
public class FlyWheelStop extends CommandBase {
    
    public FlyWheelStop() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
         requires(flyWheels);
         setTimeout(.1);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    protected void execute() {
        flyWheels.stopFlyWheel();
        oi.setShootingStatus(false);
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
}
