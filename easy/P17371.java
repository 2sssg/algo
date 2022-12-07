package easy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P17371 {
	static int n, ans;
	static double d = Integer.MAX_VALUE;
	static int[][] p = new int[1001][2];
	public static void main(String[] args) throws IOException {
		n = rn();
		for (int i = 0; i < n; ++i) {
			p[i][0] = rstn();
			p[i][1] = rstn();
		}

		for (int i = 0; i < n; ++i) {
			double temp = 0;
			for (int j = 0; j < n; ++j) {
				if (i == j) continue;
				double cur = dist(p[i][0], p[i][1], p[j][0], p[j][1]);
				temp = Math.max(cur, temp);
			}
			if (temp < d) {
				d = temp;
				ans = i;
			}
		}

		System.out.println(p[ans][0] + " " + p[ans][1]);

	}

	private static double dist(int i, int i1, int i2, int i3) {
		return Math.sqrt(((i - i2) * (i - i2) + (i1 - i3) * (i1 - i3)));
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	private static int swap(int localA, int localB) {return localA;}
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
