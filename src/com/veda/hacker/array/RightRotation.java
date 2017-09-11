/**
 * Rotate an array d times to the right.
 * @author Sesha Nandyal
 */

package com.veda.hacker.array;

public class RightRotation {
	static int[] rightRotation(int[] a, int d) {
		if(a == null || a.length == 0 ) {
			System.out.println("Either the array is null or empty.");
			return a;
		}
		
		if(a.length > d ) {
			return rotateRight(a, d);
		} else {
			int numberOfRotations =  a.length - 1;
			while(d >= 0) {
				a = rotateRight(a, numberOfRotations);
				d = d - (a.length - 1) ;
				numberOfRotations = d;
				
			}
			return a;
		}
        
    }
	
	static int[] rotateRight(int[] arr, int numberOfRotations) {
		int leftPartEndIndex =  arr.length -1  - numberOfRotations;
        int rightPartStartIndex = leftPartEndIndex + 1;
            
        inPlaceSwap(arr, 0, leftPartEndIndex);
        inPlaceSwap(arr, rightPartStartIndex, arr.length - 1);
        inPlaceSwap(arr, 0, arr.length - 1);
        
        return arr;
	}
	
	//In place swap of the leftPart of the array
    static void inPlaceSwap(int[] arr, int beginIndex, int endIndex) {
        while(beginIndex <= endIndex) {
            int temp = arr[beginIndex];
            arr[beginIndex] = arr[endIndex];
            arr[endIndex] = temp;
            beginIndex++;
            endIndex--;
        }
    }
   
    
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        
        for(int num: a) {
        	System.out.print(num + " ");
        }
        System.out.println();
        
        int[] result = rightRotation(a, 6);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");
    }
}
