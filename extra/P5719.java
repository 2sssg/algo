package extra;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class P5719 {
	static class Pair implements Comparable<Pair>{
		int v;
		long w;

		public Pair(int v, long w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Pair o) {
			if(this.w>o.w){
				return 1;
			}
			else if(this.w==o.w){
				return 0;
			}
			return -1;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n,m;
	static int start,end;
	static long[] dist;

	static Map<Integer,Long>[] adjList;
	static Map<Integer,Long>[] r_adjList;



	static boolean init() throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		dist = new long[n];

		if(n==0 && m==0) return false;

		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		adjList = new HashMap[n];
		r_adjList = new HashMap[n];
		for(int i=0; i<n; ++i) {
			adjList[i] = new HashMap<>();
			r_adjList[i] = new HashMap<>();
		}
		for(int i=0; i<m; ++i){
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			Long w = Long.parseLong(st.nextToken());
			adjList[v1].put(v2,w);
			r_adjList[v2].put(v1,w);
		}
		return true;
	}

	static void dijkstra(){
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		Arrays.fill(dist,Long.MAX_VALUE);
		pq.add(new Pair(start,0));
		dist[start] = 0;
		while(!pq.isEmpty()){
			Pair p = pq.poll();
			int cv = p.v;
			long cw = p.w;
			if(cw != dist[cv]) continue;
			for(Entry<Integer,Long> np: adjList[cv].entrySet()){
				if(dist[np.getKey()]>np.getValue()+dist[cv]){
					dist[np.getKey()] = np.getValue()+dist[cv];
					pq.add(new Pair(np.getKey(), dist[np.getKey()]));
				}
			}
		}

	}

	static void removePath(){
		boolean[] visit = new boolean[n];
		Queue<Integer> q = new ArrayDeque<>();
		q.add(end);
		visit[end] = true;
		while(!q.isEmpty()){
			int cv = q.poll();
			for(Entry<Integer,Long> en : r_adjList[cv].entrySet()){
				if(dist[cv]-dist[en.getKey()] == r_adjList[cv].get(en.getKey())){
					adjList[en.getKey()].remove(cv);
					if(!visit[en.getKey()]){
						visit[en.getKey()] = true;
						q.add(en.getKey());
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		while(init()) {
			dijkstra();
			removePath();
			dijkstra();
			System.out.println(dist[end]==Long.MAX_VALUE?"-1":dist[end]);
		}
	}
}
