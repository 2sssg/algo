package barkingdog.x1D;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class P20183 {

	static class Pair implements Comparable<Pair> {

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
			return -1;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static List<Pair>[] adjList;
	static long[] dist;


	static int V, E, A, B;
	static long C;

	static void est() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

	static int rstn() {
		return Integer.parseInt(st.nextToken());
	}

//	static boolean dijk(long mid) {
//		boolean[] visit = new boolean[V+1];
//		PriorityQueue<Pair> pq = new PriorityQueue<>();
////		Arrays.fill(visit,false);
//		pq.add(new Pair(A, 0));
//
//		while (!pq.isEmpty()) {
//			Pair p = pq.poll();
//			visit[p.v] = true;
//			if (p.v == B) {
//				return true;
//			}
//			for (Pair next : adjList[p.v]) {
//				if (visit[next.v]) {
//					continue;
//				}
//				if (next.w > mid || next.w + p.w > C) {
//					continue;
//				}
//				pq.add(new Pair(next.v, next.w + p.w));
//			}
//		}
//		return false;
//
//	}

	static private boolean Dijkstra( long cost) {
		Arrays.fill(dist, Long.MAX_VALUE);

		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(A,0));
		dist[A] = 0;
		while (!pq.isEmpty()) {
			Pair now = pq.poll();

			if (dist[now.v]<now.w)
				continue;

			for (Pair next : adjList[now.v]) {
				if (cost >= next.w && dist[next.v] > dist[now.v] + next.w) {
					dist[next.v] = dist[now.v] + next.w;
					pq.add(new Pair(next.v, dist[next.v]));
				}
			}
		}

		return dist[B] <= C;
	}

	public static void main(String[] args) throws IOException {
		long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기



		br = Source.getBufferedReader();
		est();
		V = rstn();
		E = rstn();
		A = rstn();
		B = rstn();
		C = Long.parseLong(st.nextToken());
		dist = new long[V+1];
//		visit = new boolean[V+1];
		adjList = new ArrayList[V + 1];
		for (int i = 0; i <= V; ++i) {
			adjList[i] = new ArrayList<>();
		}

		long maxcost = 0;
		while (E-- > 0) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			long w = Long.parseLong(st.nextToken());
			maxcost = Math.max(maxcost,w);
			adjList[v1].add(new Pair(v2, w));
			adjList[v2].add(new Pair(v1, w));
		}

		long l = 0;
		long r = maxcost;
		long ans = Long.MAX_VALUE;
		while (l <= r) {
			long mid = (l + r) / 2;
			if (Dijkstra(mid)) {
				if(ans>mid){
					ans = mid;
				}
				r = mid-1;
			} else {
				l = mid+1;
			}
		}

		System.out.println(ans == Long.MAX_VALUE ? "-1" : ans);

		long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
		long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
		System.out.println("시간차이(m) : "+secDiffTime);
	}

}
