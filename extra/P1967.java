package extra;

import Constant.Source;
import java.io.*;
import java.util.*;

public class P1967 {
	static int n, ans, vertax;
	static List<Pair>[] tree;
	static int[] visit;

	static void init() throws IOException {
		int p, v, w;

		n = rn();
		tree = new ArrayList[n + 1];
		visit = new int[n + 1];
		Arrays.fill(visit, -1);
		for (int i = 0; i <= n; ++i) tree[i] = new ArrayList<>();
		for (int i = 1; i < n; ++i) {
			p = rstn(); v=rstn(); w=rstn();
			tree[p].add(new Pair(v, w));
			tree[v].add(new Pair(p, w));
		}
	}

	static void dfs(int v, int w) {
		if (visit[v] != -1)
			return ;
		if (ans < (visit[v] = w)) {
			vertax = v;
			ans = w;
		}
		for (Pair nxt : tree[v]) {
			if (visit[nxt.x] != -1) continue ;
			dfs(nxt.x, w + nxt.y);
		}
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
		dfs(1, 0);
		Arrays.fill(visit, -1);
		dfs(vertax, 0);
		bw.write(Integer.toString(ans));
		bw.flush();
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
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
