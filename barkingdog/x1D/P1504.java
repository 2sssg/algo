package barkingdog.x1D;

import Constant.Source;

import java.io.*;
import java.util.*;

public class P1504 {

	static class Pair implements Comparable<Pair> {

		int v;
		int w;

		public Pair(int v, int w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Pair o) {
			return this.w - o.w;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static PriorityQueue<Pair> pq = new PriorityQueue<>();

	static int v;
	static int e;
	static List<Pair>[] adjList;

	static int dijk(int startVertex, int endVertex) throws Exception {
		int[] dist = new int[v + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		pq.add(new Pair(startVertex, 0));
		dist[startVertex] = 0;
		while (!pq.isEmpty()) {
			Pair p = pq.poll();
			if (dist[p.v] != p.w) {
				continue;
			}
			for (Pair nxt : adjList[p.v]) {
				if (dist[nxt.v] > p.w + nxt.w) {
					pq.add(new Pair(nxt.v, p.w + nxt.w));
					dist[nxt.v] = p.w + nxt.w;
				}
			}
		}
		if (dist[endVertex] == Integer.MAX_VALUE) {
			throw new Exception("-1");
		}
		return dist[endVertex];
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		adjList = new ArrayList[v + 1];

		for (int i = 1; i <= v; ++i) {
			adjList[i] = new ArrayList<>();
		}

		while (e-- > 0) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adjList[v1].add(new Pair(v2, w));
			adjList[v2].add(new Pair(v1, w));
		}

		st = new StringTokenizer(br.readLine());

		int firstRequiredVertax = Integer.parseInt(st.nextToken());
		int secondRequiredVertax = Integer.parseInt(st.nextToken());

		int answer = 0;
		try {
			answer += dijk(1, firstRequiredVertax) + dijk(firstRequiredVertax, secondRequiredVertax)
				+ dijk(secondRequiredVertax, v);
			answer = Math.min(answer,
				dijk(1, secondRequiredVertax) + dijk(secondRequiredVertax, firstRequiredVertax)
					+ dijk(firstRequiredVertax, v));
			bw.write(String.valueOf(answer));
		} catch (Exception e) {
			bw.write(e.getMessage());
		}
		bw.flush();
	}
}
