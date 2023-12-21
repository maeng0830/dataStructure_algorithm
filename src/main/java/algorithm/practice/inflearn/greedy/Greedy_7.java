package algorithm.practice.inflearn.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 원더랜드에 문제가 생겼다. 원더랜드의 각 도로를 유지보수하는 재정이 바닥난 것이다.
 * 원더랜드는 모든 도시를 서로 연결하면서 최소의 유지비용이 들도록 도로를 선택하고 나머지 도로는 폐쇄하려고 한다.
 * 아래의 그림은 그 한 예를 설명하는 그림이다.
 * 위의 지도는 각 도시가 1부터 9로 표현되었고, 지도의 오른쪽은 최소비용 196으로 모든 도시를 연결하는 방법을 찾아낸 것이다.
 *
 * 첫째 줄에 도시의 개수 V(1≤V≤100)와 도로의 개수 E(1≤E≤1,000)가 주어진다.
 * 다음 E개의 줄에는 각 도로에 대한 정보를 나타내는 세 정수 A, B, C가 주어진다.
 * 이는 A번 도시와 B번 도시가 유지비용이 C인 도로로 연결되어 있다는 의미이다.
 * 9 12
 * 1 2 12
 * 1 9 25
 * 2 3 10
 * 2 8 17
 * 2 9 8
 * 3 4 18
 * 3 7 55
 * 4 5 44
 * 5 6 60
 * 5 7 38
 * 7 8 35
 * 8 9 15
 *
 * 모든 도시를 연결하면서 드는 최소비용을 출려한다.
 * 196
 */
public class Greedy_7 {

	static int v;
	static int e;
	static int[] parents;
	static Edge[] edges;

	static class Edge implements Comparable<Edge> {
		int from;
		int to;
		int cost;

		public Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());

		edges = new Edge[e];

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			edges[i] = new Edge(a, b, cost);
		}

		parents = makeSet(v);

		int result = kruskal();

		System.out.println(result);
	}

	private static int[] makeSet(int size) {
		int[] parents = new int[size + 1];

		for (int i = 0; i < parents.length; i++) {
			parents[i] = i;
		}

		return parents;
	}

	private static int kruskal() {
		int result = 0;

		PriorityQueue<Edge> pq = new PriorityQueue<>();

		for (Edge value : edges) {
			pq.offer(value);
		}

		while (!pq.isEmpty()) {
			Edge edge = pq.poll();

			if (find(edge.from) == find(edge.to)) {
				continue;
			}

			union(edge.from, edge.to);
			result += edge.cost;
		}

		return result;
	}

	private static int find(int x) {
		if (parents[x] == x) {
			return x;
		} else {
			return parents[x] = find(parents[x]);
		}
	}

	private static void union(int a, int b) {
		int aSet = find(a);
		int bSet = find(b);

		if (aSet > bSet) {
			parents[aSet] = bSet;
		} else {
			parents[bSet] = aSet;
		}
	}
}
