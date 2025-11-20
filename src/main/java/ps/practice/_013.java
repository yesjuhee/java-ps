package ps.practice;

import java.io.*;
import java.util.*;

class _013 {

	private int n;
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private Deque<Integer> queue = new ArrayDeque<>();


	public static void main(String[] args) throws IOException {
		new _013().solution();
	}

	private void solution() throws IOException {
		n = Integer.parseInt(br.readLine());

		for (int i = 1; i <= n; i++) {
			queue.add(i);
		}

		for (int i = 0; i < n - 1; i++) {
			// 맨 앞 제거
			queue.poll();
			// 맨 앞을 맨 뒤로
			queue.add(queue.poll());
		}

		// 마지막 남는 카드 출력
		System.out.println(queue.poll());
	}
}
