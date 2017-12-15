package org.usfirst.frc.team2607.robot;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Talon;

public class DriveBase {
	
	Spark mot_LeftDriveMotors;
	Spark mot_RightDriveMotors;
	
	
	
	
	public DriveBase(int i_PWNConnector_LeftDriveMotors, 
			int i_PWNConnector_RightDriveMotors
		){
		mot_LeftDriveMotors = new Spark(i_PWNConnector_LeftDriveMotors);
		mot_LeftDriveMotors.set(0.0);
		mot_LeftDriveMotors.setInverted(true);
		mot_RightDriveMotors = new Spark(i_PWNConnector_RightDriveMotors);
		mot_RightDriveMotors.set(0.0);
		mot_RightDriveMotors.setInverted(true);
		
		
	}
	
	public void arcadeDrive(double forwardSpeed, double rotate){
		this.mot_LeftDriveMotors.set((forwardSpeed) + rotate);
		this.mot_RightDriveMotors.set((forwardSpeed*-1) + rotate );
	}
	
	public void driveForward(double forwardSpeed){
		this.mot_LeftDriveMotors.set(forwardSpeed*-1);
		this.mot_RightDriveMotors.set(forwardSpeed);
	}
	
	public void stop(){
		this.mot_LeftDriveMotors.set(0.0);
		this.mot_RightDriveMotors.set(0.0); 
	}
	
	
	//public void driveStraight(double forwardSpeed, double sidewaysSpeed, double followAngle, double presentAngle){
	//	this.arcadeDrive(forwardSpeed, sidewaysSpeed, (followAngle-presentAngle)/50);
		 
	//}
	
	//public void autonDriveStraight(double forwardSpeed, double sidewaysSpeed, double followAngle, double presentAngle){
	//	this.autonOmniDrive(forwardSpeed, sidewaysSpeed, (followAngle-presentAngle)/50);
		 
	//}
	
	
}