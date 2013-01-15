package edu.hcrhs.frc2012.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.hcrhs.frc2012.OI;
import edu.hcrhs.frc2012.subsystems.*;



/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 * @author Author
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    // Create a single static instance of all of your subsystems
    public static DriveTrain driveTrain = new DriveTrain();
    public static GearBox transmission = new GearBox();
    public static AirCompressor compressor = new AirCompressor();
    public static RampArm rampArm = new RampArm();
    public static FlyWheels flyWheels = new FlyWheels();
    public static BallFeeder ballFeeder = new BallFeeder();
    public static DriveDirectionIndicator direction = new DriveDirectionIndicator();
    public static TubeGate tubeGate = new TubeGate();
    public static Tube tube = new Tube();
    public static DigitalCamera digiCam = new DigitalCamera();

    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();
        oi.init();

        // Show what command your subsystem is running on the SmartDashboard
        SmartDashboard.putData("DriveTrain", driveTrain);
        SmartDashboard.putData("DrivingDirection", direction);
        SmartDashboard.putData("GearBox", transmission);
        SmartDashboard.putData("Compressor", compressor);
        SmartDashboard.putData("Ramp Arm", rampArm);
        SmartDashboard.putData("Fly Wheels", flyWheels);
        SmartDashboard.putData("Ball Feeder", ballFeeder);
        SmartDashboard.putData("Tube Gate", tubeGate);
        SmartDashboard.putData("Tube", tube);
        SmartDashboard.putData("Digital Camera", digiCam);
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
