package offline_query;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class P16978 {
	static int n, m, secondQueryCount;
	static long[] arr, segtree;
	static Queue<Pair> q;
	static PriorityQueue<Quad> pq;
	static void init() throws IOException {
		q = new ArrayDeque<>();
		pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.x));

		n = rn();
		arr = new long[n + 1];
		segtree = new long[4 * n];
		for (int i = 1; i <= n; ++i) arr[i] = rstn();
		m = rn();
		secondQueryCount = 0;
		for (int i = 0; i < m; ++i) {
			int type = rstn();
			if (type == 1) q.add(new Pair(rstn(), rstn()));
			else pq.add(new Quad(secondQueryCount++, rstn(), rstn(), rstn()));
		}
	}
	static long seginit(int start, int end, int node) {
		if (start == end) return segtree[node] = arr[start];
		int mid = (start + end) >> 1;
		return segtree[node] = seginit(start, mid, node * 2) + seginit(mid + 1, end, node * 2 + 1);
	}

	static void update(int start, int end, int node, int idx, long diff) {
		if (start > idx || end < idx) return ;
		segtree[node] += diff;
		if (start == end) return ;
		int mid = (start + end) >> 1;
		update(start, mid, node * 2, idx, diff);
		update(mid + 1, end, node * 2 + 1, idx, diff);
	}


	static long find(int start, int end, int node, int left, int right) {
		if (start > right || end < left) return 0;
		if (left <= start && end <= right) return segtree[node];
		int mid = (start + end) >> 1;
		return find(start, mid, node * 2, left, right) + find(mid + 1, end, node * 2 + 1, left, right);
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
		seginit(1, n, 1);
		long[] answer = new long[secondQueryCount];
		int queryCount = 0;
		while (!pq.isEmpty()) {
			Quad query = pq.poll();
			while (query.x > queryCount) {
				queryCount++;
				Pair updateQuery = q.poll();
				long diff = updateQuery.y - arr[updateQuery.x];
				arr[updateQuery.x] = updateQuery.y;
				update(1, n, 1, updateQuery.x, diff);
			}
			answer[query.w] = find(1, n, 1, query.y, query.z);
		}
		for (long ans : answer) sb.append(ans).append("\n");
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
