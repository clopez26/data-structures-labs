package linkedLists;
/**
 * Singly linked list with references to its first and its
 * last node. 
 * 
 * @author pirvos
 *
 */

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

public class SLFLList<E> extends SLList<E>
{
	private SNode<E> first, last;   // reference to the first node and to the last node
	int length; 

	public SLFLList() {       // to create an empty list instance
		first = last = null; 
		length = 0; 
	}


	public void addFirstNode(Node<E> nuevo) {
		SNode<E> nta = (SNode<E>) nuevo;

		nta.setNext(first);
		first = nta;

		if(length == 0)
			last = nta;   

		length++;
	}

	public void addNodeAfter(Node<E> target, Node<E> nuevo) 
	{
		SNode<E> st = (SNode<E>) target;
		SNode<E> sn = (SNode<E>) nuevo;


		sn.setNext(st.getNext());
		st.setNext(sn);


		if(st == last)
			last = sn;

		length++;

	}

	public void addNodeBefore(Node<E> target, Node<E> nuevo) 
	{
		SNode<E> st = (SNode<E>) target;
		SNode<E> sn = (SNode<E>) nuevo;

		if(st == first)
			addFirstNode(sn);

		else
		{
			SNode<E> ref = (SNode<E>) getNodeBefore(st);			
			addNodeAfter(ref, sn);
		}

		length++;
	}

	public Node<E> getFirstNode() throws NoSuchElementException {
		if(length == 0)
			throw new NoSuchElementException("The linked list is empty. Method invalid!");
		return first;
	}

	public Node<E> getLastNode() throws NoSuchElementException {
		if(length == 0)
			throw new NoSuchElementException("The linked list is empty. Method invalid!");
		return last;
	}

	public Node<E> getNodeAfter(Node<E> target) throws NoSuchElementException 
	{
		if(target == last)
			throw new NoSuchElementException("There is no node after the last node.");
		return ((SNode<E>) target).getNext();
	}

	public Node<E> getNodeBefore(Node<E> target)
			throws NoSuchElementException {
		if(target == first)
			throw new NoSuchElementException("There is no node before the first node.");

		SNode<E> ref = first;

		while(ref.getNext() != target && ref != null)
			ref = ref.getNext();

		return (SNode<E>) ref;
	}

	public int length() {
		return length;
	}

	public void removeNode(Node<E> target)
	{
		SNode<E> st = (SNode<E>) target;
		if (st == first) 
			first = first.getNext(); 

		else if(st == last) 
		{
			SNode<E> prev = (SNode<E>) getNodeBefore((SNode<E>) last);
			last = prev;
			prev.setNext(null);  
		} 

		else 
		{ 
			SNode<E> prev = (SNode<E>) this.getNodeBefore(target); 
			prev.setNext(st.getNext()); 
		}

		st.clean();  
		length--; 

	}

	public Node<E> createNewNode() {
		return new SNode<E>();
	}

	public Object[] toArray(){
		Object [] result = (E[]) new Object[this.length];

		SNode<E> ref = first;

		for(int i = 0; i < result.length; i++)
			if(ref.getNext() != null)
			{
				result[i] = ref.getElement();
				ref = ref.getNext();
			}

		result[length-1] = last.getElement();

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


		SNode<E> ref = first;

		for(int i = 0; i < array.length; i++)
		{
			if(ref.getNext() != null)
			{
				array[i] = (T1) ref.getElement();
				ref = ref.getNext();
			}
		}

		array[length-1] = (T1) last.getElement();
		return array;	 
	}
}