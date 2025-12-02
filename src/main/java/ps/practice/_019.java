package ps.practice;

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
		// Arrays.sort(arr);
		quickSort(0, n - 1);

		// 출력
		System.out.println(arr[k - 1]);
	}

	public void quickSort(int start, int end) {
		if (start >= end) { // 길이가 1인 집합
			return;
		}

		// pivot 설정
		int pivot = end;
		int left = start;
		int right = end - 1;

		while(left <= right) { // 둘이 엇갈릴 때 탈출
			if (arr[left] > arr[pivot] && arr[right] < arr[pivot]) {
				// swap
				int tmp = arr[left];
				arr[left] = arr[right];
				arr[right] = tmp;
				left++;
				right--;
				continue;
			}			
			if (arr[left] <= arr[pivot]) {
				left++;
			}
			if (arr[right] >= arr[pivot]) {
				right--;
			}
		}

		// swap(left, pivot) -> start는 무조건 pivot 보다 큼
		int tmp = arr[left];
		arr[left] = arr[pivot];
		arr[pivot] = tmp;

		// left 자리는 확정, 그 다음 분할정렬
		quickSort(start, left - 1);
		if (left != pivot) {
			quickSort(left + 1, end);	
		}
	}
}
