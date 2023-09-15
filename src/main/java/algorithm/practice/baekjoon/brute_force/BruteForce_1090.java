package algorithm.practice.baekjoon.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BruteForce_1090 {

	public static void solution(long[][] locations) {
		long[] answer = new long[locations.length];

		for (int i = 0; i < locations.length; i++) {
			answer[i] = -1;
		}

		long[] xLocations = new long[locations.length];
		long[] yLocations = new long[locations.length];

		for (int i = 0; i < locations.length; i++) {
			xLocations[i] = locations[i][0];
			yLocations[i] = locations[i][1];
		}

		// 로직
		for (long xLocation : xLocations) { // 목표 지점의 x좌표
			for (long yLocation : yLocations) { // 목표 지점의 y좌표
				long[] dist = new long[locations.length];

				for (int i = 0; i < locations.length; i++) { // 각 체커와 목표 지점의 거리 계산
					long d = Math.abs(xLocation - locations[i][0]) + Math.abs(yLocation - locations[i][1]);
					dist[i] = d;
				}

				Arrays.sort(dist); // 오름차순으로 정렬

				long tmp = 0;

				// dist(목표 지점과 각 체커의 거리)를 오름차순 정렬했다.
				// 0 ~ N까지 거리를 더해가면서 answer에 저장하면, N개의 체커가 목표 지점에 모일 수 있는 최단 거리가 된다.
				// '로직'이 반복되면서, 목표 지점에 따라 N개의 체커가 모일 수 있는 최단 거리가 계속 갱신된다.
				for (int i = 0; i < locations.length; i++) {
					tmp += dist[i];

					if (answer[i] == -1) {
						answer[i] = tmp;
					} else {
						answer[i] = Math.min(tmp, answer[i]);
					}
				}
			}
		}

		for (long l : answer) {
			System.out.print(l + " ");
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		long[][] locations = new long[n][2];

		for (int i = 0; i < locations.length; i++) {
			String[] str = br.readLine().split(" ");

			locations[i][0] = Long.parseLong(str[0]);
			locations[i][1] = Long.parseLong(str[1]);
		}

		solution(locations);
	}
}
