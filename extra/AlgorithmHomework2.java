package extra;

import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class AlgorithmHomework2 {
	static int n,a,b;
	static BigInteger[] dp = new BigInteger[10_005];

	public static void main(String[] args) throws IOException {
		n = rstn(); a = rstn(); b = rstn();
		dp[0] = BigInteger.ZERO;
		dp[1] = BigInteger.valueOf(1); dp[a] = BigInteger.ZERO; dp[b] = BigInteger.ZERO;
		dp[2] = dp[1].add(BigInteger.ONE); dp[a] = BigInteger.ZERO; dp[b] = BigInteger.ZERO;
		for (int i = 3; i <= n; ++i) {
			if (i == a || i == b) continue;
			dp[i] = dp[i - 1].add(dp[i - 2]);
		}
		System.out.println(dp[n]);
	}

/////////////////////////////////////////////////////////////////
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
	static int[] ra() throws IOException {return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();}
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static boolean chk(int x, int y, int n, int m){return x<0 || y<0 || x>=n || y>=m;}
	static class Pair{int x,y;public Pair(int x, int y) {this.x = x;this.y = y;}}
	static class Triple{ int x,y,z;public Triple(int x, int y,int z) {this.x = x;this.y = y;this.z = z;}}
	static class Quad{ int w,x,y,z;public Quad(int w, int x, int y,int z) {this.w = w; this.x = x;this.y = y;this.z = z;}}
}
