/**
 * You are a waiter at a party. There are  stacked plates on pile . Each plate has a number written on it. 
 * Then there will be  iterations. In -th iteration, you start picking up the plates in  from the top one by one and 
 * check whether the number written on the plate is divisible by the -th prime. If the number is divisible, you stack 
 * that plate on pile . Otherwise, you stack that plate on pile . After  iterations, plates can only be on pile , . 
 * Output numbers on these plates from top to bottom of each piles in order of , .
 * Input Format
 * The first line contains two space separated integers,  and . 
 * The next line contains  space separated integers representing the initial pile of plates, i.e., . 
 * The leftmost value represents the bottom plate of the pile.
 * Constraints
 * Output Format
 * Output  lines. Each line contains a number written on the plate. Printing should be done in the order defined above.
 * 
 * @author Sesha Shayan Nandyal
 */

package com.veda.stacksnqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Waiter {
    static List<Integer> sPrimeList = new ArrayList<>();
    static {
        sPrimeList.add(2);
        
        int nextNumber = 3;
        while(sPrimeList.size() <= 1200) {
            boolean isPrime = true;
            for(int divisor = 2; divisor < nextNumber; divisor++) {
                if(nextNumber % divisor == 0) {
                    isPrime = false;
                    break;
                }
            }
            
            if(isPrime) {
                sPrimeList.add(nextNumber);
            }
            nextNumber++;
        }
    }
    
    private List<Stack<Integer>> mAList = null;
    private List<Stack<Integer>> mBList = null;
    private int mNumberOfIterations;
    
    Waiter(int q) {
        mNumberOfIterations = q;
        mAList = new ArrayList<Stack<Integer>>();
        mBList = new ArrayList<Stack<Integer>>();
        for(int i = 0; i <= q; i++) {
            mAList.add(new Stack<Integer>());
            mBList.add(new Stack<Integer>());
        }
    }
    
    private void populateA0(int[] numberArr) {
        Stack<Integer> stack = mAList.get(0);
        for(int number: numberArr) {
            stack.push(number);
        }
    }
    
    public void performIterations() {
        for(int iteration = 1; iteration <= mNumberOfIterations; iteration++) {
            Stack<Integer> currentStack = mAList.get(iteration - 1);
            Stack<Integer> outAStack = mAList.get(iteration);
            Stack<Integer> outBStack = mBList.get(iteration);
            
            while(!currentStack.isEmpty()) {
                int number = currentStack.pop();
                int iPrime = sPrimeList.get(iteration - 1);
                if(number % iPrime == 0) {
                    outBStack.push(number);
                } else {
                    outAStack.push(number);
                }
            }
        }
    }
    
    public void displayStacks() {
        for(int iteration = 1; iteration <= mNumberOfIterations; iteration++) {
            Stack<Integer> outBStack = mBList.get(iteration);
            while(!outBStack.isEmpty()) {
                System.out.println(outBStack.pop());
            }
        }
        Stack<Integer> outAStack = mAList.get(mNumberOfIterations);
        while(!outAStack.isEmpty()) {
            System.out.println(outAStack.pop());
        }
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        int[] number = new int[n];
        
        Waiter solution = new Waiter(q);
        
        for(int number_i = 0; number_i < n; number_i++){
            number[number_i] = in.nextInt();
        }
        
        solution.populateA0(number);
        solution.performIterations();
        solution.displayStacks();
    }
}