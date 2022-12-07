package offline_query;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class P12012 {
	static int n, m;
	static List<Integer>[] adjList;
	static int[] uf;
	static Stack<Integer> s;
	static boolean[] check;

	static void init() throws IOException {
		n = rstn(); m = rstn();
		adjList = new ArrayList[n + 1];
		uf = new int[n + 1];
		Arrays.fill(uf, -1);
		check = new boolean[n + 1];
		for (int i = 0; i <= n; ++i) adjList[i] = new ArrayList<>();
		for (int i = 0; i < m; ++i) {
			int v1 = rstn(), v2 = rstn();
			adjList[v1].add(v2);
			adjList[v2].add(v1);
		}
		s = new Stack<>();
		for (int i = 0; i < n; ++i) s.push(rn());
	}

	static int find(int a) {
		if(uf[a] < 0) return a;
		return uf[a] = find(uf[a]);
	}

	static boolean merge(int a, int b){
		a = find(a); b = find(b);
		if(a != b) {
			uf[b] = a;
			return true;
		}
		return false;
	}
	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
		int component = 0;
		Stack<String> ans = new Stack<>();
		while (!s.isEmpty()) {
			component++;
			int cur = s.pop();
			for (int nxt : adjList[cur]) {
				if (check[nxt] && merge(cur, nxt)) component--;
			}
			check[cur] = true;
			ans.push(component == 1 ? "YES" : "NO");
		}
		while (!ans.isEmpty()) {
			sb.append(ans.pop()).append("\n");
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
