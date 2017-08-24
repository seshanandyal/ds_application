package linkedlist;

public class KthToLastNodeFinder {
	private Node mHead;
	private int mSize = 0;
	
	public void insert(Node node) {
		mSize++;
		if(mHead == null) {
			mHead = node;
			return;
		}
		
		Node current = mHead;
		while(current.mNext != null) {
			current = current.mNext;
		}
		current.mNext = node;
	}
	
	public Node kthToLastNode(int indexFromLastNode) {
		if(indexFromLastNode < 1) {
			return null;
		}
		
		Node current = mHead;
		while(current != null && indexFromLastNode != 0) {
			current = current.mNext;
			indexFromLastNode--;
		}
		
		if(indexFromLastNode != 0) {
			return null; //Throw an exception that the size is smaller than the kthLastNode
		}
		
		Node currentFromHead = mHead;
		while(current != null) {
			current = current.mNext;
			currentFromHead = currentFromHead.mNext;
		}
		
		return currentFromHead;
	}
	
	//First Attempt: Using the instance variable mSize
	public Node kthToLastNodeUsingSize(int indexFromLastNode) {
		if(indexFromLastNode > mSize || indexFromLastNode < 1) {
			return null;
		}
		
		int counter = mSize - indexFromLastNode;
		Node current = mHead;
		while(counter != 0) {
			current = current.mNext;
			counter--;
		}
		
		return current;
	}
	
	public void display() {
		Node current = mHead;
		while(current != null) {
			System.out.print(current + " -> ");
			current = current.mNext;
		}
		System.out.println("null");
	}
	
	public static void main(String[] args) {
		KthToLastNodeFinder finder = new KthToLastNodeFinder();
		Node angelFood = new Node("Angel Food"), bundt = new Node("Bundt"), 
				cheese = new Node("Cheese"), devilsFood = new Node("Devil's Food"),
				eccles = new Node("Eccles");
		finder.insert(angelFood);
		finder.insert(bundt);
		finder.insert(cheese);
		finder.insert(devilsFood);
		finder.insert(eccles);
		
		finder.display();
		
		int kthLastNode = 2;
		System.out.printf("%d from the last node is: %s \n", kthLastNode, finder.kthToLastNode(kthLastNode));
	}
	
	static class Node {
		String mValue;
		Node mNext;
		
		Node(String value) {
			mValue = value;
		}
		
		public String toString() {
			return mValue;
		}
	}
}
