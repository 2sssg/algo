package dev_matching.p3;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;

class Solution {

	HashSet<Integer>[] line;
	int[] dist;

	public int solution(String[] subway, int start, int end) {
		line = new HashSet[subway.length];
		for (int i = 0; i < subway.length; ++i) line[i] = new HashSet<>();
		dist = new int[100_005];
		Arrays.fill(dist, -2);

		for (int i = 0; i < subway.length; ++i) {
			String[] s = subway[i].split(" ");
			for (int j = 0; j < s.length; ++j) {
				line[i].add(Integer.parseInt(s[j]));
			}
		}
		Queue<Integer> q = new ArrayDeque<>();
		q.add(start);
		dist[start] = -1;
		while (!q.isEmpty()) {
			int cur = q.poll();
			if (cur == end){
				return dist[cur];
			}
			for(int i = 0; i < subway.length; ++i) {
				if (!line[i].contains(cur)) continue;
				for (int s: line[i]) {
					if (dist[s] != -2) continue;
					q.add(s);
					dist[s] = dist[cur] + 1;
				}
			}
		}
		return -1;
	}
}
