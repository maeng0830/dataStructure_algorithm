package algorithm.practice.inflearn.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 현수는 씨름 감독입니다. 현수는 씨름 선수를 선발공고를 냈고, N명의 지원자가 지원을 했습니다.
 * 현수는 각 지원자의 키와 몸무게 정보를 알고 있습니다.
 * 현수는 씨름 선수 선발 원칙을 다음과 같이 정했습니다.
 * “A라는 지원자를 다른 모든 지원자와 일대일 비교해서 키와 몸무게 모두 A지원자 보다 높은(크고, 무겁다) 지원자가 존재하면 A지원자는 탈락하고, 그렇지 않으면 선발된다.”
 * N명의 지원자가 주어지면 위의 선발원칙으로 최대 몇 명의 선수를 선발할 수 있는지 알아내는 프로그램을 작성하세요.
 *
 * 첫째 줄에 지원자의 수 N(5<=N<=30,000)이 주어집니다.
 * 두 번째 줄부터 N명의 키와 몸무게가 차례로 주어집니다.
 * 각 선수의 키가 모두 다르고, 몸무게도 모두 다릅니다.
 * 5
 * 172 67
 * 183 65
 * 180 70
 * 170 72
 * 181 60
 *
 * 첫째 줄에 씨름 선수로 뽑히는 최대 인원을 출력하세요.
 * 3
 */
public class Greedy_1 {

	static class Body implements Comparable<Body> {
		int height;
		int weight;

		Body(int height, int weight) {
			this.height = height;
			this.weight = weight;
		}

		@Override
		public int compareTo(Body o) {
			return o.height - this.height;
		}
	}

	public static int solution(ArrayList<Body> bodies) {
		int count = 0;

		Collections.sort(bodies);
		int max = Integer.MIN_VALUE;

		for (Body body : bodies) {
			if (body.weight > max) {
				count += 1;
				max = body.weight;
			}
		}

		return count;
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());

		ArrayList<Body> bodies = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int height = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			bodies.add(new Body(height, weight));
		}

		System.out.println(solution(bodies));
	}
}
