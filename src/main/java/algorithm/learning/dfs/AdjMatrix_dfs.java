package algorithm.learning.dfs;

public class AdjMatrix_dfs {

	private int[][] adjMatrix;

	public AdjMatrix_dfs(int size) {
		if (size <= 0) {
			System.out.println("그래프는 정점이 1개 이상이어야 합니다.");
			return;
		}

		adjMatrix = new int[size + 1][size + 1]; // vertex의 인덱스를 1부터 시작하기 위함.
	}

	// 무향 간선 - 가중치 X
	public void insertBiDir(int vertex1, int vertex2) {
		if (valid(vertex1, vertex2)) {
			return;
		}

		adjMatrix[vertex1][vertex2] = 1;
		adjMatrix[vertex2][vertex1] = 1;
	}

	// 무향 간선 - 가중치 O
	public void insertBiDir(int vertex1, int vertex2, int weight) {
		if (valid(vertex1, vertex2)) {
			return;
		}

		adjMatrix[vertex1][vertex2] = weight;
		adjMatrix[vertex2][vertex1] = weight;
	}

	// 방향 간선 - 가중치 X
	public void insertSingleDir(int vertex1, int vertex2) {
		if (valid(vertex1, vertex2)) {
			return;
		}

		adjMatrix[vertex1][vertex2] = 1;
	}

	// 방향 간선 - 가중치 O
	public void insertSingleDir(int vertex1, int vertex2, int weight) {
		if (valid(vertex1, vertex2)) {
			return;
		}

		adjMatrix[vertex1][vertex2] = weight;
	}

	public void dfs(int index) {
		if (valid(index, index)) {
			return;
		}

		// 방문 여부 체크를 위한 배열
		boolean[] visited = new boolean[adjMatrix.length];
		// index는 탐색의 시작 정점이다.
		dfsUtil(index, visited);
	}

	private void dfsUtil(int index, boolean[] visited) {
		// 현재 정점을 방문한 경우 방문 여부를 체크한다.
		visited[index] = true;

		System.out.print(index + " ");

		int[] matrix = adjMatrix[index];

		// 정점을 순회하면서 현재 정점의 인접 정점을 확인한다.
		for (int i = 1; i < matrix.length; i++) {
			// 현재 정점의 인접 정점이면서 현재 방문하지 않은 상태인 경우 방문한다.
			if (matrix[i] != 0 && !visited[i]) {
				dfsUtil(i, visited);
			}
		}
	}

	private boolean valid(int vertex1, int vertex2) {
		if (adjMatrix.length <= 1) {
			return true;
		}

		if (vertex1 < 1 || vertex1 >= adjMatrix.length || vertex2 < 1 || vertex2 >= adjMatrix.length) {
			return true;
		}

		return false;
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
