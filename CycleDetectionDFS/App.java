package CycleDetectionDFS;

import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {
		Vertex vertex1 = new Vertex("a");
		Vertex vertex2 = new Vertex("b");
		Vertex vertex3 = new Vertex("c");
		Vertex vertex4 = new Vertex("d");
		Vertex vertex5 = new Vertex("e");
		Vertex vertex6 = new Vertex("f");
		
		
		//cycle 456
		vertex1.addNeighbor(vertex2);
		vertex1.addNeighbor(vertex3);
		vertex2.addNeighbor(vertex3);
		vertex4.addNeighbor(vertex1);
		vertex4.addNeighbor(vertex5);
		vertex5.addNeighbor(vertex6);
		vertex6.addNeighbor(vertex4);
		
		List<Vertex> vertexList = new ArrayList<> ();
		vertexList.add(vertex1);
		vertexList.add(vertex2);
		vertexList.add(vertex3);
		vertexList.add(vertex4);
		vertexList.add(vertex5);
		vertexList.add(vertex6);
		
		CycleDetection cycleDetection = new CycleDetection();
		cycleDetection.detectCycle(vertexList);
	}
}

/**
 *                   cycle
 *    1<-----------4----->5
 *   /  \           ^    /
 *  v    v           \  v
 *  3<---2             6
 */
