
package edu.hcrhs.frc2012;

import edu.hcrhs.frc2012.commands.*;
import edu.hcrhs.frc2012.utils.KinectButton;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStationEnhancedIO;
import edu.wpi.first.wpilibj.DriverStationEnhancedIO.EnhancedIOException;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.KinectStick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.DigitalIOButton;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    
    
    private DriverStationEnhancedIO cypressIO;
    
    private Joystick leftStick, rightStick, rampArmStick;
    
    private KinectStick leftKinectStick, rightKinectStick;
    
    private Button lowSpeedBtn, highSpeedBtn;
    private Button forwardBtn, reverseBtn;
    private Button kinectShootTheBalsBtn;
    
    
    private final static double maximumVoltage = 3.30;
    
    
        
    DigitalIOButton precissionDrivingBtn, shootTheBallsBtn, ballPickupOnOffBnt;
    
  
    
    
    private boolean isShooting, isPicking;
    
    
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // Another type of button you can create is a DigitalIOButton, which is
    // a button or switch hooked up to the cypress module. These are useful if
    // you want to build a customized operator interface.
    // Button button = new DigitalIOButton(1);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
    
    
    public void init()
    {
        cypressIO = DriverStation.getInstance().getEnhancedIO();
        
        
        leftStick = new Joystick(RobotMap.OperatorControl.leftStickPort);
        rightStick = new Joystick(RobotMap.OperatorControl.rightStickPort);
        rampArmStick = new Joystick(RobotMap.OperatorControl.rampArmStickPort);
        
        leftKinectStick = new KinectStick(RobotMap.OperatorControl.kinectStickLeft);
        rightKinectStick = new KinectStick(RobotMap.OperatorControl.kinectStickRight);
        
        kinectShootTheBalsBtn = new KinectButton(leftKinectStick, 
                                                 RobotMap.OperatorControl.kinectShootTheBallsBtn);
        
        lowSpeedBtn = new JoystickButton(leftStick, RobotMap.OperatorControl.lowSpeedButton);
        highSpeedBtn = new JoystickButton(rightStick, RobotMap.OperatorControl.highSpeedButton);
        
        forwardBtn = new JoystickButton(leftStick, RobotMap.OperatorControl.driveForwardButton);
        reverseBtn = new JoystickButton(rightStick, RobotMap.OperatorControl.driveReverseButton);
        
               
        precissionDrivingBtn = new DigitalIOButton(RobotMap.OperatorControl.precissionDrivingOnOff);
        shootTheBallsBtn = new DigitalIOButton(RobotMap.OperatorControl.shootTheBalls);
        ballPickupOnOffBnt = new DigitalIOButton(RobotMap.OperatorControl.ballFeederOnOff);
        
        isShooting = false;
        isPicking = false;
        
        assignCommands();
    }
    
    
    public Joystick getLeftStick()
    {
        return leftStick;
    }
    
    public Joystick getRightStick()
    {
        return rightStick;
    }
    
    public double getLeftSpeed()         
    {
        return leftStick.getAxis(Joystick.AxisType.kY);
    }
    
    public double getRightSpeed()
    {
        return rightStick.getAxis(Joystick.AxisType.kY);
    }
    
    
    public double getLeftKinectSpeed()
    {
        return leftKinectStick.getY();
    }
    
    public double getRightKinectSpeed()
    {
        return rightKinectStick.getY();
        
    }
    
    public double getRampArmSpeed()
    {
        return rampArmStick.getAxis(Joystick.AxisType.kY);
    }
    
    
    public double getCameraYAxis()
    {
        return leftStick.getThrottle();
    }
    
       
    public void setPrecissionDrivingStatus(boolean b)
    {
        try {
            cypressIO.setDigitalOutput(RobotMap.OperatorControl.precisionDivingStatus, b);
        } catch (EnhancedIOException ex) {
            ex.printStackTrace();
            
        }
    }
    
    
    public void setBallFeederStatus(boolean b)
    {
        try {
            cypressIO.setDigitalOutput(RobotMap.OperatorControl.ballFeederStatus, b);
            isPicking = b;
        } catch (EnhancedIOException ex) {
            ex.printStackTrace();
        }
    }
    
    
    public void setBallOneStatus(boolean b)
    {
        try {
            cypressIO.setDigitalOutput(RobotMap.OperatorControl.ball_1_Status, b);
        } catch (EnhancedIOException ex) {
            ex.printStackTrace();
        }
    }
    
    
    public void setBallTwoStatus(boolean b)
    {
        try {
            cypressIO.setDigitalOutput(RobotMap.OperatorControl.ball_2_Status, b);
        } catch (EnhancedIOException ex) {
            ex.printStackTrace();
        }
    }
    
    
    public void setBallThreeStatus(boolean b)
    {
        try {
            cypressIO.setDigitalOutput(RobotMap.OperatorControl.ball_3_Status, b);
        } catch (EnhancedIOException ex) {
            ex.printStackTrace();
        }
    }
    
    
    private void assignCommands()
    {
        lowSpeedBtn.whenPressed(new GearBoxLowSpeed());
        highSpeedBtn.whenPressed(new GearBoxHighSpeed());
        
        forwardBtn.whenPressed(new DriveNormal());
        reverseBtn.whenPressed(new DriveReversed());
        
        precissionDrivingBtn.whenPressed(new PrecissionDriving());
        
        shootTheBallsBtn.whenPressed(new BallShootingControl());
        ballPickupOnOffBnt.whenPressed(new BallFeederControl());
    }
    
    
    public double getUpperFlyWheelSpeed()
    {
        try {
            return cypressIO.getAnalogIn(RobotMap.OperatorControl.upperFlyWheelMotorSpeed)/maximumVoltage;
        } catch (EnhancedIOException ex) {
            ex.printStackTrace();
            return 0d;
        }
    }
    
    public double getUpperFlyWheelSpeedRaw()
    {
        try {
            return cypressIO.getAnalogIn(RobotMap.OperatorControl.upperFlyWheelMotorSpeed);
        } catch (EnhancedIOException ex) {
            ex.printStackTrace();
            return 0d;
        }
    }
    
    public double getLowerFlyWheelSpeed()
    {
        try {
            return cypressIO.getAnalogIn(RobotMap.OperatorControl.lowerFlyWheelMotorSpeed)/maximumVoltage;
        } catch (EnhancedIOException ex) {
            ex.printStackTrace();
            return 0d;
        }
    }
    
    public double getLowerFlyWheelSpeedRaw()
    {
        try {
            return cypressIO.getAnalogIn(RobotMap.OperatorControl.lowerFlyWheelMotorSpeed);
        } catch (EnhancedIOException ex) {
            ex.printStackTrace();
            return 0d;
        }
    }
    
    
    public void setShootingStatus(boolean b)
    {
        
        try {
            cypressIO.setDigitalOutput(RobotMap.OperatorControl.shootingStatus, b);
            isShooting = b;
        } catch (EnhancedIOException ex) {
            ex.printStackTrace();
        }
    }
    
    
    
    public boolean isShootingBalls()
    {
        return isShooting;
    }
    
    
    public boolean isPickingBalls()
    {
        return isPicking;
    }
}

