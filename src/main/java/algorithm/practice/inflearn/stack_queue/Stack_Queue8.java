package algorithm.practice.inflearn.stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


/*
 * 메디컬 병원 응급실에는 의사가 한 명밖에 없습니다.
 * 응급실은 환자가 도착한 순서대로 진료를 합니다. 하지만 위험도가 높은 환자는 빨리 응급조치를 의사가 해야 합니다.
 * 이런 문제를 보완하기 위해 응급실은 다음과 같은 방법으로 환자의 진료순서를 정합니다.
 * • 환자가 접수한 순서대로의 목록에서 제일 앞에 있는 환자목록을 꺼냅니다.
 * • 나머지 대기 목록에서 꺼낸 환자 보다 위험도가 높은 환자가 존재하면 대기목록 제일 뒤로 다시 넣습니다. 그렇지 않으면 진료를 받습니다.
 * N명의 대기목록 순서의 환자 위험도가 주어지면, 대기목록상의 M번째 환자는 몇 번째로 진료를 받는지 출력하는 프로그램을 작성하세요.
 *
 * 첫 줄에 자연수 N(5<=N<=100)과 M(0<=M<N) 주어집니다.
 * 두 번째 줄에 접수한 순서대로 환자의 위험도(50<=위험도<=100)가 주어집니다.
 * 위험도는 값이 높을 수록 더 위험하다는 뜻입니다. 같은 값의 위험도가 존재할 수 있습니다.
 * 6 3
 * 70 60 90 60 60 60
 *
 * M번째 환자의 몇 번째로 진료받는지 출력하세요.
 * 4
 */
public class Stack_Queue8 {

	public static class PatientsInfo {

		int number;
		int hazard;

		PatientsInfo(int number, int hazard) {
			this.number = number;
			this.hazard = hazard;
		}
	}

	public static int solution(int n, int m, int[] hazards) {
		Queue<PatientsInfo> patientsInfos = new LinkedList<>();
		int count = 0;

		for (int i = 0; i < hazards.length; i++) {
			patientsInfos.offer(new PatientsInfo(i, hazards[i]));
		}


		while (!patientsInfos.isEmpty()) {
			PatientsInfo cur = patientsInfos.poll();

			for (PatientsInfo tmp : patientsInfos) {
				if (cur.hazard < tmp.hazard) {
					patientsInfos.offer(cur);
					cur = null;
					break;
				}
			}

			if (cur != null) {
				count++;

				if (cur.number == m) {
					return count;
				}
			}
		}

		return 0;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] nm = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();

		int[] hazards = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();

		System.out.println(solution(nm[0], nm[1], hazards));
	}
}
