package ps.practice;

import java.io.*;
import java.util.*;

class _017 {

	public static void main(String[] args) throws IOException {
		new _017().solution();
	}

	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		char[] arr = s.toCharArray();

		// 선택 정렬
		Arrays.sort(arr);

		// 출력
		StringBuilder sb = new StringBuilder();
		for(int i = arr.length - 1; i >= 0; i--) {
			sb.append(arr[i]);
		}
		System.out.println(sb);
	}
}
