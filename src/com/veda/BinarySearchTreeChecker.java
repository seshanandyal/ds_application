package com.veda;

public class BinarySearchTreeChecker {
	private BinaryTreeNode mRoot;
	private BinaryTreeNode mPrevious;
	
	public boolean isABinarySearchTree() {
		return inOrder();
	}

	boolean inOrder() {
		if(mRoot == null || (mRoot.mLeft == null && mRoot.mRight == null)) {
			return true;
		}
		
		mPrevious = mRoot;
		return inOrder(mRoot);
	}

	boolean inOrder(BinaryTreeNode node) {
		if (node == null) {
			return true;
		}
		
		inOrder(node.mLeft);
		
		if (node != mRoot  || 
				(node == mRoot && mPrevious != mRoot)) {
			if (node.mValue < mPrevious.mValue) {
				return false;
			}
		}
		mPrevious = node;
		
		inOrder(node.mRight);
		
		return true;
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
	}
}
