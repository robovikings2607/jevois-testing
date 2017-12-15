package org.usfirst.frc.team2607.robot;

import edu.wpi.first.wpilibj.Joystick;

public class Inputs {
	
	Joystick xBox1;
	Joystick climbSwitch;
	
	double d_LeftXAxis1;
	double d_LeftYAxis1;
	double d_RightXAxis1;
	double d_RightYAxis1;
	
	double d_LeftTrigger1;
	double d_RightTrigger1;
	
	boolean b_AButton1;
	boolean b_BButton1;
	boolean b_XButton1;
	boolean b_YButton1;
	
	boolean b_StartButton1;
	boolean b_BackButton1;
	
	boolean b_LeftBumper1;
	boolean b_RightBumper1;
	
	boolean b_LeftStickButton1;
	boolean b_RightStickButton1;
	
	int i_DPad1;
	
	boolean b_ALast1;
	boolean b_BLast1;
	boolean b_XLast1;
	boolean b_YLast1;
	
	boolean b_StartLast1;
	boolean b_BackLast1;
	
	boolean b_LeftBumperLast1;
	boolean b_RightBumperLast1;
	
	boolean b_LeftStickLast1;
	boolean b_RightStickLast1;
	
	
	
	
	double d_LeftXAxis2;
	double d_LeftYAxis2;
	double d_RightXAxis2;
	double d_RightYAxis2;
	
	double d_LeftTrigger2;
	double d_RightTrigger2;
	
	boolean b_AButton2;
	boolean b_BButton2;
	boolean b_XButton2;
	boolean b_YButton2;
	
	boolean b_StartButton2;
	boolean b_BackButton2;
	
	boolean b_LeftBumper2;
	boolean b_RightBumper2;
	
	boolean b_LeftStickButton2;
	boolean b_RightStickButton2;
	
	int i_DPad2;
	
	boolean b_ALast2;
	boolean b_BLast2;
	boolean b_XLast2;
	boolean b_YLast2;
	
	boolean b_StartLast2;
	boolean b_BackLast2;
	
	boolean b_LeftBumperLast2;
	boolean b_RightBumperLast2;
	
	boolean b_LeftStickLast2;
	boolean b_RightStickLast2;
	
	
	boolean b_climbSwitch;
	
	
	public Inputs(int USBConnector_Controller1,
			int USBConnector_ClimbSwitch){
		xBox1 = new Joystick(USBConnector_Controller1);
		climbSwitch = new Joystick(USBConnector_ClimbSwitch);
		zeroInputs();
	}
	
	public void readValues(){
		
		//  Each of these returns a double value between -1 and 1
		

		if (xBox1.getRawAxis(0) < 0.2 && xBox1.getRawAxis(0)> -0.2){
			d_LeftXAxis1 = 0.0;
		}
		else {
			d_LeftXAxis1 = xBox1.getRawAxis(0); 
		}
		
		if (xBox1.getRawAxis(1) < 0.2 && xBox1.getRawAxis(1)> -0.2){
			d_LeftYAxis1 = 0.0;
		}
		else {
			d_LeftYAxis1 = xBox1.getRawAxis(1); 
		}

		if (xBox1.getRawAxis(4) < 0.2 && xBox1.getRawAxis(4)> -0.2){
			d_RightXAxis1 = 0.0;
		}
		else {
			d_RightXAxis1 = xBox1.getRawAxis(4); 
		}
		
		if (xBox1.getRawAxis(5) < 0.2 && xBox1.getRawAxis(5)> -0.2){
			d_RightYAxis1 = 0.0;
		}
		else {
			d_RightYAxis1 = xBox1.getRawAxis(5); 
		}

		d_LeftTrigger1 = xBox1.getRawAxis(2);
		d_RightTrigger1 = xBox1.getRawAxis(3);
		
		
		
		
//		
//		if (xBox2.getRawAxis(0) < 0.2 && xBox2.getRawAxis(0)> -0.2){
//			d_LeftXAxis2 = 0.0;
//		}
//		else {
//			d_LeftXAxis2 = xBox2.getRawAxis(0); 
//		}
//		
//		if (xBox2.getRawAxis(1) < 0.2 && xBox2.getRawAxis(1)> -0.2){
//			d_LeftYAxis2 = 0.0;
//		}
//		else {
//			d_LeftYAxis2 = xBox2.getRawAxis(1); 
//		}
//
//		if (xBox2.getRawAxis(4) < 0.2 && xBox2.getRawAxis(4)> -0.2){
//			d_RightXAxis2 = 0.0;
//		}
//		else {
//			d_RightXAxis2 = xBox2.getRawAxis(4); 
//		}
//		
//		if (xBox2.getRawAxis(5) < 0.2 && xBox2.getRawAxis(5)> -0.2){
//			d_RightYAxis2 = 0.0;
//		}
//		else {
//			d_RightYAxis2 = xBox2.getRawAxis(5); 
//		}
//
//		d_LeftTrigger2 = xBox2.getRawAxis(2);
//		d_RightTrigger2 = xBox2.getRawAxis(3);
//		
//		
		
		
		
		
		
		
		//  Buttons return true when pressed, false otherwise
		b_AButton1 = xBox1.getRawButton(1);
		b_BButton1 = xBox1.getRawButton(2);
		b_XButton1 = xBox1.getRawButton(3);
		b_YButton1 = xBox1.getRawButton(4);
		
//		b_AButton2 = xBox2.getRawButton(1);
//		b_BButton2 = xBox2.getRawButton(2);
//		b_XButton2 = xBox2.getRawButton(3);
//		b_YButton2 = xBox2.getRawButton(4);
		
		b_StartButton1 = xBox1.getRawButton(8);
		b_BackButton1 = xBox1.getRawButton(7);

//		b_StartButton2 = xBox2.getRawButton(8);
//		b_BackButton2 = xBox2.getRawButton(7);
		
		b_LeftBumper1 = xBox1.getRawButton(5);
		b_RightBumper1 = xBox1.getRawButton(6);
		
//		b_LeftBumper2 = xBox2.getRawButton(5);
//		b_RightBumper2 = xBox2.getRawButton(6);
		
		b_LeftStickButton1 = xBox1.getRawButton(9);
		b_RightStickButton1 = xBox1.getRawButton(10);
		
//		b_LeftStickButton2 = xBox2.getRawButton(9);
//		b_RightStickButton2 = xBox2.getRawButton(10);
		
		// DPad returns -1 D-pad is not engaged.  
		// Otherwise returns an integer between 0 and 359 
		// up = 0  right = 90  down = 180  left = 270
		i_DPad1 = xBox1.getPOV();
		
//		i_DPad2 = xBox2.getPOV();

		
		
		b_climbSwitch = climbSwitch.getRawButton(7);
	}
	
	public String getDPad1(){
		if (this.i_DPad1 < 45 || this.i_DPad1 >=315){
			return "U";
		}
		else if (this.i_DPad1 < 135){
			return "R";
		}
		else if (this.i_DPad1 < 225) {
			return "D";
		}
		else if (this.i_DPad1 < 315) {
			return "L";
		}
		else {
			return "";
		}
	}
	
	public String getDPad2(){
		if (this.i_DPad2 < 45 || this.i_DPad2 >=315){
			return "U";
		}
		else if (this.i_DPad2 < 135){
			return "R";
		}
		else if (this.i_DPad2 < 225) {
			return "D";
		}
		else if (this.i_DPad2 < 315) {
			return "L";
		}
		else {
			return "";
		}
	}
	
	
	public boolean isDPadUp1(){
		if (this.getDPad1() == "U"){
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public boolean isDPadUp2(){
		if (this.getDPad2() == "U"){
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isDPadDown1(){
		if (this.getDPad1() == "D"){
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isDPadDown2(){
		if (this.getDPad2() == "D"){
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public boolean isDPadRight1(){
		if (this.getDPad1() == "R"){
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isDPadRight2(){
		if (this.getDPad2() == "R"){
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isDPadLeft1(){
		if (this.getDPad1() == "L"){
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isDPadLeft2(){
		if (this.getDPad2() == "L"){
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public boolean tapA1(){
		boolean current = this.b_AButton1;
		boolean last = this.b_ALast1;
		this.b_ALast1 = current;
		if (current && !last){
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean tapA2(){
		boolean current = this.b_AButton2;
		boolean last = this.b_ALast2;
		this.b_ALast2 = current;
		if (current && !last){
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public boolean tapB1(){
		boolean current = this.b_BButton1;
		boolean last = this.b_BLast1;
		this.b_BLast1 = current;
		if (current && !last){
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean tapB2(){
		boolean current = this.b_BButton2;
		boolean last = this.b_BLast2;
		this.b_BLast2 = current;
		if (current && !last){
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean tapX1(){
		boolean current = this.b_XButton1;
		boolean last = this.b_XLast1;
		this.b_XLast1 = current;
		if (current && !last){
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean tapX2(){
		boolean current = this.b_XButton2;
		boolean last = this.b_XLast2;
		this.b_XLast2 = current;
		if (current && !last){
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean tapY1(){
		boolean current = this.b_YButton1;
		boolean last = this.b_YLast1;
		this.b_YLast1 = current;
		if (current && !last){
			return true;
		}
		else {
			return false;
		}
	}
	public boolean tapY2(){
		boolean current = this.b_YButton2;
		boolean last = this.b_YLast2;
		this.b_YLast2 = current;
		if (current && !last){
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean tapStart1(){
		boolean current = this.b_StartButton1;
		boolean last = this.b_StartLast1;
		this.b_StartLast1 = current;
		if (current && !last){
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean tapStart2(){
		boolean current = this.b_StartButton2;
		boolean last = this.b_StartLast2;
		this.b_StartLast2 = current;
		if (current && !last){
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean tapBack1(){
		boolean current = this.b_BackButton1;
		boolean last = this.b_BackLast1;
		this.b_BackLast1 = current;
		if (current && !last){
			return true;
		}
		else {
			return false;
		}
	}	
	
	public boolean tapBack2(){
		boolean current = this.b_BackButton2;
		boolean last = this.b_BackLast2;
		this.b_BackLast2 = current;
		if (current && !last){
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean tapLeftBumper1(){
		boolean current = this.b_LeftBumper1;
		boolean last = this.b_LeftBumperLast1;
		this.b_LeftBumperLast1 = current;
		if (current && !last){
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean tapLeftBumper2(){
		boolean current = this.b_LeftBumper2;
		boolean last = this.b_LeftBumperLast2;
		this.b_LeftBumperLast2 = current;
		if (current && !last){
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean tapRightBumper1(){
		boolean current = this.b_RightBumper1;
		boolean last = this.b_RightBumperLast1;
		this.b_RightBumperLast1 = current;
		if (current && !last){
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean tapRightBumper2(){
		boolean current = this.b_RightBumper2;
		boolean last = this.b_RightBumperLast2;
		this.b_RightBumperLast2 = current;
		if (current && !last){
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean tapLeftStick1(){
		boolean current = this.b_LeftStickButton1;
		boolean last = this.b_LeftStickLast1;
		this.b_LeftStickLast1 = current;
		if (current && !last){
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean tapLeftStick2(){
		boolean current = this.b_LeftStickButton2;
		boolean last = this.b_LeftStickLast2;
		this.b_LeftStickLast2 = current;
		if (current && !last){
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean tapRightStick1(){
		boolean current = this.b_RightStickButton1;
		boolean last = this.b_RightStickLast1;
		this.b_RightStickLast1 = current;
		if (current && !last){
			return true;
		}
		else {
			return false;
		}
	}

	public boolean tapRightStick2(){
		boolean current = this.b_RightStickButton2;
		boolean last = this.b_RightStickLast2;
		this.b_RightStickLast2 = current;
		if (current && !last){
			return true;
		}
		else {
			return false;
		}
	}
		
		
		
	 
	public void zeroInputs(){
		this.d_RightXAxis1 = 0.0;
		this.d_RightYAxis1 = 0.0;
		this.d_LeftYAxis1 = 0.0;
		this.d_LeftXAxis1 = 0.0;
		this.d_LeftTrigger1 = 0.0;
		this.d_RightTrigger1 = 0.0;
		this.b_AButton1 = false;
		this.b_BButton1 = false;
		this.b_XButton1 = false;
		this.b_YButton1 = false;
		this.b_StartButton1 = false;
		this.b_BackButton1 = false;
		this.b_LeftBumper1 = false;
		this.b_RightBumper1 = false;
		this.b_RightStickButton1 = false;
		this.b_LeftStickButton1 = false;
		this.i_DPad1 = -1;
		
		this.b_ALast1 = false;
		this.b_BLast1 = false;
		this.b_XLast1 = false;
		this.b_YLast1 = false;
		this.b_StartLast1 = false;
		this.b_BackLast1 = false;
		this.b_LeftBumperLast1 = false;
		this.b_RightBumperLast1 = false;
		this.b_LeftStickLast1 = false;
		this.b_RightStickLast1 = false;
		
		
		this.d_RightXAxis2 = 0.0;
		this.d_RightYAxis2 = 0.0;
		this.d_LeftYAxis2 = 0.0;
		this.d_LeftXAxis2 = 0.0;
		this.d_LeftTrigger2 = 0.0;
		this.d_RightTrigger2 = 0.0;
		this.b_AButton2 = false;
		this.b_BButton2 = false;
		this.b_XButton2 = false;
		this.b_YButton2 = false;
		this.b_StartButton2 = false;
		this.b_BackButton2 = false;
		this.b_LeftBumper2 = false;
		this.b_RightBumper2 = false;
		this.b_RightStickButton2 = false;
		this.b_LeftStickButton2 = false;
		this.i_DPad2 = -1;
		
		this.b_ALast2 = false;
		this.b_BLast2 = false;
		this.b_XLast2 = false;
		this.b_YLast2 = false;
		this.b_StartLast2 = false;
		this.b_BackLast2 = false;
		this.b_LeftBumperLast2 = false;
		this.b_RightBumperLast2 = false;
		this.b_LeftStickLast2 = false;
		this.b_RightStickLast2 = false;
		
		this.b_climbSwitch = false;
	}
}