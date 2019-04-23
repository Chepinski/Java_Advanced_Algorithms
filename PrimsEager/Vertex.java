package PrimsEager;

import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex> {

	private String name;
	private Edge minEdge;//to compare against new edge to same vertex
	private boolean visited;
	private Vertex previousVertex;
	private double distance = Double.POSITIVE_INFINITY;
	
	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	private List<Edge> adjacencies;

	public Vertex(String name) {
		this.name = name;
		this.adjacencies = new ArrayList<>();
	}

	public void addEdge(Edge edge) {
		this.adjacencies.add(edge);
	}

	public Edge getMinEdge() {
		return minEdge;
	}

	public void setMinEdge(Edge minEdge) {
		this.minEdge = minEdge;
	}

	public Vertex getPreviousVertex() {
		return previousVertex;
	}

	public void setPreviousVertex(Vertex previousVertex) {
		this.previousVertex = previousVertex;
	}

	public List<Edge> getAdjacencies() {
		return adjacencies;
	}

	public void setAdjacencies(List<Edge> adjacencies) {
		this.adjacencies = adjacencies;
	}
	
	public boolean isVisited() {
		return visited;
	}
	
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	@Override
	public String toString() {
		return ""+this.name;
	}

	@Override
	public int compareTo(Vertex otherVertex) {
		return Double.compare(this.distance, otherVertex.getDistance());
	}

}
