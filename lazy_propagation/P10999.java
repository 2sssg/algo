package lazy_propagation;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P10999 {
	static int n, m, k;
	static long[] arr, tree, lazy;
	static void init() throws IOException {
		n = rstn(); m = rstn(); k = rstn();
		arr = new long[n + 1];
		tree = new long[n * 4];
		lazy = new long[n * 4];

		for (int i = 1; i <= n; ++i) arr[i] = Long.parseLong(br.readLine());
	}

	static long treeInit(int start, int end, int node) {
		if (start == end) return tree[node] = arr[start];
		int mid = (start + end) >> 1;
		return tree[node] = treeInit(start, mid, node * 2) + treeInit(mid + 1, end, node * 2 + 1);
	}
	static void propagate(int start, int end, int node) {
		if (lazy[node] == 0) return ;
		if (start != end) {
			lazy[node * 2] += lazy[node];
			lazy[node * 2 + 1] += lazy[node];
		}
		tree[node] += lazy[node] * (end - start + 1);
		lazy[node] = 0;
	}
	static void update(int start, int end, int node, int left, int right, long diff) {
		propagate(start, end, node);
		if(end < left || right < start) return;
		if(left <= start && end <= right) {
			lazy[node] = diff;
			propagate(start, end, node);
			return;
		}

		int mid = (start+end) >> 1;
		update(start, mid, node*2, left, right, diff);
		update(mid+1, end, node*2+1, left, right, diff);
		tree[node] = tree[node*2]+tree[node*2+1];
	}

	static long query(int start, int end, int node, int left, int right) {
		propagate(start, end, node);
		if(end < left || right < start) return 0;
		if(left <= start && end <= right) return tree[node];
		int mid = (start+end)/2;
		return query(start, mid, node*2, left, right) + query(mid+1, end, node*2+1, left, right);
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
		treeInit(1, n, 1);
		for (int i = 0; i < m + k; ++i) {
			int type = rstn();
			int left = rstn();
			int right = rstn();
			if (type == 1) {
				long diff = Long.parseLong(st.nextToken());
				update(1, n, 1, left, right, diff);
			} else {
				sb.append(query(1, n, 1, left, right)).append("\n");
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
