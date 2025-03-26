package ps.solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _002 {
    public static void main(String[] args) throws IOException {
        new _002().solution();
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String input = br.readLine();
        int[] numbers = new int[n];
        String[] inputs = input.split(" ");
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(inputs[i]);
        }

        int sum = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (max < numbers[i]) {
                max = numbers[i];
            }
            sum += numbers[i];
        }

        System.out.println((double) sum * 100 / n / max);
    }
}
