package algorithm.learning.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 거품 정렬은 데이터 목록 중 인접한 두 개의 데이터끼리 비교하여 정렬하는 방법이다.
 *
 * 오름차순 정렬
 * 1. 맨 앞에서 부터 현재 데이터와 다음 데이터를 비교한다.
 * 2. 현재 데이터가 다음 데이터보다 크면 두 데이터의 위치를 교환한다.
 * 3. 이후의 데이터들에게도 위의 과정을 반복한다.
 * 4. 라운드는 데이터 개수 - 1 만큼 실시된다.
 * 5. 첫 라운드에는 데이터 개수 - 1만큼 비교되며, 라운드 마다 횟수가 1씩 줄어든다.
 *
 * 추가적인 메모리 소비가 적다.
 * 안정 정렬이 가능하다.
 *
 * 시간복잡도는 O(N^2)이다.
 */
public class Bubble {

	public static int[] bubbleSorting(int[] ints) {
		for (int i = 0; i < ints.length - 1; i++) {
			for (int j = 0; j < ints.length - 1 - i; j++) {
				swap(ints, j, j + 1);
			}
		}

		return ints;
	}

	public static void swap(int[] ints, int cur, int next) {
		if (ints[cur] > ints[next]) {
			int tmp = ints[cur];
			ints[cur] = ints[next];
			ints[next] = tmp;
		}
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] ints = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();

		int[] result = bubbleSorting(ints);

		for (int i : result) {
			System.out.print(i + " ");
		}
	}
}
