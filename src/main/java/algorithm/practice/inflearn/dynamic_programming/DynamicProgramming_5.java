package algorithm.practice.inflearn.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 다음과 같이 여러 단위의 동전들이 주어져 있을때 거스름돈을 가장 적은 수의 동전으로 교환해주려면 어떻게 주면 되는가?
 * 각 단위의 동전은 무한정 쓸 수 있다.
 *
 * 첫 번째 줄에는 동전의 종류개수 N(1<=N<=50)이 주어진다.
 * 두 번째 줄에는 N개의 동전의 종류가 주어지고, 그 다음줄에 거슬러 줄 금액 M(1<=M<=500)이 주어진다.
 * 각 동전의 종류는 100원을 넘지 않는다.
 * 3
 * 1 2 5
 * 15
 *
 * 첫 번째 줄에 거슬러 줄 동전의 최소개수를 출력한다.
 * 3
 */
public class DynamicProgramming_5 {

	static int n;
	static int[] coins;
	static int total;
	static int[] memo;

	public static int solution() {
		memo[0] = 0;

		Arrays.sort(coins);

		for (int i = 0; i < coins.length; i++) {
			int coin = coins[i];

			// 냅색 알고리즘에서 각 선택지를 중복해서 선택할 수 있다면, 반복문을 앞에서부터 시작한다.
			for (int j = coin; j < memo.length; j++) {
				memo[j] = Math.min(memo[j], memo[j - coin] + 1);
			}
		}

		return memo[total];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		coins = new int[n];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < coins.length; i++) {
			coins[i] = Integer.parseInt(st.nextToken());
		}

		total = Integer.parseInt(br.readLine());

		memo = new int[total + 1];
		Arrays.fill(memo, Integer.MAX_VALUE);

		System.out.println(solution());
	}
}
