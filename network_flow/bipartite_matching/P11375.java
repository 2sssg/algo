package network_flow.bipartite_matching;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P11375 {
	static int n, m;
	static List<Integer>[] adjList;
	static boolean[] visited;
	static int[] amatch, bmatch;

	static void init() throws IOException {
		n = rstn(); m = rstn();
		adjList = new ArrayList[n];
		visited = new boolean[n];
		for (int i = 0; i < n; ++i) adjList[i] = new ArrayList<>();
		for (int i = 0; i < n; ++i) {
			int cnt = rstn();
			for (int j = 0; j < cnt; ++j) {
				adjList[i].add(rstn());
			}
		}
		amatch = new int[n];
		bmatch = new int[m + 1];
		Arrays.fill(amatch, -1);
		Arrays.fill(bmatch, -1);
	}

	static boolean dfs(int a) {
		if (visited[a]) return false;
		visited[a] = true;

		int len = adjList[a].size();
		for (int i = 0; i < len; ++i) {
			int b = adjList[a].get(i);
			if (bmatch[b] == -1 || dfs(bmatch[b])) {
				amatch[a] = b;
				bmatch[b] = a;
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
		int answer = 0;
		for (int i = 0; i < n; ++i) {
			Arrays.fill(visited, false);
			answer += dfs(i) ? 1 : 0;
			Arrays.fill(visited, false);
			answer += dfs(i) ? 1 : 0;
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
	static final int IINF = Integer.MAX_VALUE;
	static final long LINF = Long.MAX_VALUE;
	static final int HIINF = Integer.MAX_VALUE / 2;
	static final long HLINF = Long.MAX_VALUE / 2;
}
