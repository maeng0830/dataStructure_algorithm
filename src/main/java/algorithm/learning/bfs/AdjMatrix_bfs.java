package algorithm.learning.bfs;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;

public class AdjMatrix_bfs {

	private int[][] adjMatrix;

	public AdjMatrix_bfs(int size) {
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

	public void bfs(int index) {
		if (valid(index, index)) {
			return;
		}

		// 방문 여부 체크를 위한 배열
		boolean[] visited = new boolean[adjMatrix.length];
		Queue<Integer> queue = new LinkedList<>();

		visited[index] = true;
		queue.add(index);

		while (queue.size() != 0) {
			// 방문한 정점을 큐에서 추출
			index = queue.poll();
			System.out.print(index + " ");

			// 모든 정점 중 방문한 정점과 인접한 정점을 확인한다.
			int[] matrix = adjMatrix[index];
			for (int i = 1; i < matrix.length; i++) {
				// 인접 정점 중 아직 방문하지 않은 정점이면 방문한 것으로 표시하고 큐에 삽입
				if (matrix[i] != 0 && !visited[i]) {
					visited[i] = true;
					queue.add(i);
				}
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
