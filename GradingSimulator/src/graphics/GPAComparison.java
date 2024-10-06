package graphics;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import calculations.GPACalculations;

/**
 * The GPAComparison class creates the GPA Comparison page of the Student Grading Simulator.
 * This class makes various components for this page, including buttons and labels.
 * 
 * @author Daniel Santillan
 */
public class GPAComparison extends JPanel {

	/**
	 * FIELDS
	 */
	private static final long serialVersionUID = 1L;				// Version

	private ActionListener al;										// ActionListener for this page

	private GridBagLayout gbl;										// GridBagLayout for this page
	private GridBagConstraints gbc;									// GridBagConstraints for this page

	private JButton buttonPageFourEnterGPA;							// Enter GPA button for this page
	private JLabel labelEnterGPA;									// Enter GPA label for this page
	private JLabel labelResult;										// Result label for this page
	private JLabel labelResult2;									// Second result label for this page
	private JTextField enterGPA;									// JTextfield for this page

	private String labelResultText = "";							// First label text - is a field for future modification
	private String labelResult2Text= "";							// Second label text - is a field for future modification
	private Color labelResultColor = new Color(0, 0, 0);			// Label color - is a field for future modification


	/**
	 * The GPAComparison constructor creates the layout, constraints, listener, labels,
	 * button, and JTextField.
	 */
	public GPAComparison() {
		gbl = new GridBagLayout();
		gbc = new GridBagConstraints();
		al = new ActionListener() {

			/**
			 * actionPerformed is an ActionListener method that takes in an event. In this
			 * case, actionPerformed takes in the ActionEvent from the JButton, then prepares
			 * the result labels by calling a method.
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				makeResultLabel();
			}

		};

		setLayout(gbl);

		labelEnterGPA = new JLabel("Enter your GPA");
		labelEnterGPA.setFont(Constants.labelPromptFont);
		labelEnterGPA.setMinimumSize(Constants.labelPromptDimension);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = Constants.labelPromptInsets;
		add(labelEnterGPA);
		gbl.setConstraints(labelEnterGPA, gbc);

		gbc.gridwidth = GridBagConstraints.REMAINDER;

		enterGPA = new JTextField();
		enterGPA.setMinimumSize(Constants.textFieldDimension);
		enterGPA.setPreferredSize(Constants.textFieldDimension);
		enterGPA.setFont(Constants.textFieldFont);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = Constants.textFieldInsets;
		add(enterGPA);
		gbl.setConstraints(enterGPA, gbc);

		gbc.gridwidth = GridBagConstraints.REMAINDER;

		buttonPageFourEnterGPA = new JButton("Enter");
		buttonPageFourEnterGPA.addActionListener(al);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = Constants.textFieldInsets;
		add(buttonPageFourEnterGPA);
		gbl.setConstraints(buttonPageFourEnterGPA, gbc);

		gbc.gridwidth = GridBagConstraints.REMAINDER;

		labelResult = new JLabel("");
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = Constants.textFieldInsets;
		add(labelResult);
		gbl.setConstraints(labelResult, gbc);

		labelResult2 = new JLabel("");
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = Constants.textFieldInsets;
		add(labelResult2);
		gbl.setConstraints(labelResult2, gbc);

		repaint();
	}


	/**
	 * The paintComponent method creates the background for this page.
	 */
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Constants.BG_PURPLE);
		g2d.fillRect(0, 0, getWidth(), getHeight());
		g2d.setColor(Constants.HDR_PURPLE);
		g2d.fillRect(0,  getHeight() - 50, getWidth(), 50);


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
		Insets inset = Constants.bottomButtonsInsets;
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
	 * makeResultLabel takes the text from the JTextField and compares its GPA using a method
	 * from the GPACalculations class. Using the return value of that external method, text will
	 * be added to the JLabels to tell the user how their GPA compares to the national average.
	 */
	private void makeResultLabel() {
		int resultGPAComparison = GPACalculations.compareGPA(enterGPA.getText());
		System.out.println("Working");

		Color maroon = new Color(128, 0, 0);

		switch (resultGPAComparison) {
		case -1:
			labelResultText = "You did not enter a number.";
			labelResultColor = maroon;
			break;

		case 0:
			labelResultText = "Your number is too high/low.";
			labelResult2Text = "Convert your GPA to the weighted 4.0 scale.";
			labelResultColor = maroon;
			break;

		case 1:
			labelResultText = "Your GPA is extremely below average.";
			labelResult2Text = "Very few colleges will consider you.";
			labelResultColor = maroon;
			break;

		case 2:
			labelResultText = "Your GPA is below average.";
			labelResult2Text = "You can get into local community colleges.";
			labelResultColor = Color.ORANGE;
			break;

		case 3:
			labelResultText = "Your GPA is almost average.";
			labelResult2Text = "You can get into several universities nationwide.";
			labelResultColor = Color.YELLOW;
			break;

		case 4:
			labelResultText = "Your GPA is average.";
			labelResult2Text = "You can get into many universities in the nation.";
			labelResultColor = Color.GREEN;
			break;

		case 5:
			labelResultText = "Your GPA is above average!";
			labelResult2Text = "You can get into selective universities in your state.";
			labelResultColor = Color.GREEN;
			break;

		case 6:
			labelResultText = "You have a very impressive GPA!";
			labelResult2Text = "You have a fighting chance of attending many selective institutions!";
			labelResultColor = Color.GREEN;
			break;
		}

		labelResult.setText(labelResultText);
		labelResult.setFont(Constants.labelPromptFont);
		labelResult.setForeground(labelResultColor);

		labelResult2.setText(labelResult2Text);
		labelResult2.setFont(new Font("Courier New", Font.PLAIN, 20));
		labelResult2.setForeground(Color.BLACK);
	}


	/**
	 * This is the required toString method for this class. It returns the fields and a small message.
	 */
	@Override
	public String toString() {
		return "GPAComparison [al=" + al + ", gbl=" + gbl + ", gbc=" + gbc + ", buttonPageFourEnterGPA="
				+ buttonPageFourEnterGPA + ", labelEnterGPA=" + labelEnterGPA + ", labelResult=" + labelResult
				+ ", labelResult2=" + labelResult2 + ", enterGPA=" + enterGPA + ", labelResultText=" + labelResultText
				+ ", labelResult2Text=" + labelResult2Text + ", labelResultColor=" + labelResultColor + "]\nClass is working.\n\n";
	}





}
