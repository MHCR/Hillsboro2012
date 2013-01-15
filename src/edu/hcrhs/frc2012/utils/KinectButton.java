/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hcrhs.frc2012.utils;

import edu.wpi.first.wpilibj.KinectStick;
import edu.wpi.first.wpilibj.buttons.Button;

/**
 *
 * @author amorawski
 */
public class KinectButton extends Button {
    
    private int buttonNumber;
    private KinectStick stick;
    
    
    public KinectButton(KinectStick stick, int buttonId)
    {
        this.stick = stick;
        buttonNumber = buttonId;
    }

    public boolean get() {
        return stick.getRawButton(buttonNumber);
    }
    
}
