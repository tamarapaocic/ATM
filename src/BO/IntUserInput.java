package BO;

import java.util.Scanner;

public class IntUserInput {
	
	 Scanner input = new Scanner(System.in);
	
	public  int getInt( String text, int firstCondition,int secondCondition) {
		int userInput = 0;
		boolean wrongUserInput = true;

		while (wrongUserInput) {
			try {
				System.out.print(text);
				userInput = input.nextInt();

				wrongUserInput = false;

				if (userInput < firstCondition || userInput > secondCondition) {
					System.out
							.println("Wrong input. You have to enter an integer from "
									+ firstCondition
									+ " to "
									+ secondCondition
									+ ".");
					wrongUserInput = true;
				}
			} catch (Exception ex) {
				System.out
						.println("Wrong input. You have to enter an integer from "
								+ firstCondition
								+ " to "
								+ secondCondition
								+ ".");
				input.nextLine();
			}
		}

		return userInput;
	}

	public int getInt( String text, int condition) {
		int userInput = 0;
		boolean wrongUserInput = true;

		while (wrongUserInput) {
			try {
				System.out.print(text);
				userInput = input.nextInt();

				wrongUserInput = false;

				if (userInput <= condition) {
					System.out.println("Wrong input. You have to enter an integer bigger than "	+ condition);
					wrongUserInput = true;
				}
			} catch (Exception ex) {
				System.out.println("Wrong input. You have to enter an integer bigger than "
								+ condition);
				input.nextLine();
			}
		}

		return userInput;
	}

	public int getInt( String text) {
		int userInput = 0;
		boolean wrongUserInput = true;

		while (wrongUserInput) {
			try {
				System.out.print(text);
				userInput = input.nextInt();

				wrongUserInput = false;
			} catch (Exception ex) {
				System.out
						.println("Wrong input. You have to enter an integer.");
				input.nextLine();
			}
		}

		return userInput;
	}

}