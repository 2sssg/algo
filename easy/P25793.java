package easy;
import java.io.*;
import java.util.*;

public class P25793 {
	static int t, r, c;
	public static void main(String[] args) throws IOException {
		t = rn();
		while (t-- > 0) {
			r = rstn(); c = rstn();
			if (r > c) c = swap(r, r = c);
			long n = r;
			long d = c - r;
			sb.append(2 * ff(n) - (2 * f(n)) + n + d * (r + 2 * f(r - 1)))
					.append(" ")
					.append(2 * (ff(n) - f(n)) + d * (r + 2 * f(r - 1)))
					.append("\n");
		}
		System.out.println(sb);
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	private static int swap(int localA, int localB) {return localA;}
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
	static long f(long n) {return (1 + n) * n / 2;}
	static long ff(long n) {return n * (n + 1) * (2 * n + 1) / 6;}
}
