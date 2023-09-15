package algorithm.learning.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 선택 정렬은 이미 정렬된 데이터를 제외한 전체 데이터를 순회하면서 현재 인덱스에 들어갈 데이터를 선택하느 알고리즘이다.
 *
 * 1. 주어진 데이터 목록에서 최솟값(또는 최댓값)을 찾는다.
 * 2. 최솟값과 맨 앞에 위치한 값의 위치를 교환한다.
 * 3. 이미 정렬된 맨 앞자리를 제외한 데이터 목록에 대해 위의 과정을 반복한다.
 *
 * 추가적인 메모리 소비가 적다.
 *
 * 시간복잡도가 O(N^2)이다.
 * 안정 정렬이 아니다. -> 중복된 값들의 정렬 전 순서와 정렬 후 순서가 동일하게 유지되는 것을 보장하지 않는다.
 */
public class Selection {

	public static int[] selectionSorting(int[] ints) {
		for (int i = 0; i < ints.length - 1; i++) {
			int min = i;

			for (int j = i + 1; j < ints.length; j++) {
				if (ints[min] > ints[j]) {
					min = j;
				}
			}

			swap(ints, i, min);
		}

		return ints;
	}

	public static void swap(int[] ints, int cur, int min) {
		int tmp = ints[cur];

		ints[cur] = ints[min];
		ints[min] = tmp;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] ints = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();

		int[] result = selectionSorting(ints);

		for (int i : result) {
			System.out.print(i + " ");
		}
	}
}
