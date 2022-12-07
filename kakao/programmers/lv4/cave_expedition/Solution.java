package kakao.programmers.lv4.cave_expedition;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;

class Solution {

	public boolean solution(int n, int[][] path, int[][] order) {
		List<Integer>[] adjList = new ArrayList[n];
		for (int i = 0; i < n; ++i) adjList[i] = new ArrayList<>();
		HashMap<Integer, Integer> ordermap = new HashMap<>();
		boolean[] visit = new boolean[n];
		boolean[] isLock = new boolean[n];
		boolean[] enterable = new boolean[n];

		for (int[] p: path) {
			adjList[p[0]].add(p[1]);
			adjList[p[1]].add(p[0]);
		}

		for (int[] o: order) {
			if (o[1] == 0) return false;
			ordermap.put(o[0], o[1]);
			isLock[o[1]] = true;
		}

		Queue<Integer> q = new ArrayDeque<>();
		q.add(0);
		visit[0] = true;
		int cnt = 0;
		while(!q.isEmpty()) {
			int cur = q.poll();
			cnt++;
			if (ordermap.containsKey(cur)) {
				int preEnter = ordermap.get(cur);
				isLock[preEnter] = false;
				if (enterable[preEnter]) {
					q.add(preEnter);
					visit[preEnter] = true;
				}
			}
			for (int nxt : adjList[cur]) {
				if (visit[nxt]) continue;
				enterable[nxt] = true;
				if (isLock[nxt]) continue;
				q.add(nxt);
				visit[nxt] = true;
			}
		}
		System.out.println(cnt);
		return cnt == n;
	}
}