package bfs;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class P1109 {
	static int n, m;
	static int[][] map;
	static int cnt;
	static HashSet<Integer>[] neighbor;
	static int[] parent, level;
	static int[][][] copymap;

	static void init() throws IOException {
		sb.setLength(0);
		n = rstn(); m = rstn();
		map = new int[n][m];

		for(int i=0; i < n ; i++){
			String temp = br.readLine();
			for(int j = 0; j < m; j++) map[i][j] = temp.charAt(j) == 'x' ? -1 : 0;
		}
	}

	static void seperate(int i, int j, int cnt) {
		if (chk(i, j, n, m)) return ;
		if(map[i][j] != -1) return ;
		map[i][j] = cnt;
		for (int k = 0; k < 8; ++k)
			seperate(i + dx[k], j + dy[k], cnt);
	}

	static void findNeighbor(int i, int j, int me, int[][] map) {
		if(chk(i, j, n, m)) {
			neighbor[me].add(-1);
			return ;
		}
		if(map[i][j] == -1) return ;
		if(map[i][j] == me || map[i][j] == 0){
			map[i][j] = -1;
			for (int k = 0; k < 4; ++k) findNeighbor(i + dx[k], j + dy[k], me, map);
			return ;
		}
		neighbor[map[i][j]].add(me);
		neighbor[me].add(map[i][j]);
	}

	static void goToParent(int i, int l) {
		if(i == -1) return ;
		if(level[i] < l) {
			level[i] = l;
			goToParent(parent[i], l+1);
		}
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();

		cnt = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(map[i][j] == -1){
					cnt++;
					seperate(i, j, cnt);
				}
			}
		}

		copymap = new int[cnt+1][n][m];

		for (int c = 1; c <= cnt; c++)
			for (int i = 0; i < n; i++)
				System.arraycopy(map[i], 0, copymap[c][i], 0, m);


		neighbor = new HashSet[cnt + 1];
		for (int i = 0; i <= cnt; i++) neighbor[i] = new HashSet<>();

		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				if(map[i][j] > 0 && !neighbor[map[i][j]].contains(-1))
					findNeighbor(i, j, map[i][j], copymap[map[i][j]]);

		parent = new int[cnt+1];

		Queue<Integer> q = new ArrayDeque<>();

		for (int i = 1; i <= cnt; i++) {
			if(neighbor[i].contains(-1)){
				parent[i] = -1;
				q.add(i);
				neighbor[i].remove(-1);
			}
		}

		int now;
		while(!q.isEmpty()){
			now = q.poll();
			for (int j : neighbor[now]) {
				if(parent[j] == 0){
					parent[j] = now;
					q.add(j);
					neighbor[j].remove(now);
				}
			}
		}

		if(cnt == 0) {
			System.out.println(-1);
			return ;
		}

		level = new int[cnt+1];

		for (int i = 1; i <= cnt; i++) {
			if(level[i] > 0) continue;
			boolean isRoot = true;
			for (int j = 1; j <= cnt; j++) {
				if(parent[j] == i){
					isRoot = false;
					break;
				}
			}
			if(isRoot) goToParent(i, 1);
		}

		int[] nums = new int[cnt + 1];
		for (int i = 1; i <= cnt; i++) nums[level[i]] ++;

		for (int i = 1; i <= cnt; i++) {
			if(nums[i] == 0) break;
			sb.append(nums[i]).append(" ");
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
}

