package ps.solution;

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
		// for (int i = 1; i < n; i++) { // i : 정렬할 대상, 0 ~ i - 1 : 정렬 완료된 부분
		// 	int a = arr[i];

		// 	int j = i - 1;
		// 	while(j >= 0 && arr[j] > a) { // 자기보다 큰 놈들 shift
		// 		arr[j + 1] = arr[j];
		// 		j--;
		// 	}

		// 	arr[j + 1] = a; // 마지막 shift 한 놈 자리에 insert
		// }
		for (int i = 1; i < n; i++) {
			int target = i;
			int a = arr[i];

			// 삽입할 위치 찾기
			for (int j = i - 1; j >= 0; j--) {
				if (arr[j] < arr[i]) { // 앞에는 오름차순으로 정렬되어있음. arr[i]보다 작은놈이 타깃
					target = j + 1; // 작은놈 바로 뒤에
					break;
				}
				if (j == 0) {
					target = 0; // 작은놈이 없는 경우
				} 
			}

			// target 뒤에 것 한 칸씩 땡기기
			for (int j = i; j > target; j--) {
				arr[j] = arr[j - 1];
			}
			arr[target] = a;
		}

		// 합 구하기
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i] * (n - i);
		}
		System.out.println(sum);
	}
}
