package algorithm.practice.inflearn.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * N×N 크기의 도시지도가 있습니다. 도시지도는 1×1크기의 격자칸으로 이루어져 있습니다.
 * 각 격자칸에는 0은 빈칸, 1은 집, 2는 피자집으로 표현됩니다. 각 격자칸은 좌표(행번호, 열 번호)로 표현됩니다.
 * 행번호는 1번부터 N번까지이고, 열 번호도 1부터 N까지입니다.
 * 도시에는 각 집마다 “피자배달거리”가 았는데 각 집의 피자배달거리는 해당 집과 도시의 존재하는
 * 피자집들과의 거리 중 최소값을 해당 집의 “피자배달거리”라고 한다.
 * 집과 피자집의 피자배달거리는 |x1-x2|+|y1-y2| 이다.
 * 0 1 2 0
 * 1 0 2 1
 * 0 2 1 2
 * 2 0 1 2
 * (1, 2)에 있는 집과 (2, 3)에 있는 피자집과의 피자 배달 거리는 |1-2| + |2-3| = 2가 된다.
 * 도시 시장은 도시에 있는 피자집 중 M개만 살리고 나머지는 보조금을 주고 폐업시키려고 합니다.
 * 시장은 살리고자 하는 피자집 M개를 선택하는 기준으로 도시의 피자배달거리가 최소가 되는 M개의 피자집을 선택하려고 합니다.
 * 도시의 피자 배달 거리는 각 집들의 피자 배달 거리를 합한 것을 말합니다.
 *
 * 첫째 줄에 N(2 ≤ N ≤ 50)과 M(1 ≤ M ≤ 12)이 주어진다.
 * 둘째 줄부터 도시 정보가 입력된다.
 * 4 4
 * 0 1 2 0
 * 1 0 2 1
 * 0 2 1 2
 * 2 0 1 2
 *
 * 첫째 줄에 M개의 피자집이 선택되었을 때 도시의 최소 피자배달거리를 출력한다.
 * 6
 */
public class DfsBfs_15 {

	static int n;
	static int m;
	static int len;
	static int answer = Integer.MAX_VALUE;
	static int[] combination;
	static ArrayList<Point> hs, pz;

	public static class Point {
		int y;
		int x;

		Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void solution(int l, int s) {
		if (l == m) {
			int sum = 0;
			for (Point h : hs) {
				int dis = Integer.MAX_VALUE;
				for (int i : combination) {
					dis = Math.min(dis, Math.abs(h.x - pz.get(i).x) + Math.abs(h.y - pz.get(i).y));
				}

				sum += dis;
			}

			answer = Math.min(answer, sum);
			return;
		}

		for (int i = s; i < len; i++) {
			combination[l] = i;
			solution(l+1, i+1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		hs = new ArrayList<>();
		pz = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if (tmp == 1) {
					hs.add(new Point(i, j));
				} else if (tmp == 2) {
					pz.add(new Point(i, j));
				}
			}
		}

		len = pz.size();
		combination = new int[m];

		solution(0, 0);

		System.out.println(answer);
	}
}
