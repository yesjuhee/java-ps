package ps.practice;

import java.io.*;
import java.util.*;

public class _027 {

	private int n;
	private int m;
	private boolean[][] map;
	private boolean[][] visited;
	private int answer;
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private int[] dx = {1, -1, 0, 0};
	private int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
		new _027().solution();
	}

	private void solution() throws IOException {
		// 입력
		var st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		// 맵 초기화
		map = new boolean[n + 1][m + 1];
		visited = new boolean[n + 1][m + 1];		
		for (int i = 1; i < n + 1; i++) {
			String line = br.readLine();
			for (int j = 1; j < m + 1; j++) {
				char node = line.charAt(j - 1);
				// System.out.println("node: " + node);
				if (node == '1') {
					map[i][j] = true;
				}
			}
		}

		// 탐색
		Queue<Integer> qx = new LinkedList<>();
		Queue<Integer> qy = new LinkedList<>();
		Queue<Integer> qdepth = new LinkedList<>(); // 해당 좌표의 dpeth
		qx.add(1);
		qy.add(1);
		qdepth.add(1);
		visited[1][1] = true;

		while(true) {
			// 좌표 하나 꺼내기
			int x = qx.poll();
			int y = qy.poll();
			int depth = qdepth.poll();

			if (x == n && y == m) {
				answer = depth;
				break;
			}

			// 상하좌우 탐색 -> 상하좌우가 아니라 오른쪽 아래 대각선으로만 탐색해야함
			int ndepth = depth + 1;
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx >= 1 && nx <= n && ny >= 1 && ny <= m && map[nx][ny] && !visited[nx][ny] ) { // 길이 있는 경우
					qx.add(nx);
					qy.add(ny);
					qdepth.add(ndepth);
					visited[nx][ny] = true;
				}
			}
		}

		System.out.println(answer);
	}
}
