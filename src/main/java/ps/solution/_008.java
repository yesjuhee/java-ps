package ps.solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _008 {

	private int n;
	private long[] nums;
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		new _008().solution();
	}

	private void solution() throws IOException {
		// 입력
		n = Integer.parseInt(br.readLine());
		nums = new long[n];
		var st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = Long.parseLong(st.nextToken());
		}

		// 정렬
		Arrays.sort(nums);

		// 투 포인터
		int cnt = 0;
		for (int i = 0; i < n; i++) { // n개에 대해서
			long target = nums[i];
			if (isGood(target, i)) {
				cnt++;
			}
		}

		System.out.println(cnt);
	}

	private boolean isGood(long target, int i) {
		int p1 = 0;
		int p2 = n - 1;

		while (p1 < p2) {
			if (p1 == i) { // 자기 자신 제외
				p1++;
				continue;
			}
			if (p2 == i) {
				p2--;
				continue;
			}

			long v1 = nums[p1];
			long v2 = nums[p2];

			if (v1 + v2 == target) {
				return true;
			} else if (v1 + v2 > target) {
				p2--;
				continue;
			} else {
				p1++;
				continue;
			}
		}

		return false;
	}
}
