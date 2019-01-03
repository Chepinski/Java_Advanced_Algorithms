package BreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;//gives FIFO structure for BFS

public class BFS {

	public void bfs(Vertex root) {
		
		Queue<Vertex> queue = new LinkedList<>();
		
		root.setVisited(true);
		queue.add(root);
		
		while( !queue.isEmpty() ) {
			
			Vertex currentVertex = queue.remove();
			System.out.println(currentVertex+" ");
			
			for(Vertex v : currentVertex.getAdjaceniesList()) {
				if( !v.isVisited() ) {
					v.setVisited(true);
					queue.add(v);
				}
			}
		}
	}
}
