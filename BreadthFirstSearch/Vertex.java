package BreadthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

	private int data;
	private boolean visited; //have we visited vertex already?
	private List<Vertex> adjacenciesList; //list of graph neighbors of a vertex/where directed edges point
	
	public Vertex(int data) {
		this.data = data;
		this.adjacenciesList = new ArrayList<>();
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public List<Vertex> getAdjaceniesList() {
		return adjacenciesList;
	}

	public void setNeighborList(List<Vertex> adjacenciesList) {
		this.adjacenciesList = adjacenciesList;
	}
	
	public void addAdjacenciesVertex(Vertex vertex) {
		this.adjacenciesList.add(vertex);
	}
	
	@Override
	public String toString() {
		return ""+this.data;
	}
}
