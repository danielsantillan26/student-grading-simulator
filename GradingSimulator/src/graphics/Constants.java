package graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;

/**
 * The Constants class holds various constants to be used by other classes within the graphics package.
 * Most of these fields are repeated throughout the classes; it is more efficient to hold them in one place.
 * 
 * @author Daniel Santillan
 */
public final class Constants {

	public static final Font labelPromptFont = new Font("Courier New", Font.BOLD, 40);			// Label prompt font for each page
	public static final Dimension labelPromptDimension = new Dimension(500, 200);				// Label prompt dimensions for each page
	public static final Insets labelPromptInsets = new Insets(100, 14, 0, 0);					// Label prompt insets for each page

	public static final Font textFieldFont = new Font("Courier New", Font.PLAIN, 40);			// JTextField font for each page
	public static final Dimension textFieldDimension = new Dimension(500, 50);					// JTextField dimension for each page
	public static final Insets textFieldInsets = new Insets(25, 14, 0, 0);						// JTextField insets for each page

	public static final Insets bottomButtonsInsets = new Insets(15, 15, 15, 15);				// Insets for bottom buttons to switch cards

	public static final Color HDR_PURPLE = new Color(118, 58, 255);								// Color for header/footer
	public static final Color BG_PURPLE = new Color(188, 159, 255);								// Color for background


	/**
	 * This is a private constructor that does nothing; this is a final class.
	 */
	public Constants() {

	}


	/**
	 * This is the required toString method for this class. It returns a small message.
	 */
	@Override
	public String toString() {
		return "Constants toString:\nField is working.\n\n";
	}

}
