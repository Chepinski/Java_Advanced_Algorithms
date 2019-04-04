package BellmanFordAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BellmanFord {

	private List<Edge> edgeList;
	private List<Vertex> vertexList;

	public BellmanFord(List<Edge> edgeList, List<Vertex> vertexList) {
		this.edgeList = edgeList;
		this.vertexList = vertexList;
	}

	public void bellmanFord(Vertex sourceVertex) {// v-1 iterations --> we relax all the edges (find shorter path to reach v from u)
		//initially all vertex distances are set to MAX_VALUE except the source vertex
		sourceVertex.setDistance(0);
		for (int i = 0; i < vertexList.size() - 1; ++i) {
			for (Edge edge : edgeList) {

				Vertex u = edge.getStartVertex();
				Vertex v = edge.getTargetVertex();

				if (u.getDistance() == Double.MAX_VALUE)
					continue;// continue keyword forces jump to next iteration of loop

				double newDistance = u.getDistance() + edge.getWeight();

				if (newDistance < v.getDistance()) {
					v.setDistance(newDistance);
					v.setPredecessor(u);
				}
			}
		}

		for (Edge edge : edgeList) {// vth iteration
			if (edge.getStartVertex().getDistance() != Double.MAX_VALUE) {
				if (hasCycle(edge)) {
					System.out.println("This has a negative cycle");
					return;
				}
			}
		}
	}

	private boolean hasCycle(Edge edge) {
		
		return edge.getStartVertex().getDistance() + edge.getWeight() < edge.getTargetVertex().getDistance();
		/**
		 * if the startVertex distance + outgoing edgeweight is less than the target vertex's distance
		 * then there is a cycle (negative weight going to target vertex)
		 * 
		 * 				a
		 * 			-10/_\2
		 * 			  c	3 b
		 * 
		 * here c->a is negative so a-b-c is a 'negative cycle'(weighted directed graph where total
		 * weight is negative (2+3-10 = -5)
		 */
	}

	public void shortestPathTo(Vertex targetVertex) {

		List<Vertex> shortestPathToTarget = new ArrayList<>();

		if (targetVertex.getDistance() != Double.MAX_VALUE) {
			System.out.println("Shortest path found with cost: " + targetVertex.getDistance());

			Vertex actualVertex = targetVertex;
			shortestPathToTarget.add(actualVertex);

			while (actualVertex.getPredecessor() != null) {
				actualVertex = actualVertex.getPredecessor();
				shortestPathToTarget.add(actualVertex);
			}

			Collections.reverse(shortestPathToTarget);
			for (int i = 0; i < shortestPathToTarget.size(); i++) {
				System.out.print(shortestPathToTarget.get(i) + " - ");
			}

		} else {

			System.out.println("No such path exists...");
		}
	}
}
