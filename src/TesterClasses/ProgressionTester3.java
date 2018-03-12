package TesterClasses;

import orderedStructures.Arithmetic;
import orderedStructures.Geometric;
import orderedStructures.Progression;

public class ProgressionTester3 
{
	public static void main(String [] args)
	{
		Arithmetic p = new Arithmetic(2,3);
		Arithmetic q = new Arithmetic(2,3);
		Progression r = new Geometric(2,5);
		
		System.out.println(p.add(q).firstValue());
		System.out.println(p.add(q).getTerm(3));
		System.out.println(p.equals(q));
		System.out.println(r.nextValue());
		System.out.println(r.firstValue());
		System.out.println(r.nextValue());
	}
}
