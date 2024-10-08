package calculations;

import java.util.ArrayList;

/**
 * The GradeCalculations class is a collection of calculations concerning number and letter grades.
 * These methods are used in the Grade Calculator page of the Student Grading Simulator.
 * 
 * @author Daniel Santillan
 */
public class GradeCalculations {

	/**
	 * calculateGrade determines one's average grade based on the String input. The method checks the input for
	 * how grades are calculated (weighted or unweighted) to determine the method of calculation. Invalid inputs 
	 * are considered.
	 * 
	 * @param input			The list of individual grades (String)
	 * @param system		The weighting system (int)
	 * @return				The average grade (String)
	 */
	public static String calculateGrade(String input, int system) {

		if (system == 1) {
			return calculateUnweightedGrade(input);
		} else if (system == 0) {
			return calculateWeightedGrade(input);
		} else if (system == 2) {
			return calculatePointsGrade(input);
		} else {
			return "Invalid Input";
		}
	}


	/**
	 * calculateUnweightedGrade determines one's average grade using a basic average. The input is a list of
	 * individual grades, which are parsed into doubles to be averaged into a double that is returned as a
	 * String. Invalid inputs are considered.
	 * 
	 * The method is called from the calculateGrade method, which sends in a trimmed version of its own input
	 * (without the course level and weight indicators)
	 * 
	 * @param input			The list of individual grades (String)
	 * @return				The average grade (String)
	 */
	private static String calculateUnweightedGrade(String input) {
		String result = "";
		String temp = input;
		ArrayList<Double> grades = new ArrayList<Double>();

		if (!(Character.isDigit(input.charAt(0))) || input.indexOf(",") < 0) {
			return "Invalid Input";
		}

		if (input.substring(input.length() - 1).equals(",")) {
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
		resultDouble = Math.round((resultDouble*1e3)/1e1);
		resultDouble /= 100;
		result = Double.toString(resultDouble);

		return result;
	}


	/**
	 * calculateWeightedGrade determines one's average grade using weights. The input is a list of
	 * individual grades, which are parsed into doubles to be averaged into a double that is returned as a
	 * String. Invalid inputs are considered.
	 * 
	 * The method is called from the calculateGrade method, which sends in a trimmed version of its own input
	 * (without the course level and weight indicators).
	 * 
	 * @param input			The list of individual grades and their corresponding weights (String)
	 * @return				The average grade (String)
	 */
	private static String calculateWeightedGrade(String input) {
		String result = "";
		String temp = input;
		ArrayList<Double> grades = new ArrayList<Double>();
		ArrayList<Double> weights = new ArrayList<Double>();

		if (!(Character.isDigit(input.charAt(0))) || input.indexOf(",") < 0) {
			return "Invalid Input";
		}

		if (input.substring(input.length() - 1).equals(",")) {
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

			try {
				weights.add(Double.parseDouble(temp.substring(0, temp.indexOf(","))));
			} catch (Exception e) {
				return "Invalid Input";
			}

			temp = temp.substring(temp.indexOf(",") + 2);

			if (countChars(temp, ',') < 2) {
				keepGoing = false;
				try {
					grades.add(Double.parseDouble(temp.substring(0, temp.indexOf(","))));
				} catch (Exception e) {
					return "Invalid Input";
				}

				temp = temp.substring(temp.indexOf(",") + 2);

				try {
					weights.add(Double.parseDouble(temp.substring(0)));
				} catch (Exception e) {
					return "Invalid Input";
				}
			}
		}

		weights = fixWeights(weights);


		double resultDouble = 0.0;
		for (int i = 0; i < grades.size(); i++) {
			resultDouble += (grades.get(i) * weights.get(i));
		}
		resultDouble = Math.round((resultDouble*1e3)/1e1);
		resultDouble /= 100;
		result = Double.toString(resultDouble);



		return result;

	}


	/**
	 * calculatePointsGrade determines one's average grade using a points system. The input is the list
	 * of individual grades, in the format of points scored over points assigned. The sums of the points earned
	 * is divided by the sum of the points assigned to compute the grade average. Invalid input is considered.
	 * 
	 * @param input			The list of individual grades with points earned over points assigned (String)
	 * @return				The average grade (String)
	 */
	private static String calculatePointsGrade(String input) {
		String result = "";
		String temp = input;
		ArrayList<Double> pointsEarned = new ArrayList<Double>();
		ArrayList<Double> pointsAssigned = new ArrayList<Double>();

		if (!(Character.isDigit(input.charAt(0))) || input.indexOf(",") < 0) {
			return "Invalid Input";
		}

		if (input.substring(input.length() - 1).equals(",")) {
			temp = temp.substring(0, temp.length() - 1);
		}

		boolean keepGoing = true;
		while (keepGoing) {

			try {
				pointsEarned.add(Double.parseDouble(temp.substring(0, temp.indexOf("/"))));
			} catch (Exception e) {
				return "Invalid Input";
			}

			temp = temp.substring(temp.indexOf("/") + 1);

			try {
				pointsAssigned.add(Double.parseDouble(temp.substring(0, temp.indexOf(","))));
			} catch (Exception e) {
				return "Invalid Input";
			}

			temp = temp.substring(temp.indexOf(",") + 2);

			if (countChars(temp, '/') < 2) {
				keepGoing = false;
				try {
					pointsEarned.add(Double.parseDouble(temp.substring(0, temp.indexOf("/"))));
				} catch (Exception e) {
					return "Invalid Input";
				}

				temp = temp.substring(temp.indexOf("/") + 1);

				try {
					pointsAssigned.add(Double.parseDouble(temp.substring(0)));
				} catch (Exception e) {
					return "Invalid Input";
				}
			}
		}
		
		double resultDouble = 0.0;
		double pointsEarnedTotal = 0.0;
		double pointsAssignedTotal = 0.0;
		
		for (int i = 0; i < pointsEarned.size(); i++) {
			pointsEarnedTotal += pointsEarned.get(i);
			pointsAssignedTotal += pointsAssigned.get(i);
		}
		
		resultDouble = pointsEarnedTotal/pointsAssignedTotal * 100;
		result = Double.toString(resultDouble);

		return result;
	}


	/**
	 * countChars counts the number of characters in a String. This method is used when calculating
	 * a weighted grade to help ensure every grade has a respective weight.
	 * 
	 * @param input			The input to be searched (String)
	 * @param search		The char being searched (char)
	 * @return				The number of occurrences of search in input (int)
	 */
	private static int countChars(String input, char search) {
		int result = 0;

		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == search) {
				result++;
			}
		}

		return result;
	}


	/**
	 * fixWeights divides each weight in the list of weights (for weighted grade calculations) by the
	 * number of occurrences of said weight in the list. This is to ensure correct calculation of the
	 * weighted grade.
	 * 
	 * @param weights		The list of weights (ArrayList of double)
	 * @return				The list of modified weights (ArrayList of double)
	 */
	private static ArrayList<Double> fixWeights(ArrayList<Double> weights) {
		ArrayList<Double> individualWeights = new ArrayList<Double>();

		for (int i = 0; i < weights.size(); i++) {
			if (individualWeights.indexOf(weights.get(i)) == -1) {
				individualWeights.add(weights.get(i));
			}
		}

		for (double j : individualWeights) {
			int occurrence = 0;
			for (int k = 0; k < weights.size(); k++) {
				if (weights.get(k) == j) {
					occurrence++;
				}
			}

			for (int l = 0; l < weights.size(); l++) {
				if (weights.get(l) == j) {
					weights.set(l, weights.get(l)/occurrence);
				}
			}
		}

		return weights;
	}


	/**
	 * convertNumberToLetter converts a number grade to a letter grade. It is assumed no invalid input
	 * can enter this method.
	 * 
	 * @param numberString	The grade (String)
	 * @return				The letter grade (String)
	 */
	public static String convertNumberToLetter(String numberString) {
		String result = "";
		double number = Double.parseDouble(numberString);

		if (number >= 92.50) {
			result = "A";
		} else if (number >= 89.50) {
			result = "A-";
		} else if (number >= 86.50) {
			result = "B+";
		} else if (number >= 82.50) {
			result = "B";
		} else if (number >= 79.50) {
			result = "B-";
		} else if (number >= 76.50) {
			result = "C+";
		} else if (number >= 72.50) {
			result = "C";
		} else if (number >= 69.50) {
			result = "C-";
		} else if (number >= 64.50) {
			result = "D";
		} else { result = "F"; }

		return result;
	}


	/**
	 * This is the required toString method for this class. Since there are no fields, the class only returns
	 * a small message for testing purposes.
	 */
	@Override
	public String toString() {
		return "GradeCalculations toString:\nClass is working.\n\n";
	}

}
