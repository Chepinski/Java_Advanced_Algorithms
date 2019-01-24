package TopologicalOrdering;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class App {

	public static void main(String[] args) {

		TopologicalOrdering topologicalOrdering = new TopologicalOrdering();

		List<Vertex> graph = new ArrayList<>();

		graph.add(new Vertex("a"));
		graph.add(new Vertex("b"));
		graph.add(new Vertex("c"));
		graph.add(new Vertex("d"));
		graph.add(new Vertex("e"));
		graph.add(new Vertex("f"));

		graph.get(2).addAdjacency(graph.get(3));

		graph.get(3).addAdjacency(graph.get(1));

		graph.get(4).addAdjacency(graph.get(0));
		graph.get(4).addAdjacency(graph.get(1));

		graph.get(5).addAdjacency(graph.get(0));
		graph.get(5).addAdjacency(graph.get(2));

		for (int i = 0; i < graph.size(); ++i) {
			if (!graph.get(i).isVisited()) {
				topologicalOrdering.dfs(graph.get(i));
			}

		}
		
		Stack<Vertex> stack = topologicalOrdering.getStack();

		for (int i = 0; i < graph.size(); ++i) {
			Vertex vertex = stack.pop();
			System.out.println(vertex + " -> ");
		}
	}
}

/**
 * the graph created/directed acyclic graph
 * 
 * 1<--3<--2<--5
 * ^           |
 * |           v
 * 4---------->0
 *
 *
 *topological order = 5-4-2-3-1-0
 **/
