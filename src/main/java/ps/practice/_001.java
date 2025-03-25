package ps.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _001 {
    public static void main(String[] args) throws IOException {
        new _001().solution();
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String numbers = br.readLine();

        int sum = 0;
        for (int i = 0; i < n; i++) {
            char ch = numbers.charAt(i);
            sum += Integer.parseInt(String.valueOf(ch));
        }

        System.out.print(sum);
    }
}
