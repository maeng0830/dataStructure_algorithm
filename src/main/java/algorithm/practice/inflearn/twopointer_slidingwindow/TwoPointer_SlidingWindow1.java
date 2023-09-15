package algorithm.practice.inflearn.twopointer_slidingwindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요.
 *
 * 첫 번째 줄에 첫 번째 배열의 크기 N(1<=N<=100)이 주어집니다.
 * 두 번째 줄에 N개의 배열 원소가 오름차순으로 주어집니다.
 * 세 번째 줄에 두 번째 배열의 크기 M(1<=M<=100)이 주어집니다.
 * 네 번째 줄에 M개의 배열 원소가 오름차순으로 주어집니다.
 * 각 리스트의 원소는 int형 변수의 크기를 넘지 않습니다.
 * 3
 * 1 3 5
 * 5
 * 2 3 6 7 9
 *
 * 오름차순으로 정렬된 배열을 출력합니다.
 * 1 2 3 3 5 6 7 9
 */
public class TwoPointer_SlidingWindow1 {

	public static void solution(int firstCount, int[] firstArray, int secondCount, int[] secondArray) {
		int[] answer = new int[firstCount + secondCount];

		int ft = 0;
		int st = 0;
		int cur = 0;

		while (ft < firstCount && st < secondCount) {
			if (firstArray[ft] < secondArray[st]) {
				answer[cur++] = firstArray[ft++];
			} else {
				answer[cur++] = secondArray[st++];
			}
		}

		while (ft < firstCount) {
			answer[cur++] = firstArray[ft++];
		}

		while (st < secondCount) {
			answer[cur++] = secondArray[st++];
		}

		for (int i : answer) {
			System.out.print(i + " ");
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int firstCount = Integer.parseInt(br.readLine());

		int[] firstArray = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt).toArray();

		int secondCount = Integer.parseInt(br.readLine());

		int[] secondArray = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt).toArray();

		solution(firstCount, firstArray, secondCount, secondArray);
	}
}
