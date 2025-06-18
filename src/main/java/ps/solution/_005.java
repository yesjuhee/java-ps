package ps.solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _005 {

    public static void main(String[] args) throws IOException {
        new _005().solution();
    }

    public void solution() throws IOException {
        // n, m 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] sum = new long[n]; // 구간 합 배열
        long[] counts = new long[m]; // m 으로 나눈 나머지에 따라 카운트 하는 배열 (0 ~ m-1)

        // 수열 합 배열 만들기
        st = new StringTokenizer(br.readLine());
        sum[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            sum[i] = sum[i - 1] + num;
        }

        // 합 배열의 모든 값에 나머지 연산 수행
        long answer = 0;
        for (int i = 0; i < n; i++) {
            int remainder = (int) (sum[i] % m);
            // 구간 합 자체의 나머지가 0 인 경우 따로 카운트
            if (remainder == 0) {
                answer++;
            }
            counts[remainder]++;
        }
        for (int i = 0; i < m; i++) {
            if (counts[i] > 1) {
                answer = answer + (counts[i] * (counts[i] - 1) / 2); // n 개의 배열 합 중 1개 뽑기
            }
        }
        System.out.println(answer);
    }
}
