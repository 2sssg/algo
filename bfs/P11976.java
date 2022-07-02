package bfs;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P11976 {
	static class Pair{
		int x;
		int y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static HashMap<Integer,List<Pair>> m = new HashMap<>();
	static Queue<Pair> q = new ArrayDeque<>();
	static int N,M;
	static int[][] arr;
	static int[][] visit;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};


	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		visit = new int[N][N];

		while(M-->0){
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			if(m.containsKey(x*N+y)){
				m.get(x*N+y).add(new Pair(a,b));
			}else{
				m.put(x*N+y,new ArrayList<>());
				m.get(x*N+y).add(new Pair(a,b));
			}
		}
		visit[0][0] = 2;
		q.add(new Pair(0,0));

		int answer = 0;
		while(!q.isEmpty()){
			Pair p = q.poll();
			int curX = p.x;
			int curY = p.y;
			if(m.containsKey(curX*N+curY)){
				for(Pair on: m.get(curX*N+curY)){
					if(visit[on.x][on.y]==0){
						visit[on.x][on.y] = 1;
						for(int i=0; i<4; ++i){
							int nx = on.x+dx[i];
							int ny = on.y+dy[i];
							if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
							if(visit[nx][ny] == 2){
								q.add(new Pair(on.x,on.y));
								visit[on.x][on.y] = 2;
							}
						}
						answer++;
					}
				}
			}
			for(int i=0; i<4; ++i){
				int nx = curX + dx[i];
				int ny = curY + dy[i];
				if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
				if(visit[nx][ny] == 1){
					q.add(new Pair(nx,ny));
					visit[nx][ny] = 2;
				}
			}
		}
		System.out.println(answer+1);
	}
}
