package algorithm.learning.binary_search;

import java.io.IOException;
import java.util.Arrays;

/**
 * 이진 탐색은 데이터가 정렬되어있을 때, O(logN)의 시간 복잡도로 목표 데이터를 찾는 알고리즘이다.
 * 재귀함수 또는 반복문을 통해 구현할 수 있다.
 *
 * 동작 과정(오름차순 정렬 기준)
 *   1. mid(배열의 중간 값)을 target(목표 데이터)과 비교한다.
 *   2. mid > target인 경우, 현재 mid보다 작은 데이터들을 대상으로 새로운 mid를 선정하여 다시 target과 비교한다.
 *   3. mid < target인 경우, 현재 mid보다 큰 데이터들을 대상으로 새로운 mid를 선정하여 다시 target과 비교한다.
 *   4. mid == target인 경우, mid를 반환하고 탐색을 종료한다.
 */
public class BinarySearch {

	/**
	 * @param ints 전체 배열
	 * @param start 시작 인덱스
	 * @param end 끝 인덱스
	 * @param target 목표 데이터
	 * @return 오름차순 정렬 시, 목표 데이터의 인덱스
	 */
	public static int recursion(int[] ints, int start, int end, int target) {
		if (start > end) {
			return -1;
		}

		int mid = (start + end) / 2; // 중간 지점

		if (ints[mid] == target) {
			return mid;
		} else if (ints[mid] < target) {
			return recursion(ints, mid + 1, end, target);
		} else {
			return recursion(ints, start, mid - 1, target);
		}
	}

	/**
	 * @param ints 전체 배열
	 * @param target 목표 데이터
	 * @return 오름차순 정렬 시, 목표 데이터의 인덱스
	 */
	public static int iteration(int[] ints, int target) {
		int left = 0;
		int right = ints.length - 1;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (ints[mid] == target) {
				return mid;
			} else if (ints[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		return -1;
	}

	public static void main(String[] args) throws IOException {
		int[] numbers1 = {1, 3, 4, 6, 7, 11, 12, 15, 19, 25, 8};
		int target11 = 8;
		int target12 = 25;

		int[] numbers2 = {5, 20, 16, 21, 7, 8, 9, 10, 4};
		int target21 = 5;
		int target22 = 21;

		Arrays.sort(numbers1);
		Arrays.sort(numbers2);

		System.out.println(recursion(numbers1, 0, numbers1.length, target11)); // 5
		System.out.println(iteration(numbers1, target11)); // 5

		System.out.println(recursion(numbers1, 0, numbers1.length, target12)); // 10
		System.out.println(iteration(numbers1, target12)); // 10

		System.out.println(recursion(numbers2, 0, numbers1.length, target21)); // 1
		System.out.println(iteration(numbers2, target21)); // 1

		System.out.println(recursion(numbers2, 0, numbers1.length, target22)); // 8
		System.out.println(iteration(numbers2, target22)); // 8
	}
}
