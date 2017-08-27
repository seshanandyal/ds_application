/**
 * Creates a minimal binary search tree using a sorted array and also creates a list of all nodes at each depth.
 * For the latter, we could have used level order traversal but chose pre-order traversal instead.
 * @author Sesha Shayan Nandyal
 */

package com.veda.treesngraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimalTree {
	private Node mRoot;
	private List<Queue<Node>> mListOfNodes = new ArrayList<>();
	
	public void createMinimalTree(int[] sortedArray) {
		if(sortedArray == null || sortedArray.length == 0) {
			return;
		}
		
		if(sortedArray.length == 1) {
			mRoot = new Node(sortedArray[0]);
			return;
		}
		
		mRoot = createSubTree(sortedArray, 0, sortedArray.length - 1);
	}
	
	
	public void displayListOfNodesAtEachDepth() {
		if(mRoot == null) {
			return;
		}
		
		preOrderTraversal(mRoot, 0);
		
		int depth = 0;
		for(Queue queue: mListOfNodes) {
			System.out.printf("Depth: %d, %s \n", depth, queue);
			depth++;
		}
	}
	
	private void preOrderTraversal(Node node, int depth) {
		if(node == null) {
			return;
		}
		
		Queue<Node> queue = null;
		if(depth <= (mListOfNodes.size() - 1)) {
			queue = mListOfNodes.get(depth);
		}
		if(queue == null) {
			queue = new LinkedList<>();
		} else {
			mListOfNodes.remove(depth);
		}
		
		queue.add(node);
		mListOfNodes.add(depth, queue);
		
		preOrderTraversal(node.mLeftNode, depth + 1);
		preOrderTraversal(node.mRightNode, depth + 1);
	}
	
	public void display() {
		display(mRoot, 0);
		System.out.println();
	}
	
	private void display(Node node, int level) {
		if(node == null) {
			return;
		}
		
		display(node.mRightNode, level + 1);
		System.out.println();
		
		for(int count = 0; count < level; count++) {
			System.out.print("     ");
		}
		System.out.print(node.mValue);
		
		display(node.mLeftNode, level + 1);
	}
	
	private Node createSubTree(int[] sortedArray, int start, int end) {
		if(end < start) {
			return null;
		}
		
		int mid = (start + end)/2;
		Node node = new Node(sortedArray[mid]);
		node.mLeftNode = createSubTree(sortedArray, start, mid - 1);
		node.mRightNode = createSubTree(sortedArray, mid + 1, end);
		return node;
	}
	
	public static void main(String[] args) {
		MinimalTree tree = new MinimalTree();
		int[] sortedArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
		
		tree.createMinimalTree(sortedArr);
		tree.display();
		
		tree.displayListOfNodesAtEachDepth();
	}
	
	class Node {
		private int mValue;
		private Node mLeftNode;
		private Node mRightNode;
		
		Node(int value) {
			mValue = value;
		}
		
		public String toString() {
			return String.valueOf(mValue);
		}
	}
}
