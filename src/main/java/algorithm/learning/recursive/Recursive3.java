package algorithm.learning.recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Recursive3 {

	public static int solution(int n) {
		if (n <= 2) {
			return 1;
		}

		// 첫 번째 재귀 함수 호출에 대한 모든 작업이 끝난 후에, 두 번째 재귀 함수 호출에 대한 작업이 실행된다.
		// 첫 번째, 두 번째 재귀 함수 호출에 대한 모든 작업이 끝나야 해당 코드가 실행된다.
		// n == 5: 5 3 1 2 3 1 2
		return solution(n - 2) + solution(n - 1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		System.out.println(solution(n));
	}
}
