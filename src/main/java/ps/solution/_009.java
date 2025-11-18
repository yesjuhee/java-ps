package ps.solution;

import java.io.*;
import java.util.*;

public class _009 {

	private int s;
	private int p;
	private int mins[] = new int[4]; // 최소 값 조건
	private int myArr[] = new int[4]; // 현재 상태 저장
	private char[] dna;
	private int checkSecret; // 최소값을 만족하는 염기서열 개수 카운트

	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		new _009().solution();
	}

	private void solution() throws IOException {
		// 입력
		var st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());

		dna = br.readLine().toCharArray();
		int result = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			mins[i] = Integer.parseInt(st.nextToken());
			if (mins[i] == 0) {
				checkSecret++; // 최소 조건이 없음
			}
		}

		// 초기 문자열 처리
		for (int i = 0; i < p; i++) {
			add(dna[i]); // p개 만큼 push
		}
		if (checkSecret == 4) { // 4개 서열 다 만족하는지 확인
			result++;
		}

		// 나머지는 슬라이딩 윈도우 처리
		for (int p1 = 0, p2 = p - 1; p2 < s - 1; p1++, p2++) {
			remove(dna[p1]); // 맨 앞에 제거
			add(dna[p2 + 1]); // 그 다음 추가
			if (checkSecret == 4) { // 4개 서열 다 만족하는지 호가인
				result++;
			}
		}

		System.out.println(result);
		br.close();
	}

	private void add(char c) { // 새로 들어온 문자를 처리하는 함수
		switch(c) {
		case 'A':
			myArr[0]++;
			if (myArr[0] == mins[0]) checkSecret++;
			break;
		case 'C':
			myArr[1]++;
			if (myArr[1] == mins[1]) checkSecret++;
			break;
		case 'G':
			myArr[2]++;
			if (myArr[2] == mins[2]) checkSecret++;
			break;
		case 'T':
			myArr[3]++;
			if (myArr[3] == mins[3]) checkSecret++;
			break;
		}
	}

	private void remove(char c) { // 제거되는 문자를 처리하는 함수
		switch(c) {
		case 'A':
			if (myArr[0] == mins[0]) checkSecret--; // 기준값보다 적어짐
			myArr[0]--;
			break;
		case 'C':
			if (myArr[1] == mins[1]) checkSecret--;
			myArr[1]--;
			break;
		case 'G':
			if (myArr[2] == mins[2]) checkSecret--;
			myArr[2]--;
			break;
		case 'T':
			if (myArr[3] == mins[3]) checkSecret--;			
			myArr[3]--;
			break;
		}
	}
}
