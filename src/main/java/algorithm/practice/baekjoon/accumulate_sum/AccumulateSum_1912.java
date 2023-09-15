package algorithm.practice.baekjoon.accumulate_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AccumulateSum_1912 {

	public static int solution(int n, int[] ints) {
		int answer = Integer.MIN_VALUE;

		int[] prefix = new int[n];

		for (int i = 0; i < ints.length; i++) {
			if (i == 0) {
				prefix[i] = ints[i];
			} else {
				prefix[i] = Math.max(prefix[i - 1] + ints[i], ints[i]);
			}

			answer = Math.max(answer, prefix[i]);
		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] ints = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();

		System.out.println(solution(n, ints));
	}
}
