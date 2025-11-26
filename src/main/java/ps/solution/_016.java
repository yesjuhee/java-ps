package ps.solution;

import java.io.*;
import java.util.*;

class _016 {

	private int n;
	private Node[] arr;
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		new _016().solution();
	}

	private void solution() throws IOException {
		n = Integer.parseInt(br.readLine());
		arr = new Node[n];

		for (int i = 0; i < n; i++) {
			arr[i] = new Node(Integer.parseInt(br.readLine()), i);
		}
		Arrays.sort(arr); // value를 기준으로 정렬

		int max = 0;
		for (int i = 0; i < n; i++) {
			if (max < arr[i].index - i) { // 인덱스 차이 최대값 계산
				max = arr[i].index - i;
			}
		}

		System.out.println(max + 1);
	}

	static class Node implements Comparable<Node> {

		int value;
		int index;

		public Node(int v, int i) {
			super();
			this.value = v;
			this.index = i;
		}

		@Override
		public int compareTo(Node o) {
			return this.value - o.value; // value 기준 오름차순 정렬
		}
	}
}
