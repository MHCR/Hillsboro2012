package edu.hcrhs.frc2012;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static final int leftMotor = 1;
    // public static final int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static final int rangefinderPort = 1;
    // public static final int rangefinderModule = 1;
    
    
    public static int digitalModuleSlot = 1;
    public static int analogModuleSlot = 1;
    public static int solenoidModuleSlot = 1;
    
    
    public static double SPINNING_FLYWHEEL_TIMEOUT = 0.2;
    public static double SPINNING_FLYWHEEL_TIMEOUT_AUTON = 0.6;
    
    
    public static interface OperatorControl {
        
        //joys and buttons on joys
        public static int leftStickPort = 2,
                          rightStickPort = 1,
                          rampArmStickPort = 3;
        
        public static final int 
                        highSpeedButton = 1,
                        lowSpeedButton = 1,
                        driveForwardButton = 2,
                        driveReverseButton = 2;
        
        //Kinect
        public static final int
                        kinectStickLeft = 1,
                        kinectStickRight = 2;
        
        
        public static final int
                        kinectEngageKinectBtn = 9,
                        kinectShootTheBallsBtn = 5;
        
        //Buttons and ouptuts on Cypress IO board
        public static final int
                        precissionDrivingOnOff = 3,
                        shootTheBalls = 5,
                        ballFeederOnOff = 4;
        
        
        public static final int
                        precisionDivingStatus = 16,
                        ball_1_Status = 14,
                        ball_2_Status = 10,
                        ball_3_Status = 12,
                        ballFeederStatus = 15,
                        shootingStatus = 7;
        
        public static final int
                        upperFlyWheelMotorSpeed = 8,
                        lowerFlyWheelMotorSpeed = 7;
    }
  
    
    // traction motors and relays
    public static interface Traction {
        
        //motors
        public static final int
                        leftMotor_1 = 2,
                        leftMotor_2 = 3,
                        rightMotor_1 = 7,
                        rightMotor_2 = 6;
        
        //relays
        public static final int
                drivingDirectionRelay = 2;
        
        
    }
    
    
    //all other robot motors
    public static interface OtherMotors {
        
        public static final int
                        rampArmMotor = 8,
                        ballFeederMotor = 9,
                        brushMotor = 1,
                        flyWheelMotor_1 = 4,
                        flyWheelMotor_2 = 5,
                        digitalCameraYAxis = 10;
        
    } 
    
    
    //pneumatic hardware control
    public static interface Pneumatic {
        
        //compressor operation control
        public static final int
                pressureSwitch = 1,
                compressorRelay = 1;
        
        //valves
        public static final int
                lowGearPosition = 3,
                highGearPosition = 1,
                gateClosedPosition = 4,
                gateOpenPosition = 2;
        
    }
    
    
    //feedback from robot sensorium
    public static interface Feedback
    {
        
        
        public static final int
                ballOneSensor = 3,
                ballTwoSensor = 4,
                ballThreeSensor = 2;
       
        //Ramp Arm
        public static final int
                rampArmDown = 5,
                rampArmUp = 6,
                rampArmGyro = 1;  //maybe?
        
       
                
    } 
    
    
}
