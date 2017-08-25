/**
 * Compute the sum of two operands, which are represented as linked lists. The nodes in the list
 * are in the reverse order (starting from the ones digit).
 * @author Sesha Shayan Nandyal
 */
package com.veda.linkedlist;

public class AdditionOperator {
	private Operand mLeftOperand;
	private Operand mRightOperand;

	public AdditionOperator(int[] leftArr, int[] rightArr) {
		mLeftOperand = new Operand(leftArr);
		mRightOperand = new Operand(rightArr);
		
		//Pad zeros if one linkedlist is shorter than the other.
		if (leftArr.length < rightArr.length) {
			for (int index = 0; index < (rightArr.length - leftArr.length); index++) {
				mLeftOperand.insert(0);
			}
		} else if (rightArr.length < leftArr.length) {
			for (int index = 0; index < (leftArr.length - rightArr.length); index++) {
				mRightOperand.insert(0);
			}
		}
		
		mLeftOperand.display();
		mRightOperand.display();
	}

	public void sum() {
		LinkedListNode leftNode = mLeftOperand.mHead;
		LinkedListNode rightNode = mRightOperand.mHead;

		int carryOver = 0;
		int onesDigit = 0;
		LinkedListNode prevLeftNode = null;

		while (leftNode != null) {
			int sum = carryOver + leftNode.getValue() + rightNode.getValue();
			carryOver = sum / 10;
			onesDigit = sum % 10;
			
			if(carryOver == 0) {
				leftNode.setValue(sum);
			} else {
				leftNode.setValue(onesDigit);
			}

			prevLeftNode = leftNode;
			leftNode = leftNode.getNext();
			rightNode = rightNode.getNext();
		}

		if (carryOver != 0) {
			prevLeftNode.setNext(new LinkedListNode(carryOver));
		}
		
		System.out.println("Sum of the two operands is: ");
		mLeftOperand.display();
	}

	public static void main(String[] args) {
		int[] leftArr = { 7, 1 }, rightArr = { 9, 9, 9 };
		AdditionOperator operator = new AdditionOperator(leftArr, rightArr);
		operator.sum();
	}

	class Operand {
		private LinkedListNode mHead;

		public Operand(int[] digits) {
			for (int digit : digits) {
				insert(digit);
			}
		}

		public void insert(int value) {
			LinkedListNode newNode = new LinkedListNode(value);

			if (mHead == null) {
				mHead = newNode;
				return;
			}

			LinkedListNode current = mHead;

			while (current.getNext() != null) {
				current = current.getNext();
			}

			current.setNext(newNode);
		}

		public void display() {
			LinkedListNode current = mHead;
			
			while(current != null) {
				System.out.print(current + " -> ");
				current = current.getNext();
			}
			System.out.println("null");
		}
	}
}
