package algorithm.learning.binary_search;

import java.io.IOException;
import java.util.Arrays;

/**
 * 정렬된 데이터 목록에 중복된 데이터들이 존재한다고 가정하자.
 * 이 때 이진탐색을 응용하면 목표 데이터의 개수, 첫 인덱스, 마지막 인덱스를 구할 수 있다.
 * 이것을 위해 lowerBound와 upperBound를 구해야한다. 두 값은 이진탐색을 통해 구할 수 있다.
 *
 * lowerBound는 목표 데이터 이상의 값이 처음으로 나오는 인덱스를 의미한다.
 *
 * upperBound는 목표 데이터를 초과하는 값이 처음으로 나오는 인덱스를 의미한다.
 */
public class LowerBound_UpperBound {

	public static int lowerBound(int target, int[] numbers) {
		int left = 0;
		int right = numbers.length;

		while (left < right) { // left == right가 될 경우, out of index가 발생할 수 있다.
			int mid = (left + right) / 2;

			if (numbers[mid] >= target) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}

		return left;
	}

	public static int upperBound(int target, int[] numbers) {
		int left = 0;
		int right = numbers.length;

		while (left < right) { // left == right가 될 경우, out of index가 발생할 수 있다.
			int mid = (left + right) / 2;

			if (numbers[mid] <= target) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}

		return left;
	}

	public static void count(int target, int[] numbers) {
		int lower = lowerBound(target, numbers);
		int upper = upperBound(target, numbers);

		int count = upper - lower; // 목표 데이터의 개수

		System.out.printf("대상 원소가 %d개 존재합니다.\n", count);

	}

	public static void main(String[] args) throws IOException {
		int[] numbers1 = {1, 1, 2, 3, 4, 5, 5, 7, 10, 12};
		int target11 = 1;
		int target12 = 5;

		int[] numbers2 = {2, 3, 4, 6, 6, 6, 7, 10, 11};
		int target21 = 11;
		int target22 = 6;

		Arrays.sort(numbers1);
		Arrays.sort(numbers2);

		System.out.println(lowerBound(target11, numbers1)); // 0
		System.out.println(upperBound(target11, numbers1)); // 2
		count(target11, numbers1); // 대상 원소가 2개 존재합니다.

		System.out.println(lowerBound(target12, numbers1)); // 5
		System.out.println(upperBound(target12, numbers1)); // 7
		count(target12, numbers1); // 대상 원소가 2개 존재합니다.

		System.out.println(lowerBound(target21, numbers2)); // 8
		System.out.println(upperBound(target21, numbers2)); // 9
		count(target21, numbers2); // 대상 원소가 1개 존재합니다.

		System.out.println(lowerBound(target22, numbers2)); // 3
		System.out.println(upperBound(target22, numbers2)); // 6
		count(target22, numbers2); // 대상 원소가 3개 존재합니다.
	}
}
