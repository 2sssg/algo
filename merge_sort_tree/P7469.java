package merge_sort_tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class P7469 {
	static ArrayList<Integer>[] seg;
	static int n, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

	static void update(int idx, int val) {
		while (idx <= n) {
			seg[idx].add(val);
			idx += idx &- idx;
		}
	}

	static int getCntOfOver(ArrayList<Integer> list, int k) {
		int res = Collections.binarySearch(list, k+1);
		if (res < 0) {
			res += 1;
			res = -res;
		}
		return list.size() - res;
	}

	static int prefixSumOfCnt(int idx, int k) {
		int cnt = 0;
		while (idx > 0) {
			cnt += getCntOfOver(seg[idx], k);
			idx -= idx&-idx;
		}
		return cnt;
	}

	static int query(int i, int j, int k) {
		return prefixSumOfCnt(j, k) - prefixSumOfCnt(i-1, k);
	}

	static int getAnswer(int a, int b, int c) {
		c = b - a + 1 - c;
		int start = min;
		int end = max;
		while (start<=end) {
			int mid = (start + end) / 2;
			if (query(a, b, mid) > c)
				start = mid + 1;
			else
				end = mid - 1;
		}
		return start;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		seg = new ArrayList[n+1];
		for (int i = 1; i <= n; i++) seg[i] = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			int cur = Integer.parseInt(st.nextToken());
			if (max<cur) max = cur;
			if (min>cur) min = cur;
			update(i, cur);
		}
		for (int i = 1; i <= n; i++) Collections.sort(seg[i]);

		StringBuilder sb = new StringBuilder();
		while (m-->0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			sb.append(getAnswer(a,b,c)).append('\n');
		}
		System.out.print(sb);
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
	static final int IINF = Integer.MAX_VALUE;
	static final long LINF = Long.MAX_VALUE;
	static final int HIINF = Integer.MAX_VALUE / 2;
	static final long HLINF = Long.MAX_VALUE / 2;
}