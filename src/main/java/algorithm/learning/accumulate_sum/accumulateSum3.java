package algorithm.learning.accumulate_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class accumulateSum3 {

	public static int solution(int[][] ints, int x1, int y1, int x2, int y2) {
		x1--;
		y1--;
		x2--;
		y2--;

		int[][] prefix = new int[ints.length][ints[0].length];
		
		for (int i = 0; i < prefix.length; i++) {
			for (int j = 0; j < prefix[i].length; j++) {
				if (i == 0 && j == 0) {
					prefix[i][j] = ints[i][j];
				} else if (j == 0) {
					prefix[i][j] = prefix[i - 1][j] + ints[i][j];
				} else if (i == 0) {
					prefix[i][j] = prefix[i][j - 1] + ints[i][j];
				} else {
					prefix[i][j] = prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1] + ints[i][j];
				}
			}
		}

		int answer = prefix[y2][x2];

		if (y1 == 0 && x1 == 0) {
			return answer;
		} else if (x1 == 0) {
			return answer - prefix[y1 - 1][x1];
		} else if (y1 == 0) {
			return answer - prefix[y1][x1 - 1];
		} else {
			return answer - prefix[y1 - 1][x2] - prefix[y2][x1 - 1] + prefix[y1 - 1][x1 - 1];
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] ints = new int[4][4];

		for (int i = 0; i < ints.length; i++) {
			String[] str = br.readLine().split(" ");

			for (int j = 0; j < ints[i].length; j++) {
				ints[i][j] = Integer.parseInt(str[j]);
			}
		}

		int[] targets = Arrays.stream(br.readLine().split(" "))
						.mapToInt(Integer::parseInt)
								.toArray();

		System.out.println(solution(ints, targets[0], targets[1], targets[2], targets[3]));
	}
}
