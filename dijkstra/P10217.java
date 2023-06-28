package dijkstra;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P10217 {
	static int t,v,m,e;
	static List<Triple>[] adjList;
	static PriorityQueue<Triple> pq;
	static int[][] dp;

	static void init() throws IOException {
		v=rstn(); m=rstn(); e=rstn();
		adjList = new ArrayList[v+1];
		dp = new int[101][10001];
		pq = new PriorityQueue<>((o1,o2)->o1.time == o2.time ? o1.cost-o2.cost:o1.time-o2.time);
		for(int i=0; i<101; ++i) Arrays.fill(dp[i],Integer.MAX_VALUE);
		for(int i=1; i<=v; ++i) adjList[i] = new ArrayList<>();
		for(int i=0; i<e; ++i) adjList[rstn()].add(new Triple(rstn(),rstn(),rstn()));
	}

	static void dijk(){
		// 정점 , 돈, 시간
		pq.add(new Triple(1,0,0));
		//정점 돈 = 시간
		dp[1][0] = 0;

		while(!pq.isEmpty()){
			Triple cur = pq.poll();
			if(dp[cur.ver][cur.cost] < cur.time) continue;
			//다음 노드
			for(Triple item: adjList[cur.ver]){
				// 모든 돈
				// 현재 정점을 i원으로 갈수없으면 컨티뉴
				if(cur.cost + item.cost > m) continue;
				if(dp[item.ver][cur.cost + item.cost] < dp[cur.ver][cur.cost] + item.time) continue;
				Triple nxt = new Triple(item.ver,cur.cost + item.cost,dp[cur.ver][cur.cost] + item.time);
//				nxt.ver = item.ver;
//				nxt.cost = cur.cost + item.cost;
//				nxt.time = dp[cur.ver][cur.cost] + item.time;
				pq.add(new Triple(item.ver,cur.cost + item.cost,dp[cur.ver][cur.cost] + item.time));
				dp[item.ver][cur.cost + item.cost] = dp[cur.ver][cur.cost] + item.time;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		rn();
		init();
		dijk();
		int min = Integer.MAX_VALUE;
		for(int i=0; i<=m; ++i){
			if(dp[v][i] != Integer.MAX_VALUE){
				min = Math.min(dp[v][i],min);
			}
		}
		sb.append(min==Integer.MAX_VALUE?"Poor KCM":min).append("\n");
		System.out.println(sb);
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
	static int[] ra() throws IOException {return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();}
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static boolean chk(int x, int y, int n, int m){return x<0 || y<0 || x>=n || y>=m;}
	static class Pair{int ver,time;public Pair(int ver, int time) {this.ver = ver;this.time = time;}

		@Override
		public String toString() {
			return "Pair{" +
					"ver=" + ver +
					", time=" + time +
					'}';
		}
	}
	static class Triple{ int ver,cost,time;public Triple(int ver, int cost,int time) {this.ver = ver;this.cost = cost;this.time = time;}}
	static class Quad{ int w,x,y,z;public Quad(int w, int x, int y,int z) {this.w = w; this.x = x;this.y = y;this.z = z;}}
}

