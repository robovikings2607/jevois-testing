package org.usfirst.frc.team2607.robot;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;

public class Solenoids {
	
	Solenoid s_DualSpeedShifter;
	Solenoid s_solenoid1;
	Solenoid s_solenoid2;
	Solenoid s_solenoid3;
	Solenoid s_solenoid4;
	
		
	
	Timer solTimer;
	
	public Solenoids(int i_sol0, int i_sol1, int i_sol2, int i_sol3, int i_sol4) {
		
		s_DualSpeedShifter = new Solenoid(i_sol0);
		s_solenoid1 = new Solenoid(i_sol1);
		
		
		solTimer = new Timer();
		
		initializeSolenoids(); 	
	}
	
	public void initializeSolenoids(){
		s_DualSpeedShifter.set(true);
		}

}
	
