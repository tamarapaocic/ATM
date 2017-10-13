package BO;
import java.util.Scanner;

public class StringUserInput {

	 Scanner input = new Scanner(System.in);

	public  String getString(String text){
		System.out.print(text);
		String userInput = input.nextLine();
		return userInput;
	}
	
}
