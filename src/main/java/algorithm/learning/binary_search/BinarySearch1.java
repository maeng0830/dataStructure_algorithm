package algorithm.learning.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 이진 탐색은 데이터가 정렬되어있을 때, O(logN)의 시간 복잡도로 목표 데이터를 찾는 알고리즘이다.
// 재귀함수 또는 반복문을 통해 구현할 수 있다.

/**
 * 주어진 숫자 목록에서 목표 숫자가 몇번째로 작은 숫자인지 확인하고자 한다.
 *
 * 첫째 줄에 숫자 갯수와 목표 숫자가 주어진다.
 * 둘째 줄에 숫자 목록이 주어진다.
 * 9 5
 * 2 3 4 7 5 8 9 1 6
 *
 * 숫자 목록에 목표 숫자가 존재하지 않으면 -1, 존재하면 목표 숫자가 몇번째로 작은 숫자인지 반환한다.
 * 5
 */
public class BinarySearch1 {

	public static int solution(int[] ints, int start, int end, int target) {
		if (start > end) {
			return -1;
		}

		int mid = (start + end) / 2; // 중간 지점

		if (ints[mid] == target) {
			return mid + 1;
		} else if (ints[mid] < target) {
			return solution(ints, mid + 1, end, target);
		} else {
			return solution(ints, start, mid - 1, target);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 숫자의 개수
		int target = Integer.parseInt(st.nextToken()); // 목표 숫자

		int[] ints = new int[n]; // 숫자를 저장할 배열
		st = new StringTokenizer(br.readLine());

		// 숫자를 배열에 저장
		for (int i = 0; i < n; i++) {
			ints[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(ints); // 숫자 정렬

		System.out.println(solution(ints, 0, n - 1, target));
	}
}
