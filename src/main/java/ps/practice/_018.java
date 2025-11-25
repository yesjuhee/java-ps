package ps.practice;

import java.io.*;
import java.util.*;

class _018 {

	private int n;
	private int[] arr;
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		new _018().solution();
	}

	private void solution() throws IOException {
		// 입력
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 정렬
		// Arrays.sort(arr);
		for (int i = 1; i < n; i++) { // i : 정렬할 대상, 0 ~ i - 1 : 정렬 완료된 부분
			int a = arr[i];

			int j = i - 1;
			while(j >= 0 && arr[j] > a) { // 자기보다 큰 놈들 shift
				arr[j + 1] = arr[j];
				j--;
			}

			arr[j + 1] = a; // 마지막 shift 한 놈 자리에 insert
		}

		// 합 구하기
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i] * (n - i);
		}
		System.out.println(sum);
	}
}
