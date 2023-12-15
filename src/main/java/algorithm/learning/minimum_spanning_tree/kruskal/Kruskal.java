package algorithm.learning.minimum_spanning_tree.kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 크루스칼 알고리즘은 그래프의 간선들을 하나씩 연결하면서 최소 신장 트리를 완성해나가는 알고리즘이다.
 * 연결할 간선을 선택함에 있어서 그리디한 방법을 사용한다.
 * 구현을 위해 Union-Find가 사용된다.
 *
 * 구현방법
 *   1) 그래프의 모든 간선을 비용 오름차순으로 정렬한다.
 *   2) 정렬된 수선대로 간선을 선택하면서, 가선으로 연결된 정점들을 Union한다.
 *      주의할 점은 간선으로 연결될 두 정점이 이미 같은 집합에 속해있따면, 해당 간선은 선택하지 않아야한다.
 *
 * 첫째 줄에 정점, 간선의 수가 주어진다.
 * 두번째 줄부터 간선 정보가 주어진다.
 * 6 9
 * 1 6 5
 * 2 4 6
 * 1 2 7
 * 3 5 15
 * 5 6 9
 * 3 4 10
 * 1 3 11
 * 2 3 3
 * 4 5 7
 *
 * 최소 비용을 출력한다.
 * 28
 */
public class Kruskal {

	static int v;
	static int e;
	static int[] parents;
	static PriorityQueue<Edge> pq;
	static int result;

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

		// 정점, 간선 개수 입력
		st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());

		// 부모를 저장할 메모리
		parents = makeSet(v);

		// 간선 정보 저장
		// 비용 오름차순 정렬
		pq = new PriorityQueue<>();

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			pq.offer(new Edge(from, to, cost));
		}

		kruskal();
	}

	private static void kruskal() {
		while (!pq.isEmpty()) {
			Edge edge = pq.poll();

			int fromSet = find(edge.from);
			int toSet = find(edge.to);

			// 연결될 두 정점이 이미 같은 집합에 속해있다면, 간선을 선택하지 않는다.
			if (fromSet == toSet) {
				continue;
			}

			System.out.println("<선택된 간선의 정보>");
			System.out.printf("from:%d to:%d cost:%d\n", edge.from, edge.to, edge.cost);

			union(edge.from, edge.to);
			result += edge.cost;
			System.out.println("<현재 정점들의 부모>");
			System.out.println(Arrays.toString(parents) + "\n");
		}

		System.out.printf("최소 비용: %d", result);
	}

	private static int[] makeSet(int size) {
		// 1번 원소가 1번 인덱스에 대응할 수 있도록 배열 크기를 선언
		int[] parents = new int[size + 1];

		// 각 원소는 자기 자신을 가르킨다.
		for (int i = 1; i < parents.length; i++) {
			parents[i] = i;
		}

		return parents;
	}

	private static void union(int a, int b) {
		int aRep = find(a); // a가 속한 집합의 대표
		int bRep = find(b); // b가 속한 집합의 대표

		if (aRep > bRep) {
			parents[aRep] = bRep;
		} else {
			parents[bRep] = aRep;
		}
	}

	private static int find(int x) {
		if (parents[x] == x) {
			return x;
		} else {
			return find(parents[x]);
		}
	}
}
