package linkedLists;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

import linkedLists.AbstractSLList.SNode;

public class DLDHDTList<E> extends AbstractDLList<E> {
	private DNode<E> header, trailer; 
	private int length; 
	
	public DLDHDTList() { 
		header = new DNode<E>(null, null, trailer);
		trailer = new DNode<E>(null, header, null);
		length = 0;
	}
	
	public void addFirstNode(Node<E> nuevo) {
		addNodeAfter(header, nuevo); 
	}
	
	public void addLastNode(Node<E> nuevo) { 
		DNode<E> dnuevo = (DNode<E>) nuevo; 
		DNode<E> nBefore = trailer.getPrev();  
		nBefore.setNext(dnuevo); 
		trailer.setPrev(dnuevo); 
		dnuevo.setPrev(nBefore); 
		dnuevo.setNext(trailer); 
		length++; 
	}

	public void addNodeAfter(Node<E> target, Node<E> nuevo) {
		DNode<E> dnuevo = (DNode<E>) nuevo; 
		DNode<E> nBefore = (DNode<E>) target; 
		DNode<E> nAfter = nBefore.getNext(); 
		nBefore.setNext(dnuevo); 
		nAfter.setPrev(dnuevo); 
		dnuevo.setPrev(nBefore); 
		dnuevo.setNext(nAfter); 
		length++; 
	}

	public void addNodeBefore(Node<E> target, Node<E> nuevo) {
		DNode<E> dt = (DNode<E>) target;
		DNode<E> dn = (DNode<E>) nuevo;
		
		addNodeAfter(dt.getPrev(), dn);
		length++;
	
	}

	public Node<E> createNewNode() {
		return new DNode<E>();
	}

	public Node<E> getFirstNode() throws NoSuchElementException {
		if (length == 0) 
			throw new NoSuchElementException("List is empty."); 
		return header.getNext();
	}

	public Node<E> getLastNode() throws NoSuchElementException {
		if (length == 0) 
			throw new NoSuchElementException("List is empty."); 
		return trailer.getPrev();
	}

	public Node<E> getNodeAfter(Node<E> target)
			throws NoSuchElementException {
		
		DNode<E> dt = (DNode<E>) target;
		
		if(dt == trailer)
			throw new NoSuchElementException("List is empty. No next node after trailer.");
		
		return dt.getNext(); 
	}

	public Node<E> getNodeBefore(Node<E> target)
			throws NoSuchElementException {
		
		DNode<E> dt = (DNode<E>) target;
		
		if(dt == header)
			throw new NoSuchElementException("List is empty. No previous node before header.");
		
		return dt.getPrev(); 
	}

	public int length() {
		return length;
	}

	public void removeNode(Node<E> target) 
	{
		DNode<E> dt = (DNode<E>) target;
		DNode<E> prev = dt.getPrev();
		DNode<E> after = dt.getNext();
		
		prev.setNext(after);
		after.setPrev(prev);
		dt.clean();
		length--;
	}
	
	/**
	 * Prepares every node so that the garbage collector can free 
	 * its memory space, at least from the point of view of the
	 * list. This method is supposed to be used whenever the 
	 * list object is not going to be used anymore. Removes all
	 * physical nodes (data nodes and control nodes, if any)
	 * from the linked list
	 */
	private void destroy() {
		while (header != null) { 
			DNode<E> nnode = header.getNext(); 
			header.clean(); 
			header = nnode; 
		}
	}
	
	/**
	 * The execution of this method removes all the data nodes from
	 * the current instance of the list, leaving it as a valid empty
	 * doubly linked list with dummy header and dummy trailer nodes. 
	 */
	public void makeEmpty() { 
		// TODO
	}
		
	protected void finalize() throws Throwable {
	    try {
			this.destroy(); 
	    } finally {
	        super.finalize();
	    }
	}
	
	public Object[] toArray(){
		Object [] result = (E[]) new Object[this.length];

		DNode<E> ref = header.getNext();

		for(int i = 0; i < result.length; i++)
			if(ref.getNext() != trailer)
			{
				result[i] = ref.getElement();
				ref = ref.getNext();
			}

		result[length-1] = trailer.getPrev().getElement();

		return result;
	}
	
	public <T1> T1[] toArray(T1[] array) 
	{
		if (array.length < this.length) 
		{
			array = (T1[]) Array.newInstance(array.getClass().getComponentType(), this.length);
		}
		else if (array.length > this.length) 
			// Set to null all those positions of arr that won't be used. 
			for (int j=this.length; j< array.length; j++) 
				array[j] = null;


		DNode<E> ref = header.getNext();

		for(int i = 0; i < array.length; i++)
		{
			if(ref.getNext() != trailer)
			{
				array[i] = (T1) ref.getElement();
				ref = ref.getNext();
			}
		}

		array[length-1] = (T1) trailer.getPrev().getElement();
		return array;	 
	}

}
