package llPositionalList;

import java.util.Iterator;
import java.util.NoSuchElementException;
import interfaces.Position;
import interfaces.PositionalList;

public class PositionalListElementsBackwardIterator<E> implements Iterator<E> {

	private Position<E> current,recent; 
	private PositionalList<E> theList; 
	
	public PositionalListElementsBackwardIterator(PositionalList<E> list) { 
		theList = list; 
		try { 
			current = theList.last(); 
			recent = null;
		}
	    catch (Exception e) { 
	    	current = null;
	    	recent = null;
	    }
	}
	
	public boolean hasNext() {
		return current != null;
	}

	public E next() throws NoSuchElementException {
		if (!hasNext()) 
			throw new NoSuchElementException("Iterator has passed the end.");
		try { 
			recent = current;
			current = theList.before(current); 
		}
		catch (Exception e) { 
			current = null; 
		}
		return recent.getElement();
	}
	
	public void remove() throws IllegalStateException
	{
		if(recent == null)
			throw new IllegalStateException("Invalid operation.");
		
		theList.remove(recent);
		recent = null;
	}

}

