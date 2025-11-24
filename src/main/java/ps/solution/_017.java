package ps.solution;

import java.io.*;

class _017 {

	public static void main(String[] args) throws IOException {
		new _017().solution();
	}

	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int[] arr = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			arr[i] = Integer.parseInt(s.substring(i, i + 1));
		}

		// 선택 정렬
		for (int i = 0; i < s.length(); i++) {
			int max = i; // 시작 인덱스
			for (int j = i + 1; j < s.length(); j++) {
				if (arr[j] > arr[max]) {
					max = j; // 최대값 확인
				}
			}
			if (arr[i] < arr[max]) { // 최대값이 바뀌었으면 swap
				int tmp = arr[max];
				arr[max] = arr[i];
				arr[i] = tmp;
			}
		}

		// 출력
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < s.length(); i++) {
			sb.append(arr[i]);
		}
		System.out.println(sb);
	}
}
