/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2607.robot;

import edu.wpi.cscore.MjpegServer;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoMode;
import edu.wpi.cscore.VideoMode.PixelFormat;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.SerialPort;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends IterativeRobot {

	@Override
	public void disabledInit() {
	}


	@Override
	public void disabledPeriodic() {
		checkJeVois();
	}

	private SerialPort jevois = null;
	private int loopCount;
	private UsbCamera jevoisCam;
	private MjpegServer jevoisServer;
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		int tryCount = 0;
		do {
			try {
				System.out.print("Trying to create jevois SerialPort...");
				jevois = new SerialPort(9600, SerialPort.Port.kUSB);
				tryCount = 99;
				System.out.println("success!");
			} catch (Exception e) {
				tryCount += 1;
				System.out.println("failed!");
			}
		} while (tryCount < 3);
		
		if (tryCount == 99) {
			writeJeVois("info\n");
		}
		loopCount = 0;
	}

	
	public void checkJeVois() {
		if (jevois == null) return;
		if (jevois.getBytesReceived() > 0) {
			System.out.println("Waited: " + loopCount + " loops, Rcv'd: " + jevois.readString());
			loopCount = 0;
		} 
	}

	public void writeJeVois(String cmd) {
		if (jevois == null) return;
		int bytes = jevois.writeString(cmd);
		System.out.println("wrote " +  bytes + "/" + cmd.length() + " bytes");	
		loopCount = 0;
	}

	@Override
	public void autonomousInit() {
		
		System.out.println("Starting CameraServer");
		if (jevoisCam == null) {
			jevoisCam = new UsbCamera("jevoisCam",0);
			jevoisCam.setVideoMode(PixelFormat.kYUYV,320,254,60);
			//jevoisCam.setPixelFormat(PixelFormat.kYUYV);
			VideoMode vm = jevoisCam.getVideoMode();
			System.out.println("jevoisCam pixel: " + vm.pixelFormat);
			System.out.println("jevoisCam res: " + vm.width + "x" + vm.height);
			System.out.println("jevoisCam fps: " + vm.fps);
		}
		if (jevoisServer == null) {
			jevoisServer = new MjpegServer("JeVoisServer", 1181);
			jevoisServer.setSource(jevoisCam);
		}
		
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		checkJeVois();
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
