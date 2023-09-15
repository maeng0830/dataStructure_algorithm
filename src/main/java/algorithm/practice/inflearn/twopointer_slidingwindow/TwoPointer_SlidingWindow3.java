package algorithm.practice.inflearn.twopointer_slidingwindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 현수의 아빠는 제과점을 운영합니다. 현수 아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 최대 매출액이 얼마인지 구하라고 했습니다.
 * 만약 N=10이고 10일 간의 매출기록이 아래와 같습니다. 이때 K=3이면
 * 12 15 11 20 25 10 20 19 13 15
 * 연속된 3일간의 최대 매출액은 11+20+25=56만원입니다.
 *
 * 첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.
 * 두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다.
 * 10 3
 * 12 15 11 20 25 10 20 19 13 15
 *
 * 첫 줄에 최대 매출액을 출력합니다.
 * 56
 */

public class TwoPointer_SlidingWindow3 {

	public static int solution(int n, int k, int[] array) {

		int maxSum = Integer.MIN_VALUE;
		int curSum = 0;

		int lt = 0;
		int rt = 0;

		while (rt < n) {
			if (rt < k) {
				curSum += array[rt];
				rt++;
				continue;
			}

			maxSum = Math.max(maxSum, curSum);

			curSum -= array[lt];
			curSum += array[rt];
			lt++;
			rt++;
		}

		return maxSum;
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] array = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();

		System.out.println(solution(n, k, array));
	}
}
