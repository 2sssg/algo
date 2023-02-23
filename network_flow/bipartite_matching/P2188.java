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

public class P2188 {
	static int n, m;
	static List<Integer>[] adjList;
	static int[] amatch, bmatch;
	static boolean[] visit;


	static void init() throws IOException {
		n = rstn(); m = rstn();
		adjList = new ArrayList[n];
		for (int i = 0; i < n; ++i) adjList[i] = new ArrayList<>();
		for (int i = 0; i < n; ++i) {
			for (int j = rstn(); j > 0; --j) {
				adjList[i].add(rstn());
			}
		}

		amatch = new int[n];
		bmatch = new int[m + 1];
		Arrays.fill(amatch, -1);
		Arrays.fill(bmatch, -1);
	}

	static int dfs(int cur) {
		if (visit[cur]) return 0;
		visit[cur] = true;

		for (int i = 0; i < adjList[cur].size(); ++i) {
			int nxt = adjList[cur].get(i);
			if (bmatch[nxt] == -1 || dfs(bmatch[nxt]) == 1) {
				amatch[cur] = nxt;
				bmatch[nxt] = cur;
				return 1;
			}

		}
		return 0;
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();

		int answer = 0;
		for (int i = 0; i < n; ++i) {
			visit = new boolean[n];
			answer += dfs(i);
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
