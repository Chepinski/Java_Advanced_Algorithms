package MaxFlow;

//import java.util.ArrayList;
import java.util.LinkedList;
//import java.util.List;
import java.util.Queue;

public class FordFulkerson {
	
	private boolean[] marked; //marked[v] = true, there is a path from source to sink in residual graph
	private Edge[] edgeTo; //edgeTo[v] = edges in the augmenting path
	private double valueMaxFlow;
	
	public FordFulkerson(FlowNetwork flowNetwork, Vertex s, Vertex t) {
		
		while(hasAugmentingPath(flowNetwork, s, t)) {//while there is an augmenting path
			double minValue = Double.POSITIVE_INFINITY;
			
			for(Vertex v=t;v!= s; v= edgeTo[v.getId()].getOther(v)) {//v = vertex on augmenting path
				minValue = Math.min(minValue, edgeTo[v.getId()].getResidualCapacity(v));//minValue of edges going to sink
			}
			
			for(Vertex v = t; v!=s; v=edgeTo[v.getId()].getOther(v)) {//add flows into flow network along augmenting path
				edgeTo[v.getId()].addResidualFlowTo(v, minValue);
			}
			
			valueMaxFlow = valueMaxFlow + minValue;//add the min flow to the min flows from other augmenting paths to obtain max flow
		}
	}
	
	public boolean isInCut(int index) {
		return marked[index];
	}
	
	public double getMaxFlow() {
		return this.valueMaxFlow;
	}

	private boolean hasAugmentingPath(FlowNetwork flowNetwork, Vertex s, Vertex t) {
		/**
		 * this function will eventually return false because any augmenting paths
		 * will be blocked by 0 capacity paths which in turn won't add the sink
		 * to the visited queue
		 */
		edgeTo = new Edge[flowNetwork.getNumOfVertices()];
		marked = new boolean[flowNetwork.getNumOfVertices()];
		
		Queue<Vertex> queue = new LinkedList<>();
		queue.add(s);//add start vertex to queue
		marked[s.getId()] = true;//mark start vertex as visited
		
		while(!queue.isEmpty() && !marked[t.getId()]){//loop while the there are still vertices in the queue and the sink hasn't been reached
			Vertex v = queue.remove();
			
			for(Edge e : flowNetwork.getAdjacenciesList(v)) {//traverse each edge from vertex
				Vertex w = e.getOther(v);
				
				if(e.getResidualCapacity(w) > 0) {//if there is still capacity left
					if(!marked[w.getId()]) {//and the vertex is not yet marked as visited
						edgeTo[w.getId()] = e;//the edge to this vertex is e
						marked[w.getId()]=true;//mark the edge as visited
						queue.add(w);//add the vertex to the queue
					}
				}
			}
		}
		return marked[t.getId()];//if the sink i
	}
}
