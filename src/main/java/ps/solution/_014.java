package ps.solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class _014 {

	private int n;
	private PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
		int firstAbs = Math.abs(o1);
		int secondAbs = Math.abs(o2);
		if (firstAbs == secondAbs) {
			return o1 - o2; // 절대 값이 같으면 음수 우선 정렬
		} else {
			return firstAbs - secondAbs;
		}
	});
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		new _014().solution();
	}

	private void solution() throws IOException {
		// 입력
		n = Integer.parseInt(br.readLine());
		var sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			int input = Integer.parseInt(br.readLine());

			// 0이 아닌 경우
			if (input != 0) {
				pq.add(input);
			} else { // 0인 경우
				if (pq.isEmpty()) {
					sb.append("0").append("\n");
				} else {
					sb.append(pq.poll()).append("\n");
				}
			}
		}

		System.out.println(sb);			
	}
}
