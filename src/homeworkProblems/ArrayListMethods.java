package homeworkProblems;

import java.util.ArrayList;

public class ArrayListMethods 
{
	
	public static void removeAllOccurrences(int n, ArrayList<Integer> array)
	{
		for(int i = 0; i < array.size(); i++)
			if(array.get(i) == n)
			{
				array.remove(i);
				removeAllOccurrences(n, array);
			}
	}
}
