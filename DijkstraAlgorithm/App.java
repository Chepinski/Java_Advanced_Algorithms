package DijkstraAlgorithm;

public class App {

	public static void main(String[] args) {

		Vertex vertex0 = new Vertex("A");
		Vertex vertex1 = new Vertex("B");
		Vertex vertex2 = new Vertex("C");
		Vertex vertex3 = new Vertex("D");
		Vertex vertex4 = new Vertex("E");

		/***           A
		 *       5/  |6  \7
		 *       B   C    D
		 *       9\  |1   /7
		 *           E
		 */

		vertex0.addNeighbor(new Edge(5, vertex0, vertex1));
		vertex0.addNeighbor(new Edge(6, vertex0, vertex2));
		vertex0.addNeighbor(new Edge(7, vertex0, vertex3));
		vertex1.addNeighbor(new Edge(9, vertex1, vertex4));
		vertex2.addNeighbor(new Edge(1, vertex2, vertex4));
		vertex3.addNeighbor(new Edge(7, vertex3, vertex4));
		
		DijkstraAlgorithm algorithm = new DijkstraAlgorithm();
		algorithm.computePath(vertex0);

		System.out.println(algorithm.getShortestPathTo(vertex4));

	}
}
