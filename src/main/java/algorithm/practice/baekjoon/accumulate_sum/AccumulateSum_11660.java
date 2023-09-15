package algorithm.practice.baekjoon.accumulate_sum;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class AccumulateSum_11660 {

	public static int[] solution(int[][] table, int[][]locations) {
		int[] answers = new int[locations.length];

		int[][] prefix = new int[table.length + 1][table[0].length + 1];

		for (int x = 1; x < prefix.length; x++) {
			for (int y = 1; y < prefix[x].length; y++) {
				prefix[x][y] = prefix[x - 1][y] + prefix[x][y - 1] - prefix[x - 1][y - 1] + table[x - 1][y - 1];
			}
		}

		for (int i = 0; i < locations.length; i++) {
			int x1 = locations[i][0];
			int y1 = locations[i][1];
			int x2 = locations[i][2];
			int y2 = locations[i][3];

			answers[i] = prefix[x2][y2] - prefix[x2][y1-1] - prefix[x1-1][y2] + prefix[x1-1][y1-1];
		}

		return answers;
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 초기 표 입력
		int[][] table = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < n; j++) {
				table[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 목표 좌표 입력(m번) -> 실행
		int[][] locations = new int[m][4];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				locations[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] answers = solution(table, locations);

		for (int answer : answers) {
			bw.write(answer + "\n");
		}

		bw.flush();
	}
}
