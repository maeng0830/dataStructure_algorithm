package algorithm.learning.accumulate_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class accumulateSum1 {

	public static int solution(int a, int b, int[] ints) {
		int answer = Integer.MIN_VALUE;

		int[] prefix = new int[ints.length];

		for (int i = 0; i < ints.length; i++) {
			if (i == 0) {
				prefix[i] = ints[i];
			} else {
				prefix[i] = prefix[i - 1] + ints[i];
			}
		}

		for (int i = b; i < prefix.length; i++) {
			int cur = prefix[i] - prefix[i - b];

			answer = Math.max(answer, cur);
		}

		return answer;
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] ab = br.readLine().split(" ");
		int a = Integer.parseInt(ab[0]);
		int b = Integer.parseInt(ab[1]);

		int[] ints = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();

		System.out.println(solution(a, b, ints));
	}
}
