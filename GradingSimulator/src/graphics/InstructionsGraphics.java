package graphics;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

/**
 * The InstructionsGraphics class creates the Instructions page of the Student Grading Simulator.
 * This class sets up the instructions and the buttons.
 */
public class InstructionsGraphics extends JPanel {

	/**
	 * FIELDS
	 */
	private static final long serialVersionUID = 1L;	// Version
	
	private GridBagLayout gbl;							// GridBagLayout for this page

	
	/**
	 * The InstructionGraphics constructor sets up the layout.
	 */
	public InstructionsGraphics() {
		gbl = new GridBagLayout();

		setLayout(gbl);

	}


	/**
	 * paintComponent sets up the background and draws up the instructions
	 * for how to use the Student Grading Simulator.
	 */
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Constants.BG_PURPLE);
		g2d.fillRect(0, 0, getWidth(), getHeight());
		g2d.setColor(Constants.HDR_PURPLE);
		g2d.fillRect(0,  getHeight() - 50, getWidth(), 50);
		
		Font plain = new Font("Courier New", Font.PLAIN, 27);
		Font italic = new Font("Courier New", Font.ITALIC, 40);
		
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font("Courier New Bold", Font.BOLD, 50));
		g2d.drawString("How to Use", 25, 40);
		g2d.setFont(italic);
		g2d.drawString("Grade Calculator", 25, 105);
		g2d.setFont(plain);
		g2d.drawString("- Determine the course difficulty with the buttons", 30, 150);
		g2d.drawString("- Determine how the course is graded with the buttons.", 30, 185);
		g2d.drawString("- Enter your grades in percent format if weighted or unweighted.", 35, 220);
		g2d.drawString("- Add a colon, a space, to separate your grades.", 35, 255);
		g2d.drawString("- For points, format your grade as points earned over points assigned.", 35, 290);
		g2d.drawString("- If weighted, type the weight decimal after your grade", 30, 325);
		g2d.drawString("- Weighted Example: 94.58, 0.65, 75.00, 0.15", 30, 360);
		g2d.drawString("- Unweighted Example: 98.5, 94.3", 30, 395);
		g2d.drawString("- Points Example: 95/100, 10/10, 50/55", 30, 430);
		g2d.setFont(italic);
		g2d.drawString("GPA Calculator", 25, 475);
		g2d.setFont(plain);
		g2d.drawString("- Type your class GPAs, separated by commas.", 30, 515);
		g2d.drawString("- Example: 4.2, 3.7, 4,0", 30, 550);
		g2d.setFont(italic);
		g2d.drawString("GPA Comparison", 25, 600);
		g2d.setFont(plain);
		g2d.drawString("- Enter your GPA on the weighted 4.0 grading scale.", 25, 640);
		g2d.drawString("- The system will tell analyze your college odds.", 25, 675);
		
	}

	
	/**
	 * setComponentPosition sets up the bottom row of buttons in the page. These
	 * buttons switch between the cards of the CardLayout. GridBagConstraints are
	 * applied to properly position the buttons.
	 * 
	 * @param a			First button (Component)
	 * @param b			Second button (Component)
	 * @param c			Third button (Component)
	 * @param d			Fourth button, usually close (Component)
	 */
	public void setComponentPosition(Component a, Component b, Component c, Component d) {

		GridBagConstraints gbcBottom = new GridBagConstraints();
		Insets inset = new Insets(15, 15, 15, 15);
		gbcBottom.insets = inset;

		gbcBottom.anchor = GridBagConstraints.SOUTH;
		gbcBottom.weighty = 1;								// Moves components to the top.

		gbl.setConstraints(a, gbcBottom);
		gbl.setConstraints(b, gbcBottom);
		gbl.setConstraints(c, gbcBottom);
		gbl.setConstraints(d,  gbcBottom);

		gbcBottom.gridwidth = GridBagConstraints.REMAINDER;
	}


	/**
	 * This is the required toString method for this class. It returns the fields and a small message.
	 */
	@Override
	public String toString() {
		return "InstructionsGraphics [gbl=" + gbl + "]\nClass is working.\n\n";
	}
	
}
