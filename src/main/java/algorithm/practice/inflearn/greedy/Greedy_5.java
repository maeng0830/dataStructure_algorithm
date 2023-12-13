package algorithm.practice.inflearn.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 다익스트라 알고리즘은 음의 가중치가 없는 그래프의 한 정점에서 다른 모든 정점으로 가는 최단 경로를 구한다.
 * 1번 정점에서 다른 모든 정점으로 가는 최단 경로를 구하라.
 *
 * input
 * 5 6
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
public class Greedy_5 {

	static int v;
	static int e;
	static ArrayList<ArrayList<Edge>> graph;

	static class Edge implements Comparable<Edge> {
		int to;
		int cost;

		public Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}

	public static void dijkstra() {
		// dp 메모리 초기화
		int[] dist = new int[v + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		// 출발 정점 설정
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(1, 0));
		dist[1] = 0;

		// dp 메모리 갱신
		while (!pq.isEmpty()) {
			Edge cur = pq.poll(); // 현재 정점 인덱스, 출발 정점부터 현재 정점까지의 비용

			if (dist[cur.to] < cur.cost) {
				continue;
			}

			// (출발 정점부터 현재 정점까지의 비용 + 현재 정점부터 인접 정점까지의 비용) < 출발 정점부터 인접 정점까지의 비용
			for (Edge e : graph.get(cur.to)) {
				if (dist[e.to] > cur.cost + e.cost) {
					dist[e.to] = cur.cost + e.cost;
					pq.offer(new Edge(e.to, cur.cost + e.cost));
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

		// 정점 개수, 간선 개수 입력
		st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());

		// 간선 입력 및 그래프 초기화
		graph = new ArrayList<>();
		for (int i = 0; i < v + 1; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			graph.get(s).add(new Edge(d, c));
		}

		dijkstra();
	}
}
