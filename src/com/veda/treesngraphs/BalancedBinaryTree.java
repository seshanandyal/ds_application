/**
 * Checks if the binary tree is "super" balanced - where the difference between the minHeight and maxHeight of a
 * binary tree is less than or equal to 1.
 * @author Sesha Shayan Nandyal
 */

package com.veda.treesngraphs;

public class BalancedBinaryTree {
	public BinaryTreeNode mRoot;
	
	boolean isSuperBalanced() {
		return (maxHeightOfTree() - minHeightOfTree() <= 1);
	}
	
	int minHeightOfTree() {
		return minHeightOfTree(mRoot);
	}
	
	int minHeightOfTree(BinaryTreeNode node) {
		if(node == null) {
			return 0;
		}
		
		return 1 + Math.min(minHeightOfTree(node.mLeft), minHeightOfTree(node.mRight));
	}
	
	int maxHeightOfTree() {
		return maxHeightOfTree(mRoot);
	}
	
	int maxHeightOfTree(BinaryTreeNode node) {
		if(node == null) {
			return 0;
		}
		
		return 1 +  Math.max(maxHeightOfTree(node.mLeft), maxHeightOfTree(node.mRight));
	}
	
	static class BinaryTreeNode {
		public int mValue;
		public BinaryTreeNode mLeft;
		public BinaryTreeNode mRight;
		
		public BinaryTreeNode(int value) {
			mValue = value;
		}
		
		public BinaryTreeNode insertLeft(int leftValue) {
			mLeft = new BinaryTreeNode(leftValue);
			return mLeft;
		}
		
		public BinaryTreeNode insertRight(int rightValue) {
			mRight = new BinaryTreeNode(rightValue);
			return mRight;
		}
	}
}
