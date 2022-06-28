package barkingdog.x1D;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * P17853. 면접보는 승범이네 다익스트라.
 */

public class P17835 {

	/**
	 * Pair.
	 */
	static class Pair implements Comparable<Pair> {

		int town;
		long cost;

		public Pair(int town, long cost) {
			this.town = town;
			this.cost = cost;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) {
				return true;
			}
			if (o == null || getClass() != o.getClass()) {
				return false;
			}
			Pair pair = (Pair) o;
			return town == pair.town;
		}

		@Override
		public int hashCode() {
			return Objects.hash(town);
		}

		@Override
		public int compareTo(Pair o) {
			if(this.cost>o.cost){
				return 1;
			}
			return -1;
		}
	}


	static void dijk() {

		while (!pq.isEmpty()) {
			Pair cur = pq.poll();
			if (dist[cur.town] < cur.cost) {
				continue;
			}
			for (Entry<Integer, Long> next : adjList[cur.town].entrySet()) {
				if (dist[next.getKey()] > cur.cost + next.getValue()) {
					pq.add(new Pair(next.getKey(), cur.cost + next.getValue()));
					dist[next.getKey()] = cur.cost + next.getValue();
				}
			}
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int n;
	static int m;
	static int k;
	static Map<Integer, Long>[] adjList;
	static HashSet<Integer> kList = new HashSet<>();
	static long[] dist;
	static PriorityQueue<Pair> pq = new PriorityQueue<>();

	/**
	 * Main.
	 */
	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		dist = new long[n + 1];

		adjList = new HashMap[n + 1];
		for (int i = 1; i <= n; ++i) {
			adjList[i] = new HashMap<>();
		}

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			adjList[v].put(u, adjList[v].getOrDefault(u, Long.MAX_VALUE) > cost ? cost
				: adjList[v].getOrDefault(u, Long.MAX_VALUE));
		}

		st = new StringTokenizer(br.readLine());

		while (st.hasMoreTokens()) {
			kList.add(Integer.parseInt(st.nextToken()));
		}
		Arrays.fill(dist, Long.MAX_VALUE);
		for (int i : kList) {
			pq.add(new Pair(i, 0));
			dist[i] = 0;
		}

		long longDist = -1;
		int longDistLoc = 0;
		dijk();

		for (int i = 1; i <= n; ++i) {
			if (longDist < dist[i]) {
				longDist = dist[i];
				longDistLoc = i;
			}
		}
		System.out.println(longDistLoc);
		System.out.println(longDist);


	}
}
