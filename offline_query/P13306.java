package offline_query;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class P13306 {
	static int n,q;
	static int[] parent;
	static Stack<String> s;
	static String[] qu;
	static int[] originParent;

	static void init() throws IOException {
		n = rstn(); q = rstn();
		s = new Stack<>();
		originParent = new int[n + 1];
		for (int i = 1; i < n; ++i) originParent[i + 1] = rn();

		parent = new int[n + 1];
		for (int i = 1; i < n + 1; ++i) parent[i] = i;
		qu = new String[n + q - 1];
		for (int i = 0; i < n + q - 1; ++i) {
//			qu[i] = br.readLine();
			s.add(br.readLine());
		}
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
		boolean[] answer = new boolean[q];
		int idx = q - 1;
		while (!s.isEmpty()) {
			st = new StringTokenizer(s.pop());
			int type = rstn();
			if (type == 1) {
				answer[idx--] = isUnion(rstn(), rstn());
			} else {
				int v = rstn();
				union(v, originParent[v]);
			}
		}

		for (boolean res : answer) {
			if (res) sb.append("YES\n");
			else sb.append("NO\n");
		}
		System.out.println(sb);
	}

//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int N = Integer.parseInt(st.nextToken());
//		int Q = Integer.parseInt(st.nextToken());
//		int[] parentlink = new int[N + 1];
//		boolean[] result = new boolean[Q];
//		String[] query = new String[N - 1 + Q];
//
//		for (int i = 2; i <= N; i++) {
//			parentlink[i] = Integer.parseInt(br.readLine());
//		}
//
//		for (int i = 0; i < N - 1 + Q; i++) {
//			query[i] = br.readLine();
//		}
//
//		int[] parent = new int[N + 1];
//		for(int i = 1; i <= N; i++) {
//			parent[i] = i;
//		}
//
//		for (int i = N - 1 + Q - 1, rIdx = Q - 1; i >= 0; i--) {
//			st = new StringTokenizer(query[i]);
//			if (st.nextToken().charAt(0) == '0') {
//				int child = Integer.parseInt(st.nextToken());
//				union(parent, child, parentlink[child]);
//			}
//			else {
//				result[rIdx--] = isUnion(parent, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
//			}
//		}
//		StringBuilder sb = new StringBuilder();
//		for(int i = 0; i < Q; i++) {
//			if (result[i]) {
//				sb.append("YES");
//			}
//			else {
//				sb.append("NO");
//			}
//			sb.append("\n");
//		}
//		System.out.println(sb);
//	}
	static int find(int x) {
		if (parent[x] == x)
			return x;
		return parent[x] = find(parent, parent[x]);
	}

	static void union(int x, int y) {
		x = find(parent, x);
		y = find(parent, y);
		if (x == y) return ;
		parent[y] = x;
	}

	static boolean isUnion(int x, int y) {
		return find(parent, x) == find(parent, y);
	}

	static int find(int[] parent, int x) {
		if (parent[x] == x)
			return x;
		return parent[x] = find(parent, parent[x]);
	}

	static void union(int[] parent, int x, int y) {
		x = find(parent, x);
		y = find(parent, y);
		if (x == y) return ;
		parent[y] = x;
	}

	static boolean isUnion(int[] parent, int x, int y) {
		return find(parent, x) == find(parent, y);
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
	static class Triple{ int x,y,z;public Triple(int x, int y,int z) {this.x = x;this.y = y;this.z = z;}public Triple(int x, int y) {this.x = x;this.y = y;}
	}
	static class Quad{ int w,x,y,z;public Quad(int w, int x, int y,int z) {this.w = w; this.x = x;this.y = y;this.z = z;}}
}
