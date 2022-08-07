package dijkstra;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class P11952 {
	static class Pair implements Comparable<Pair> {
		int x;
		long y;
		public Pair(int x, long y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Pair o) {
			if(this.y>o.y)return 1;
			else if(this.y==o.y) return 0;
			return -1;
		}
	}
	static int n,m,k,s,p,q;
	static List<Integer>[] adjList;
	static int[] cost;
	static long[] visit;
	static Queue<Integer> que = new ArrayDeque<>();
	static PriorityQueue<Pair> pq = new PriorityQueue<>();

	static void init() throws IOException {
		est(); n=rstn(); m=rstn(); k=rstn(); s=rstn();
		est(); p = rstn(); q=rstn();
		adjList = new ArrayList[n+1];
		for(int i=1; i<=n; ++i) adjList[i] = new ArrayList<>();
		cost = new int[n+1];
		visit = new long[n+1];
		Arrays.fill(cost,p);
		cost[0] = 0;
		Arrays.fill(visit,-1);
		for(int i=0; i<k; ++i){
			int con = Integer.parseInt(br.readLine());
			cost[con] = Integer.MAX_VALUE;
			que.add(con);
			visit[con] = 0;
		}
		for(int i=0; i<m; ++i){
			est();
			int v1 = rstn(), v2 = rstn();
			adjList[v1].add(v2);
			adjList[v2].add(v1);
		}
		findQcost();
	}

	static void findQcost(){
		while(!que.isEmpty()){
			int cur = que.poll();
			if(cost[cur]==p) cost[cur] = q;
			if(visit[cur]==s) continue;
			for(int nxt: adjList[cur]){
				if(visit[nxt]!=-1) continue;
				que.add(nxt);
				visit[nxt] = visit[cur]+1;
			}
		}
	}

	static void dijkstra(){
		pq.add(new Pair(1,0));
		Arrays.fill(visit, Long.MAX_VALUE);
		visit[1] = 0;
		while(!pq.isEmpty()){
			Pair p = pq.poll();
			if(visit[p.x] != p.y) continue;
			for(int nxt: adjList[p.x]){
				if(cost[nxt]==Integer.MAX_VALUE) continue;
				if(visit[nxt]>p.y+cost[nxt]){
					pq.add(new Pair(nxt,p.y+cost[nxt]));
					visit[nxt] = p.y+cost[nxt];
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
		dijkstra();
		System.out.println(visit[n]-cost[n]);
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() {return Integer.parseInt(st.nextToken());}
	static int[] ra() throws IOException {return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();}
}
