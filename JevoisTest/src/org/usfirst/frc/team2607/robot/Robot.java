package org.usfirst.frc.team2607.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.*;
import java.awt.Image;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.cscore.CameraServerJNI;
import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.MjpegServer;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.cscore.VideoMode;
import edu.wpi.cscore.VideoMode.PixelFormat;

/**
 * _
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */

public class Robot extends IterativeRobot {

	Timer timer;
	DriveBase driveBase;
	Inputs inputs;
	Solenoids solenoids;
	
	int autonCounter;

	boolean bp_MinDisplay;
	
	public void disabledInit() {
	}
	
	public void disabledPeriodic() {
		checkJeVois();

	}
	
	private SerialPort jevois = null;
	private int loopCount;
	private UsbCamera jevoisCam;
	private MjpegServer jevoisServer;


	final String defaultAuton = "Default Auton";
	final String customAuton1 = "My Auton1";
	final String customAuton2 = "My Auton2";
	final String customAuton3 = "My Auton3";
	final String customAuton4 = "My Auton4";
	final String customAuton5 = "My Auton5";
	String autonSelected;
	SendableChooser<String> chooser;

	/**
	 * _
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */

	//@Override
	public void robotInit() {			
		driveBase = new DriveBase(0, 1); 	//Both left and right motor combos are combined
							//Low Shooter
		inputs = new Inputs(0,1);//This is for the 1 joystick		
		solenoids = new Solenoids(0, 1, 2, 3, 4);
				
		timer = new Timer();
						
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
		
		System.out.println("Starting CameraServer");
		if (jevoisCam == null) {
			jevoisCam = new UsbCamera("jevoisCam",0);
			jevoisCam.setVideoMode(PixelFormat.kYUYV,320,254,60);
			//jevoisCam.setResolution(320, 254);
			//jevoisCam.setPixelFormat(PixelFormat.kYUYV);
			//jevoisCam.setFPS(60);
			VideoMode vm = jevoisCam.getVideoMode();
			System.out.println("jevoisCam pixel: " + vm.pixelFormat);
			System.out.println("jevoisCam res: " + vm.width + "x" + vm.height);
			System.out.println("jevoisCam fps: " + vm.fps);
		}
		if (jevoisServer == null) {
			jevoisServer = new MjpegServer("JeVoisServer", 1181);
			jevoisServer.setSource(jevoisCam);
		}
		
		if (tryCount == 99) {
			writeJeVois("info\n");
		}
		loopCount = 0;
		
		jevoisCam = CameraServer.getInstance().startAutomaticCapture();
//		jevoisCam.setBrightness(50);
//		jevoisCam.setExposureManual(50);
//		jevoisCam.setFPS(60);
	}
		
	public void checkJeVois() {
		if (jevois == null) return;
		if (jevois.getBytesReceived() > 0) {
			System.out.println("Waited: " + loopCount + " loops, Rcv'd: " + jevois.readString());
			loopCount = 0;
		}
		if (++loopCount % 150 == 0) {
			System.out.println("checkJeVois() waiting..." + loopCount);
			jevoisCam.setVideoMode(PixelFormat.kYUYV,320,254,60);
			writeJeVois("getpar serout\n");
			writeJeVois("info\n");
		}
	}
		
	public void writeJeVois(String cmd) {
		if (jevois == null) return;
		int bytes = jevois.writeString(cmd);
		System.out.println("wrote " +  bytes + "/" + cmd.length() + " bytes");	
		loopCount = 0;
	}
	

//		bp_MinDisplay = true;
//
//		chooser = new SendableChooser<String>();
//		chooser.addDefault("Default Auton", defaultAuton);
//		chooser.addObject("My Auton1", customAuton1);
//		chooser.addObject("My Auton2", customAuton2);
//		chooser.addObject("My Auton3", customAuton3);
//		chooser.addObject("My Auton4", customAuton4);
//		chooser.addObject("My Auton5", customAuton5);
//		SmartDashboard.putData("Auton choices", chooser);
//
//
//
//		shootChooser = new SendableChooser<String>();
//		shootChooser.addDefault("Full Speed", fullSpeed);
//		shootChooser.addObject("3/4 Speed", threeQuarterSpeed);
//		shootChooser.addObject("1/2 Speed", halfSpeed);
//		shootChooser.addObject("1/4 Speed", quarterSpeed);
//		SmartDashboard.putData("Shooter choices", shootChooser);
//
//		
//		
//		sideChooser = new SendableChooser<String>();
//		sideChooser.addDefault("Center Start", centerStart);
//		sideChooser.addObject("Right Start", rightStart);
//		sideChooser.addObject("Left Start", leftStart);
//		SmartDashboard.putData("Side Choice", sideChooser);


	/**
	 * _
	 * This function is run once each time the robot enters autonomous mode
	 */

	//@Override
	public void autonomousInit() {
		timer.reset();
		timer.start();
		solenoids.initializeSolenoids();
	

		autonSelected =  chooser.getSelected();
		SmartDashboard.putString("My Selected Auton is ", autonSelected);



		//Sets initial auton conditions
		autonCounter = 0;
	
	}

	/**
	 * _
	 * This function is called periodically during autonomous
	 */

	//@Override
	public void autonomousPeriodic() {
		
		
		if (autonSelected == defaultAuton){
			defaultAuton();
		}

		else if (autonSelected == customAuton1){
			customAuton1();
		}

		else if (autonSelected == customAuton2){
			customAuton1();
		}

		else if (autonSelected == customAuton3){
			customAuton1();
		}

		else if (autonSelected == customAuton4){
			customAuton1();
		}

		else if (autonSelected == customAuton5){
			customAuton1();
		}
	}
	/**
	 * _
	 * This function is called once each time the robot enters tele-operated
	 * mode
	 */

	//@Override
	public void teleopInit() {

	solenoids.initializeSolenoids();

	}

	/**
	 * _
	 * This function is called periodically during operator control
	 */

	//@Override
	public void teleopPeriodic() {
		// Reads all the inputs from the controller
		inputs.readValues();

		checkMinDisplay();	
		
		checkJeVois();

		driveBase.arcadeDrive(inputs.d_LeftXAxis1, inputs.d_RightYAxis1);

//		if (inputs.tapStart2()){
//			stayStraight = !stayStraight;
//		}
//
//		if (stayStraight){
//
//			if (!gotAngle){
//				sensors.setFollowAngle(0.0);
//				gotAngle = true;
//			}
//			else if (inputs.d_LeftXAxis2 > 0.2 || inputs.d_LeftXAxis2 < -0.2){
//				robotBase.omniDrive(inputs.d_RightYAxis2, inputs.d_RightXAxis2, inputs.d_LeftXAxis2);
//				sensors.setFollowAngle(0.0);
//
//			}
//			else {
//				robotBase.driveStraight(inputs.d_RightYAxis2, inputs.d_RightXAxis2, sensors.getFollowAngle(), sensors.getPresentAngle());
//			}
//
//		}
//		else{
//			gotAngle = false;
//			robotBase.omniDrive(inputs.d_RightYAxis2, inputs.d_RightXAxis2, inputs.d_LeftXAxis2);
//		}
//
//
//		shooter.mot_BallShoot.set(-1*inputs.d_RightTrigger2);
//		shooter.mot_LowShooter.set(-1*inputs.d_RightTrigger2);
//
//		shooter.mot_BallFeed.set(inputs.d_LeftTrigger2);
//		
//	
		if (inputs.tapRightBumper1()){
			solenoids.s_DualSpeedShifter.set(!solenoids.s_DualSpeedShifter.get());
		}
//
//		if (inputs.b_climbSwitch && inputs.d_LeftYAxis2 < -0.2){
//			climber.mot_climbMotor.set(inputs.d_LeftYAxis2);
//		}
//		else {
//			climber.mot_climbMotor.set(0.0); 
//		}
//
//		if (inputs.tapA1()){
//			solenoids.s_GearTilt.set(!solenoids.s_GearTilt.get());
//		}
//		if (inputs.tapLeftBumper1()){
//			solenoids.s_GearGrab.set(!solenoids.s_GearGrab.get());
//		}
//		if (inputs.tapRightBumper1()){
//			solenoids.s_GearLift.set(!solenoids.s_GearLift.get());
//		}
//		if (inputs.tapRightStick1()){
//			solenoids.s_Light.set(!solenoids.s_Light.get());
//		}
//
//
//		if (inputs.tapX1()){
//			solenoids.resetGrabber();
//		}
//		if (inputs.tapRightStick1()){
//			solenoids.s_Light.set(!solenoids.s_Light.get());
//		}
//
//		if (inputs.tapY1()){
//			solenoids.donePickUp = false;
//		}
//		solenoids.pickUp();

		//SmartDashboard.putBoolean("R_MinDisplay(bool)", bp_MinDisplay);
		//SmartDashboard.putBoolean("CLimbSwitch", inputs.b_climbSwitch);
		SmartDashboard.putBoolean("Gear Shift", inputs.b_RightBumper1);

	}

	/**
	 * _
	 * This function is called periodically during test mode
	 */

	//@Override
	public void testPeriodic() {
		LiveWindow.run();
	}


	public void checkMinDisplay(){
		this.bp_MinDisplay = Preferences.getInstance().getBoolean("R_MinDisplay(bool)", true);	// ****  we do not zero this ****
	}

	// just shoots balls at selected speed
	public void defaultAuton(){
		if (autonSelected == defaultAuton){
			if (timer.get()<10){
		//		solenoids.s_LowShooter.set(true);
		//		shooter.shoot(lowShootSpeed);
			}
			else {
				//solenoids.s_LowShooter.set(false);
				//shooter.stop();
			}
		}
	}

	// center start, deploy gear, cross baseline
	public void customAuton1(){

		// drive forward
		if (autonCounter ==0){
			if (timer.get() < 2){
				//driveBase.driveStraight(-0.5, 0, 0, presentAngle);
			}
			else {
				//robotBase.stop();
				autonCounter++;
				timer.reset();
				timer.start();
			}
		}

		// drop off gear
		else if (autonCounter ==1){
			if (timer.get()<0.25){
				//solenoids.resetGrabber();
			}
			else {
				autonCounter++;
				timer.reset();
				timer.start();
			}
		}

		// drive backward
		else if (autonCounter ==2){
			if (timer.get() < 2){
				//robotBase.driveStraight(0.5, 0, 0, presentAngle);
			}
			else {
				//robotBase.stop();
				autonCounter++;
				timer.reset();
				timer.start();
			}
		}

		//  drive sideways.  Direction based on Side Choice
		else if (autonCounter ==3){
			if (timer.get() < 1){
				//robotBase.driveStraight(0, side * 0.5, 0, presentAngle);
			}
			else {
				//robotBase.stop();
				autonCounter++;
				timer.reset();
				timer.start();
			}
		}

		//cross baseline
		else if (autonCounter ==4){
			if (timer.get() < 2){
				//robotBase.driveStraight(-1, 0, 0, presentAngle);
			}
			else {
				//robotBase.stop();
				autonCounter++;
				timer.reset();
				timer.start();
			}
		}
	}

	// Just cross baseline
	public void customAuton2(){
		if (timer.get() <3)
		{
		//	robotBase.driveStraight(1, 0, 0.0, presentAngle);
		}
		else {
			//robotBase.stop();
		}
	}

	public void customAuton3(){

	}	

	public void customAuton4(){

	}	

	//gear + shoot + baseline
	public void customAuton5(){


		//Drive Forward and Drop gear
		if (autonCounter == 0){
			if (timer.get()<3){
			//	robotBase.driveStraight(-0.75, 0, 0.0, sensors.getPresentAngle()); 
			}
			else {
			//	solenoids.s_GearGrab.set(true);								
			//	robotBase.stop();
				autonCounter++;
				timer.reset();
				timer.start();
			}
		}
		 
		// wait 1/4 second to make sure the gear drops
		if (autonCounter == 1){
			if (timer.get() > 0.25){
				autonCounter++;
				timer.reset();
				timer.start();
			}
		}

		// drive backward
		else if (autonCounter == 2){
			if (timer.get()<1){
			//	robotBase.driveStraight(0.75, 0, 0.0, sensors.getPresentAngle());	//Drive Backward
			}
			else {
			//	robotBase.stop();
				autonCounter++;
				timer.reset();
				timer.start();
			}
		}

		//Turn Left 90 Degrees
		else if (autonCounter == 3){
			if (timer.get()<1){
			//	robotBase.driveStraight(0, 0, -90 * side, sensors.getPresentAngle());	
			}
			else {
			//	robotBase.stop();
				autonCounter++;
				timer.reset();
				timer.start();
			}
		}

		//Drive Forward
		else if (autonCounter == 4){
			if (timer.get()<2){
			//	robotBase.driveStraight(-0.75, 0, -90 * side, sensors.getPresentAngle());	
			}
			else {
			//	robotBase.stop();
				autonCounter++;
				timer.reset();
				timer.start();
			}
		}

		//Shoot balls
		else if (autonCounter == 5){
			if (timer.get()<2){
			//	shooter.shoot(1);												
			}
			else {
			//	shooter.stop();
				autonCounter++;
				timer.reset();
				timer.start();
			}
		}

		//Drive Sideways over baseline
		else if (autonCounter == 6){
			if (timer.get() < 4){
				//robotBase.driveStraight(0, 0.75, -90 * side, sensors.getPresentAngle());	
			}
			else {
			//	robotBase.stop();
				autonCounter++;
				timer.reset();
				timer.start();
			}
		}

	}



}

