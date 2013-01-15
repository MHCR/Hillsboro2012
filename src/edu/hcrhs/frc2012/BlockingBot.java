/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.hcrhs.frc2012;


//import edu.hcrhs.frc2012.commands.AutoOperatorCommand;
import edu.hcrhs.frc2012.commands.AutonomusMode;
import edu.hcrhs.frc2012.commands.CommandBase;
import edu.hcrhs.frc2012.commands.InitializeTeleOp;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Watchdog;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class BlockingBot extends IterativeRobot {
    
    //static SmartDashboard station;

    Command autonomousCommand;
    Command ito;
    
    
    

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        // instantiate the command used for the autonomous period
        autonomousCommand = new AutonomusMode();
        
        // Initialize all subsystems
        CommandBase.init();
        
        
    }
    
    

    public void autonomousInit() {
        // schedule the autonomous command (example)
        autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        
        System.out.println("This is my own implementation of AutonomousPeriodic\n");
        
        Scheduler.getInstance().run();
    }
    
    
    public void autonomousContinuous()
    {
        
    }

    public void teleopInit() {
	// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        autonomousCommand.cancel();
        ito = new InitializeTeleOp();
        ito.start();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        
        //SmartDashboard.log("teleop periodic","This is test");
        
        Watchdog.getInstance().feed();
        
        Scheduler.getInstance().run();
    }
    
    
    /**
     * Continuous code for teleop mode should go here. 
     * Users should override this method for code which will be called 
     * repeatedly as frequently as possible while the robot is in teleop mode.
     */
    public void teleopContinuous()
    {
        
    }
    
    
    
    public void disabledInit()
    {
       
    }
    
    
    public void disabledPeriodic()
    {
        
    }
    
    
    public void disabledContinuous()
    {
        
    }
}
