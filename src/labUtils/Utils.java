package labUtils;

import treeClasses.LinkedBinaryTree;
import treeClasses.LinkedTree;
import treeInterfaces.Position;
import treeInterfaces.Tree;

public class Utils {
	public static <E> void displayTree(String msg, Tree<E> t) { 
		System.out.println("\n\n" + msg); 
		t.display(); 
	}

	public static <E> void displayTreeElements(String msg, Tree<E> t) {
		System.out.println("\n\n" + msg); 
		for (E element : t)
			System.out.println(element); 
		
	}
	
	public static LinkedTree<Integer> buildExampleTreeAsLinkedTree() { 
		LinkedTree<Integer> t = new LinkedTree<>(); 
		
		t.addRoot(4);
		
		Position<Integer> rootLeftChild = t.addChild(t.root(), 9);
		Position<Integer> rootRightChild = t.addChild(t.root(), 20);
		
		// left side children
		
		t.addChild(rootLeftChild, 7);
		t.addChild(rootLeftChild, 10);
		
		// right side children
		
		Position<Integer> rootRightLeftGrandChild = t.addChild(rootRightChild, 15);
		Position<Integer> rootRightRightGrandChild = t.addChild(rootRightChild, 21);
		
		// right side grandchildren
		
		t.addChild(rootRightLeftGrandChild, 12);
		
		Position<Integer> rootRightLeftGreatGrandChild = t.addChild(rootRightLeftGrandChild, 17);
		
		t.addChild(rootRightLeftGreatGrandChild, 19);
		
		Position<Integer> rootRightRightGreatGrandChild = t.addChild(rootRightRightGrandChild, 40);
		
		t.addChild(rootRightRightGreatGrandChild, 30);
		t.addChild(rootRightRightGreatGrandChild, 45);
		
		return t; 
	}
	
	public static LinkedBinaryTree<Integer> buildExampleTreeAsLinkedBinaryTree() { 
		LinkedBinaryTree<Integer> t = new LinkedBinaryTree<>(); 
	
		Position<Integer> root = t.addRoot(4);
		Position<Integer> rootLeftChild = t.addLeft(root, 9);
		Position<Integer> rootRightChild = t.addRight(root, 20);
		
		// left children
		
		t.addLeft(rootLeftChild, 7);
		t.addRight(rootLeftChild, 10);
		
		Position<Integer> rootLeftGrandChild = t.addLeft(rootRightChild, 15);
		Position<Integer> rootRightGrandChild = t.addRight(rootRightChild, 21);
		
		// left grandchildren
		
		t.addLeft(rootLeftGrandChild, 12);
		
		Position<Integer> rootRightLeftGrandChild = t.addRight(rootLeftGrandChild, 17);
		
		t.addLeft(rootRightLeftGrandChild, 19);
		
		// right grandchildren
		
		Position<Integer> rootRightRightGreatGrandChild = t.addRight(rootRightGrandChild, 40);
		
		t.addLeft(rootRightRightGreatGrandChild, 30);
		t.addRight(rootRightRightGreatGrandChild, 45);
		
		return t; 
	}


}
