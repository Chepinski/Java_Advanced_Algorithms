package DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {
		Vertex va = new Vertex("a");
		Vertex vb = new Vertex("b");
		Vertex vc = new Vertex("c");
		Vertex vd = new Vertex("d");
		Vertex ve = new Vertex("e");

		List<Vertex> list = new ArrayList<>();

		/**add edges to cluster
		 *          a
		 *         /\
		 *        b  c
		 *            \
		 *             d
		 *              \
		 *               e
		 */
		va.addAdjacency(vb);
		va.addAdjacency(vc);
		vc.addAdjacency(vd);
		vd.addAdjacency(ve);
		
		list.add(va);
		list.add(vb);
		list.add(vc);
		list.add(vd);
		list.add(ve);
		
		DFS dfs = new DFS();
		dfs.dfs(list);
	}
}
/**result: a c d e b
//'b' is at the end and correct as a result of the LIFO/stack.  it was added 
to the root vertex before the 'c'
*/