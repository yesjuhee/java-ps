package ps.solution;

import java.io.*;
import java.util.*;

class _019 {

	private int n;
	private int k;
	private int[] arr;
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		new _019().solution();
	}

	public void solution() throws IOException {
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 정렬
		quickSort(0, n);

		// 출력
		System.out.println(arr[k - 1]);
	}

	public void quickSort(int start, int end) {
		if (start + 1 >= end) { // 원소가 1개 이하인 배열
			return;
		}
		int pivot = partition(start, end); // pivot의 위치
		if (pivot == k - 1) { // k 번째 수 찾음
			return;
		} else if (k - 1 < pivot) { // pivot의 왼쪽에 k 존재
			quickSort(start, pivot);
		} else { // k - 1 > pivot, pivot의 오른쪽에 k 존재
			quickSort(pivot + 1, end);
		}
	}

	/* 
	 * pivot을 기준으로 파티션 후 pivot의 위치를 반환
	 */
	public int partition(int start, int end) {
		// if (start + 1 >= end) { // 원소가 없는 배열
		// 	return start;
		// }		

		// 가운데 있는 값을 pivot으로 선정
		int m = (start + end) / 2;
		swap(start, m);
		int pivot = arr[start]; // 맨 앞
		int l = start + 1;
		int r = end - 1;

		while(true) {
			while(l <= r && arr[l] <= pivot) l++;
			while(l <= r && arr[r] >= pivot) r--;
			if (l > r) break;
			swap(l, r);
		}
		swap(start, r); // r 자리에 pivot 위치 -> 자리 확정
		return r;
	}

	private void swap(int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
