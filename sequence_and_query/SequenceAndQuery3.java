package sequence_and_query;
import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SequenceAndQuery3 {

	static int n, m, answer;
	static int[][] tree;
	static int[] arr;

	static void init() throws IOException {
		n = rn();
		arr = new int[n + 1];
		int h = (int)Math.ceil(Math.log(n) / Math.log(2)) + 1;
		tree = new int[1 << h][];
		for (int i = 1; i <= n; ++i) arr[i] = rstn();
		m = rn();
	}

	static void mergeSortTree(int start, int end, int node){
		int mid = (start + end) >> 1;
		int s = start;
		int e = mid + 1;
		tree[node] = new int[end-start+1];
		int idx = 0;

		while(s <= mid && e <= end)
			tree[node][idx++] = arr[s] < arr[e] ? arr[s++] : arr[e++];

		if(s > mid)
			while(e <= end)
				tree[node][idx++] = arr[e++];

		if(e > end)
			while(s <= mid)
				tree[node][idx++] = arr[s++];

		for(int i = start;i <= end; i++)
			arr[i] = tree[node][i - start];

	}

	static void merge(int start, int end, int node){
		if(start != end){
			int mid = (start + end) >> 1;
			merge(start, mid, node * 2);
			merge(mid+1, end, node * 2 + 1);
			mergeSortTree(start, end, node);
		} else {
			tree[node] = new int[]{arr[start]};
		}
	}

	static int query(int start, int end, int node, int left, int right, int k) {
		if (end < left || start > right) return 0;
		if (left <= start && right >= end) return tree[node].length - upperBound(tree[node], k);
		int mid = (start + end) / 2;
		return query(start, mid, node * 2, left, right, k)
				+ query(mid + 1, end, node * 2 + 1, left, right, k);
	}



	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
		merge(1, n, 1);
		while (m-- > 0) {
			int i = answer ^ rstn(), j = answer ^ rstn(), k = answer ^ rstn();
			answer = query(1, n, 1, i, j, k);
			sb.append(answer).append('\n');
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
	private static int upperBound(int[] data, int target) {
		int begin = 0;
		int end = data.length;
		while(begin < end) {
			int mid = (begin + end) / 2;
			if(data[mid] <= target) begin = mid + 1;
			else end = mid;
		}
		return end;
	}
}

