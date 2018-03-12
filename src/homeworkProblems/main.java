package homeworkProblems;

import java.util.ArrayList;
import java.util.Scanner;

public class main {

	public static void main(String[] args)
	{
		ArrayList<Integer> array = new ArrayList<>();
		int commandCounter = 0; 

		Scanner input = new Scanner(System.in);

		System.out.println("Enter how many commands you want to perform.");

		int numOfCommands = input.nextInt();

		while(commandCounter < numOfCommands)
		{
			System.out.println("Number of commands: " + numOfCommands);
			System.out.println("Commands left: " + String.valueOf(numOfCommands - commandCounter));
			System.out.println("List of commands:\n1. 1 X - add X at the end of an ArrayList\n"
					+ "2. 2 Y - removes all Y's from ArrayList\n"
					+ "3. 3 - prints the size of the ArrayList\n\n"
					+ "Enter your respective command."
					+ "");


			int command1 = input.nextInt();
			int command2 = input.nextInt();

			while(!DecisionsAndValidations.validateInt(command1)){
				System.out.println("Your input does not correspond to a valid command.\n"
						+ "Enter a new set of commands.");

				command1 = input.nextInt();
				command2 = input.nextInt();
			}

			DecisionsAndValidations.commandExecution(command1, command2, array);
			commandCounter++;
		}	


	}
}

