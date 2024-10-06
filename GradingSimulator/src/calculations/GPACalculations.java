package calculations;

import java.util.ArrayList;

/**
 * GPACalculations is a collection of calculations regarding one's GPA. These methods are used 
 * in the GPA Calculator and the GPA Comparison pages of the Student Grading Simulator program.
 * 
 * @author Daniel Santillan
 */
public class GPACalculations {

	/**
	 * calculateGPA determines a student's GPA in a specific course based on their letter grade and
	 * the course difficulty. The GPA increases if the course difficulty is at an Honors or AP level. The
	 * grade point average system used in this program follows the system implemented by Bishop Ireton,
	 * linked in their student handbook.
	 * 
	 * @param letterGrade		The course letter grade (String)
	 * @param level				The course difficulty (int)
	 * @return					The course GPA (String)
	 */
	public static String calculateGPA(String letterGrade, int level) {
		String result = "";
		
		if (letterGrade.equals("A")) {
			result = "4.0";
		} else if (letterGrade.equals("A-")) {
			result = "3.7";
		} else if (letterGrade.equals("B+")) {
			result = "3.3";
		} else if (letterGrade.equals("B")) {
			result = "3.0";
		} else if (letterGrade.equals("B-")) {
			result = "2.7";
		} else if (letterGrade.equals("C+")) {
			result = "2.3";
		} else if (letterGrade.equals("C")) {
			result = "2.0";
		} else if (letterGrade.equals("C-")) {
			result = "1.7";
		} else if (letterGrade.equals("D")) {
			result = "1.0";
		} else if (letterGrade.equals("F")) {
			return "0.0";
		} else {
			return "Invalid Input";
		}
		
		if (level == 1) {
			result = Double.toString(Double.parseDouble(result) + 0.5);
		} else if (level == 2) {
			result = Double.toString(Double.parseDouble(result) + 1);
		}
		
		return result;
	}
	
	
	/**
	 * calculateOverallGPA determines a student's average GPA with a String reflecting a list of 
	 * individual GPAs. The list comes from the JTextField of the GPA Calculator page in the
	 * Student Grading Simulator. A valid input consists of double values (which represent individual GPAs)
	 * separated by commas and spaces. The GPAs are parsed as doubles and are averaged to calculate the
	 * overall GPA, converted to a String for the JLabel that holds this value. Invalid inputs
	 * are considered.
	 * 
	 * @param list				The list of individual GPAs (String)
	 * @return					The overall GPA (String)
	 */
	public static String calculateOveralLGPA(String list) {
		String result = "";
		String temp = list;
		ArrayList<Double> grades = new ArrayList<Double>();

		if (!(Character.isDigit(list.charAt(0))) || list.indexOf(",") < 0) {
			return "Invalid Input";
		}
		
		if (list.substring(list.length() - 1).equals(",")) {
			temp = temp.substring(0, temp.length() - 1);
		}

		boolean keepGoing = true;
		while (keepGoing) {
			try {
				grades.add(Double.parseDouble(temp.substring(0, temp.indexOf(","))));
			} catch (Exception e) {
				return "Invalid Input";
			}

			temp = temp.substring(temp.indexOf(",") + 2);

			if (temp.indexOf(",") < 0) {
				keepGoing = false;
				try {
					grades.add(Double.parseDouble(temp));
				} catch (Exception e) {
					return "Invalid Input";
				}
			}
		}

		double resultDouble = 0.0;

		for (int i = 0; i < grades.size(); i++) {
			resultDouble += grades.get(i);
		}

		resultDouble /= grades.size();
		resultDouble = Math.round(resultDouble*1e3);
		resultDouble /= 1000;
		result = Double.toString(resultDouble);

		return result;
	}
	
	
	/**
	 * compareGPA takes in a student's GPA as a String value parsed into a double. An integer is
	 * returned based on the value of the GPA; that number is used in a method in GPAComparison.java
	 * to formulate a display message regarding how a student is doing in terms of their GPA. Invalid
	 * values are considered.
	 * 
	 * @param gpaString			The GPA (String)
	 * @return					Value for later use (int)
	 */
	public static int compareGPA(String gpaString) {
		double gpaDouble = 0;

		try {
			gpaDouble = Double.valueOf(gpaString);
		} catch (NumberFormatException e) {
			return -1;
		}

		if (gpaDouble < 0 || gpaDouble > 5) {
			return 0;
		} else if (gpaDouble < 2) {
			return 1;
		} else if (gpaDouble < 2.5) {
			return 2;
		} else if (gpaDouble < 3) {
			return 3;
		} else if (gpaDouble < 3.5) {
			return 4;
		} else if (gpaDouble < 4) {
			return 5;
		} else {
			return 6;
		}

	}
	
	
	/**
	 * This is the required toString method for this class. Since there are no fields, the class only returns
	 * a small message for testing purposes.
	 */
	@Override
	public String toString() {
		return "GPACalculations toString:\nClass is working.\n\n";
	}

}
