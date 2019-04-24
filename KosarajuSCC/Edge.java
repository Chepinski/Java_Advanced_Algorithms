package KosarajuSCC;

public class Edge {
	
	private double weight;
	private Vertex startvertex;
	private Vertex targetVertex;
	
	public Edge(double weight, Vertex startvertex, Vertex targetVertex) {
		this.weight = weight;
		this.startvertex = startvertex;
		this.targetVertex = targetVertex;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Vertex getStartvertex() {
		return startvertex;
	}

	public void setStartvertex(Vertex startvertex) {
		this.startvertex = startvertex;
	}

	public Vertex getTargetVertex() {
		return targetVertex;
	}

	public void setTargetVertex(Vertex targetVertex) {
		this.targetVertex = targetVertex;
	}
	
	

}
