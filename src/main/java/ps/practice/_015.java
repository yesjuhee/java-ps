package ps.practice;

import java.io.*;

class _015 {

	int n;
	int[] arr;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		new _015().solution();
	}

	public void solution() throws IOException {
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		// Arrays.sort(arr);
		// 버블소트로 구현
		for (int i = n; i > 0; i--) { // i 뒤는 정렬 완료된 부분
			for (int j = 0; j < i - 1; j++) { // 정렬이 안된 부분
				if (arr[j] > arr[j + 1]) {
					int tmp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = tmp;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			sb.append(arr[i]).append("\n");
		}
		System.out.println(sb);
	}
}
