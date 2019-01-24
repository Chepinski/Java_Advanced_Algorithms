package DepthFirstSearch;

import java.util.List;
import java.util.Stack;

public class DFS {//LIFO structure
	
	private Stack<Vertex> stack;
	
	public DFS() {
		this.stack = new Stack<>();
	}
	
	public void dfs(List<Vertex> vertexList) {
		
		for(Vertex v : vertexList) {
			//if we have several clusters that we need to visit each vertex
			//not needed if we are traversing just one cluster
			if( !v.isVisited() ) {
				v.setVisited(true);
				dfsRecursive(v);
			}
		}
	}
	
	private void dfsRecursive (Vertex v) {
		System.out.print(v+" ");
		
		for(Vertex vertex : v.getAdjacenciesList()) {
			if( !vertex.isVisited() ) {
				vertex.setVisited(true);
				dfsRecursive(vertex);
			}
		}
	}

	private void dfsWithStack(Vertex rootVertex) {
		
		this.stack.add(rootVertex);
		rootVertex.setVisited(true);
		
		while ( !stack.isEmpty() ) {
			
			Vertex currentVertex = this.stack.pop();
			System.out.print(currentVertex +" ");
			
			for(Vertex v : currentVertex.getAdjacenciesList() ) {
				if( !v.isVisited() ) {
					v.setVisited(true);
					this.stack.push(v);
				}
			}
		}
	}

}
