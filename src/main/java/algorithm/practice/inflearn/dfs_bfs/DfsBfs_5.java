package algorithm.practice.inflearn.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 다음과 같이 여러 단위의 동전들이 주어져 있을때 거스름돈을 가장 적은 수의 동전으로 교환해주려면 어떻게 주면 되는가?
 * 각 단위의 동전은 무한정 쓸 수 있다.
 *
 * 첫 번째 줄에는 동전의 종류개수 N(1<=N<=12)이 주어진다. 두 번째 줄에는 N개의 동전의 종류가 주어지고,
 * 그 다음줄에 거슬러 줄 금액 M(1<=M<=500)이 주어진다.각 동전의 종류는 100원을 넘지 않는다.
 * 3
 * 1 2 5
 * 15
 *
 * 첫 번째 줄에 거슬러 줄 동전의 최소개수를 출력한다.
 * 3
 */
public class DfsBfs_5 {

	public static class Save {
		int sum = 0;
		int answer = Integer.MAX_VALUE;
	}

	public static int solution(int depth, int n, int target, Integer[] coins, Save save) {
		if (save.sum > target || depth >= save.answer) {
			return 0;
		} else if (save.sum == target) {
			save.answer = depth;
			return 0;
		}

		for (int i = 0; i < coins.length; i++) {
			save.sum += coins[i];
			solution(depth + 1, n, target, coins, save);
			save.sum -= coins[i];
		}

		return save.answer;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		Integer[] coins = new Integer[n];

		for (int i = 0; i < coins.length; i++) {
			coins[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(coins, Collections.reverseOrder());


		st = new StringTokenizer(br.readLine());
		int target = Integer.parseInt(st.nextToken());

		Save save = new Save();

		System.out.println(solution(0, n, target, coins, save));
	}
}
