/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hcrhs.frc2012.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author amorawski && jdigiacomo
 */


public class DriveWithJoysticks extends CommandBase {
    
    
    public DriveWithJoysticks() {
        // Use requires() here to declare subsystem dependencies
        requires(driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        //driveTrain.setNormalMode();
        //oi.setPrecissionDrivingStatus(false);
        //driveTrain.setPrecssionDriving(false);
       
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double leftS = oi.getLeftSpeed();
        double rightS = oi.getRightSpeed();
        boolean pDrive = driveTrain.isPrecissionDriving();
        boolean isDrvFwd = direction.isDrivingForward();
        
        
        SmartDashboard.putDouble("LeftJoy", leftS);
        SmartDashboard.putDouble("RightJoy", rightS);
        //SmartDashboard.putString("Driving mode", driveTrain.getDrivingModeName());
        SmartDashboard.putInt("DRive train direction value:", driveTrain.getDrivingMode());
        SmartDashboard.putBoolean("Driving indicator is driving forward:", isDrvFwd);
        SmartDashboard.putBoolean("Precission driving", pDrive);
        
        oi.setPrecissionDrivingStatus(pDrive);
        
        if(isDrvFwd)
        {
            //System.out.println("Command -> driving forward");
            driveTrain.setNormalMode();
        }
        else
        {
            //System.out.println("Command -> driving reverse");
            driveTrain.setReversedMode();
        }
        
        driveTrain.tankDrive(leftS, rightS);
        
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