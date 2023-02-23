package network_flow.bipartite_matching;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P3295 {

	static int n, m, ans;
 	static List<Integer>[] adjList;
 	static int[] nxt;
	static boolean[] visited;

	static boolean dfs(int cur) {
		visited[cur] = true;
		for (int next : adjList[cur]) {
			if ((nxt[next] == -1) || (!visited[nxt[next]] && dfs(nxt[next]))) {
				nxt[next] = cur;
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) throws IOException {
		int t = rn();
		while (t-- > 0) {
			ans = 0;
			n = rstn(); m = rstn();
			adjList = new ArrayList[n + 1];
			for (int i = 0; i <= n; ++i) adjList[i] = new ArrayList<>();

			for (int i = 0; i < m; ++i) {
				int u = rstn(), v = rstn();
				adjList[u].add(v);

			}
			nxt = new int[n];
			Arrays.fill(nxt, -1);
			visited = new boolean[n];

			for (int i = 0; i < n; ++i) {
				Arrays.fill(visited, false);
				ans += dfs(i) ? 1 : 0;
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
}
