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
		
		for(Edge edge : vertex.getAdjacencies()) {
			Vertex v = edge.getTargetVertex();
			
			if(v.isVisited()) {
				continue;
			}
			
			if(edge.getWeight() < v.getDistance()) {
				v.setDistance(edge.getWeight());
				v.setMinEdge(edge);
				
				if(this.heap.contains(v)) {
					this.heap.remove(v);
				}
				this.heap.add(v);
			}
		}
	}
	
	public void showMST() {
		for(Vertex vertex : vertexList) {
			if(vertex.getMinEdge() != null) {
				Edge e = vertex.getMinEdge();
				System.out.println("Edge: "+e.getStartVertex()+"-"+e.getTargetVertex());
			}
		}
	}
}
