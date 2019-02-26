package DAGShortestPath;

import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {
		
		
		Vertex vertex0 = new Vertex("A");
		Vertex vertex1 = new Vertex("B");
		Vertex vertex2 = new Vertex("C");
		
		List<Vertex> vertexList = new ArrayList<>();
		
		vertexList.add(vertex0);
		vertexList.add(vertex1);
		vertexList.add(vertex2);
		
		vertex0.AddNeighbor(new Edge(1, vertex0, vertex1));
		vertex0.AddNeighbor(new Edge(1, vertex0, vertex2));
		vertex1.AddNeighbor(new Edge(1, vertex1, vertex2));
		
		/**
		 * 			A
		 * 		  1/_\1
		 *        B 1 C
		 *        
		 *        DAG is the fastest shortest path O(E+V)
		 */
		
		AcyclicShortestPath acyclicShortestPath = new AcyclicShortestPath();
		acyclicShortestPath.shortestPath(vertexList, vertex0, vertex2);
		//Lieber Gott warum hab i es so gennant?
		acyclicShortestPath.showShortestPathTo(vertex2);

	}

}
