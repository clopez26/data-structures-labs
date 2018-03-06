package orderedStructures;

public class Geometric extends Progression {
	
	private double commonFactor; 
	
	public Geometric(double firstValue, double commonFactor) { 
		super(firstValue); 
		this.commonFactor = commonFactor; 
	}
	
	@Override
	public double nextValue() throws IllegalStateException
	{
		if(!hasUsedFirstValue)
			throw new IllegalStateException("You must use the firstValue method before using this method!");
		else
		{
			current = current * commonFactor; 
			return current;
		}
	}
	
	public String toString()
	{
		return "Geom(" + this.firstValue() + ", " + commonFactor + ")";
	}
	
	public double getTerm(int n)
	{
		return this.firstValue()*Math.pow(this.commonFactor, n-1);
	}

}
