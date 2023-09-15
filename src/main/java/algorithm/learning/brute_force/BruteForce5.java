package algorithm.learning.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BruteForce5 {

	public static long solution(int[][] locations) {
		long answer = Long.MAX_VALUE;

		long xMin = Long.MAX_VALUE;
		long xMax = Long.MIN_VALUE;
		long yMin = Long.MAX_VALUE;
		long yMax = Long.MIN_VALUE;

		for (int i = 0; i < locations.length; i++) {
			if (locations[i][0] > xMax) {
				xMax = locations[i][0];
			}

			if (locations[i][0] < xMin) {
				xMin = locations[i][0];
			}

			if (locations[i][1] > yMax) {
				yMax = locations[i][1];
			}

			if (locations[i][1] < yMin) {
				yMin = locations[i][1];
			}
		}

		for (long x = xMin; x <= xMax; x++) {
			for (long y = yMin; y <= yMax; y++) {
				long tmp = 0;

				for (int i = 0; i < locations.length; i++) {
					tmp += Math.sqrt(Math.pow((x - locations[i][0]), 2) + Math.pow((y - locations[i][1]), 2));
				}

				answer = Math.min(answer, tmp);
			}
		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] locations = new int[n][2];

		for (int i = 0; i < n; i++) {
			int[] location = Arrays.stream(br.readLine().split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();

			locations[i][0] = location[0];
			locations[i][1] = location[1];
		}

		System.out.println(solution(locations));
	}
}
