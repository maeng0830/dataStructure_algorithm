package algorithm.learning.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 이진 탐색은 데이터가 정렬되어있을 때, O(logN)의 시간 복잡도로 목표 데이터를 찾는 알고리즘이다.
// 재귀함수 또는 반복문을 통해 구현할 수 있다.
public class BinarySearch1 {

	public static int solution(int[] ints, int start, int end, int target) {
		if (start > end) {
			return -1;
		}

		int mid = (start + end) / 2;

		if (ints[mid] == target) {
			return mid;
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
		int n = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());

		int[] ints = new int[n];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			ints[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(ints);

		System.out.println(solution(ints, 0, n - 1, target));
	}
}
