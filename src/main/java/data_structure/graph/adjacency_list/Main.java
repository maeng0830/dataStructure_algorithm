package data_structure.graph.adjacency_list;

public class Main {

	public static void main(String[] args) {
		AdjList<Integer> graph = new AdjList<>();

		for (int i = 1; i <= 5; i++) {
			graph.addVertex(i);
		}

		graph.addEdge(0, 2, 2);
		graph.addEdge(0, 3, 4);
		graph.addEdge(1, 4);
		graph.addEdge(3, 4, 6);

		System.out.print(graph.toString());
		/*adjVertices to 0: 2(2) 3(4)
		  adjVertices to 1: 4(1)
		  adjVertices to 2:
		  adjVertices to 3: 4(6)
		  adjVertices to 4:*/
	}
}
