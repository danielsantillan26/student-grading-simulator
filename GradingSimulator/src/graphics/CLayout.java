package graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.CardLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

import calculations.GPACalculations;
import calculations.GradeCalculations;

/**
 * The CLayout class sets up the CardLayout used in the Student Grading Simulator. Buttons that switch
 * cards are implemented in this class.
 * 
 * @author Daniel Santillan
 */
public class CLayout extends JFrame implements ActionListener {

	/**
	 * FIELDS
	 */
	private static final long serialVersionUID = 1L;				// Version

	private CardLayout cl;											// CardLayout

	private Container container;									// Container for the CardLayout

	private JButton buttonPageOneStartUp;							// Start-Up button on the title screen
	private JButton buttonPageOneInstructions;						// Instructions button on the title screen
	private JButton buttonPageTwoSeeGPA;							// See GPA button on the grade calculator page
	private JButton buttonPageTwoSeeCompare;						// See GPA comparison button on the grade calculator page
	private JButton buttonPageThreeSeeGrade;						// See Grade button on the GPA calculator page
	private JButton buttonPageThreeSeeCompare;						// See GPA comparison button on the GPA calculator page
	private JButton buttonPageFourSeeGrade;							// See Grade button on the GPA comparison page
	private JButton buttonPageFourSeeGPA;							// See GPA button on the GPA comparison page
	private JButton buttonPageTwoClose;								// Close button on the grade calculator page
	private JButton buttonPageThreeClose;							// Close button on the GPA calculator page
	private JButton buttonPageFourClose;							// Close button on the GPA comparison page
	private JButton buttonPageTwoInstructions;						// instructions button on the grade calculator page
	private JButton buttonPageThreeInstructions;					// Instructions button on the GPA calculator page
	private JButton buttonPageFourInstructions;						// Instructions button on the GPA comparison page
	private JButton buttonPageFiveSeeGrade;							// See Grade button on the instructions page
	private JButton buttonPageFiveSeeGPA;							// See GPA button on the instructions page
	private JButton buttonPageFiveSeeCompare;						// See GPA comparison button on the instructions page
	private JButton buttonPageFiveReturn;							// Return to title screen button on the instructions page

	private MenuGraphics page1;										// JPanel for the title screen
	private GradeCalculator page2;									// JPanel for the grade calculator page
	private GPACalculator page3;									// JPanel for the GPA calculator page
	private GPAComparison page4;									// JPanel for the GPA comparison page
	private InstructionsGraphics page5;								// JPanel for the GPA

	private static final String START_UP = "Opening Card";			// String card name for page1
	private static final String SEE_GRADE = "Grade Calculator";		// String card name for page2
	private static final String SEE_GPA = "GPA Calculator";			// String card name for page3
	private static final String SEE_COMPARE = "GPA Comparison";		// String card name for page4
	private static final String INSTRUCTIONS = "Instructions";		// String card name for page5


	/**
	 * The CLayout constructor prepares the CardLayout and its container. It creates the buttons and assigns
	 * them to the ActionListener implemented by this class. It prepares the panels and adds them to the CardLayout.
	 * Lastly, the buttons are prepared in methods located inside each page's respective class.
	 */
	public CLayout() {
		cl = new CardLayout();
		container = getContentPane();
		container.setLayout(cl);

		buttonPageOneStartUp = new JButton("START");
		buttonPageOneInstructions = new JButton("INSTRUCTIONS");
		buttonPageTwoSeeGPA = new JButton("CALCULATE GPA");
		buttonPageTwoSeeCompare = new JButton("COMPARE YOUR GPA");
		buttonPageTwoInstructions = new JButton("INSTRUCTIONS");
		buttonPageThreeSeeGrade = new JButton("CALCULATE YOUR GRADE");
		buttonPageThreeSeeCompare = new JButton("COMPARE YOUR GPA");
		buttonPageThreeInstructions = new JButton("INSTRUCTIONS");
		buttonPageFourSeeGrade = new JButton("CALCULATE YOUR GRADE");
		buttonPageFourSeeGPA = new JButton("CALCULATE GPA");
		buttonPageFourInstructions = new JButton("INSTRUCTIONS");
		buttonPageTwoClose = new JButton("CLOSE");
		buttonPageThreeClose = new JButton("CLOSE");
		buttonPageFourClose = new JButton("CLOSE");
		buttonPageFiveReturn = new JButton("RETURN");
		buttonPageFiveSeeGrade = new JButton("CALCULATE YOUR GRADE");
		buttonPageFiveSeeGPA = new JButton("CALCULATE GPA");
		buttonPageFiveSeeCompare = new JButton("COMPARE YOUR GPA");

		buttonPageOneStartUp.addActionListener(this);
		buttonPageOneInstructions.addActionListener(this);
		buttonPageTwoSeeGPA.addActionListener(this);
		buttonPageTwoSeeCompare.addActionListener(this);
		buttonPageTwoInstructions.addActionListener(this);
		buttonPageThreeSeeGrade.addActionListener(this);
		buttonPageThreeSeeCompare.addActionListener(this);
		buttonPageThreeInstructions.addActionListener(this);
		buttonPageFourSeeGrade.addActionListener(this);
		buttonPageFourSeeGPA.addActionListener(this);
		buttonPageFourInstructions.addActionListener(this);
		buttonPageTwoClose.addActionListener(this);
		buttonPageThreeClose.addActionListener(this);
		buttonPageFourClose.addActionListener(this);
		buttonPageFiveReturn.addActionListener(this);
		buttonPageFiveSeeGrade.addActionListener(this);;
		buttonPageFiveSeeGPA.addActionListener(this);
		buttonPageFiveSeeCompare.addActionListener(this);

		page1 = new MenuGraphics();
		page2 = new GradeCalculator();
		page3 = new GPACalculator();
		page4 = new GPAComparison();
		page5 = new InstructionsGraphics();

		page1.add(buttonPageOneStartUp);
		page1.add(buttonPageOneInstructions);
		page2.add(buttonPageTwoSeeGPA);
		page2.add(buttonPageTwoSeeCompare);
		page2.add(buttonPageTwoInstructions);
		page2.add(buttonPageTwoClose);
		page3.add(buttonPageThreeSeeGrade);
		page3.add(buttonPageThreeSeeCompare);
		page3.add(buttonPageThreeInstructions);
		page3.add(buttonPageThreeClose);
		page4.add(buttonPageFourSeeGrade);
		page4.add(buttonPageFourSeeGPA);
		page4.add(buttonPageFourInstructions);
		page4.add(buttonPageFourClose);
		page5.add(buttonPageFiveSeeGrade);
		page5.add(buttonPageFiveSeeGPA);
		page5.add(buttonPageFiveSeeCompare);
		page5.add(buttonPageFiveReturn);

		page2.setComponentPosition(buttonPageTwoSeeGPA, buttonPageTwoSeeCompare, buttonPageTwoInstructions, buttonPageTwoClose);
		page3.setComponentPosition(buttonPageThreeSeeGrade, buttonPageThreeSeeCompare, buttonPageThreeInstructions, buttonPageThreeClose);
		page4.setComponentPosition(buttonPageFourSeeGrade, buttonPageFourSeeGPA, buttonPageFourInstructions, buttonPageFourClose);
		page5.setComponentPosition(buttonPageFiveSeeGrade, buttonPageFiveSeeGPA, buttonPageFiveSeeCompare, buttonPageFiveReturn);

		container.add(START_UP, page1);
		container.add(SEE_GRADE, page2);
		container.add(SEE_GPA, page3);
		container.add(SEE_COMPARE, page4);
		container.add(INSTRUCTIONS, page5);
		
		System.out.println(page1);
		System.out.println(page2);
		System.out.println(page3);
		System.out.println(page4);
		System.out.println(page5);
		System.out.println(new Constants());
		System.out.println(new GPACalculations());
		System.out.println(new GradeCalculations());

	}


	/**
	 * The getCLContainer returns the container for the CardLayout. It is used merely to add the
	 * CardLayout to the primary JFrame.
	 * 
	 * @return 			The CardLayout's container (Container)
	 */
	public Container getCLContainer() {
		return container;
	}


	/**
	 * The actionPerformed method determines what to do when the ActionListener detects an event.
	 * The method detects the source of the event (i.e., which button was pressed) to determine which card
	 * to switch to in the CardLayout.
	 * 
	 * @param e 			An action was detected (ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttonPageOneStartUp) {
			cl.next(container);
		} else if (e.getSource() == buttonPageOneInstructions || e.getSource() == buttonPageTwoInstructions 
				|| e.getSource() == buttonPageThreeInstructions
				|| e.getSource() == buttonPageFourInstructions) {
			cl.last(container);
		} else if (e.getSource() == buttonPageTwoSeeGPA || e.getSource() == buttonPageFourSeeGPA 
				|| e.getSource() == buttonPageFiveSeeGPA) {
			cl.first(container);
			cl.next(container);
			cl.next(container);
		} else if (e.getSource() == buttonPageTwoSeeCompare || e.getSource() == buttonPageThreeSeeCompare
				|| e.getSource() == buttonPageFiveSeeCompare) {
			cl.last(container);
			cl.previous(container);
		} else if (e.getSource() == buttonPageThreeSeeGrade || e.getSource() == buttonPageFourSeeGrade
				|| e.getSource() == buttonPageFiveSeeGrade) {
			cl.first(container);
			cl.next(container);
		} else if (e.getSource() == buttonPageTwoClose || e.getSource() == buttonPageThreeClose
				|| e.getSource() == buttonPageFourClose) {
			System.exit(0);
		} else if (e.getSource() == buttonPageFiveReturn) {
			for (int i = 0; i < 4; i++) {
				cl.previous(container);
			}
		} 
	}


	/**
	 * This is the required toString method for this class. It returns the fields and a short message.
	 */
	@Override
	public String toString() {
		return "CLayout [cl=" + cl + ", container=" + container + ", buttonPageOneStartUp=" + buttonPageOneStartUp
				+ ", buttonPageOneInstructions=" + buttonPageOneInstructions + ", buttonPageTwoSeeGPA="
				+ buttonPageTwoSeeGPA + ", buttonPageTwoSeeCompare=" + buttonPageTwoSeeCompare
				+ ", buttonPageThreeSeeGrade=" + buttonPageThreeSeeGrade + ", buttonPageThreeSeeCompare="
				+ buttonPageThreeSeeCompare + ", buttonPageFourSeeGrade=" + buttonPageFourSeeGrade
				+ ", buttonPageFourSeeGPA=" + buttonPageFourSeeGPA + ", buttonPageTwoClose=" + buttonPageTwoClose
				+ ", buttonPageThreeClose=" + buttonPageThreeClose + ", buttonPageFourClose=" + buttonPageFourClose
				+ ", buttonPageTwoInstructions=" + buttonPageTwoInstructions + ", buttonPageThreeInstructions="
				+ buttonPageThreeInstructions + ", buttonPageFourInstructions=" + buttonPageFourInstructions
				+ ", buttonPageFiveSeeGrade=" + buttonPageFiveSeeGrade + ", buttonPageFiveSeeGPA="
				+ buttonPageFiveSeeGPA + ", buttonPageFiveSeeCompare=" + buttonPageFiveSeeCompare
				+ ", buttonPageFiveReturn=" + buttonPageFiveReturn + "]\nClass is working.\n\n";
	}



}
