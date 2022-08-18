package koala.preparation.week7.dijk;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P16681 {
	static class Pair implements Comparable<Pair> {
		int x;
		long y;

		Pair(int x, long y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Pair o) {
			if(this.y < o.y) return -1;
			else if(this.y == o.y) return 0;
			else return 1;
		}
	}
	static int n, m, d, e;
	static long[] heightArr;
	static List<Pair>[] graph;


	static long[] dijk(boolean isUp) {
		long[] dijkstra = new long[n + 1];
		Arrays.fill(dijkstra, Long.MAX_VALUE);
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		if(isUp) {	// 올라가는경우
			pq.add(new Pair(1, 0));
			dijkstra[1] = 0;
		}
		else {	// 내려오는 경우
			pq.offer(new Pair(n, 0));
			dijkstra[n] = 0;
		}

		while(!pq.isEmpty()) {
			Pair v = pq.poll();
			if(dijkstra[v.x] < v.y) {
				continue;
			}

			for(Pair nextV : graph[v.x]) {
				if(heightArr[v.x] >= heightArr[nextV.x]) {
					continue;
				}

				if(v.y + nextV.y >= dijkstra[nextV.x]) {
					continue;
				}

				dijkstra[nextV.x] = v.y + nextV.y;
				pq.add(new Pair(nextV.x, dijkstra[nextV.x]));
			}
		}
		return dijkstra;
	}

	public static void main(String args[]) throws IOException {
		br = Source.getBufferedReader();
		n = rstn(); m = rstn();d=rstn();e=rstn();

		heightArr = new long[n + 1];	// 인덱스 : 1 ~ n
		graph = new ArrayList[n + 1];

		// 높이 저장 + 그래프 객체 생성
		for(int i = 1; i <= n; i++) {
			heightArr[i] = rstn();
			graph[i] = new ArrayList<>();
		}

		for(int i = 0; i < m; i++) {
			int start = rstn();
			int end = rstn();
			int distance = rstn();

			graph[start].add(new Pair(end, distance));
			graph[end].add(new Pair(start, distance));
		}

		long[] upDijkstra = dijk(true);
		long[] downDijkstra = dijk(false);
		long maxValue = Long.MIN_VALUE;
		for(int i = 1; i <= n; i++) {
			if(upDijkstra[i] == Long.MAX_VALUE || downDijkstra[i] == Long.MAX_VALUE) {
				continue;
			}

			maxValue = Math.max(maxValue, (heightArr[i] * e) - ((upDijkstra[i] + downDijkstra[i]) * d));
		}

		if(maxValue == Long.MIN_VALUE) {
			System.out.println("Impossible");
		}
		else {
			System.out.println(maxValue);
		}
	}



	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
	static int[] ra() throws IOException {return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();}
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static boolean chk(int x, int y, int n, int m){return x<0 || y<0 || x>=n || y>=m;}
	static class Triple{ int x,y,z;public Triple(int x, int y,int z) {this.x = x;this.y = y;this.z = z;}}
	static class Quad{ int w,x,y,z;public Quad(int w, int x, int y,int z) {this.w = w; this.x = x;this.y = y;this.z = z;}}


}
