package bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P2593 {

	static final int MAX_VALUE = 1000000000;
	static int n,m;
	static int[] dist = new int[m + 1];
	static int[] prev = new int[m + 1];
	static ArrayList<ArrayList<Integer>> floor = new ArrayList<>();
	static ArrayList<ArrayList<Integer>> elevator = new ArrayList<>();

	static void print(int[] prev, int elevator) throws IOException {

		if (elevator == 0) return;
		print(prev, prev[elevator]);
		bw.append(Integer.toString(elevator)).append("\n");
	}

	public static void main(String[] args) throws IOException {

		n = rstn(); m = rstn();

		for (int i = 0; i < n + 1; i++) floor.add(new ArrayList<>());

		for (int i = 0; i < m + 1; i++) elevator.add(new ArrayList<>());

		for (int i = 1; i <= m; i++) {
			int f = rstn();
			int gap = rstn();

			while (f <= n) {
				floor.get(f).add(i);
				elevator.get(i).add(f);
				f += gap;
			}
		}
		dist = new int[m + 1];
		prev = new int[m + 1];

		st = new StringTokenizer(br.readLine());

		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.y));

		Arrays.fill(dist, MAX_VALUE);

		for (int i = 0; i < floor.get(start).size(); i++) {
			pq.add(new Pair(floor.get(start).get(i), 1));
			dist[floor.get(start).get(i)] = 1;
		}

		while (!pq.isEmpty()) {

			Pair cur = pq.poll();
			if (dist[cur.x] < cur.y) continue;
			for (int i = 0; i < elevator.get(cur.x).size(); i++) {
				int level = elevator.get(cur.x).get(i);
				for (int j = 0; j < floor.get(level).size(); j++) {
					int nextElevator = floor.get(level).get(j);
					if (dist[nextElevator] > cur.y + 1) {
						dist[nextElevator] = cur.y + 1;
						prev[nextElevator] = cur.x;
						pq.add(new Pair(nextElevator, dist[nextElevator]));
					}
				}
			}
		}

		int min = Integer.MAX_VALUE;
		int lastElevator = 0;
		for (int i = 0; i < floor.get(end).size(); i++) {
			if (min> dist[floor.get(end).get(i)]) {
				min = dist[floor.get(end).get(i)];
				lastElevator = floor.get(end).get(i);
			}
		}

		if (min == MAX_VALUE)
			bw.append("-1\n");
		else {
			bw.append(Integer.toString(min)).append("\n");
			print(prev, lastElevator);
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
