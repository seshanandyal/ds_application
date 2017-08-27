/**
 * Returns the inorder successor of a node in a binary search tree.
 * @author Sesha Shayan Nandyal
 */

package com.veda.treesngraphs;

public class InOrderSuccessor {
	private BinaryTreeNode mRoot;
	
	public void display() {
		display(mRoot, 0);
		System.out.println();
	}
	
	private void display(BinaryTreeNode node, int level) {
		if(node == null) {
			return;
		}
		
		display(node.mRight, level + 1);
		System.out.println();
		
		for(int count = 0; count < level; count++) {
			System.out.print("     ");
		}
		System.out.print(node.mValue);
		
		display(node.mLeft, level + 1);
	}
	
	void constructTestTree() {
		mRoot = new BinaryTreeNode(50);
		mRoot.mLeft = new BinaryTreeNode(mRoot, 30);
		mRoot.mRight = new BinaryTreeNode(mRoot, 80);
		mRoot.mLeft.mLeft = new BinaryTreeNode(mRoot.mLeft, 20);
		mRoot.mLeft.mRight = new BinaryTreeNode(mRoot.mLeft, 40);
		mRoot.mRight.mLeft = new BinaryTreeNode(mRoot.mRight, 70);
		mRoot.mRight.mRight = new BinaryTreeNode(mRoot.mRight, 90);
		
		System.out.printf("Successor of 90 is: %s \n", successor(mRoot.mRight.mRight));
		System.out.printf("Successor of 40 is: %s \n", successor(mRoot.mLeft.mRight));
		System.out.printf("Successor of 30 is: %s \n", successor(mRoot.mLeft));
		System.out.printf("Successor of 20 is: %s \n", successor(mRoot.mLeft.mLeft));
		
	}
	
	public BinaryTreeNode successor(BinaryTreeNode node) {
		if(node.mRight != null) {
			BinaryTreeNode current = node.mRight;
			while(current.mLeft != null) {
				current = current.mLeft;
			}
			return current;	
		} else {
			BinaryTreeNode current = node;
			BinaryTreeNode parent = node.mParent;
			
			while(parent != null && parent.mLeft != current) {
				current = parent;
				parent = parent.mParent;
			}
			
			return parent;
		}
	}
	
	public static void main(String[] args) {
		InOrderSuccessor successor = new InOrderSuccessor();
		successor.constructTestTree();
		successor.display();
	}

	class BinaryTreeNode {
		int mValue;
		BinaryTreeNode mLeft;
		BinaryTreeNode mRight;
		BinaryTreeNode mParent;

		BinaryTreeNode(BinaryTreeNode parent, int value) {
			mParent = parent;
			mValue = value;
		}
		
		BinaryTreeNode(int value) {
			mValue = value;
		}

		BinaryTreeNode insertLeft(int value) {
			mLeft = new BinaryTreeNode(this, value);
			return mLeft;
		}

		BinaryTreeNode insertRight(int value) {
			mRight = new BinaryTreeNode(this, value);
			return mRight;
		}
		
		public String toString() {
			return String.valueOf(mValue);
		}
	}
}
