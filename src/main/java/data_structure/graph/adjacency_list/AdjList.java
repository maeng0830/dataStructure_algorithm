package data_structure.graph.adjacency_list;

import java.util.ArrayList;
import java.util.List;

public class AdjList<T> {
	private int size; // 정점들의 개수
	private List<List<Edge>> adjList = new ArrayList<>(); // 정점들의 목록
	private List<T> dataList = new ArrayList<>(); // 정점들의 데이터를 저장한다.

	// 정점 추가
	public void addVertex(T data) {
		adjList.add(new ArrayList<>()); // 정점들의 목록을 추가한다.
		dataList.add(data); // 정점들의 데이터를 저장한다. 동일한 정점에 대한 adjList와 dataList의 인덱스는 동일하다.
		size++; // 정점 개수 증가
	}

	// 간선을 추가한다 - 가중치 지정
	public void addEdge(int source, int destination, int weight) {
		adjList.get(source).add(new Edge(destination, weight));
	}

	// 간선을 추가한다 - 가중치 지정
	public void addEdge(int source, int destination) {
		adjList.get(source).add(new Edge(destination));
	}

	// 주어진 인덱스에 해당하는 정점의 인접 정점을 반환한다.
	public List<Edge> getAdjVertices(int index) {
		return adjList.get(index);
	}

	// 주어진 인덱스에 해당하는 정점의 데이터를 반환한다.
	public T getData(int index) {
		return dataList.get(index);
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
