package koala.preparation.week1.bruteforce;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P13423 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int t, n, answer;
	static int[] arr, use = new int[3];
	static boolean[] visit;

	static boolean chk(int x1, int x2, int x3) {
		return Math.abs(x2 * 2) == Math.abs(x1 + x3);
	}

	static void f(int depth, int cur) {
		if (depth == 3) {
			if (chk(use[0], use[1], use[2])) {
				answer++;
			}
			return;
		}
		for (int i = cur; i < n; ++i) {
			if (visit[i]) {
				continue;
			}
			visit[i] = true;
			use[depth] = arr[i];
			f(depth + 1, i + 1);
			visit[i] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			answer = 0;
			n = Integer.parseInt(br.readLine());
			arr = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.sorted()
				.toArray();
			visit = new boolean[n];
			f(0,0);
			bw.write(String.valueOf(answer));
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
}
