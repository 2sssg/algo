package dp;

import java.util.*;
import java.io.*;
import java.util.stream.*;

public class P4013 {
	static boolean[] finished,isRes;
	static int n, m, index, sccIndex, start, max;
	static int[] discover,sccNum,atm,totalAtm,dp;
	static ArrayList<ArrayList<Integer>> list,sccList;
	static Stack<Integer> s;

	private static void sccBfs() {
		LinkedList<Integer> q = new LinkedList<>();
		q.add(sccNum[start]);
		dp[sccNum[start]] = totalAtm[sccNum[start]];

		while (!q.isEmpty()){
			Integer cur = q.poll();

			for (Integer next : sccList.get(cur)) {
				if(dp[next] < dp[cur] + totalAtm[next]){
					dp[next] = dp[cur]+totalAtm[next];
					q.add(next);
				}
			}
		}
	}


	private static void setSccInfo() {
		totalAtm = new int[sccIndex+1];
		sccList = new ArrayList<>();
		dp = new int[sccIndex + 1];
		for(int i = 0; i <= sccIndex; i++) sccList.add(new ArrayList<>());

		for (int i = 1; i <= n; i++) {
			totalAtm[sccNum[i]]+=atm[i];
			for (Integer next : list.get(i))
				if (sccNum[i] != sccNum[next]) sccList.get(sccNum[i]).add(sccNum[next]);
		}
	}

	private static void findScc() {
		index = 0;
		discover = new int[n + 1];
		finished = new boolean[n + 1];
		s = new Stack<>();
		sccIndex = 0;
		sccNum = new int[n + 1];

		for (int i = 1; i <= n; i++)
			if (discover[i] == 0) dfs(i);

	}

	private static int dfs(int cur) {
		discover[cur] = ++index;
		s.push(cur);

		int parent = discover[cur];
		for (Integer next : list.get(cur)) {
			if (discover[next] == 0) parent = Math.min(dfs(next), parent);
			else if (!finished[next]) parent = Math.min(discover[next], parent);
		}

		if (parent == discover[cur]) {
			while (true) {
				Integer pop = s.pop();
				finished[pop] = true;
				sccNum[pop] = sccIndex + 1;
				if (pop == cur) break;
			}
			sccIndex++;
		}
		return parent;
	}

	public static void main(String[] args) throws IOException {
		n = rstn();
		m = rstn();
		list = new ArrayList<>();
		atm = new int[n+1];
		for (int i = 0; i <= n; i++) list.add(new ArrayList<>());
		for (int i = 0; i < m; i++) {
			int[] edge = Arrays.stream(br.readLine().split(" "))
					.mapToInt(Integer::parseInt).toArray();
			list.get(edge[0]).add(edge[1]);
		}
		for(int i=1;i<=n;i++) atm[i] = Integer.parseInt(br.readLine());


		start = rstn();
		isRes = new boolean[n+1];
		Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt).forEach(e->isRes[e]=true);
		findScc();
		setSccInfo();
		sccBfs();

		for (int i = 1; i <= n; i++) if (isRes[i]) max = Math.max(max,dp[sccNum[i]]);
		System.out.println(max);

	}


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int swap(int localA, int localB) {return localA;}
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
	static int[] ra() throws IOException {return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();}
	static int dy[] = { -1,0,0,1,1,1,-1,-1 };
	static int dx[] = { 0,1,-1,0,-1,1,1,-1 };
	static boolean chk(int x, int y, int n, int m){return x<0 || y<0 || x>=n || y>=m;}
	static class Pair{int x,y;public Pair(int x, int y) {this.x = x;this.y = y;}}
	static class Triple{ int x,y,z;public Triple(int x, int y,int z) {this.x = x;this.y = y;this.z = z;}}
	static class Quad{ int w,x,y,z;public Quad(int w, int x, int y,int z) {this.w = w; this.x = x;this.y = y;this.z = z;}}
	static final int IINF = Integer.MAX_VALUE;
	static final long LINF = Long.MAX_VALUE;
	static final int HIINF = Integer.MAX_VALUE / 2;
	static final long HLINF = Long.MAX_VALUE / 2;
	static int max(int... temp) {return Arrays.stream(temp).max().getAsInt();}
	static int min(int... temp) {return Arrays.stream(temp).min().getAsInt();}
}