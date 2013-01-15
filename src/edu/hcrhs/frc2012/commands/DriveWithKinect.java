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
public class DriveWithKinect extends CommandBase {
    
    
    private boolean autonomusEnabled;
    
    public DriveWithKinect() 
    {
        requires(driveTrain);
        autonomusEnabled = true;
    }
    
    
    // Called just before this Command runs the first time
    protected void initialize() 
    {
        driveTrain.setNormalMode();
        oi.setPrecissionDrivingStatus(false);
        driveTrain.setPrecssionDriving(false);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
        double leftS = oi.getLeftKinectSpeed();
        double rightS = oi.getLeftKinectSpeed();
                
        SmartDashboard.putDouble("LeftJoy", leftS);
        SmartDashboard.putDouble("RightJoy", rightS);
        SmartDashboard.putString("Driving mode", driveTrain.getDrivingModeName());
        SmartDashboard.putBoolean("Precission driving", driveTrain.isPrecissionDriving());
                
        driveTrain.tankDrive(leftS, rightS);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return !isAutonomus();
    }

    // Called once after isFinished returns true
    protected void end() {
        driveTrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    
    
    public void setAutonomus(boolean b)
    {
        autonomusEnabled = b;
    }
    
    public boolean isAutonomus()
    {
        return autonomusEnabled;
    }
}
