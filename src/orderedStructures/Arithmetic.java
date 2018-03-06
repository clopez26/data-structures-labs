package orderedStructures;

public class Arithmetic extends Progression {
	private double commonDifference; 
	
	public Arithmetic(double firstValue, double commonDifference) { 
		super(firstValue); 
		this.commonDifference = commonDifference; 
	}
	
	@Override
	public double nextValue() throws IllegalStateException 
	{
		if(!hasUsedFirstValue)
			throw new IllegalStateException("You must use the firstValue method before using this method!");
		else
		{
			current = current + commonDifference; 
			return current;
		}
	}
		public String toString()
	{
		return "Arith(" + this.firstValue() + ", " + commonDifference + ")";
	}
	
	public double getTerm(int n)
	{
		return this.firstValue() + commonDifference*(n-1);
	}
}
