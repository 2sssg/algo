package kakao.programmers.lv3.choosing_hiking_course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

class Solution {

	void init(int n, int[][] paths, int[] gates, int[] summits) {
		System.out.println("n : " + n);
		System.out.println("path : ");
		Arrays.stream(paths).forEach(r -> System.out.println(Arrays.toString(r)));
		System.out.println("gates : " + Arrays.toString(gates));
		System.out.println("summits : " + Arrays.toString(summits));
	}

	PriorityQueue<Pair> pq = new PriorityQueue<>();
	int[] visit;
	List<Pair>[] adjList;

	public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
		int dest = Integer.MAX_VALUE, weight = Integer.MAX_VALUE;
		init(n, paths, gates, summits);
		HashSet<Integer> summitSet = Arrays.stream(summits).boxed().collect(Collectors.toCollection(HashSet::new));
		adjList = new ArrayList[n + 1];
		visit = new int[n + 1];
		Arrays.fill(visit, Integer.MAX_VALUE);
		for (int i = 0; i <= n; ++i) adjList[i] = new ArrayList<>();
		for (int[] path : paths) {
			adjList[path[0]].add(new Pair(path[1], path[2]));
			adjList[path[1]].add(new Pair(path[0], path[2]));
		}
		for (int item : gates) {
			pq.add(new Pair(item, 0));
			visit[item] = 0;
		}

		while (!pq.isEmpty()) {
			Pair cur = pq.poll();
			System.out.println(cur);
			if (visit[cur.x] < cur.y) continue;
			if (cur.y > weight) continue;
			if (summitSet.contains(cur.x)) {
				if (weight == cur.y) {
					dest = Math.min(cur.x, dest);
				} else {
					dest = cur.x;
					weight = cur.y;
				}
				continue;
			}
			for (Pair nxt : adjList[cur.x]) {
				int nx = nxt.x;
				int ny = Math.max(cur.y, nxt.y);
				if (visit[nx] <= ny) continue;
				visit[nx] = ny;
				pq.add(new Pair(nx, ny));
			}
		}

		return new int[]{dest, weight};
	}

	class Pair implements Comparable<Pair> {
		int x,y;

		@Override
		public String toString() {
			return "Pair{" +
					"x=" + x +
					", y=" + y +
					'}';
		}

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Pair o) {
			return this.y == o.y ? this.x - o.x : this.y - o.y ;
		}
	}
}