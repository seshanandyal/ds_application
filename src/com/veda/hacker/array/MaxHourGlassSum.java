/**
 * Calculate the hourglass sum for every hourglass in a 6X6 2D Array A, then print the maximum hourglass sum.
 * @author Sesha Shayan Nandyal
 */

package com.veda.hacker.array;

import java.util.Scanner;

public class MaxHourGlassSum {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for(int arr_i=0; arr_i < 6; arr_i++){
            for(int arr_j=0; arr_j < 6; arr_j++){
                arr[arr_i][arr_j] = in.nextInt();
            }
        }
        
        boolean firstTime = true;
        int maxSum = 0;
        for(int rowIndex = 0; rowIndex <= 3; rowIndex++) {
            for(int columnIndex = 0; columnIndex <= 3; columnIndex++) {
                int sum = arr[rowIndex][columnIndex] + arr[rowIndex][columnIndex + 1] +
                    arr[rowIndex][columnIndex + 2] + arr[rowIndex + 1][columnIndex + 1] + 
                    arr[rowIndex + 2][columnIndex] + arr[rowIndex + 2][columnIndex + 1]+
                    arr[rowIndex + 2][columnIndex + 2];
                
                if(firstTime) {
                    maxSum = sum;
                    firstTime = false;
                } else {
                    if(maxSum < sum) {
                        maxSum = sum;
                    }
                }
            }
        }
        
        System.out.println(maxSum);
    }
}
