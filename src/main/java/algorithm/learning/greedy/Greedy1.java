package algorithm.learning.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/*
 * 그리디 알고리즘은 최적의 해를 구하기 위해 사용되는 근시안적인 방법론으로 '각 단계에서 최적이라고 생각되는 해를 선택'하는 방식으로 전체 단계를 진행하여 최종적인 해에 도달하는 알고리즘이다.
 * '전체 문제를 부분 문제로 쪼개고, 부분 문제의 해를 통합해 전체 문제의 해를 구한다'는 점에서 완전 탐색 및 동적 프로그래밍과 유사하다. 하지만 각 단계에서 모든 선택지를 고려해보는 다른 두 방법과는 달리, 그리디는 각 단계에서 최적의 선택지만을 고려한다.
 * 따라서 그리디는 전체 문제에 대한 최적해를 보장하지는 않지만, 최적해의 근사치를 보다 빠른 속도로 구할 수 있으며, 경우에 따라 최적해를 구할 수도 있다.
 *
 * 네 종류의 동전으로 거슬러줘야할 돈이 주어진다.
 * 네 종류의 동전을 조합해 가장 적은 개수의 동전으로 거슬러 줄 것이다.
 * 각 동전은 무한대로 사용할 수 있다.
 *
 * 입력
 * 1250
 *
 * 출력
 * 5
 */
public class Greedy1 {

	static int money;
	static Integer[] coins = {10, 50, 100, 500};
	static int count = 0;

	public static int solution() {
		Arrays.sort(coins, Comparator.reverseOrder());

		int point = 0;

		while (money != 0) {
			if (money >= coins[point]) {
				money -= coins[point];
				count++;
			} else {
				point++;
				if (point == coins.length) {
					count = -1;
					break;
				}
			}
		}

		return count;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		money = Integer.parseInt(br.readLine());

		System.out.println(solution());
	}
}
