/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
// import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  // motor definitions
  Spark leftMotor1 = new Spark(0);
  Spark leftMotor2 = new Spark(1);
  Spark rightMotor1 = new Spark(2);
  Spark rightMotor2 = new Spark(3);
  SpeedControllerGroup leftMotors = new SpeedControllerGroup(leftMotor1, leftMotor2);
  SpeedControllerGroup rightMotors = new SpeedControllerGroup(rightMotor1, rightMotor2);
  // drivetrain
  RobotDrive drive = new RobotDrive(leftMotors, rightMotors);

  // xbox controller
  Joystick xbox = new Joystick(0);

  @Override
  public void robotInit() {
    // fix inverted drive
    /*leftMotors.setInverted(true);  //I kinda liked it backward :) Idon't :( 
    //rightMotors.setInverted(true);  //The new skeitor is woried conreltyh! (with progmra's oversight)
    /*/// invert right intake motor for simplicity //i i kinda like the contorl raoted 90 degres */
    // initialize camera*/
    UsbCamera cam = CameraServer.getInstance().startAutomaticCapture();
    cam.setResolution(160, 120);
    cam.setFPS(30);
  }

  @Override
  public void autonomousInit() {
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    // drive
    drive.arcadeDrive(xbox.getRawAxis(1)*.75, xbox.getRawAxis(0)*.65);
    // deprecated drive, implemented by volunteer
    // drive.arcadeDrive(xbox, 1, xbox, 0, true);
    // read joystick input, adjust arm accordingly
    /*double armPower = xbox.getRawAxis(5);
    armMotor.set(-armPower * 0.6);
    // intake
    if (xbox.getRawButton(5)) {
      succLeft.set(0.8);
      succRight.set(0.8);
    } else if (xbox.getRawButton(6)) {
      succLeft.set(-0.8);
      succRight.set(-0.8);
    } else {
      succLeft.set(0);
      succRight.set(0);
    }*/
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    // drive
    drive.arcadeDrive(xbox.getRawAxis(1)*.75, xbox.getRawAxis(0)*.65);
    // deprecated drive, implemented by volunteer
    // drive.arcadeDrive(xbox, 1, xbox, 0, true);
    // read joystick input, adjust arm accordingly
    /*double armPower = xbox.getRawAxis(5);
    armMotor.set(-armPower * 0.6);*/
    // intake
    /*if (xbox.getRawButton(5)) {
      succLeft.set(1);
      succRight.set(1);
    } else if (xbox.getRawButton(6)) {
      succLeft.set(-1);
      succRight.set(-1);
    } else {
      succLeft.set(0);
      succRight.set(0);
    }*/
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
