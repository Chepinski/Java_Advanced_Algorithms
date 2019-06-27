package MaxFlow;

import java.util.ArrayList;
import java.util.List;

public class BipartiteApp {

	public static void main(String[] args) {
		int N = 5;
		
		FlowNetwork flowNetwork = new FlowNetwork(2*N+2);
		List<Vertex> vertexList = new ArrayList<>();
		//1st set "people"
		vertexList.add(new Vertex(0,"s"));//source
		vertexList.add(new Vertex(1,"A"));
		vertexList.add(new Vertex(2,"B"));
		vertexList.add(new Vertex(3,"C"));
		vertexList.add(new Vertex(4,"D"));
		vertexList.add(new Vertex(5,"E"));
		//2nd set "jobs"
		vertexList.add(new Vertex(6,"1"));
		vertexList.add(new Vertex(7,"2"));
		vertexList.add(new Vertex(8,"3"));
		vertexList.add(new Vertex(9,"4"));
		vertexList.add(new Vertex(10,"5"));
		vertexList.add(new Vertex(11,"t"));//sink
		
		for(int i=0;i<N;i++) {
			flowNetwork.addEdge((new Edge(vertexList.get(0),vertexList.get(i+1),1)));//add edges from source to "people" vertices
			flowNetwork.addEdge((new Edge(vertexList.get(i+1+N),vertexList.get(11),1)));//add edges from "jobs" vertices to sink
			//set all edges from source and to sink with capacity 1
		}
		//set the edges between the sets and give capacity 1
		flowNetwork.addEdge((new Edge(vertexList.get(1),vertexList.get(6),1)));
		flowNetwork.addEdge((new Edge(vertexList.get(2),vertexList.get(6),1)));
		flowNetwork.addEdge((new Edge(vertexList.get(1),vertexList.get(7),1)));
		flowNetwork.addEdge((new Edge(vertexList.get(3),vertexList.get(7),1)));
		flowNetwork.addEdge((new Edge(vertexList.get(3),vertexList.get(8),1)));
		flowNetwork.addEdge((new Edge(vertexList.get(5),vertexList.get(8),1)));
		flowNetwork.addEdge((new Edge(vertexList.get(1),vertexList.get(9),1)));
		flowNetwork.addEdge((new Edge(vertexList.get(4),vertexList.get(9),1)));
		flowNetwork.addEdge((new Edge(vertexList.get(4),vertexList.get(10),1)));
		
		FordFulkerson fordFulkerson = new FordFulkerson(flowNetwork, vertexList.get(0), vertexList.get(11));
		System.out.println(" Max number of pairs: " + fordFulkerson.getMaxFlow());//ans: 5, perfect match.  all people get jobs
	}

}
