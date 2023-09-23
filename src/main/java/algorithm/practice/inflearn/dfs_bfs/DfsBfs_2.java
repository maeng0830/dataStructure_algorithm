package algorithm.practice.inflearn.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 철수는 그의 바둑이들을 데리고 시장에 가려고 한다. 그런데 그의 트럭은 C킬로그램 넘게 태울수가 없다.
 * 철수는 C를 넘지 않으면서 그의 바둑이들을 가장 무겁게 태우고 싶다.
 * N마리의 바둑이와 각 바둑이의 무게 W가 주어지면, 철수가 트럭에 태울 수 있는 가장 무거운 무게를 구하는 프로그램을 작성하세요.
 *
 * 첫 번째 줄에 자연수 C(1<=C<=100,000,000)와 N(1<=N<=30)이 주어집니다.
 * 둘째 줄부터 N마리 바둑이의 무게가 주어진다.
 * 259 5
 * 81
 * 58
 * 42
 * 33
 * 61
 *
 * 첫 번째 줄에 가장 무거운 무게를 출력한다.
 * 242
 */
public class DfsBfs_2 {

	public static class Save {
		int sum = 0;
		int answer = 0;
	}

	public static int solution(int cur, int c, int[] weights, Save save) {
		if (save.sum > c) {
			return save.answer;
		} else if (cur == weights.length) {
			save.answer = Math.max(save.answer, save.sum);
			return save.answer;
		}

		save.sum += weights[cur];
		solution(cur + 1, c, weights, save);
		save.sum -= weights[cur];
		solution(cur + 1, c, weights, save);

		return save.answer;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int c = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[] weights = new int[n + 1];
		Save save = new Save();

		for (int i = 1; i <= n; i++) {
			weights[i] = Integer.parseInt(br.readLine());
		}

		System.out.println(solution(1, c, weights, save));
	}
}
