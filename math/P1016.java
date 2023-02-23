package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1016 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static long lo,hi;
	static boolean[] chk;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		lo = Long.parseLong(st.nextToken());
		hi = Long.parseLong(st.nextToken());
		chk = new boolean[(int)(hi - lo) + 1];
		long ans = hi - lo + 1;
		for (long i = 2; i * i <= hi; ++i) {
			long sNum = (long)Math.ceil((double)lo / (i * i));
			while (sNum * (i * i) <= hi) {
				if (!chk[(int)(sNum * (i * i) - lo)]) {
					chk[(int)(sNum * (i * i) - lo)] = true;
					ans -= 1;
				}
				sNum += 1;
			}
		}
		System.out.println(ans);
	}
}
