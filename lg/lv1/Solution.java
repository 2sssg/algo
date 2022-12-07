package lg.lv1;

import java.util.Arrays;

public class Solution {

	int n, sum, useMarbles, differ = Integer.MAX_VALUE, w;
	int[] marbles, answer;
	int[] arr;
	boolean[] use;

	public int chk(int max) {
		// flag = true ==> 공 위에
		// flag = false ==> 공 사이에
		int flag = 0;
		int left = arr[0];
		int tempsum = Arrays.stream(arr).sum();
		for (int i = 1; i < max; ) {
			if (left * 2 > tempsum) return -1;
			if (flag == 0 && left * 2 == tempsum) {
				return Math.abs(max - i - i);
			} else if (flag == 1 && left == ((double)tempsum - arr[i]) / 2) {
				return Math.abs(max - i - i - 1);
			}
			if (flag == 1) {
				left += arr[i];
				i++;
			}
			flag ^= 1;
		}
		return -1;
	}

	public void f(int depth, int max) {
		if (depth == max) {
			System.out.println(Arrays.toString(arr));
			int chkret = chk(max);
			if (chkret != -1) {
				if (differ > chkret) {
					differ = chkret;
					answer = arr.clone();
					useMarbles = max;
					w = Arrays.stream(arr).sum();
				} else if (differ == chkret) {
					if (useMarbles < max) {
						useMarbles = max;
						w = Arrays.stream(arr).sum();
						answer = arr.clone();
					} else if (useMarbles == max) {
						if (w < Arrays.stream(arr).sum()) {
							w = Arrays.stream(arr).sum();
							answer = arr.clone();
						}
					}
				}
			}
			return;
		}
		for (int i = 0; i < n; ++i) {
			if (use[i]) continue;
			use[i] = true;
			arr[depth] = marbles[i];
			f(depth + 1, max);
			use[i] = false;
		}
	}

	public int[] solution(int[] m) {

		marbles = m.clone();
		Arrays.sort(marbles);
		sum = Arrays.stream(marbles).sum();
		n = marbles.length;
		use = new boolean[n];

		for (int i = marbles.length; i >= 1; --i) {
			Arrays.fill(use, false);
			arr = new int[i];
			f(0, i);
		}
		return answer!=null?answer:new int[]{Arrays.stream(marbles).max().getAsInt()};
	}
}
