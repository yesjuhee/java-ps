package ps.practice;

import java.io.*;
import java.util.*;

public class _010 {

	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private int n;
	private int l;
	private Deque<Node> dq = new LinkedList<>();
	private StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		new _010().solution();
	}

	private void solution() throws IOException {
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());

		// 첫 번째 노드만 미리 작업
		int v0 = Integer.parseInt(st.nextToken());
		Node now0 = new Node(0, v0);
		dq.addLast(now0);
		sb.append(now0.value).append(" ");

		// i 번 반복
		for (int i = 1; i < n; i++) {
			// 하나 추가
			int v = Integer.parseInt(st.nextToken());
			Node now = new Node(i, v);
			
			// 자기보다 큰 애들 제거
			while(dq.size() > 0) {
				Node last = dq.removeLast(); // 뒤에 제거
				if (last.value < now.value) { // 자기보다 작은 노드가 나오면 중단
					dq.addLast(last);
					break;
				}
			}
			dq.addLast(now);

			// L의 크기보다 크다면 하나 제거
			Node first = dq.removeFirst();
			if (first.index >= i - l + 1) {
				dq.addFirst(first);
			}

			// 최소 값 읽기
			first = dq.removeFirst();
			sb.append(first.value).append(" ");
			dq.addFirst(first);
		}

		// 출력
		System.out.println(sb);
	}

	static class Node {
		int index;
		int value;

		public Node(int i, int v) {
			this.index = i;
			this.value = v;
		}
	}
}
