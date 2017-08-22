package com.veda;

public class SecondLargestElementInBSTFinder {
	BinaryTreeNode mRoot;
	BinaryTreeNode mLargest;
	BinaryTreeNode mSecondLargest;
	
	void findSecondLargestElement() {
		modifiedInOrder();
		if(mSecondLargest != null) {
			System.out.println("The second largest element in the tree is: " + 
									mSecondLargest.mValue);
		} else {
			System.out.println("The binary search tree has only one element or no elements.");
		}
	}
	
	void modifiedInOrder() {
		mLargest = mRoot;
		if(mRoot.mRight != null) {
			mSecondLargest = mRoot;
			modifiedInOrder(mRoot.mRight);
		} else {
			modifiedInOrder(mRoot);
		}
	}
	
	void modifiedInOrder(BinaryTreeNode node) {
		if(node == null) {
			return;
		}
		
		//First check if there is a right subtree
		if(node.mRight != null) {
			mSecondLargest = node;
			mLargest = node.mRight; //Greedily assigning the largest and secondLargest
			modifiedInOrder(node.mRight); //Visit the right subtree
		} else {
			modifiedInOrder(node.mLeft);
		}
		
		if(node.mValue > mLargest.mValue) {
			mSecondLargest = mLargest;
			mLargest = node;
		} else if(node.mValue > mSecondLargest.mValue) {
			mSecondLargest = node;
		}
	}
	
	class BinaryTreeNode {
		int mValue;
		BinaryTreeNode mLeft;
		BinaryTreeNode mRight;
		
		BinaryTreeNode(int value) {
			mValue = value;
		}
		
		BinaryTreeNode insertLeft(int value) {
			mLeft = new BinaryTreeNode(value);
			return mLeft;
		}
		
		BinaryTreeNode insertRight(int value) {
			mRight = new BinaryTreeNode(value);
			return mRight;
		}
	}
}
