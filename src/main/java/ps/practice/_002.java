package ps.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _002 {
    public static void main(String[] args) throws IOException{
        new _002().solution();
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String input = br.readLine();
        String[] inputs = input.split(" ");
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(inputs[i]);
        }

        int max = numbers[0];
        for (int i = 0; i < n; i++) {
            if (max < numbers[i]) {
                max = numbers[i];
            }
        }

        double[] doubles = new double[n];
        for (int i = 0; i < n; i++) {
            doubles[i] = (double) numbers[i] / max;
        }

        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += doubles[i];
        }

        System.out.println(sum / n * 100);
    }
}
