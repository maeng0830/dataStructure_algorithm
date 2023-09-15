package algorithm.practice.inflearn.hashmap_treeset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/*
 * 현수는 1부터 100사이의 자연수가 적힌 N장의 카드를 가지고 있습니다. 같은 숫자의 카드가 여러장 있을 수 있습니다.
 * 현수는 이 중 3장을 뽑아 각 카드에 적힌 수를 합한 값을 기록하려고 합니다. 3장을 뽑을 수 있는 모든 경우를 기록합니다.
 * 기록한 값 중 K번 째로 큰 수를 출력하는 프로그램을 작성하세요.
 * 만약 큰 수부터 만들어진 수가 25 25 23 23 22 20 19......이고 K값이 3이라면 K번째 큰 값은 22입니다.
 *
 * 첫 줄에 자연수 N(3<=N<=100)과 K(1<=K<=50) 입력되고, 그 다음 줄에 N개의 카드값이 입력된다.
 * 10 3
 * 13 15 34 23 45 65 33 11 26 42
 *
 * 첫 줄에 K번째 수를 출력합니다. K번째 수가 존재하지 않으면 -1를 출력합니다.
 * 143
 */

public class HashMap_TreeSet5 {

	public static int solution(int n, int k, int[] ints) {
		// TreeSet의 생성자에 Comparator.reverseOrder() 사용하면 내림차순 정렬된다.
		TreeSet<Integer> set = new TreeSet<>(Comparator.reverseOrder());

		int answer = 0;

		for (int a = 0; a < ints.length - 2; a++) {
			for (int b = a + 1; b < ints.length - 1; b++) {
				for (int c = b + 1; c < ints.length; c++) {
					set.add(ints[a] + ints[b] + ints[c]);
				}
			}
		}

		Iterator<Integer> iterator = set.iterator();

		for (int i = 0; i < k; i++) {
			if (iterator.hasNext()) {
				answer = iterator.next();
			} else {
				answer = - 1;
				break;
			}
		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] nk = br.readLine().split(" ");
		int n = Integer.parseInt(nk[0]);
		int k = Integer.parseInt(nk[1]);

		int[] ints = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();

		System.out.println(solution(n, k, ints));
	}
}
