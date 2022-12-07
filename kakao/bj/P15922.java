package kakao.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P15922 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, cs, ce, s, e, answer;
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		s = -1_111_111_111;
		e = -1_111_111_111;

		while (n--> 0) {
			st = new StringTokenizer(br.readLine());
			cs = Integer.parseInt(st.nextToken());
			ce = Integer.parseInt(st.nextToken());
			if (e < cs) {
				answer += e - s;
				s = cs;
			}
			e = Math.max(e, ce);
		}
		answer += e - s;
		System.out.println(answer);
	}
}
