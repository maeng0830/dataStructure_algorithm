package algorithm.practice.inflearn.hashmap_treeset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

/*
 * 현수의 아빠는 제과점을 운영합니다.
 * 현수아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 매출액의 종류를 각 구간별로 구하라고 했습니다.
 * 7일 간의 매출기록이 다음과 같고, 4일간의 구간 매출종류를 구한다면
 * 20 12 20 10 23 17 10
 * 첫 번째 구간은 [20, 12, 20, 10]는 매출액의 종류가 20, 12, 10으로 3이다.
 * 두 번째 구간은 [12, 20, 10, 23]는 매출액의 종류가 4이다.
 * 세 번째 구간은 [20, 10, 23, 17]는 매출액의 종류가 4이다.
 * 네 번째 구간은 [10, 23, 17, 10]는 매출액의 종류가 3이다.
 *
 * 첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.
 * 두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다.
 * 7 4
 * 20 12 20 10 23 17 10
 *
 * 첫 줄에 각 구간의 매출액 종류를 순서대로 출력합니다.
 * 3 4 4 3
 */
public class HashMap_TreeSet3 {

	public static void solution(int n, int k, int[] ints) {
		HashMap<Integer, Integer> map = new HashMap<>();

		int p1 = 0;

		for (int p2 = 0; p2 < ints.length; p2++) {
			map.put(ints[p2], map.getOrDefault(ints[p2], 0) + 1);

			if (p2 - p1 + 1 == k) {
				System.out.print(map.size() + " ");
			} else if (p2 - p1 + 1 > k) {
				if (map.get(ints[p1]) == 1) {
					map.remove(ints[p1]);
				} else {
					map.put(ints[p1], map.get(ints[p1]) - 1);
				}
				p1++;
				System.out.print(map.size() + " ");
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] nk = br.readLine().split(" ");
		int n = Integer.parseInt(nk[0]);
		int k = Integer.parseInt(nk[1]);

		int[] ints = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();

		solution(n, k, ints);
	}
}
