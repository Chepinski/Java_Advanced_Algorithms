package DAGShortestPath;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

	private String name;
	private Vertex predecessor;
	private boolean visited;
	private List<Edge> adjacenciesList;
	private double distance = Double.MAX_VALUE;
	
	public Vertex(String name) {
		this.name = name;
		this.adjacenciesList = new ArrayList<Edge>();
	}
	
	public void AddNeighbor(Edge edge) {
		this.adjacenciesList.add(edge);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Vertex getPredecessor() {
		return predecessor;
	}

	public void setPredecessor(Vertex predecessor) {
		this.predecessor = predecessor;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public List<Edge> getAdjacenciesList() {
		return adjacenciesList;
	}

	public void setAdjacenciesList(List<Edge> adjacenciesList) {
		this.adjacenciesList = adjacenciesList;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
	
}
