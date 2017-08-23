package com.veda;

public class BinarySearchTreeChecker {
	private BinaryTreeNode mRoot;
	private BinaryTreeNode mPrevious;

	public boolean isABinarySearchTree() {
		return inOrder();
	}

	boolean inOrder() {
		if (mRoot == null || (mRoot.mLeft == null && mRoot.mRight == null)) {
			return true;
		}

		return modifiedInOrder(mRoot);
	}

	boolean modifiedInOrder(BinaryTreeNode node) {
		if (node == null) {
			return true;
		}

		boolean resume = modifiedInOrder(node.mLeft);
		if(!resume) {
			return false;
		}

		if (mPrevious != null) {
			if (node.mValue < mPrevious.mValue) {
				System.out.printf("Failing at node: %s as the previous node: %s \n ", node, mPrevious);
				return false;
			}
		}
		
		mPrevious = node;

		resume = modifiedInOrder(node.mRight);
		if(!resume) {
			return false;
		}

		return true;
	}
	
	void constructTestTree() {
		mRoot = new BinaryTreeNode(50);
		mRoot.mLeft = new BinaryTreeNode(30);
		mRoot.mRight = new BinaryTreeNode(80);
		mRoot.mLeft.mLeft = new BinaryTreeNode(20);
		mRoot.mLeft.mRight = new BinaryTreeNode(60);
		mRoot.mRight.mLeft = new BinaryTreeNode(70);
		mRoot.mRight.mRight = new BinaryTreeNode(90);
	}
	
	public static void main(String[] args) {
		BinarySearchTreeChecker checker = new BinarySearchTreeChecker();
		checker.constructTestTree();
		
		System.out.printf("The test tree is a binary search tree: %b \n", checker.isABinarySearchTree());
	}

	public static class BinaryTreeNode {
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
		
		public String toString() {
			return String.valueOf(mValue);
		}
	}
}
