package Prim;

import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {
		List<Vertex> vertexList = new ArrayList<>();
		
		Vertex vertex0 = new Vertex("A");
		Vertex vertex1 = new Vertex("B");
		Vertex vertex2 = new Vertex("C");
		
		vertexList.add(vertex0);
		vertexList.add(vertex1);
		vertexList.add(vertex2);

		//to use undirected edges we must duplicate
		//the edge forwards and backwards
		//so from 0->1 (edge weight:1) & 1->0 (edge weight:1)
		vertex0.addEdge(new Edge(vertex0, vertex1, 1));
		vertex0.addEdge(new Edge(vertex0, vertex2, 1));
		vertex0.addEdge(new Edge(vertex1, vertex2, 10));
		/***vertex with edgeweights
		 * A---(1)---B
		 *  \      /
		 *  (1)  (10)
		 *    \  /
		 *      C
		 */
		
		vertex1.addEdge(new Edge(vertex1, vertex0, 1));
		vertex2.addEdge(new Edge(vertex2, vertex0, 1));
		vertex2.addEdge(new Edge(vertex2, vertex1, 10));
		
		PrimsAlgorithm algorithm = new PrimsAlgorithm(vertexList);
		
		algorithm.PrimsAlgorithm(vertex2);
		algorithm.showMST();
	}
	
	/**min spanning tree solution
	 * 
	 * A--(1)--B
	 *  \
	 *  (1)
	 *    \
	 *     C
	 */

}
