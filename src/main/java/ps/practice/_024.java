package ps.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class _024 {

    private int n;
    private List<Integer> first = List.of(2, 3, 5, 7);
    private List<Integer> second = List.of(23, 29, 31, 37, 53, 59, 71, 73, 79); // 1, 3, 7, 9

    public static void main(String[] args) throws IOException {
        new _024().solution();
    }

    public void solution() throws IOException {
        // nlogn 시간복잡도

        // 한 자리 소수
        // 2, 3, 5, 7 -> 이 4가지 숫자로 시작하는 것 밖에 안됨

        // 두 자리 소수
        // 2 -> 23, 29
        // 3 -> 31, 37
        // 5 -> 53, 59
        // 7 -> 71, 73, 79

        // 세 자리 소수
        // 23 ->

        // 한 자리 소수 구하기 -> 1 - 9 사이의 소수
        // 두 자리 소수 구하기 -> 앞에서 구한 것으로 시작하는 숫자 중, 1-9 사이의 소수
        // 앞에서 구한 것 * 10 + 1 ~ 9(홀수만) => 이렇게 해보고, 소수인지 여부만 판단하기

        // n 입력
        var br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        if (n == 1) {
            for (int num : first) {
                sb.append(num).append("\n");
            }
            System.out.println(sb);
            return;
        }
        if (n == 2) {
            for (int num : second) {
                sb.append(num).append("\n");
            }
            System.out.println(sb);
            return;
        }

        // n == 3 일 때
        List<Integer> adds = List.of(1, 3, 7, 9);
        for (int i = 0; i < second.size(); i++) {
            // 숫자 하나 꺼내오기
            int num = second.get(i);
            // 하나씩 순회
            for (int add : adds) {
                int newNum = num * 10 + add; // n 자리 수 소수의 후보들

            }
        }

    }
}
