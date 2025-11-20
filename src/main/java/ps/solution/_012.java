package ps.solution;

import java.io.*;
import java.util.*;

public class _012 {

    private int n;
    private Deque<Node> stack = new ArrayDeque<>();
    private int[] result;
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static class Node {

        int i; // index
        int v; // value        

        public Node(int i, int v) {
            this.i = i;
            this.v = v;
        }
    }

    public static void main(String[] args) throws IOException {
        new _012().solution();
    }

    public void solution() throws IOException {
        // 입력
        n = Integer.parseInt(br.readLine());        
        var st = new StringTokenizer(br.readLine());

        result = new int[n];        
        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(st.nextToken()); // 입력 값
            Node cur = new Node(i, v);

            // 스택의 위에서부터 비교
            while (!stack.isEmpty()) {
                Node prev = stack.pop();
                if (prev.v < cur.v) { // cur가 prev의 오큰수라면
                    result[prev.i] = cur.v; // 결과 기록, 그 다음 것 도 비교
                } else { // prev.v >= cur.v -> 오큰수가 아니라면, 다시 push하고 비교 끝
                    stack.push(prev);
                    break;
                }
            }

            // 현재 값 push
            stack.push(cur);
        }

        // 스택에 남아 있는 값 (오큰수 못찾은 값) -> -1로 기록
        while(!stack.isEmpty()) {
            Node now = stack.pop();
            result[now.i] = -1;
        }

        // result 배열 출력
        var sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb);
    }
}
