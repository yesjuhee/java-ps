package ps.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _004 {

    public static void main(String[] args) throws IOException {
        new _004().solution();
    }

    public void solution() throws IOException {
        // 그냥 구하기 -> N * N * M = 10^3 * 10^3 * 10^5 = 10 ^ 11 -> 100억
        // 한 열의 구간 합 이용 -> N * M = 10 ^ 8 -> 1억

        // n, m 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 2차원 구간합 배열 초기화
        int[][] numberSum = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            numberSum[0][i] = 0;
            numberSum[i][0] = 0;
        }

        // 표 입력
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {
                numberSum[i][j] = numberSum[i][j - 1] + Integer.parseInt(st.nextToken()); // 해당 행에서의 구간 합
            }
        }

        // 질의
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            // 입력
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            // 출력
            int sum = 0;
            for (int x = x1; x < x2 + 1; x++) {
                sum += (numberSum[x][y2] - numberSum[x][y1 - 1]);
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
