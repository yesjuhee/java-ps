package ps.solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _010 {
	
	private int N;
	private int L;
	private Deque<Node> deque = new LinkedList<>();

	public void answer() throws IOException {
		// 1. N, L 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		// 2. N번 입력 받으면서 for문 반복
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int now = Integer.parseInt(st.nextToken());

			// 덱의 뒤에서부터 now 보다 큰 값 제거
			while (!deque.isEmpty() && deque.getLast().value > now) {
				deque.removeLast();
			}
			// 덱의 마지막 위치에 now 값 저장
			deque.addLast(new Node(i, now));
			// 덱의 앞에서 L 범위를 벗어난 값은 제거
			if (deque.getFirst().index <= i - L) {
				deque.removeFirst();
			}
			// 덱의 첫번째 데이터 출력
			sb.append(deque.getFirst().value).append(" ");
		}

		// 3. 출력
		System.out.println(sb);
		br.close();
	}

	public static void main(String[] args) throws IOException {
		new _010().answer();
	}

	static class Node {
		public int index;
		public int value;

		public Node(int index, int value) {
			this.index = index;
			this.value = value;
		}
	}
}
