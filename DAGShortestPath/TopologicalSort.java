package DAGShortestPath;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {
	
	private Stack<Vertex> stack;//needed for topological ordering
	
	public TopologicalSort() {
		this.stack = new Stack<>();
	}
	
	public void makeTopologicalOrder(List<Vertex> vertexList) {
		//perform depth first search on any unvisited vertex
		for(Vertex vertex : vertexList) {
			if( !vertex.isVisited() ) {
				dfs(vertex);
			}
		}
	}
	
	private void dfs(Vertex vertex) {
		//travel down vertexes until all have been visited
		for(Edge edge : vertex.getAdjacenciesList() ) {
			if( !edge.getTargetVertex().isVisited() ) {
				edge.getTargetVertex().setVisited(true);
				dfs(edge.getTargetVertex());
			}
		}
		//push vertex on the stack after all it's adjacencies have been visited
		this.stack.push(vertex);
	}
	
	public Stack<Vertex> getTopologicalOrder(){
		Collections.reverse(stack);;
		return this.stack;
	}

}
