package extra;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2644 {
	static class Graph {
		int V;
		List<Integer>[] adj;

		public Graph(int v) {
			V = v;
			adj = new ArrayList[v + 1];
			for (int i = 0; i <= v; ++i) adj[i] = new ArrayList<>();
		}

		public void addEdge(int u, int v) {
			adj[u].add(v);
		}

		public int bfs(int start, int end) {
			// dist를 만들어주고 -1로 초기화 시킨다
			int[] dist = new int[V + 1];
			Arrays.fill(dist, -1);
			// [-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1]
			Queue<Integer> q = new ArrayDeque<>();

			// 만약 7번이 start라고 한다면 7번칸을 0으로 만들어준다
			// 왜냐하면 7번에서 출발해서 7번으로 도착하는 거리는 0이니까
			// [-1, -1, -1, -1, -1, -1, -1, 0, -1, -1, -1, -1]
			dist[start] = 0;
			q.add(start);

			while (!q.isEmpty()) {
				// queue에 들어가있는거를 뽑고
				int current = q.poll();
				// current와 붙어있는 노드를 탐색한다.
				for (int next : adj[current]) {
					// current와 붙어있는 노드 중 -1이 아닌 노드 ==> 이미 방문했던 노드
					// 는 이후 탐색을 진행하지 않고 skip한다
					if (dist[next] != -1) continue;

					// 위에 if문에 걸리지 않았다면 아직 탐색하지 않은 노드이므로 queue에 넣어준다
					q.add(next);
					// current에서 edge하나를 더 거쳐서 갈 수 있는게 next이므로
					// current노드까지 도달하는 거리 (dist[current])에 1을 더해주면 next 노드까지의 최단거리가 된다
					dist[next] = dist[current] + 1;
				}
			}

			// while 문이 끝나면 탐색이 종료되고 (start와 연결되어있는 노드들만 탐색을 한다)
			// dist[end] (도착지점까지의 거리) 를 return 해주면 된다.
			// 만약 start노드와 end노드가 연결되어있지 않다면 dist[end]는 -1이 될것이고
			// 연결되어 있다면 start에서 end까지의 최단거리가 된다
			return dist[end];
		}
	}


	public static void main(String[] args) throws IOException {
		int nodeCount = Integer.parseInt(br.readLine());
		Graph graph = new Graph(nodeCount);
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());


		int edgeCount = Integer.parseInt(br.readLine());
		while (edgeCount-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph.addEdge(u, v);
			graph.addEdge(v, u);
		}
		System.out.println(graph.bfs(start, end));
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
}
