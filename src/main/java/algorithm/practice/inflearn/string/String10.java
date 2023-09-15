package algorithm.practice.inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.
 *
 * 첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다.
 * 문자열의 길이는 100을 넘지 않는다.
 * teachermode e
 *
 * 첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.
 * 1 0 1 2 1 0 1 2 2 1 0
 */

public class String10 {
	public static void solution(String str, char c) {
		int[] locations = new int[str.length()];

		// 주어진 문자열을 순회한다.
		for (int i = 0; i < str.length(); i++) {
			int lt = i; // 현재 문자를 기준으로 왼쪽으로 이동하는 포인터
			int rt = i; // 현재 문자를 기준으로 오른쪽으로 이동하는 포인터

			// lt 또는 rt가 가르키는 문자가 목표 문자와 일치할 때 까지 반복한다.
			// 반복할 때마다 lt는 왼쪽으로 한칸, rt는 오른쪽으로 한칸 이동한다.
			// lt 또는 rt가 목표 문자에 해당할 경우, 현재 문자와 lt 또는 rt의 거리 차이를 locations에 저장한다.
			do {
				if (lt >= 0 && str.charAt(lt) == c) {
					locations[i] = i - lt;
					break;
				}

				if (rt < str.length() && str.charAt(rt) == c) {
					locations[i] = rt - i;
					break;
				}

				lt--;
				rt++;
			} while (!(lt < 0 && rt >= str.length()));
		}

		for (int location : locations) {
			System.out.print(location + " ");
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		String str = st.nextToken();
		char c = st.nextToken().charAt(0);

		solution(str, c);
	}
}
