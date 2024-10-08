package run;

import graphics.Frame;

/**
 * The Run class runs the overall Student Grading Simulator.
 * 
 * @author Daniel Santillan
 */
public class Run {
	
	/**
	 * FIELDS
	 */
	public static Frame frame;	// JFrame for the program
	
	
	/**
	 * The main method runs the simulator.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		frame = new Frame("Student Grading Simulator", 1250, 800);
		System.out.println(new Run());
	}
	
	
	/**
	 * This is the required toString for this class. It returns a small message.
	 */
	@Override
	public String toString() {
		return ("Run class toString():\nEverything is working!");
	}

}
