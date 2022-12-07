package class5;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class P2150 {
	static int v, e;
	static List<Integer>[] adjList, r_adjList;
	static List<List<Integer>> res;
	static Stack<Integer> s;
	static boolean[] visit;

	static void init() throws IOException {
		v = rstn(); e = rstn();
		visit = new boolean[v + 1];
		s = new Stack<>();
		adjList = new ArrayList[v + 1];
		r_adjList = new ArrayList[v + 1];
		res = new ArrayList<>();
		for (int i = 0; i <= v; ++i) adjList[i] = new ArrayList<>();
		for (int i = 0; i <= v; ++i) r_adjList[i] = new ArrayList<>();
		for (int i = 0; i < e; ++i) {
			int v1 = rstn(), v2 = rstn();
			adjList[v1].add(v2);
			r_adjList[v2].add(v1);
		}
	}

	static void dfs(int cur) {
		visit[cur] = true;
		for (int nxt: adjList[cur])
			if (!visit[nxt])
				dfs(nxt);
		s.push(cur);
	}

	static void dfs2(int cur) {
		visit[cur] = true;
		res.get(res.size() - 1).add(cur);
		for (int nxt: r_adjList[cur])
			if (!visit[nxt])
				dfs2(nxt);
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
		for (int i = 1; i <= v; ++i)
			if (!visit[i])
				dfs(i);
		Arrays.fill(visit, false);

		int g = 0;
		while (!s.isEmpty()) {
			int cur = s.pop();
			if (visit[cur]) continue;
			res.add(new ArrayList<>());
			dfs2(cur);
			g++;
		}
		bw.append(Integer.toString(g)).append("\n");
		for (int i = 0; i < g; ++i)
			Collections.sort(res.get(i));
		Collections.sort(res, Comparator.comparingInt(o -> o.get(0)));
		for (int i = 0; i < g; ++i) {
			for (int node: res.get(i))
				bw.append(Integer.toString(node)).append(" ");
			bw.append("-1\n");
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
}
