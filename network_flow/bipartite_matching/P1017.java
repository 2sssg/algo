package network_flow.bipartite_matching;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class P1017 {
	static int n;
	static boolean[] prime = new boolean[2500];
	static List<Integer>[] adjList;
	static List<Integer> a, b;
	static int[] amatch, bmatch;
	static boolean[] visited;
	static boolean isFirstEven;

	static void eratos() {
		Arrays.fill(prime, true);
		for (int i = 2; i <= 50; ++i)
			if (prime[i])
				for (int j = i * i; j < 2500; j+=i)
					prime[j] = false;
	}

	static boolean init() throws IOException {
		a = new ArrayList<>();
		b = new ArrayList<>();

		n = rstn();
		int first = rstn();
		isFirstEven = first%2 == 0;
		a.add(first);
		for (int i = 1; i < n; ++i) {
			int num = rstn();
			if (isFirstEven) {
				if (num % 2 == 0) a.add(num);
				else b.add(num);
			} else {
				if (num % 2 != 0) a.add(num);
				else b.add(num);
			}
		}
		return a.size() == b.size();
	}

	static boolean dfs(int a_idx){
		if(a_idx == 0 || visited[a_idx])
			return false;
		visited[a_idx] = true;

		for(int i=0; i<adjList[a_idx].size() ; ++i){
			int b_idx = adjList[a_idx].get(i);

			if(bmatch[b_idx] == -1 || dfs(bmatch[b_idx])){
				amatch[a_idx] = b_idx;
				bmatch[b_idx] = a_idx;
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		if (!init()) {
			System.out.println(-1);
			return ;
		}
		eratos();
		adjList = new ArrayList[a.size()];
		for (int i = 0; i < a.size(); ++i) adjList[i] = new ArrayList<>();

		for (int i = 0; i < a.size(); ++i) {
			for (int j = 0; j < b.size(); ++j) {
				if (prime[a.get(i) + b.get(j)]) {
					adjList[i].add(j);
				}
			}
		}

		List<Integer> answer = new ArrayList<>();
		for (int i = 0; i < adjList[0].size(); ++i) {
			int pair_b_idx = adjList[0].get(i);
			int paired_size = 1;

			amatch = new int[a.size()];
			bmatch = new int[b.size()];
			Arrays.fill(amatch, -1);
			Arrays.fill(bmatch, -1);

			amatch[0] = pair_b_idx;
			bmatch[pair_b_idx] = 0;

			for(int j =1 ; j<a.size() ; ++j){
				visited = new boolean[a.size()];
				if(dfs(j))
					paired_size++;
			}
			if(paired_size == b.size())
				answer.add(b.get(pair_b_idx));
		}

		if(answer.size() != 0){
			Collections.sort(answer);
			for(int i=0; i<answer.size() ; ++i) {
				sb.append(answer.get(i)).append(" ");
			}
		} else {
			sb.append("-1");
		}
		System.out.println(sb);
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	private static int swap(int localA, int localB) {return localA;}
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
	static int[] ra() throws IOException {return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();}
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static boolean chk(int x, int y, int n, int m){return x<0 || y<0 || x>=n || y>=m;}
	static class Pair{int x,y;public Pair(int x, int y) {this.x = x;this.y = y;}}
	static class Triple{ int x,y,z;public Triple(int x, int y,int z) {this.x = x;this.y = y;this.z = z;}}
	static class Quad{ int w,x,y,z;public Quad(int w, int x, int y,int z) {this.w = w; this.x = x;this.y = y;this.z = z;}}
	static final int IINF = Integer.MAX_VALUE;
	static final long LINF = Long.MAX_VALUE;
	static final int HIINF = Integer.MAX_VALUE / 2;
	static final long HLINF = Long.MAX_VALUE / 2;
}
