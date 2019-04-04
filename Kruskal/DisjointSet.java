package Kruskal;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {
	private int nodeCount = 0;
	private int setCount = 0;
	private List<Node> rootNodes;

	public DisjointSet(List<Vertex> vertices) {
		this.rootNodes = new ArrayList<>(vertices.size());
		makeSets(vertices);
	}
	
	public int find(Node n) {
		Node currentNode = n;
		
		while(currentNode.getParent() != null) {
			currentNode = currentNode.getParent();
		}
		
		Node rootNode = currentNode;
		
		currentNode = n;
		while(currentNode != rootNode) {
			Node temp = currentNode.getParent();
			currentNode.setParent(rootNode);
			currentNode = temp;
		}
		
		return rootNode.getId();
	}
	
	public void union(Node node1, Node node2) {
		//merge disjoint sets
		int index1 = find(node1);//find root
		int index2 = find(node2);//find root
		
		if(index1 == index2) {
			return;//indexes are in the same set
		}
		
		Node root1 = this.rootNodes.get(index1);
		Node root2 = this.rootNodes.get(index2);
		
		if(root1.getRank() < root2.getRank()) {
			root1.setParent(root2);//root2 has larger rank, make root1 child
		}else if(root1.getRank() > root2.getRank()) {
			root2.setParent(root1);//root1 has larger rank, make root2 child
		}else {//roots are equal rank, make root2 child of root1(arbitary) and increase root1's rank
			root2.setParent(root1);
			root1.setRank(root1.getRank()+1);
		}
		
		this.setCount--;//merged sets so number of sets decrease
	}

	private void makeSets(List<Vertex> vertices) {
		for (Vertex v : vertices) {
			makeSet(v);
		}

	}

	private void makeSet(Vertex vertex) {
		//assign disjoint set to every node in graph
		Node n = new Node(rootNodes.size(), 0, null);
		vertex.setNode(n);
		this.rootNodes.add(n);
		this.setCount++;
		this.nodeCount++;
	}

}
