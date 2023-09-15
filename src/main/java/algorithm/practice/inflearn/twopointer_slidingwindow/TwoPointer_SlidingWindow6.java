package algorithm.practice.inflearn.twopointer_slidingwindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 0과 1로 구성된 길이가 N인 수열이 주어집니다.
 * 여러분은 이 수열에서 최대 k번을 0을 1로 변경할 수 있습니다.
 * 여러분이 최대 k번의 변경을 통해 이 수열에서 1로만 구성된 최대 길이의 연속부분수열을 찾는 프로그램을 작성하세요.
 * 만약 길이가 길이가 14인 다음과 같은 수열이 주어지고 k=2라면
 * 1 1 0 0 1 1 0 1 1 0 1 1 0 1
 * 여러분이 만들 수 있는 1이 연속된 연속부분수열은 1 1 0 0 1 1 1 1 1 1 1 1 이며 그 길이는 8입니다.
 *
 * 첫 번째 줄에 수열의 길이인 자연수 N(5<=N<100,000)이 주어집니다.
 * 두 번째 줄에 N길이의 0과 1로 구성된 수열이 주어집니다.
 * 14 2
 * 1 1 0 0 1 1 0 1 1 0 1 1 0 1
 *
 * 첫 줄에 최대 길이를 출력하세요.
 * 8
 */

public class TwoPointer_SlidingWindow6 {
	public static int solution(int n, int k, int[] array) {
		int maxLen = Integer.MIN_VALUE;

		int p1 = 0;
		int count = 0;

		for (int p2 = 0; p2 < array.length; p2++) {
			if (array[p2] == 0) {
				count++;
			}

			while (count > k) {
				if (array[p1] == 0) {
					count--;
				}
				p1++;
			}

			// 인데스 ~ 인덱스의 요소 개수는 p2 - p1 + 1이다.
			maxLen = Math.max(maxLen, p2 - p1 + 1);

			if (maxLen >= array.length - p1) {
				break;
			}
		}

		return maxLen;
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] array = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();

		System.out.println(solution(n, k, array));
	}
}
