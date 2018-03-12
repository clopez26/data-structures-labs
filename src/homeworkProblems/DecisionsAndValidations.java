package homeworkProblems;

import java.util.ArrayList;

public class DecisionsAndValidations 
{
	public static boolean validateInt(int n)
	{
		return n == 1 || n == 2 || n == 3;
	}
	
	public static boolean validateString(String decision)
	{
		return decision.equalsIgnoreCase("Y") || decision.equalsIgnoreCase("N");
	}

	public static void commandExecution(int command1, int command2, ArrayList<Integer> array)
	{
		switch(command1)
		{
			case 1: {
						array.add(command2);
						System.out.println(array.toString() + "\n");
						break;
					}
				
			case 2: {
						ArrayListMethods.removeAllOccurrences(command2, array);	
						System.out.println(array.toString()+ "\n");
						break;
					}
				
			case 3: {
						System.out.println(array.size());
						System.out.println(array.toString()+ "\n");
						break;
					}
		}
	}
	
}
