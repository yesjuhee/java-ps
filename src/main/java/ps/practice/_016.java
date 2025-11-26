package ps.practice;

import java.io.*;
import java.util.*;

class _016 {

	private int n;
	private PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); // 내림차순
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		new _016().solution();
	}

	private void solution() throws IOException {
		n = Integer.parseInt(br.readLine());

		int changed = 0; // 변경되는 횟수 카운트
		for (int i = 0; i < n; i++) {
			int a = Integer.parseInt(br.readLine()); // 입력 값 확인

			while(!pq.isEmpty() && a < pq.peek()) { // 새로 들어오는 수가 기존에 있던 수 보다 작은 경우
				changed++;
				pq.poll();
			}

			pq.offer(a);
		}

		System.out.println(changed + 1);
	}
}
