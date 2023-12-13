package algorithm.learning.shortest_path_algorithm.dijkstra;

import data_structure.list.arraylist.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 다익스트라 알고리즘은 그래프의 한 노드에서 다른 모든 노드까지의 최단 거리를 구하는 알고리즘이다.
 * 	음의 가중치를 가진 간선이 없어야 한다.
 * 	초기 모델은 O(V^2)의 시간 복잡도를 가졌으며, 우선순위 큐를 이용하면 O(Elog V)의 시간 복잡도로 개선할 수 있다.
 *
 * 다익스트라 알고리즘은 그리디 알고리즘과 다이나믹 프로그래밍 기법을 사용한 알고리즘이다. 아래의 두 단계를 반복하여 최단 거리를 구하기 떄문이다.
 *   1. 방문하지 않은 정점 중 가장 비용이 적은 정점을 선택한다. <- 그리디
 *   2. 정점들을 방문하면서 출발지로부터의 최단 거리를 갱신한다. <- 다이나믹 프로그래밍
 *
 * input
 * 5 6
 * 1
 * 5 1 1
 * 1 2 2
 * 1 3 3
 * 2 3 4
 * 2 4 5
 * 3 4 6
 *
 * output
 * 0 2 3 7 INF
 */
public class Dijkstra1 {

	static int v, e, start;
	static ArrayList<ArrayList<Node>> graph;

	static class Node implements Comparable<Node> {
		int to; // 다음 노드 인덱스
		int cost; // 비용

		public Node(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
	}

	public static void dijkstra() {
		// 최소 비용을 저장할 dp용 메모리 초기화
		int[] dist = new int[v + 1];

		for (int i = 0; i < dist.length; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[start] = 0;

		// dp용 메모리 업데이트
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.offer(new Node(start, 0));

		while (!queue.isEmpty()) {
			Node curNode = queue.poll();

			// 만약 목표 정점까지의 최단 거리만 구하는 경우라면, 아래의 주석 코드를 통해 반복문을 종료할 수 있다.
//			if (curNode.to == end) {
//				break;
//			}

			if (dist[curNode.to] < curNode.cost) {
				continue;
			}

			for (int i = 0; i < graph.get(curNode.to).size(); i++) {
				Node adjNode = graph.get(curNode.to).get(i);

				if (dist[adjNode.to] > curNode.cost + adjNode.cost) {
					dist[adjNode.to] = curNode.cost + adjNode.cost;
					queue.offer(new Node(adjNode.to, dist[adjNode.to]));
				}
			}
		}

		// 결과 출력
		for (int i = 1; i < v + 1; i++) {
			if (dist[i] == Integer.MAX_VALUE) {
				System.out.print("INF ");
			} else {
				System.out.print(dist[i] + " ");
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 정점, 간선 수 입력
		st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());

		// 시작 노드
		start = Integer.parseInt(br.readLine());

		// 그래프 초기화(인덱스 1부터 시작, 유향 그래프)
		graph = new ArrayList<>();

		for (int i = 0; i < v + 1; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()); // 출발 정점
			int d = Integer.parseInt(st.nextToken()); // 도착 정점
			int c = Integer.parseInt(st.nextToken()); // 비용

			graph.get(s).add(new Node(d, c));
		}

		dijkstra();
	}
}
