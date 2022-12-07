package extra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1138 {
	static int n;
	static int[] arr, make;
	static boolean[] use;

	static boolean f(int depth) {

		if (depth == n) {
			for (int i = 0; i < n; ++i) {
				int cnt = 0;
				for (int j = i - 1; j >= 0; --j) {
					if (make[i] < make[j]) cnt++;
					if (cnt > arr[make[i] - 1]) return false;
				}
				if (cnt != arr[make[i] - 1]) return false;
			}
			return true;
		}

		for (int i = 1; i <= n; ++i) {
			if (use[i]) continue;
			make[depth] = i;
			use[i] = true;
			if (f(depth + 1)) return true;
			use[i] = false;
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		n = rn(); arr = ra(); use = new boolean[n + 1]; make = new int[n];
		f(0);
		System.out.println(Arrays.toString(make).replaceAll("[,\\[\\]]", ""));

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
