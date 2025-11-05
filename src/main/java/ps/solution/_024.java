package ps.solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class _024 {

    private StringBuilder sb = new StringBuilder();
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private int n;

    public static void main(String[] args) throws IOException {
        new _024().solution();
    }

    public void solution() throws IOException {
        n = Integer.parseInt(br.readLine());

        for (int cur : List.of(2, 3, 5, 7)) {
            dfs(cur, 1);
        }

        System.out.println(sb);
    }

    // 현재 숫자에 1, 3, 7, 9 붙여서 검사하는 탐색
    // 트리 구조여서 visited를 체크할 필요는 없음
    public void dfs(int cur, int nth) {
        // 종료 조건: n자리 수에 도달했나?
        if (nth == n) {
            if (isPrime(cur)) {
                sb.append(cur).append("\n");
            }
            return;
        }
        // 그 다음 자리 수 탐색
        for (int a : List.of(1, 3, 7, 9)) {
            // 소수인지 먼저 검사해야지, 시간 복잡도를 확 줄일 수 있음!!
            int next = cur * 10 + a;
            if (isPrime(next)) {
                dfs(next, nth + 1);
            }
        }
    }

    public boolean isPrime(int num) {
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
