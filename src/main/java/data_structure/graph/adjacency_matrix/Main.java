package data_structure.graph.adjacency_matrix;

public class Main {

	public static void main(String[] args) {
		AdjMatrix adjMatrix = new AdjMatrix(5);

		adjMatrix.insertSingleDir(1, 3, 2);
		adjMatrix.insertSingleDir(3, 2, 3);
		adjMatrix.insertBiDir(4, 5, 4);

		System.out.print(adjMatrix.toString());
		/*0 0 2 0 0
		  0 0 0 0 0
		  0 3 0 0 0
		  0 0 0 0 4
		  0 0 0 4 0*/
	}
}
