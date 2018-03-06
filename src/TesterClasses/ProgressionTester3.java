package TesterClasses;

import orderedStructures.Fibonacci;
import orderedStructures.Progression;

public class ProgressionTester3 
{
	public static void main(String [] args)
	{
		Progression p = new Fibonacci();
		System.out.println(p.nextValue());
		System.out.println(p.firstValue());
		System.out.println(p.nextValue());
	}
}
