package infastructure;

import java.util.*;

public class IO {
	public static int menu(String prompt, int min, int max) {
		return promptForInt("\n" + prompt, min, max);
	}

	@SuppressWarnings("resource")
	private static int fetchIntInput(String prompt, int min, int max) {
		Scanner input = null;
		int choice = min - 1;
		try {
			System.out.println(prompt);
			System.out.print("Make your choice. It should be between " + min
					+ " and " + max + "\n");
			input = new Scanner(System.in);
			choice = input.nextInt();
		} catch (IllegalStateException e) {
		} catch (InputMismatchException e) {
		}
		return choice;
	}

	public static int promptForInt(String prompt, int min, int max) {
		int userChoice = min - 1;
		while (userChoice < min || userChoice > max) {
			userChoice = IO.fetchIntInput(prompt, min, max);
			if (userChoice < min || userChoice > max) {
				System.out.println("You did not follow instructions.");
			}
		}
		return userChoice;
	}

	public static String promptForString(String prompt) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		String string = "";
		int size = 0;
		do {
			System.out.print(prompt + " ");
			string = in.nextLine();
			size = string.length();
			if (size <= 0) {
				System.out.println("You must enter at least one character");
			}
		} while (size <= 0);
		//in.close();
		return string;
	}
}
