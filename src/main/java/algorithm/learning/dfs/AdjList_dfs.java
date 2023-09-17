package algorithm.learning.dfs;

import data_structure.graph.adjacency_list.Edge;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class AdjList_dfs<T> {
	private int size;
	private List<List<Edge>> adjList = new ArrayList<>(); // 정점들의 목록
	private List<T> dataList = new ArrayList<>(); // 정점들의 데이터를 저장한다.

	// 정점 추가
	public void addVertex(T data) {
		// 인덱스를 1부터 시작하기 위해 첫 번쨰 정점 추가 전에 의미없는 정점을 추가.
		if (size == 0) {
			adjList.add(new ArrayList<>());
			dataList.add(null);
			size++;
		}

		adjList.add(new ArrayList<>()); // 정점들의 목록을 추가한다.
		dataList.add(data); // 정점들의 데이터를 저장한다. 동일한 정점에 대한 adjList와 dataList의 인덱스는 동일하다.
		size++; // 정점 개수 증가
	}

	public void dfs(int index) {
		if (valid(index)) {
			return;
		}

		boolean[] visited = new boolean[size];
		dfsUtil(index, visited);
	}

	private void dfsUtil(int index, boolean[] visited) {
		// 현재 노드를 방문한 것으로 체크
		visited[index] = true;

		System.out.print(index + " ");

		ListIterator<Edge> listIterator = adjList.get(index).listIterator();

		while (listIterator.hasNext()) {
			int cur = listIterator.next().getDestination();

			if (!visited[cur]) {
				dfsUtil(cur, visited);
			}
		}
	}

	// 간선을 추가한다 - 가중치 지정 O
	public void addEdge(int source, int destination, int weight) {
		if (valid(source) || valid(destination)) {
			return;
		}

		adjList.get(source).add(new Edge(destination, weight));
	}

	// 간선을 추가한다 - 가중치 지정 X
	public void addEdge(int source, int destination) {
		if (valid(source) || valid(destination)) {
			return;
		}

		adjList.get(source).add(new Edge(destination));
	}

	// 주어진 인덱스에 해당하는 정점에서 출발하는 간선 정보를 반환한다.
	public List<Edge> getAdjVertices(int index) {
		return adjList.get(index);
	}

	// 주어진 인덱스에 해당하는 정점의 데이터를 반환한다.
	public T getData(int index) {
		return dataList.get(index);
	}

	private boolean valid(int index) {
		if (size <= 1) {
			System.out.println("정점이 없습니다.");
			return true;
		}

		if (index < 1 || index >= size) {
			System.out.println("유효한 정점 인덱스가 아닙니다.");
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < adjList.size(); i++) {
			sb.append("adjVertices to " + i + ": ");
			List<Edge> adjVertices = getAdjVertices(i);

			for (Edge adjVertex : adjVertices) {
				sb.append(adjVertex.getDestination() + "(" + adjVertex.getWeight() + ")" + " ");
			}

			sb.append("\n");
		}

		return sb.toString();
	}
}
