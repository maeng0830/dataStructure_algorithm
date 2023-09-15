package algorithm.practice.baekjoon.accumulate_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AccumulateSum_2559 {

	public static int solution(int n, int k, int[] ints) {
		int answer = Integer.MIN_VALUE;

		int[] prefix = new int[n];

		for (int i = 0; i < ints.length; i++) {
			if (i == 0) {
				prefix[i] = ints[i];
			} else {
				prefix[i] = prefix[i - 1] + ints[i];
			}
		}

		for (int i = k - 1; i < prefix.length; i++) {
			int cur = 0;

			if (i - k < 0) {
				cur = prefix[i];
			} else {
				cur = prefix[i] - prefix[i - k];
			}


			answer = Math.max(answer, cur);
		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int k = Integer.parseInt(str[1]);

		int[] ints = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();

		System.out.println(solution(n, k, ints));
	}
}
