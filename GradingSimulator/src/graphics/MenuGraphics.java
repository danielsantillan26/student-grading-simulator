package graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

/**
 * The MenuGraphics class designs the graphics for the program's
 * title screen.
 * 
 * @author Daniel Santillan
 */

public class MenuGraphics extends JPanel {

	/**
	 * FIELDS
	 */
	private static final long serialVersionUID = 1L;	// Version
	
	
	/**
	 * paintComponent paints the graphics for the title screen.
	 */
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setColor(Constants.BG_PURPLE);
		g2d.fillRect(0,  0, getWidth(),  getHeight());
		g2d.setColor(Color.BLACK);
		g2d.fillOval(200, 450, 600, 75);
		g2d.setColor(Constants.BG_PURPLE);
		g2d.fillOval(350, 450, 600, 75);
		g2d.setColor(Color.BLACK);
		g2d.fillOval(300, 450, 600, 75);
		g2d.setColor(Constants.BG_PURPLE);
		g2d.fillOval(350, 450, 600, 75);
		g2d.setColor(Color.BLACK);
		g2d.fillOval(400, 450, 600, 75);
		g2d.setColor(Constants.BG_PURPLE);
		g2d.fillOval(450, 450, 600, 75);
		g2d.setColor(Constants.HDR_PURPLE);
		g2d.fillRect(0, 0, getWidth(), 50);

		g2d.setFont(new Font("Courier New Bold", Font.PLAIN, 80));
		g2d.setColor(Color.BLACK);
		g2d.drawString("STUDENT GRADING", 225, 300);
		g2d.drawString("SIMULATOR", 225, 400);
		
		g2d.setFont(new Font("Courier New", Font.PLAIN, 30));
		g2d.drawString("By Daniel Santillan", 400, 650);
		
		g2d.setColor(Color.RED);
		g2d.setFont(new Font("Comic Sans MS", Font.PLAIN, 70));
		g2d.drawString("A+", 950, 200);
		
		
	}

	
	/**
	 * This is the required toString method for this class. It returns a short message.
	 */
	@Override
	public String toString() {
		return "MenuGraphics toString:\nClass is working.\n";
	}
	
	
	
	
}
