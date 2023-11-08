package algorithm.practice.inflearn.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


/**
 * 현수는 유명한 강연자이다. N개이 기업에서 강연 요청을 해왔다. 각 기업은 D일 안에 와서 강연을 해 주면 M만큼의 강연료를 주기로 했다.
 * 각 기업이 요청한 D와 M를 바탕으로 가장 많을 돈을 벌 수 있도록 강연 스케쥴을 짜야 한다.
 * 단 강연의 특성상 현수는 하루에 하나의 기업에서만 강연을 할 수 있다.
 *
 * 첫 번째 줄에 자연수 N(1<=N<=10,000)이 주어지고, 다음 N개의 줄에 M(1<=M<=10,000)과 D(1<=D<=10,000)가 차례로 주어진다.
 * 6
 * 50 2
 * 20 1
 * 40 2
 * 60 3
 * 30 3
 * 30 1
 *
 * 첫 번째 줄에 최대로 벌 수 있는 수입을 출력한다.
 * 150
 */
public class Greedy_4 {


	static class Lecture implements Comparable<Lecture> {
		int pay;
		int day;

		Lecture(int pay, int day) {
			this.pay = pay;
			this.day = day;
		}

		@Override
		public int compareTo(Lecture o) {
			if (this.day == o.day) {
				return o.pay - this.pay;
			}

			return o.day - this.day;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		ArrayList<Lecture> lectures = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			int pay = Integer.parseInt(st.nextToken());
			int day = Integer.parseInt(st.nextToken());

			lectures.add(new Lecture(pay, day));
		}

		System.out.println(solution(lectures, n));
	}

	private static int solution(ArrayList<Lecture> lectures, int n) {
		Collections.sort(lectures);
		int max = lectures.get(0).day;
		int cur = 0;
		int answer = 0;

		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = max; i >= 1; i--) {
			for (int j = cur; j < n; j++) {
				cur = j;

				if (lectures.get(j).day < i) {
					break;
				}

				pq.offer(lectures.get(j).pay);
			}

			if (!pq.isEmpty()) {
				answer += pq.poll();
			}
		}

		return answer;
	}
}
