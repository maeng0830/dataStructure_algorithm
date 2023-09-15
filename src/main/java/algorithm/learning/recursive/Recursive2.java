package algorithm.learning.recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Recursive2 {

	public static int solution(int x, int n) {
		if (n == 0) {
			return 1;
		}

		// 모든 호출이 끝난 후, 역순으로 값이 반환된다.
		// 값이 반환되야 해당 코드가 실행된다. 즉 해당 코드는 호출 역순으로 실행된다.
		return x * solution(x, n - 1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int x = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		System.out.println(solution(x, n));
	}
}
