package sequence_and_query;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SequenceAndQuery16 {
	static int n, m, h;
	static int[] arr;
	static int[] tree;

	static void init() throws IOException {
		n = rn();
		arr = new int[n + 1];
		h = (int)Math.ceil(Math.log(n) / Math.log(2)) + 1;
		tree = new int[1 << h];

		for (int i = 1; i <= n; ++i) arr[i] = rstn();
		m = rn();
	}

	static void treeinit(int start, int end, int node) {
		if (start == end) tree[node] = start;
		else {
			int mid = (start + end) >> 1;
			treeinit(start, mid, node * 2);
			treeinit(mid + 1, end, node * 2 + 1);
			if (arr[tree[node * 2]] > arr[tree[node * 2 + 1]]) {
				tree[node] = tree[node * 2 + 1];
			} else {
				tree[node] = tree[node * 2];
			}
		}
	}

	static void update(int start, int end, int node, int idx) {
		if (idx < start || end < idx) return ;
		if (start == end) return ;
		int mid = (start + end) >> 1;
		update (start, mid, node * 2, idx);
		update (mid + 1, end, node * 2 + 1, idx);
		if (arr[tree[node * 2]] > arr[tree[node * 2 + 1]]) {
			tree[node] = tree[node * 2 + 1];
		} else {
			tree[node] = tree[node * 2];
		}
	}

	public static int query(int start, int end, int node, int left, int right) {
		if (left > end || right < start) return -1;
		if (left <= start && end <= right) return tree[node];
		int mid = (start + end) / 2;
		int m1 = query(start, mid, node * 2, left, right);
		int m2 = query(mid + 1, end, node * 2 + 1, left, right);

		if (m1 == -1) return m2;
		else if (m2 == -1) return m1;
		else {
			if (arr[m1] <= arr[m2]) return m1;
			else return m2;
		}
	}

	public static void main(String... args) throws IOException {
		br = Source.getBufferedReader();
		init();
		treeinit(1, n, 1);
		while (m-- > 0) {
			int type = rstn();
			if (type == 1) {
				int i = rstn(), v = rstn();
				arr[i] = v;
				update(1, n, 1, i);
			} else {
				int i = rstn(), j = rstn();
				sb.append(query(1, n, 1, i, j)).append('\n');
			}
		}
		System.out.println(sb);
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
