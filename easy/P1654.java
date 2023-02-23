package easy;

import java.io.*;
import java.util.*;

public class P1654 {
	static int n, m;
	static long[] arr;

	static long f(long mid) {
		long ans = 0;
		for (long temp : arr) ans += (temp / mid);
		return ans;
	}

	public static void main(String[] args) throws IOException {
		n = rstn(); m = rstn();
		arr = new long[n];
		for (int i = 0; i < n; ++i) arr[i] = rn();

		long lo = 0, hi = min(arr) + 1;
		while (lo + 1 < hi) {
			long mid = (lo + hi) >> 1;
			if (f(mid) < m) hi = mid;
			else lo = mid;
		}
		System.out.println(lo);
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
	static long min(long... temp) {return Arrays.stream(temp).min().getAsLong();}
}
