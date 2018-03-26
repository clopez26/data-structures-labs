 package classes;

public class SymmetricStringAnalyzer {
	private String s; 
	public SymmetricStringAnalyzer(String s) {
		this.s = s; 
	}
	
	/**
	 * Determines if the string s is symmetric
	 * @return true if it is; false, otherwise. 
	 */
	public boolean isValidContent() { 
		SLLStack<Character> stack = new SLLStack<>();
		
		for(int i = 0; i < s.length(); i++)
		{	
			char charToExamine = s.charAt(i);
			
			if(Character.isLetter(charToExamine))
				if(Character.isUpperCase(charToExamine))
					stack.push(charToExamine);
				else if(stack.isEmpty())
						return false;
					else
					{
						
						if(stack.top() == Character.toUpperCase(charToExamine))
							stack.pop();
						
						else
							return false;
					}
			else 
				return false;
		}
			
		return stack.isEmpty(); 
	}
	
	public String toString() { 
		return s; 
	}

	public String parenthesizedExpression() 
	throws StringIsNotSymmetricException 
	{
		if(!isValidContent())
			throw new StringIsNotSymmetricException("Parameter string is not symmetric");
		
		SLLStack<Character> stack = new SLLStack<>();
		String result = "";
		
		for(int i = 0; i < s.length(); i++)
		{
			char currentChar = s.charAt(i);
			
			if(Character.isUpperCase(currentChar))
			{
				result += "<" + currentChar + " ";
				stack.push(currentChar);
			}
			else
				if(stack.top() == Character.toUpperCase(currentChar))
				{
					result += currentChar+ "> ";
					stack.pop();
				}
		}
		return result;
	}

}
