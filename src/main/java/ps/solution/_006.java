package ps.solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _006 {

    public static void main(String[] args) throws IOException {
        new _006().solution();
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int answer = 1; // n 하나만 있는 경우 미리 카운트
        int p1 = 1;
        int p2 = 1;
        int sum = 1; // 초기 값 1

        while (p2 != n) {
            if (sum == n) { // 현재 연속 합과 N이 같은 경우
                answer++;    // 정답 카운트
                p2++;
                sum += p2;
            } else if (sum > n) { // 현재 연속 합이 N보다 더 큰 경우
                // p1 이동
                sum -= p1; // 합계에 이동 반영
                p1++;
            } else { // 현재 연속 합이 N 보다 작은 경우
                p2++;
                sum += p2;
            }
        }

        System.out.println(answer);
    }
}
