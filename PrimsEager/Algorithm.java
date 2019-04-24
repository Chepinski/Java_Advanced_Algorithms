package PrimsEager;

import java.util.List;
import java.util.PriorityQueue;

public class Algorithm {

	private List<Vertex> vertexList;
	private PriorityQueue<Vertex> heap;
	
	public Algorithm(Graph graph) {
		this.vertexList = graph.getVertexList();
		this.heap = new PriorityQueue<>();
	}
	
	public void spanningTree() {
		for(Vertex vertex : vertexList) {
			if( !vertex.isVisited()) {
				greedyPrim(vertex);
			}
		}
	}

	private void greedyPrim(Vertex vertex) {
		
		vertex.setDistance(0);
		heap.add(vertex);
		
		while(!heap.isEmpty()) {
			Vertex v = heap.remove();
			scanvertex(v);
		}
	}

	private void scanvertex(Vertex vertex) {
		
		vertex.setVisited(true);
		
		for(Edge edge : vertex.getAdjacencies()) {//visit all vertexes connected to this vertex
			Vertex v = edge.getTargetVertex();
			
			if(v.isVisited()) {
				continue;
			}
			
			if(edge.getWeight() < v.getDistance()) {//if this edgeweight is less than the previous edgeweight given for target vertex
				v.setDistance(edge.getWeight());//set new distance to current edgeweight
				v.setMinEdge(edge);//set the minimum edge for the vertex to new distance
				
				if(this.heap.contains(v)) {//if the heap already contained this edge, delete it
					this.heap.remove(v);
				}
				this.heap.add(v);//add new edge to heap
			}
		}
	}
	
	public void showMST() {//print out solution to min spanning tree (non-eager version)
		for(Vertex vertex : vertexList) {
			if(vertex.getMinEdge() != null) {
				Edge e = vertex.getMinEdge();
				System.out.println("Edge: "+e.getStartVertex()+"-"+e.getTargetVertex());
			}
		}
	}
}
