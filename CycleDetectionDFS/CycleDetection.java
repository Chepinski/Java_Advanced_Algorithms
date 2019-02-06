package CycleDetectionDFS;

import java.util.List;

public class CycleDetection {
	
	public void detectCycle(List<Vertex> vertexList) {
		for (Vertex v : vertexList) {
			if( !v.isVisited() ) {
				dfs(v);
			}
		}
	}
	
	private void dfs(Vertex vertex) {
		
		System.out.println("DFS vertex "+vertex);
		vertex.setBeingVisited(true);
		
		for(Vertex v : vertex.getAdjacenciesList() ) {
			
			if( v.isBeingVisited() ) {
				System.out.println("There's a cycle here, bro!");
				return;
			}
			
			if( !v.isVisited() ) {
				v.setVisited(true);
				dfs(v);
			}
		}
		
		vertex.setBeingVisited(false);
		vertex.setVisited(true);
	}

}
