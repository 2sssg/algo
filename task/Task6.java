package task;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Task6 {
	static int n, m, s, a, t;
	static List<Pair>[] adjList;
	static int[] dist;
	static PriorityQueue<Pair> pq;

	static void init() throws IOException {
		n = rstn(); m = rstn();
		s = rstn(); a = rstn(); t = rstn();

		adjList = new ArrayList[n];
		for (int i = 0; i < n; ++i) adjList[i] = new ArrayList<>();

		while (m-- > 0) adjList[rstn()].add(new Pair(rstn(), rstn()));
	}

	static int dijk(int start, int end) {
		pq = new PriorityQueue<>(Comparator.comparingInt(o->o.y));
		dist = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);

		pq.add(new Pair(start, 0));
		dist[start] = 0;

		while (!pq.isEmpty()) {
			Pair cur = pq.poll();
			if (dist[cur.x] < cur.y) continue;
			for (Pair nxt: adjList[cur.x]) {
				int ny = cur.y + nxt.y;
				if (dist[nxt.x] < ny) continue;
				pq.add(new Pair(nxt.x, ny));
				dist[nxt.x] = ny;
			}
		}
		return dist[end];
	}


	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
		System.out.println(dijk(s, a) + dijk(a, t));
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
