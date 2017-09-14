/**
 * A binary tree is a tree which is characterized by any one of the following properties:
 * It can be an empty (null).
 * It contains a root node and two subtrees, left subtree and right subtree. These subtrees are also binary tree.
 * Inorder traversal is performed as
 * 
 * Traverse the left subtree.
 * Visit root (print it).
 * Traverse the right subtree.
 * (For an Inorder traversal, start from the root and keep visiting the left subtree recursively until you reach the 
 * leaf,then you print the node at which you are and then you visit the right subtree.)
 * 
 * We define depth of a node as follow:
 * Root node is at depth 1.
 * If the depth of parent node is d, then the depth of current node wll be d+1.
 * Swapping: Swapping subtrees of a node means that if initially node has left subtree L and right subtree R, 
 * then after swapping left subtree will be R and right subtree L.
 * 
 * @author Sesha Shayan Nandyal
 */

package com.veda.treesngraphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SwapNode {
	static class Node {
        int mData;
        Node mLeft;
        Node mRight;
        int mDepth;
        
        Node(int data) {
            mData = data;
        }
        
        public String toString() {
            return String.valueOf(mData);
        }
    }
    
    static Map<Integer, List<Node>> depthNodeListMap = new HashMap<>();
    
    static void inOrder(Node node) {
        if(node == null) {
            return;
        }
        
        inOrder(node.mLeft);
        System.out.print(node.mData + " ");
        inOrder(node.mRight);
    }
    
    static void swap(List<Node> nodeList, int depth) {
        for(Node node: nodeList) { 
            Node temp = node.mLeft;
            node.mLeft = node.mRight;
            node.mRight = temp;    
        }
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberOfNodes = scan.nextInt();
        
        
        Node newNode = new Node(1);
        List<Node> nodeList = new ArrayList<>();
        List<Node> mapNodeList = new ArrayList<>();
        newNode.mDepth = 1;
        nodeList.add(newNode);
        mapNodeList.add(newNode);
        depthNodeListMap.put(1, mapNodeList);
        
        Node current = null;
        for(int count = 1; count <= numberOfNodes; count++) {
            current = nodeList.get(count - 1);
            int leftData = scan.nextInt();
            if(leftData != -1) {
                newNode = new Node(leftData);
                current.mLeft = newNode;
                mapNodeList = depthNodeListMap.get(current.mDepth + 1);
                if(mapNodeList == null) {
                    mapNodeList = new ArrayList<>();
                }
                newNode.mDepth = current.mDepth + 1;
                mapNodeList.add(newNode);
                nodeList.add(newNode);
                depthNodeListMap.put(current.mDepth + 1, mapNodeList);
            } else {
                current.mLeft = null;
            }
            
            int rightData = scan.nextInt();
            if(rightData != -1) {
                newNode = new Node(rightData);
                current.mRight = newNode;
                mapNodeList = depthNodeListMap.get(current.mDepth + 1);
                if(mapNodeList == null) {
                    mapNodeList = new ArrayList<>();
                }
                newNode.mDepth = current.mDepth + 1;
                mapNodeList.add(newNode);
                nodeList.add(newNode);
                depthNodeListMap.put(current.mDepth + 1, mapNodeList);
            } else {
                current.mRight = null;
            }
        }

       
        int numberOfOperations = scan.nextInt();
        for(int count = 1; count <= numberOfOperations; count++) {
            int depth = scan.nextInt();
            mapNodeList = depthNodeListMap.get(depth);
            
            int step = 1;
            int newDepth = depth;
            while(mapNodeList != null ) {
                swap(mapNodeList, depth);
                newDepth = depth * (++step);
                mapNodeList = depthNodeListMap.get(newDepth);
            }            
            inOrder(nodeList.get(0));
            System.out.println();
        }
    }
}
