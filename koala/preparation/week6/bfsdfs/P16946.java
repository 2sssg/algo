package koala.preparation.week6.bfsdfs;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;
import java.util.StringTokenizer;

public class P16946 {
	static int n,m;
	static int[][] arr;
	static int[][] visit;
	static HashMap<Integer,Integer> count;
//	static void bfs(int x, int y,int u){
//		Queue<Pair> q = new ArrayDeque<>();
//
//		int cnt = 0;
//		q.add(new Pair(x,y));
//		visit[x][y] = u;
//
//		while(!q.isEmpty()){
//			cnt++;
//			Pair p = q.poll();
//			for(int i=0; i<4; ++i){
//				int nx = p.x+dx[i];
//				int ny = p.y+dy[i];
//				if(chk(nx,ny,n,m) || arr[nx][ny] == 1 || visit[nx][ny]==u) continue;
//				q.add(new Pair(nx,ny));
//				visit[nx][ny] = u;
//			}
//		}
//		count.put(u,cnt);
//	}

	static int dfs(int x, int y, int u){
		int cnt = 1;
		visit[x][y] = u;
		for(int i=0; i<4; ++i){
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(chk(nx,ny,n,m) || arr[nx][ny] == 1 || visit[nx][ny]==u) continue;
			cnt += dfs(nx,ny,u);
		}
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		arr = new int[n=rstn()][m=rstn()];
		visit = new int[n][m];
		for(int i=0; i<n; ++i) Arrays.fill(visit[i],-1);
		count = new HashMap<>();

		for(int i=0; i<n; ++i) arr[i] = ra();
		for(int i=0; i<n; ++i){
			for(int j=0; j<m; ++j){
				if(arr[i][j]==0 && visit[i][j]==-1){
					count.put(i*m+j,dfs(i,j, i*m+j));
				}
			}
		}


		HashSet<Integer> hs = new HashSet<>();

		for(int i=0; i<n; ++i){
			for(int j=0; j<m; ++j){
				if(arr[i][j]==1){
					int cnt = 1;
					hs.clear();
					for(int k=0; k<4; ++k){
						int nx = i+dx[k];
						int ny = j+dy[k];
						if(chk(nx,ny,n,m)) continue;
						int unique = visit[nx][ny];
						if(hs.contains(unique)) continue;
						if(count.containsKey(unique)) cnt += count.get(unique);
						hs.add(unique);
					}
					bw.write(String.valueOf(cnt%10));
				}else{
					bw.write("0");
				}
			}

			bw.write("\n");
		}

		bw.flush();

	}
	////////////////////////////////bfs/////////////////////////////////////////////
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
	static int[] ra() throws IOException {return Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();}
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static boolean chk(int x, int y, int n, int m){return x<0 || y<0 || x>=n || y>=m;}
	static class Pair{int x,y;public Pair(int x, int y) {this.x = x;this.y = y;}}
	static class Triple{ int x,y,z;public Triple(int x, int y,int z) {this.x = x;this.y = y;this.z = z;}}
	static class Quad{ int w,x,y,z;public Quad(int w, int x, int y,int z) {this.w = w; this.x = x;this.y = y;this.z = z;}}
	////////////////////////////////bfs/////////////////////////////////////////////
}
