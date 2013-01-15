/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hcrhs.frc2012.commands;

import edu.hcrhs.frc2012.RobotMap;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author amorawski
 */
public class TubeIdle extends CommandBase {
    
    public TubeIdle() {
        requires(tube);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        tube.doNothing();
        
        
        boolean b1, b2, b3;
        
        b1 = tube.getBallSensorStatus(RobotMap.Feedback.ballOneSensor);
        b2 = tube.getBallSensorStatus(RobotMap.Feedback.ballTwoSensor);
        b3 = tube.getBallSensorStatus(RobotMap.Feedback.ballThreeSensor);
        
        
        if (b1 && b2 && b3 && oi.isPickingBalls())
        {
            tube.setBrushOff();
            ballFeeder.setBrushOff();
        }
            
        
        
        oi.setBallOneStatus(tube.getBallSensorStatus(RobotMap.Feedback.ballOneSensor));
        oi.setBallTwoStatus(tube.getBallSensorStatus(RobotMap.Feedback.ballTwoSensor));
        oi.setBallThreeStatus(tube.getBallSensorStatus(RobotMap.Feedback.ballThreeSensor));
        //oi.setShootingStatus(flyWheels.isFlyWheelOn());
        
        
        
        SmartDashboard.putBoolean("Ball 1 Status:", 
                                   tube.getBallSensorStatus(RobotMap.Feedback.ballOneSensor));
        SmartDashboard.putBoolean("Ball 2 Status:", 
                                   tube.getBallSensorStatus(RobotMap.Feedback.ballTwoSensor));
        SmartDashboard.putBoolean("Ball 3 Status:", 
                                   tube.getBallSensorStatus(RobotMap.Feedback.ballThreeSensor));
        
        SmartDashboard.putBoolean("Fly Wheels are on:", flyWheels.isFlyWheelOn());
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
