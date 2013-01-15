/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hcrhs.frc2012.commands;

/**
 *
 * @author amorawski
 */
public class BallFeederControl extends CommandBase {
    
    AbortBallsPickUp apb;
    PickUpBalls pb;
    
    public BallFeederControl() {
        requires(ballFeeder);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(oi.isPickingBalls())
        {
            oi.setBallFeederStatus(false);
            apb = new AbortBallsPickUp();
            apb.start();
        }
        else
        {
            oi.setBallFeederStatus(true);
            pb = new PickUpBalls();
            pb.start();
        }
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
