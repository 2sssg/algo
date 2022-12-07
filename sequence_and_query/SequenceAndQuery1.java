package sequence_and_query;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class SequenceAndQuery1 {

	static int n, m;
	static List<Integer>[] tree;
	static List<Integer> arr;

	static void init() throws IOException {
		n = rn();
		tree = new ArrayList[4 * n];
		arr = new ArrayList<>();
		arr.add(0);
		for (int i = 0; i < 4 * n; ++i) tree[i] = new ArrayList<>();
		for (int i = 1; i <= n; ++i) {
			arr.add(rstn());
			update(1, n, 1, i);
		}
		m = rn();
	}

	static int query(int start, int end, int node, int left, int right, int k) {
		if (end < left || start > right) return 0;
		if (left <= start && right >= end) return tree[node].size() - upperBound(tree[node], k);
		int mid = (start + end) / 2;
		return query(start, mid, node * 2, left, right, k)
				+ query(mid + 1, end, node * 2 + 1, left, right, k);
	}

	static void update(int start, int end, int node, int idx) {
		if (idx < start || idx > end) return ;
		tree[node].add(arr.get(idx));
		if (start == end) return ;
		int mid = (start + end) / 2;
		update(start, mid, node * 2, idx);
		update(mid + 1, end, node * 2 + 1, idx);
	}




	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
		for (int i = 0; i < 4 * n; ++i) Collections.sort(tree[i]);
		while (m-- > 0) {
			bw.write(Integer.toString(query(1, n, 1, rstn(), rstn(), rstn())));
			bw.write("\n");
		}
		bw.flush();
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
	private static int upperBound(List<Integer> data, int target) {
		int begin = 0;
		int end = data.size();
		while(begin < end) {
			int mid = (begin + end) / 2;
			if(data.get(mid) <= target) begin = mid + 1;
			else end = mid;
		}
		return end;
	}
}
