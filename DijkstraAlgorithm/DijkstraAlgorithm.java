package DijkstraAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {

	public void computePath(Vertex sourceVertex) {

		sourceVertex.setDistance(0);
		PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
		priorityQueue.add(sourceVertex);
		
		//cycles through entire priority queue
		while (!priorityQueue.isEmpty()) {
			// removes head of queue/min distance
			Vertex actualVertex = priorityQueue.poll();
			System.out.println("actualVertex: "+actualVertex.getName());
			
			//loop through edges coming from the current vertex
			for (Edge edge : actualVertex.getAdjacenciesList()) {
				//get the vertex that this edge points to
				Vertex v = edge.getTargetVertex();
				//newDistance is the distance of the current vertex plus 
				//the weight of the current edge (in for loop)
				double newDistance = actualVertex.getDistance() + edge.getWeight();
				System.out.println("edgeweight: "+edge.getWeight());
				
				//if distance from source vertex + edge weight pointing to new vertex 
				//is less than the distance of the current vertex
				//set the distance of this vertex to newDistance
				//*if vertex hasn't been visited, vertex distance was infinite*/
				if (newDistance < v.getDistance()) {
					priorityQueue.remove(v);
					v.setDistance(newDistance);
					System.out.println(v.getName()+" distance: "+v.getDistance());
					v.setPredecessor(actualVertex);
					priorityQueue.add(v);
				}
			}
		}
	}
	
	public List<Vertex> getShortestPathTo(Vertex targetVertex) {

		List<Vertex> shortestPathToTarget = new ArrayList<>();

		for (Vertex vertex = targetVertex; vertex != null; vertex = vertex.getPredecessor()) {

			shortestPathToTarget.add(vertex);
		}

		Collections.reverse(shortestPathToTarget);

		return shortestPathToTarget;

	}
}
