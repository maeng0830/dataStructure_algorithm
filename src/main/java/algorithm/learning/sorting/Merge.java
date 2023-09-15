package algorithm.learning.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 병합 정렬은 분할정복 알고리즘을 바탕으로한 정렬 방법이다.
 * 데이터 목록에 대해 분할을 반복하여 최대한 작은 데이터 부분을 만들고, 인접한 부분들 끼리 정렬하여 합친다.
 *
 * 1. 주어진 데이터 목록을 절반으로 분할하여 부분을 만든다.
 * 2. 부분의 데이터 개수가 1이 아니라면, 위의 과정을 반복한다.
 * 3. 분할이 완료되면, 인접한 부분들끼리 정렬하면서 합친다.
 *
 * 시간복잡도가 O(NlogN)이다.
 * 안정 정렬이다.
 *
 * 메모리 사용량이 비교적 많다.
 * 배열간 복사 과정 때문에 데이터가 많을수록 비효율적이다.
 */
public class Merge {

	public static void mergeSorting(int[] ints, int left, int right) {
		if (left == right) {
			return;
		}

		int mid = (left + right) / 2;

		mergeSorting(ints, left, mid);
		mergeSorting(ints, mid + 1, right);

		merge(ints, left, mid, right);
	}

	/**
	 * @param ints 전체 배열
	 * @param left 현재 병합될 배열의 시작 인덱스
	 * @param mid 현재 병합될 배열의 중간 인덱스
	 * @param right 현재 병합될 배열의 끝 인덱스
	 */
	public static void merge(int[] ints, int left, int mid, int right) {
		int lt = left; // 왼쪽 부분의 시작점
		int rt = mid + 1; // 오른쪽 부분의 시작점
		int idx = left; // 데이터를 저장할 인덱스

		int[] tmp = new int[ints.length]; // 정렬을 위한 임시 배열

		// 왼쪽 또는 오른쪽 부분의 모든 데이터가 임시 배열에 저장되지 않았을 경우
		// 왼쪽 부분과 오른쪽 데이터를 크기를 비교해가면서 올바른 순서대로 임시 배열에 저장한다.
		while (lt <= mid && rt <= right) {
			if (ints[lt] < ints[rt]) {
				tmp[idx] = ints[lt];
				lt++;
				idx++;
			} else {
				tmp[idx] = ints[rt];
				rt++;
				idx++;
			}
		}

		// 왼쪽 부분이 먼저 임시 배열에 모두 채워진 경우(lt > mid), 오른쪽 부분의 남은 데이터를 임시 배열에 저장
		// 오른쪽 부분이 먼저 임시 배열에 모두 채워진 경우(rt > right), 왼쪽 부분의 남은 데이터를 임시 배열에 저장
		if (lt > mid) {
			while (rt <= right) {
				tmp[idx] = ints[rt];
				rt++;
				idx++;
			}
		} else {
			while (lt <= mid) {
				tmp[idx] = ints[lt];
				lt++;
				idx++;
			}
		}

		for (int i = left; i <= right; i++) {
			ints[i] = tmp[i];
		}
	}



	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] ints = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();

		mergeSorting(ints, 0, ints.length - 1);

		for (int i : ints) {
			System.out.print(i + " ");
		}
	}
}
