/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hcrhs.frc2012.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author amorawski
 */
public class StopShootingBalls extends CommandGroup {
    
    public StopShootingBalls() {
        addParallel(new StopTubeBrushes());
        addParallel(new CloseGate());
        addParallel(new FlyWheelStop());
    }
}
