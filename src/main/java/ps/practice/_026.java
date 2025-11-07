package ps.practice;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class _026 {

	private int n;
	private int m;
	private int v;
	private List<Integer>[] adj;
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		new _026().solution();
	}

	private void solution() throws IOException {
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());

		// 인접리스트 초기화
		adj = new ArrayList[n + 1];
		for (int i = 1; i < n + 1; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a].add(b);
			adj[b].add(a);
		}

		// DFS 수행
		boolean[] visited = new boolean[n + 1];
		dfs(v, visited);

		// BFS 수행
		sb.append("\n");
		bfs(v);

		// 출력
		System.out.println(sb);
	}

	private void dfs(int cur, boolean[] visited) {
		if (visited[cur]) return;
		visited[cur] = true;
		sb.append(cur).append(" ");

		// 번호가 작은 것 부터 방문
		List<Integer> nexts = adj[cur].stream().sorted().collect(Collectors.toList());
		for (int next: nexts) {
			dfs(next, visited);
		}
	}

	private void bfs(int start) {
		boolean[] visited = new boolean[n + 1];

		// 시작 노드 enqueue
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = true;

		while(!q.isEmpty()) {
			// 노드 방문
			int cur = q.poll();
			sb.append(cur).append(" ");
			
			// 인접 노드 enqueue, 작은 것 부터
			List<Integer> nexts = adj[cur].stream().sorted().collect(Collectors.toList());
			for (int next: nexts) {
				if (visited[next]) continue;
				q.add(next);
				visited[next] = true;
			}
		}
	}
}
