package kakao.hacker_rank.strictly_increasing_sequence;

import java.io.*;
import java.util.*;

public class Solution {
	static int t,n, cnt;
	static int[] arr, dp;

	static void init() throws IOException {
		n = rn(); arr = ra();
		dp = new int[n + 1];
		cnt = 1;
	}

	public static void main(String[] args) throws IOException {
		t = rn();
		while (t-->0) {
			init();
			for (int i = 0; i < n; ++i) {
				if (i == 0) dp[i + 1] = 1;
				for (int j = i - 1; j >= 0; --j) {
					if (arr[j] < arr[i]) {
						dp[i + 1] = dp[j + 1] + 1;
						cnt = Math.max(cnt, dp[i + 1]);
						break;
					}
					dp[i + 1] = 1;
				}
			}
			bw.append(((n - cnt) & 1) == 1 ? "Second\n" : "First\n");
		}
		bw.flush();
	}
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