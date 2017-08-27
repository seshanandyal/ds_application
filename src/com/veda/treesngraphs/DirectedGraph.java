/**
 * Checks if there is path between two nodes in a directed graph using breadth first search
 * @author Sesha Shayan Nandyal
 */

package com.veda.treesngraphs;

import java.util.LinkedList;
import java.util.Queue;

public class DirectedGraph {
	private VertexNode mStart;
	private Queue<VertexNode> mQueue = new LinkedList<>();
	
	public void insertEdge(String value) {
		VertexNode newNode = new VertexNode(value);
		
		if(mStart == null) {
			mStart = newNode;
		} else {
			VertexNode current = mStart;
			while(current.mNext != null) {
				current = current.mNext;
			}
			current.mNext = newNode;
		}
	}
	
	public void setPath(String startValue, String endValue) {
		VertexNode startNode = null, endNode = null;
		VertexNode current = mStart;
		
		while((startNode == null || endNode == null) && current != null) {
			if(current.mName == startValue) {
				startNode = current;
			} else if(current.mName == endValue) {
				endNode = current;
			}
			
			current = current.mNext;
		}
		
		if(startNode == null || endNode == null) {
			System.out.println("Vertex nodes do not exist. First call insertEdge() and then setPath().");
			return;
		}
		
		EdgeNode newEndEdgeNode = new EdgeNode(endNode);
		if(startNode.mFirstEdgeNode == null) {
			startNode.mFirstEdgeNode = newEndEdgeNode;
		} else {
			EdgeNode currentEndEdgeNode = startNode.mFirstEdgeNode;
			while(currentEndEdgeNode.mNext != null) {
				currentEndEdgeNode = currentEndEdgeNode.mNext;
			}
			currentEndEdgeNode.mNext = newEndEdgeNode;
		}
	}
	
	public boolean pathExists(String start, String end) {
		mQueue = new LinkedList<>();
		VertexNode current = mStart;
		
		while(current != null) {
			if(current.mName == start) {
				break;
			}
			current = current.mNext;
		}
		
		if(current == null) {
			System.out.println("The start string does not exists.");;
			return false;
		}
		
		//Initialize the visited member variable to false.
		initializeVisitedToFalse();
		
		mQueue.add(current);
		return performBreadFirstSearch(end);
		
	}
	
	private void initializeVisitedToFalse() {
		VertexNode current = mStart;
		while(current != null) {
			current.mVisited = false;
			current = current.mNext;
		}
	}
	
	private boolean performBreadFirstSearch(String end) {
		while(!mQueue.isEmpty()) {
			VertexNode current = mQueue.remove();
			current.mVisited = true;
			
			if(current.mName.equals(end)) {
				return true;
			}
			
			EdgeNode currentNeighbor = current.mFirstEdgeNode;
			while(currentNeighbor != null && !currentNeighbor.mEndVertexNode.mVisited) {
				mQueue.add(currentNeighbor.mEndVertexNode);
				currentNeighbor = currentNeighbor.mNext;
			}
		}
		
		return false;
	}
	public static void main(String[] args) {
		DirectedGraph graph = new DirectedGraph();
		graph.insertEdge("xyz");
		graph.insertEdge("pqr");
		graph.insertEdge("abc");
		graph.insertEdge("lmn");
		
		graph.setPath("xyz", "pqr");
		graph.setPath("xyz", "abc");

		graph.setPath("abc", "lmn");
		graph.setPath("lmn", "abc");
		graph.setPath("lmn", "pqr");
		graph.setPath("lmn", "xyz");
		graph.setPath("pqr", "abc");
		
		System.out.printf("Path exists between %s and %s is: %b \n", "lmn", "pqr", 
				graph.pathExists("lmn", "pqr"));
		System.out.printf("Path exists between %s and %s is: %b \n", "abc", "pqr", 
				graph.pathExists("abc", "pqr"));
		System.out.printf("Path exists between %s and %s is: %b \n", "pqr", "abc", 
				graph.pathExists("pqr", "abc"));
		System.out.printf("Path exists between %s and %s is: %b \n", "xyz", "lmn", 
				graph.pathExists("xyz", "lmn"));
		System.out.printf("Path exists between %s and %s is: %b \n", "lmn", "xyz", 
				graph.pathExists("lmn", "xyz"));
	}

	class VertexNode {
		private String mName;
		private VertexNode mNext;
		private EdgeNode mFirstEdgeNode;
		private boolean mVisited;
		
		public VertexNode(String name) {
			mName = name;
		}
		
		public String toString() {
			return mName;
		}
	}
	
	class EdgeNode {
		private VertexNode mEndVertexNode;
		private EdgeNode mNext;
		
		public EdgeNode(VertexNode node) {
			mEndVertexNode = node;
		}
		
		public String toString() {
			return mEndVertexNode.toString();
		}
	}
}
