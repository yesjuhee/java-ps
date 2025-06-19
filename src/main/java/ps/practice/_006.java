package ps.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _006 {

    public static void main(String[] args) throws IOException {
        new _006().solution();
    }

    public void solution() throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int answer = 0;
        for (int p1 = 1; p1 <= n; p1++) {
            int sum = 0;
            for (int p2 = p1; p2 <= n; p2++) {
                sum += p2; // 부분 합 계산
                if (sum == n) { // 연속된 자연수의 합으로 계산 됨
                    answer++;
                    break; // p1 변경
                } else if (sum > n) { // 초과해버림
                    break; // p1 변경
                }
            }
        }

        System.out.println(answer);
    }
}
