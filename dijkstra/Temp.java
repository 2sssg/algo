package dijkstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Queue;
import java.util.StringTokenizer;

public class Temp {
	static int n,m;
	static int[] dist;
	static HashMap<Integer, Integer> ladder, snake;
	public static void main(String[] args) throws IOException {
		n = rstn(); m = rstn();
		ladder = new HashMap<>();
		snake = new HashMap<>();
		dist = new int[101];
		while (n-->0) ladder.put(rstn(), rstn());
		while (m-->0) snake.put(rstn(), rstn());
		Arrays.fill(dist, -1);
		Queue<Integer> q = new ArrayDeque<>();
		q.add(1);
		dist[1] = 0;
		while (!q.isEmpty()) {
			int cur = q.poll();
			if (cur == 100) {
				System.out.println(dist[cur]);
				return;
			}
			for (int i = 1; i <= 6; ++i) {
				int nxt = cur + i;
				if (nxt > 100) continue;
				if (ladder.containsKey(nxt)) nxt = ladder.get(nxt);
				if (snake.containsKey(nxt)) nxt = snake.get(nxt);
				if (dist[nxt] != -1) continue;
				q.add(nxt);
				dist[nxt] = dist[cur] + 1;
			}
		}

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
