/**
 * Given an array, , of  integers, print each element in reverse order as a 
 * single line of space-separated integers.
 * @author Sesha Shayan Nandyal
 */

package com.veda.hacker.array;

import java.util.Scanner;

public class ReverseArray {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        
        for(int index = 0; index < (arr.length)/2; index++) {
            int temp = arr[index];
            arr[index] = arr[arr.length - index -1];
            arr[arr.length - index -1] = temp;
        }
    
        for(int index = 0; index < arr.length; index++) {
            System.out.print(arr[index] + " ");
        }
    }
}
