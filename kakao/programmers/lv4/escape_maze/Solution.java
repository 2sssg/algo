package kakao.programmers.lv4.escape_maze;

import java.util.*;


public class Solution {
	static int INF = 100000000;
	Map<Integer, Integer> trapMap = new HashMap<>();

	public int solution(int n, int start, int end, int[][] roads, int[] traps) {
		int answer = 0;

		List<Edge>[] graph = new ArrayList[n+1];

		for(int i=1; i<=n; i++)
			graph[i] = new ArrayList<>();

		int len = roads.length;
		for(int i=0; i<len; i++) {
			int u = roads[i][0];
			int v = roads[i][1];
			int w = roads[i][2];
			graph[u].add(new Edge(v,w,false));
			graph[v].add(new Edge(u,w,true));
		}

		len = traps.length;
		for(int i=0; i<len; i++)
			trapMap.put(traps[i],i);

		int dist[][] = new int[n+1][1<<10];
		for(int i=1; i<=n; i++)
			Arrays.fill(dist[i],INF);

		PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
		priorityQueue.add(new Node(start,0,0));

		answer = INF;
		while(!priorityQueue.isEmpty()) {
			Node curNode = priorityQueue.poll();
			int curv = curNode.vertex;
			int curw = curNode.weight;
			int curStatus = curNode.trapStatus;

			if(curv == end) {
				answer = Math.min(answer,curw);
				continue;
			}

			if(curw > dist[curv][curStatus])
				continue;

			if(trapMap.containsKey(curv))
				curStatus ^= (1<<trapMap.get(curv));

			for(Edge nextNode : graph[curv]) {
				int nextv = nextNode.vertex;
				int nextw = nextNode.weight;
				boolean isReverseEdge = nextNode.isReverse;
				boolean isRight = checkIsRight(curv,nextv,curStatus);
				if(isRight && isReverseEdge)
					continue;
				else if(!isRight && !isReverseEdge)
					continue;
				if(dist[nextv][curStatus] > nextw + curw) {
					dist[nextv][curStatus] = nextw + curw;
					priorityQueue.add(new Node(nextv, nextw + curw, curStatus));
				}
			}

		}
		return answer;
	}
	boolean checkIsRight(int curv, int nextv, int curStatus) {
		if(!trapMap.containsKey(curv) && !trapMap.containsKey(nextv))
			return true;
		if(trapMap.containsKey(curv) && trapMap.containsKey(nextv)) {
			int curvBit = 1 << trapMap.get(curv);
			int nextvBit = 1 << trapMap.get(nextv);
			boolean isCurvActive = (curStatus & curvBit) == curvBit;
			boolean isNextvActice = (curStatus & nextvBit) == nextvBit;
			return isCurvActive == isNextvActice ? true : false;
		}
		if(trapMap.containsKey(curv)) {
			int curvBit = 1 << trapMap.get(curv);
			boolean isCurvActive = (curStatus & curvBit) == curvBit;
			return !isCurvActive;
		}
		else if(trapMap.containsKey(nextv)) {
			int nextvBit = 1 << trapMap.get(nextv);
			boolean isNextvActice = (curStatus & nextvBit) == nextvBit;
			return !isNextvActice;
		}
		return true;
	}

	class Edge {
		int vertex;
		int weight;
		boolean isReverse;

		public Edge(int vertex, int weight, boolean isReverse) {
			this.vertex = vertex;
			this.weight = weight;
			this.isReverse = isReverse;
		}
	}

	class Node implements Comparable<Node> {
		int vertex;
		int weight;
		int trapStatus;

		public Node(int vertex, int weight, int trapStatus) {
			this.vertex = vertex;
			this.weight = weight;
			this.trapStatus = trapStatus;
		}

		@Override
		public int compareTo(Node node) {
			return this.weight > node.weight ? 1 : -1;
		}
	}
}