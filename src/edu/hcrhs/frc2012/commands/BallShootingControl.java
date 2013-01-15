/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hcrhs.frc2012.commands;

/**
 *
 * @author amorawski
 */

  
public class BallShootingControl extends CommandBase {
    
    
    StopShootingBalls ssb;
    ShootTheBalls stb;
    
    public BallShootingControl() {
        // Use requires() here to declare subsystem dependencies
        //requires(tube);
        requires(flyWheels);
        //requires(tubeGate);
  
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(oi.isShootingBalls())
        {
            System.out.println("Stop shooting");
            ssb = new StopShootingBalls();
            oi.setShootingStatus(false);
            ssb.start();
                    
        }
        else {
            System.out.println("Start shooting");
            stb = new ShootTheBalls();
            oi.setShootingStatus(true);
            stb.start();
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
