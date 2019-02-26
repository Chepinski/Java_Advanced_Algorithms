package DAGShortestPath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class AcyclicShortestPath {

	public void shortestPath(List<Vertex> vertexList, Vertex sourceVertex, Vertex targetVertex) {

		sourceVertex.setDistance(0);// as usual we're setting the distance for the source vertex to 0
		TopologicalSort topologicalSort = new TopologicalSort();
		topologicalSort.makeTopologicalOrder(vertexList);

		Stack<Vertex> stack = topologicalSort.getTopologicalOrder();

		for (Vertex actualVertex : stack) {

			for (Edge edge : actualVertex.getAdjacenciesList()) {

				Vertex u = edge.getStartVertex();
				Vertex v = edge.getTargetVertex();

				double newDistance = u.getDistance() + edge.getWeight();

				if (newDistance < v.getDistance()) {
					v.setDistance(newDistance);
					v.setPredecessor(u);
				}
			}
		}

		if (targetVertex.getDistance() == Double.MAX_VALUE) {
			System.out.println("Can't find shortest path here");
		} else {
			System.out.println("Shortest path = " + targetVertex.getDistance());
		}
	}

	public void showShortestPathTo(Vertex targetVertex) {

		List<Vertex> list = new ArrayList<>();

		Vertex actualVertex = targetVertex;
		list.add(actualVertex);

		while (actualVertex.getPredecessor() != null) {
			actualVertex = actualVertex.getPredecessor();
			list.add(actualVertex);
		}

		Collections.reverse(list);
		System.out.println(list);

	}

}
