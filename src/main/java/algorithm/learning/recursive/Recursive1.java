package algorithm.learning.recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 재귀 함수는 함수 내부에서 자신을 호출하는 함수를 말한다.
public class Recursive1 {

	public static void solution(int n) {
		// 재귀함수는 종료조건을 정의해줘야한다. 그렇지 않을 경우, 무한 호출로 인해 StackOverFlow가 발생한다.
		if (n == 0) {
			System.out.println(); // 마지막 함수가 호출된 뒤(n == 0) 실행된다.
			return; // 마지막 함수가 호출된 곳(n == 1)으로 돌아간다.
		}

		System.out.println(n); // 첫 번째 함수부터 호출될 때마다 차례대로 실행된다.
		solution(n - 1);
		System.out.println(n); // 모든 호출이 끝난 후, 마지막 함수부터 반환될 때마다 역순으로 실행된다.
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		solution(n);
	}
}
