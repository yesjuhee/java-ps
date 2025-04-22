package ps.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _003 {

    public static void main(String[] args) throws IOException {
        new _003().solution();
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        int[] numberSum = new int[n + 1];
        numberSum[0] = 0;
        int[] numbers = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int i = 1; i <= n; i++) {
            numberSum[i] = numberSum[i - 1] + numbers[i - 1];
        }

        for (int i = 0; i < m; i++) {
            String[] split2 = br.readLine().split(" ");
            int a = Integer.parseInt(split2[0]);
            int b = Integer.parseInt(split2[1]);
            System.out.println(numberSum[b] - numberSum[a - 1]);
        }
    }
}
