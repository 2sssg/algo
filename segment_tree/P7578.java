package segment_tree;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P7578 {
	static int[] arr;
	static HashMap<Integer, Integer> brr;
	static int n, size = 1;
	static long answer;
	static long[] seg;

	static void init() throws IOException {
		n = rn();
		arr = new int[n + 1];
		brr = new HashMap<>();
		for (int i = 1; i <= n; ++i) arr[i] = rstn();
		for (int i = 1; i <= n; ++i) brr.put(rstn(), i);
		while (n > size) size *= 2;
		seg = new long[size * 2];
	}

	static void update(int s, int e, int node, int idx) {
		if (idx < s || e < idx) return ;
		seg[node]++;
		if (s == e) return ;
		int mid = (s + e) >> 1;
		update(s, mid, node * 2, idx);
		update(mid + 1, e, node * 2 + 1, idx);
	}

	static long query(int s, int e, int node, int l, int r) {
		if (l > r) return 0;
		if (r < s || e < l) return 0;
		if (l <= s && e <= r) return seg[node];
		int mid = (s + e) >> 1;
		return query(s, mid, node * 2, l, r) + query(mid + 1, e, node * 2 + 1, l, r);
	}


	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
		for (int i = 1; i <= n; ++i) {
			int item = arr[i];
			int idx = brr.get(item);
			update(1, n, 1, idx);
			answer += query(1, n, 1, idx + 1, n);
		}
		System.out.println(answer);

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
