/**
 * Finding the median of an array of numbers using Queue.
 * @author Sesha Nandyal
 */

package com.veda.stacksnqueue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class MedianFinder {
    
    Queue<Integer> mSmallerElements;
    Queue<Integer> mLargerElements;
    
    MedianFinder(int number) {
        int queueSize;
        if(number %2 == 0) {
            queueSize = number / 2;
        } else {
            queueSize = (number/2) + 1;
        }
        mSmallerElements = new PriorityQueue<>(queueSize, new Comparator<Integer>() {
            public int compare(Integer integer1, Integer integer2) {
                return integer2.compareTo(integer1);
            }
        });
        mLargerElements = new PriorityQueue<>(queueSize);
    }
    
    public void compute(int number) {
        if(mSmallerElements.size() == mLargerElements.size()) {
            if(mLargerElements.peek() != null) {
                if(mLargerElements.peek() < number) {
                    mSmallerElements.add(mLargerElements.remove());
                    mLargerElements.add(number);
                } else {
                    mSmallerElements.add(number);
                }
            } else {
                mSmallerElements.add(number);
            }
            
            if(mLargerElements.size() > mSmallerElements.size()) {
                System.out.println((float) mLargerElements.peek());
            } else {
                System.out.println((float) mSmallerElements.peek());
            }
            
        } else if(Math.abs(mSmallerElements.size() - mLargerElements.size()) == 1) {
            if(mSmallerElements.size() > mLargerElements.size()) {
                if(number < mSmallerElements.peek()) {
                    mLargerElements.add(mSmallerElements.remove());
                    mSmallerElements.add(number);
                } else {
                    mLargerElements.add(number);
                }
            } else {
                if(number > mLargerElements.peek()) {
                    mSmallerElements.add(mLargerElements.remove());
                    mLargerElements.add(number);
                } else {
                    mSmallerElements.add(number);
                }
            }
            System.out.println((mSmallerElements.peek() + mLargerElements.peek()) / 2.0);
        }
    }
    
    public void display() {
        System.out.println(mSmallerElements);
        System.out.println("headsmall: " + mSmallerElements.peek());

        System.out.println(mLargerElements);
        System.out.println("headLarge: " + mLargerElements.peek());

        
        System.out.println("----------------------------------------");
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        MedianFinder finder = new MedianFinder(n);
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
            finder.compute(a[a_i]);
            //solution.display();
        }
        in.close();
    }
}
