package ps.practice;

import java.io.*;
import java.util.*;

public class _012 {

    private int n;
    private Deque<Integer> dq = new ArrayDeque<>();
    private Deque<Integer> tmp = new ArrayDeque<>();
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        new _012().solution();
    }

    public void solution() throws IOException {
        // 입력
        n = Integer.parseInt(br.readLine());
        var st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            dq.addLast(Integer.parseInt(st.nextToken()));
        }

        // 오큰수 구하기
        for (int i = 0; i < n; i++) {
            int a = dq.removeFirst(); // i번째 수

            // 자기보다 큰 수 찾기
            while(!dq.isEmpty() && dq.getFirst() <= a) { // 자기보다 큰 수 발견할 때 까지 pop
                tmp.addLast(dq.removeFirst());
            }

            // 큰 수 확인
            if (dq.isEmpty()) {
                sb.append("-1").append(" ");
            } else {
                sb.append(dq.getFirst()).append(" ");
            }

            // pop 했던 것 그대로 다시 push
            while(!tmp.isEmpty()) {
                dq.addFirst(tmp.removeLast());
            }
        }

        // 출력
        System.out.println(sb);
    }
}
