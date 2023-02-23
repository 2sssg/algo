package extra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P10424 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=  new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static class Pair{int x,y;public Pair(int x, int y) {this.x = x;this.y = y;}}
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
	static int n, k;
	static long MOD = 1000000007;
	public static void main(String[] args) throws IOException {
		long n = Long.parseLong(br.readLine());
		long ans1 = 0;
		long ans2 = 1;
		for (long i = 1; i <= n; ++i) ans1 = (ans1 + ((i * i) % MOD * (i + 1)) % MOD) % MOD;
		for (long i = 2; i <= n; ++i) ans2 = (((ans2 * i) % MOD) * i) % MOD;
		System.out.println(ans1 + " " + ans2);
	}
}
