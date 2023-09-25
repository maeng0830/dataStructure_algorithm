package algorithm.practice.inflearn.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1부터 N까지 번호가 적힌 구슬이 있습니다. 이 중 중복을 허락하여 M번을 뽑아 일렬로 나열하는 방법을 모두 출력합니다.
 *
 * 첫 번째 줄에 자연수 N(3<=N<=10)과 M(2<=M<=N)이 주어집니다.
 * 3 2
 *
 * 첫 번째 줄에 결과를 출력합니다.
 * 1 1
 * 1 2
 * 1 3
 * 2 1
 * 2 2
 * 2 3
 * 3 1
 * 3 2
 * 3 3
 */
public class DfsBfs_4 {

	public static void solution(int n, int m, int depth, StringBuilder answer) {
		if (depth == m + 1) {
			System.out.println(answer);
			return;
		}

		for (int i = 1; i <= n; i++) {
			answer.append(" ").append(i);
			solution(n, m, depth + 1, answer);
			answer.delete(answer.lastIndexOf(" "), answer.length());
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();

		solution(n, m, 1, sb);
	}
}
