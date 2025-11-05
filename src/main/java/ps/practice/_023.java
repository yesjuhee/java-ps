package ps.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _023 {

    public static void main(String[] args) throws IOException {
        new _023().solution();
    }

    private void solution() throws IOException {
        // 그래프는 양 방향 연결
        // 모든 그래프 탐색
        // 탐색 지점 개수 == 연결 요소 개수
        int solution = 0;

        // n, m 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int n = Integer.parseInt(line.split(" ")[0]);
        int m = Integer.parseInt(line.split(" ")[1]);
        boolean[][] graph = new boolean[n + 1][n + 1];
        // 연결리스트로 그래프 표현하는 방법을 모르겠음. 일단 2차원 블린으로 표현.

        // 간선이 0개일 경우 early return 
        if (m == 0) {
            System.out.println(n);
            return;
        }

        // m 개 간선 입력
        for (int i = 0; i < m; i++) {
            String edgeLine = br.readLine();
            int u = Integer.parseInt(edgeLine.split(" ")[0]);
            int v = Integer.parseInt(edgeLine.split(" ")[1]);
            graph[u][v] = true;
            graph[v][u] = true; // 양방향 연결 그래프
        }

        // 방문 여부 체크
        boolean[] visited = new boolean[n + 1];

        // n 개 노드 순회 & 조회
        for (int i = 1; i <= n; i++) {
            if (visited[i] == true) {
                continue;
            }
            visite(i, visited, graph, n);
            solution++;
        }

        System.out.println(solution);
    }

    private void visite(int currentNode, boolean[] visited, boolean[][] graph, int n) {
        if (visited[currentNode]) {
            return;
        }
        visited[currentNode] = true;

        // 인접 노드들 방문
        boolean[] adjacentNodes = graph[currentNode];
        for (int i = 1; i <= n; i++) {
            // 연결 여부 확인
            if (adjacentNodes[i] == false) {
                continue;
            }
            // 연결 노드 방문
            visite(i, visited, graph, n);
        }
    }
}
