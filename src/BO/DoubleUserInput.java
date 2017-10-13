package BO;

import java.util.Scanner;

public class DoubleUserInput {
	
	 Scanner input = new Scanner(System.in);
	
	public  double getDouble(String text,
			double firstCondition, double secondCondition) {
		double userInput = 0;
		boolean wrongUserInput = true;

		while (wrongUserInput) {
			try {
				System.out.print(text);
				userInput = input.nextDouble();

				wrongUserInput = false;

				if (userInput < firstCondition || userInput > secondCondition) {
					System.out.println("Wrong input. You have to enter a number from "
									+ firstCondition
									+ " to "
									+ secondCondition
									+ ".");
					wrongUserInput = true;
				}
			} catch (Exception ex) {
				System.out.println("Wrong input. You have to enter a number from "
								+ firstCondition
								+ " to "
								+ secondCondition
								+ ".");
				input.nextLine();
			}
		}

		return userInput;
	}

	public  double getDouble(String text, double condition) {
		double userInput = 0;
		boolean wrongUserInput = true;

		while (wrongUserInput) {
			try {
				System.out.print(text);
				userInput = input.nextDouble();

				wrongUserInput = false;

				if (userInput < condition) {
					System.out.println("Wrong input. You have to enter a number bigger or equal to "
									+ condition);
					wrongUserInput = true;
				}
			} catch (Exception ex) {
				System.out.println("Wrong input. You have to enter a number bigger or equal to "
								+ condition);
				input.nextLine();
			}
		}

		return userInput;
	}

	public double getDouble(String text) {
		double userInput = 0;
		boolean wrongUserInput = true;

		while (wrongUserInput) {
			try {
				System.out.print(text);
				userInput = input.nextDouble();

				wrongUserInput = false;
			} catch (Exception ex) {
				System.out.println("Wrong input. You have to enter a number.");
				input.nextLine();

			}
		}

		return userInput;
	}

}