package algorithm.practice.inflearn.recursive_tree_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 자연수 N이 입력되면 N!를 구하는 프로그램을 작성하세요.
 *
 * 첫 번째 줄에 자연수 N이 주어집니다.
 * 5
 *
 * 첫 번째 줄에 N! 값을 출력합니다.
 * 120
 */
public class RecursiveTreeGraph_3 {

	public static int solution(int n) {
		if (n == 0) {
			return 1;
		} else {
			return n * solution(n - 1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		System.out.println(solution(n));
	}
}
