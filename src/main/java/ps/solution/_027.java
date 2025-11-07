package ps.solution;

import java.io.*;
import java.util.*;

public class _027 {

    private int n, m;
    private int[][] map;
    private boolean[][] visited;

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
        visited = new boolean[n + 1][m + 1];
        map = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 1; j < m + 1; j++) {
                map[i][j] = Integer.parseInt(line.substring(j - 1, j));
            }
        }

        // 탐색
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 1});
        visited[1][1] = true;

        while(!q.isEmpty()) {
            int cur[] = q.poll();
            for (int i = 0; i < 4; i++) {
                int x = cur[0] + dx[i];
                int y = cur[1] + dy[i];
                if (x < 1 || y < 1 || x > n || y > m) continue; // 범위 체크
                if (map[x][y] == 0 || visited[x][y]) continue; // 갈 수 있는지 체크
                map[x][y] = map[cur[0]][cur[1]] + 1; // 깊이 업데이트
                visited[x][y] = true;
                q.add(new int[]{x, y});
            }
        }

        System.out.println(map[n][m]);
    }
}
