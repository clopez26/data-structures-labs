package orderedStructures;

public class Fibonacci extends Progression {

	private double prev; 
	
	public Fibonacci() { 
		this(1); 
		prev = 0; 
	}
	private Fibonacci(double first) {
		super(first);
	}

	@Override
	public double nextValue() throws IllegalStateException
	{
		if(!hasUsedFirstValue)
			throw new IllegalStateException("You must use the firstValue method before using this method!");
		else
		{
			double nextValue = prev + current;
			prev = current;
			current = nextValue;
			
			return current;
		}
	
	}
	
	public double firstValue() { 
		double value = super.firstValue(); 
		prev = 0; 
		return value; 
	}

}
