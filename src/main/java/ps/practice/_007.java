package ps.practice;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class _007 {

	private int n;
	private int m;
	private List<Integer> nums = new ArrayList<>();
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		new _007().solution();
	}

	private void solution() throws IOException {
		// 입력
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		var st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums.add(Integer.parseInt(st.nextToken()));
		}

		// 고유 번호 정렬
		nums = nums.stream().sorted().collect(Collectors.toList());

		// 투 포인터
		int p1 = 0;
		int p2 = n - 1;

		// 탐색
		int answer = 0;
		while(p1 < p2) {
			int v1 = nums.get(p1); // p1이 가리키는 값
			int v2 = nums.get(p2); // p2가 가리키는 값
			
			if (v1 + v2 == m) { // 답을 찾은 경우
				answer++;
				p1++; // 그 다음 포인터
				p2--;
			} else if (v1 + v2 < m) { // v2 가 작은 경우 -> 답을 찾을 수 없음
				p1++;
			} else { // v1 + v2 > m
				p2--;
			}
		}

		System.out.println(answer);
	}
}
