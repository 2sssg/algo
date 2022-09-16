package extra;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2644 {
	static int n, v1, v2, m, p, s;
	static int[] visit;
	static List<Integer>[] adjList;
	static Queue<Integer> q;

	static void init() throws IOException {
		n = rn(); v1 = rstn(); v2 = rstn(); m = rn();
		adjList = new ArrayList[n + 1];
		visit = new int[n + 1];
		Arrays.fill(visit, -1);
		for(int i = 1; i <= n; ++i) adjList[i] = new ArrayList<>();
		for(int i = 0; i < m; ++i) {
			p = rstn();
			s = rstn();
			adjList[p].add(s);
			adjList[s].add(p);
		}
	}

	static int bfs() {
		q = new ArrayDeque<>();
		q.add(v1);
		visit[v1] = 0;
		while (!q.isEmpty()) {
			int cur = q.poll();
			if (cur == v2) return (visit[cur]);
			for(int nxt : adjList[cur]) {
				if (visit[nxt] != -1) continue;
				q.add(nxt);
				visit[nxt] = visit[cur] + 1;
			}
		}
		return (-1);
	}


	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
		bw.write(Integer.toString(bfs()));
		bw.flush();
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
}
