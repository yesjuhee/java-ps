package ps.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _025 {

    private int n;
    private int m;
    private List<Integer>[] A;
    private boolean[] visited;
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private boolean flag = false;

    public static void main(String[] args) throws IOException {
        new _025().solution();
    }

    public void solution() throws IOException {
        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        A = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            A[i] = new ArrayList<>();
        }

        // 간선 초기화
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            A[u].add(v);
            A[v].add(u);
        }

        // dfs 실행
        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            dfs(i, 1);
            if (flag) {
            	System.out.println(1);
            	return;
            }
        }

        System.out.println(0);
    }

    public void dfs(int cur, int depth) { // 현재 노드, depth
		if (visited[cur]) {
			return;
		}
        visited[cur] = true;

        if (depth == 5) { // 종료 조건
            flag = true;
            return;
        }

        // 다음 노드 탐색
        for (int next : A[cur]) {
            dfs(next, depth + 1);
        }
    }
}
