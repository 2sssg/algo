package barkingdog.x1B;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P4368 {
	static class Pair{
		double x;
		double y;

		public Pair(double x, double y) {
			this.x = x;
			this.y = y;
		}

		public double dist(Pair p){
			return Math.sqrt((this.x-p.x)*(this.x-p.x) + (this.y-p.y)*(this.y-p.y));
		}
	}
	static class Edge implements Comparable<Edge>{
		int v;
		double w;

		@Override
		public int compareTo(Edge o) {
			if(this.w>o.w){
				return 1;
			}else if(this.w == o.w){
				return 0;
			}
			return -1;
		}

		public Edge(int v, double w) {
			this.v = v;
			this.w = w;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static Pair[] pairs;
	static PriorityQueue<Edge> pq = new PriorityQueue<>();
	static boolean[] visit;

	static int V;
	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		V = Integer.parseInt(br.readLine());
		visit = new boolean[V+1];
		pairs = new Pair[V+1];

		for(int i=1; i<=V; ++i){
			st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			pairs[i] = new Pair(x,y);
		}
		pq.add(new Edge(1,0.0));
		int cnt = 0;
		double ans = 0.0;
		while(cnt < V){
			Edge cur = pq.poll();
			if(visit[cur.v]) continue;
			cnt++;
			ans += cur.w;
			visit[cur.v] = true;
			for(int i=1; i<=V; ++i){
				if(visit[i]) continue;
				pq.add(new Edge(i,pairs[cur.v].dist(pairs[i])));
			}
		}

		System.out.printf("%.2f",ans);


	}
}
