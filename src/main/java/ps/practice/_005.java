package ps.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _005 {

    public static void main(String[] args) throws IOException {
        new _005().solution();
    }

    public void solution() throws IOException {
        // 구간 합이 M으로 나누어 떨어지는 (i,j) 쌍의 개수

        // n, m 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] sum = new long[n + 1]; // 구간 합 배열
        long[] counts = new long[m]; // m 으로 나눈 나머지에 따라 카운트 하는 배열 (0 ~ m-1)

        // N 개의 수 입력, 구간 합 & 카운트 -> O(n)
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(st.nextToken());
            sum[i] = sum[i - 1] + num;
            counts[(int) (sum[i] % m)]++;
        }
        counts[0]++;

        // 각 카운트에 따라서 등차수열 계산 -> O(m)
        long result = 0;
        for (long count : counts) {
            if (count == 0 || count == 1) {
                continue;
            }
            result += (count * (count - 1) / 2);
        }
        System.out.println(result);
    }
}
