package algorithm.learning.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 삽입 정렬은 현재 데이터와 그 이전(또는 이후) 데이터를 비교하며 위치를 교환하는 정렬 방법이다.
 *
 * 오름차순 정렬
 * 1. 목표 데이터와 그 이전에 있는 데이터를 비교한다.
 * 2. 목표 데이터가 이전 데이터보다 작다면 서로 위치를 교환한다.
 * 3. 목표 데이터가 이전 데이터보다 작지 않을 때까지 반복한다.
 * 4. 목표 데이터는 두 번째 데이터부터 시작한다.
 * 5. 라운드는 데이터 개수 - 1 만큼 실시된다.
 * 6. 첫 라운드의 최대 비교 횟수는 1이며, 라운드 마다 최대 비교 횟수는 1씩 증가한다.
 *
 * 추가적인 메모리 소비가 적다.
 * 안정 정렬이 가능하다.
 *
 * 시간복잡도는 O(N^2)이다.
 */
public class Insertion {

	public static int[] insertionSorting(int[] ints) {
		for (int i = 1; i < ints.length; i++) {
			int cur = ints[i]; // 목표 데이터

			int j = i - 1; // 첫 번째 비교 데이터

			while (j >= 0 && ints[j] > cur) {
				ints[j + 1] = ints[j];
				j--;
			}

			ints[j + 1] = cur;
		}

		return ints;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] ints = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();

		int[] result = insertionSorting(ints);

		for (int i : result) {
			System.out.print(i + " ");
		}
	}
}
