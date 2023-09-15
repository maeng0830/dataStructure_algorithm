package algorithm.practice.inflearn.sorting_searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SortingSearching_8 {

	public static int solution(int n, int m, int[] ints) {
		Arrays.sort(ints);

		int left = 0;
		int right = n - 1;
		int mid = (left + right) / 2;

		int answer = -1;

		while (left <= right) {
			if (ints[mid] == m) {
				answer = mid + 1;
				break;
			} else if (ints[mid] < m) {
				left = mid + 1;
				mid = (left + right) / 2;
			} else {
				right = mid - 1;
				mid = (left + right) / 2;
			}
		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] ints = new int[n];
		for (int i = 0; i < n; i++) {
			ints[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(solution(n, m, ints));
	}
}
