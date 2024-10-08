package graphics;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
 * The Frame class creates the JFrame that holds all the components of the Student Grading Simulator.
 */
public class Frame extends JFrame {

	/**
	 *  FIELDS
	 */
	private static final long serialVersionUID = 1L;		// Version

	private CLayout cl;										// CardLayout used

	/**
	 * The Frame constructor creates the JFrame with user input. The CardLayout is added to the Frame as well. 
	 * 
	 * @param title			The title of the Frame (String)
	 * @param length		The length of the frame (int)
	 * @param width			The width of the frame (int)
	 */
	public Frame(String title, int length, int width) {
		cl = new CLayout();

		setTitle(title);
		setSize(length, width);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		add(cl.getCLContainer(), BorderLayout.CENTER);
		setVisible(true);
		
		System.out.println(cl);
		System.out.println(this);

	}

	/**
	 * This is the required toString method for this class. It prints the fields and a small message.
	 */
	@Override
	public String toString() {
		return "Frame [cl]\nClass is working.\n\n";
	}



}
