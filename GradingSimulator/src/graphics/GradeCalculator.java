package graphics;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import calculations.GPACalculations;
import calculations.GradeCalculations;

/**
 * The GradeCalculator class creates the Grade Calculator page of the Student Grading Simulator.
 * This class makes various components for this page, including buttons and labels.
 * 
 * @author Daniel Santillan
 */
public class GradeCalculator extends JPanel {

	/**
	 * FIELDS
	 */
	private static final long serialVersionUID = 1L;	// Version
			
	private ActionListener al;							// ActionListener for this page

	private GridBagLayout gbl;							// GridBagLayout for this page
	private GridBagConstraints gbc;						// GridBagConstraints for this page

	private JButton buttonPageTwoEnterGrades;			// Enter grades button for this page
	private JLabel labelEnterGrades;					// Enter grades label for this page
	private JLabel labelResult;							// Result label for this page
	private JLabel labelResult2;						// Second result label for this page
	private JTextField enterGrades;						// JTextField for this page

	private String labelResultText = "";				// Label text - is a field for future modification
	private String labelResult2Text = "";				// Label text - is a field for future modification


	/**
	 * The GradeCalculator constructor creates the layout, constraints, listener, labels,
	 * button, and JTextField.
	 */
	public GradeCalculator() {
		gbl = new GridBagLayout();
		gbc = new GridBagConstraints();
		al = new ActionListener() {
			
			/**
			 * actionPerformed is an ActionListener method that takes in an event. In this
			 * case, actionPerformed takes in the ActionEvent from the JButton, then procures
			 * the text from the JTextField to calculate the grade and make a result label out
			 * of the results.
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				makeResultLabel();
			}

		};

		setLayout(gbl);

		labelEnterGrades = new JLabel("Enter your grades");
		labelEnterGrades.setFont(Constants.labelPromptFont);
		labelEnterGrades.setMinimumSize(Constants.labelPromptDimension);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = Constants.labelPromptInsets;
		add(labelEnterGrades);
		gbl.setConstraints(labelEnterGrades, gbc);
		
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		
		enterGrades = new JTextField();
		enterGrades.setMinimumSize(Constants.textFieldDimension);
		enterGrades.setPreferredSize(Constants.textFieldDimension);
		enterGrades.setFont(Constants.textFieldFont);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = Constants.textFieldInsets;
		add(enterGrades);
		gbl.setConstraints(enterGrades, gbc);
		
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		
		buttonPageTwoEnterGrades = new JButton("Enter");
		buttonPageTwoEnterGrades.addActionListener(al);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = Constants.textFieldInsets;
		add(buttonPageTwoEnterGrades);
		gbl.setConstraints(buttonPageTwoEnterGrades, gbc);
		
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
		g2d.fillRect(0, getHeight() - 50, getWidth(), 50);
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
	 * makeResultLabel takes the text from the JTextField and calculates the average grade using a method
	 * from the GradeCalculations class. Using the return value of that external method, text will
	 * be added to the JLabels to tell their average grade. Other methods are called to calculate the letter
	 * grade and the GPA.
	 */
	private void makeResultLabel() {
		
		String temp = GradeCalculations.calculateGrade(enterGrades.getText());
		
		if (temp.equals("Invalid Input")) {
			labelResult.setText("Invalid Input");
			labelResult2.setText("");
			labelResult.setFont(Constants.labelPromptFont);
			labelResult.setForeground(Color.BLACK);
			return;
		}
		
		String temp2 = GradeCalculations.convertNumberToLetter(temp);
		int level = -1;
		
		if (enterGrades.getText().substring(0, 1).equals("C")) {
			level = 0;
		} else if (enterGrades.getText().substring(0, 1).equals("H")) {
			level = 1;
		} else { level = 2; }
		
		labelResultText = temp;
		labelResult2Text = "Letter Grade: " + temp2 + "   GPA: " + GPACalculations.calculateGPA(temp2, level); 
		
		labelResult.setText(labelResultText);
		labelResult.setFont(Constants.labelPromptFont);
		labelResult.setForeground(Color.BLACK);
		
		labelResult2.setText(labelResult2Text);
		labelResult2.setFont(new Font("Courier New", Font.BOLD, 30));
		labelResult2.setForeground(Color.BLACK);
	}


	/**
	 * This is the required toString method for this class. It returns a small message.
	 */
	@Override
	public String toString() {
		return "GradeCalculator [al=" + al + ", gbl=" + gbl + ", gbc=" + gbc + ", buttonPageTwoEnterGrades="
				+ buttonPageTwoEnterGrades + ", labelEnterGrades=" + labelEnterGrades + ", labelResult=" + labelResult
				+ ", labelResult2=" + labelResult2 + ", enterGrades=" + enterGrades + ", labelResultText="
				+ labelResultText + ", labelResult2Text=" + labelResult2Text + "]\nClass is working.\n\n";
	}
	
}
