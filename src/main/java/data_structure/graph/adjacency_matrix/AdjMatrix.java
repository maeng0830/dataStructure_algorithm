package data_structure.graph.adjacency_matrix;

public class AdjMatrix {

	private int[][] adjMatrix;

	public AdjMatrix(int size) {
		adjMatrix = new int[size + 1][size + 1]; // vertex의 인덱스를 1부터 시작하기 위함.
	}

	// 무향 간선 - 가중치 X
	public void insertBiDir(int vertex1, int vertex2) {
		adjMatrix[vertex1][vertex2] = 1;
		adjMatrix[vertex2][vertex1] = 1;
	}

	// 무향 간선 - 가중치 O
	public void insertBiDir(int vertex1, int vertex2, int weight) {
		adjMatrix[vertex1][vertex2] = weight;
		adjMatrix[vertex2][vertex1] = weight;
	}

	// 방향 간선 - 가중치 X
	public void insertSingleDir(int vertex1, int vertex2) {
		adjMatrix[vertex1][vertex2] = 1;
	}

	// 방향 간선 - 가중치 O
	public void insertSingleDir(int vertex1, int vertex2, int weight) {
		adjMatrix[vertex1][vertex2] = weight;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i < adjMatrix.length; i++) {
			for (int j = 1; j < adjMatrix[i].length; j++) {
				sb.append(adjMatrix[i][j]).append(" ");
			}
			sb.append("\n");
		}

		return sb.toString();
	}
}
