package Prim;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
//LAZY IMPLEMENTATION OF PRIMS
public class PrimsAlgorithm {
	//unvisitedVertices will initially contain all vertices
	private List<Vertex> unvisitedVertices;
	private List<Edge> spanningTree;
	private PriorityQueue<Edge> edgeHeap;
	private double fullCost;//sum of edges
	
	public PrimsAlgorithm(List<Vertex> unvisitedList) {
		this.spanningTree = new ArrayList<>();
		this.unvisitedVertices = unvisitedList;
		this.edgeHeap = new PriorityQueue<>();
	}
	
	public void PrimsAlgorithm(Vertex vertex) {
		this.unvisitedVertices.remove(vertex);
		
		while( !unvisitedVertices.isEmpty()) {
			for(Edge edge : vertex.getAdjacencies()) {
				if(this.unvisitedVertices.contains(edge.getTargetVertex())) {
					this.edgeHeap.add(edge);
					//prevent cycles
					//only add to edgeHeap if Vertex hasn't been visited
				}
			}
			//remove min Edge from priority queue
			Edge minEdge = this.edgeHeap.remove();
			//add min Edge to spanning tree
			this.spanningTree.add(minEdge);
			//add min Edge weight to total cost
			this.fullCost += minEdge.getWeight();
			
			vertex = minEdge.getTargetVertex();
			//remove min edge targetVertex from unvisited
			this.unvisitedVertices.remove(vertex);
		}
	}
	
	public void showMST() {
		System.out.println("The minimum spanning tree costs: "+this.fullCost);
		for(Edge edge : spanningTree) {
			System.out.println(edge.getStartVertex()+" - "+edge.getTargetVertex());
		}
	}

}
