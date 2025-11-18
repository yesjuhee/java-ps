package ps.practice;

import java.io.*;
import java.util.*;

public class _009 {

	private int s;
	private int p;
	private int[][] numberSum;
	private char[] dna;
	private int[] mins = new int[4]; // A, C, G, T 의 최수 개수
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		new _009().solution();
	}

	private void solution() throws IOException {
		// 입력
		var st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		
		var line = br.readLine();
		dna = line.toCharArray(); // char 배열로 읽기
		numberSum = new int[s + 1][4]; // s 길이 만큼, A,C,G,T 각각의 sum
		for (int i = 1; i < s + 1; i++) {
			char v = dna[i - 1];
			if (v == 'A') {
				numberSum[i][0] = numberSum[i - 1][0] + 1;
				numberSum[i][1] = numberSum[i - 1][1];
				numberSum[i][2] = numberSum[i - 1][2];
				numberSum[i][3] = numberSum[i - 1][3];
			} else if (v == 'C') {
				numberSum[i][0] = numberSum[i - 1][0];
				numberSum[i][1] = numberSum[i - 1][1] + 1;
				numberSum[i][2] = numberSum[i - 1][2];
				numberSum[i][3] = numberSum[i - 1][3];
			} else if (v == 'G') {
				numberSum[i][0] = numberSum[i - 1][0];
				numberSum[i][1] = numberSum[i - 1][1];
				numberSum[i][2] = numberSum[i - 1][2] + 1;
				numberSum[i][3] = numberSum[i - 1][3];
			} else {
				numberSum[i][0] = numberSum[i - 1][0];
				numberSum[i][1] = numberSum[i - 1][1];
				numberSum[i][2] = numberSum[i - 1][2];
				numberSum[i][3] = numberSum[i - 1][3] + 1;
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			mins[i] = Integer.parseInt(st.nextToken());
		}

		// 슬라이딩
		int cnt = 0;
		for (int p1 = 1, p2 = p; p2 <= s; p1++, p2++) {
			if (isOk(p1, p2)) {
				cnt++;
			}
		}

		System.out.println(cnt);
	}

	private boolean isOk(int p1, int p2) {
		for (int i = 0; i < 4; i++) { // A, C, G, T 차례로
			int cnt = numberSum[p2][i] - numberSum[p1 - 1][i]; // 부분 문자열 내의 개수
			if (cnt < mins[i]) {
				return false;
			}
		}
		return true;
	}
}
