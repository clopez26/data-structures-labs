package linkedLists;
/**
 * Singly linked list with references to its first and its
 * last node. 
 * 
 * @author pirvos
 *
 */

import java.util.NoSuchElementException;

import linkedLists.LinkedList;

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
		
		if(st == last)
		{
			sn.setNext(null);
			last.setNext(sn);
			last = sn;
		}
		
		else
		{
			sn.setNext(st.getNext());
			st.setNext(sn);
		}
		
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
			sn.setNext(st);
			ref.setNext(sn);
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
			throw new NoSuchElementException("There is no node after the first node.");
		
		SNode<E> ref = first;
		
		while(ref.getNext() != target && ref != null)
			ref = ref.getNext();
		
		return (SNode<E>) ref;
	}

	public int length() {
		return length;
	}

	public void removeNode(Node<E> target) {
		SNode<E> st = (SNode<E>) target;
		
		if(st == first)
		{	
			SNode<E> temp = first;
			temp.setNext(first.getNext());
			first.clean();
			first = temp;
			
		}
			
		SNode<E> ref = (SNode<E>) getNodeBefore(st);
		
		ref.setNext(st.getNext());
		
		if(st == last)
			last = ref;
		
		st.clean();
		
		length--;
	}
	
	public Node<E> createNewNode() {
		return new SNode<E>();
	}

}
