package bfs;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P9328 {
	static class Pair{
		int x,y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Pair{" +
				"x=" + x +
				", y=" + y +
				'}';
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int T,N,M,answer;
	static char[][] arr;
	static HashSet<Character> keys;
	static Queue<Pair> q = new ArrayDeque<>();
	static boolean[][] visit;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static HashMap<Character, List<Pair>> nokey;

	static void init() throws IOException {
		nokey = new HashMap<>();
		answer = 0;
		q.clear();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		visit = new boolean[N][M];
		for(int i=0; i<N; ++i){
			arr[i] = br.readLine().toCharArray();
		}

		keys = new HashSet<>();
		for(char k: br.readLine().toCharArray()){
			if(k=='0') break;
			keys.add(k);
		}
	}

	static void fillEnter(int x, int y){
		char edge = arr[x][y];

		if(edge != '*'){
			if('A'<=edge && edge<='Z'){
				if(!keys.contains((char)(edge+32))) {
					nokey.computeIfAbsent(edge,k->new ArrayList<>());
					nokey.get(edge).add(new Pair(x,y));
					return;
				}
			}
			else if('a'<=edge && edge<='z'){
				keys.add(edge);
				if(nokey.containsKey((char)(edge-32))){
					q.addAll(nokey.get((char)(edge-32)));
				}
			}
			else if(edge == '$'){
				answer++;
			}
			q.add(new Pair(x,y));
			visit[x][y] = true;
		}
	}

	static void findEnter(){
		for(int i=1; i<M-1; ++i){
			fillEnter(0,i);
			fillEnter(N-1,i);
		}
		for(int j=1; j<N-1; ++j){
			fillEnter(j,0);
			fillEnter(j,M-1);
		}
		fillEnter(0,0);
		fillEnter(0,M-1);
		fillEnter(N-1,0);
		fillEnter(N-1,M-1);
	}

	static void bfs(){
		while(!q.isEmpty()){
			Pair p = q.poll();
			int curX = p.x;
			int curY = p.y;
			for(int i=0; i<4; ++i){
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
				char nc = arr[nx][ny];

				//벽이면
				if(nc == '*' || visit[nx][ny]) continue;

				//길이면
				if(nc == '.'){
					q.add(new Pair(nx,ny));
					visit[nx][ny] = true;
					continue;
				}

				//문 이면
				if('A'<=nc && nc<='Z' && !visit[nx][ny]){
					if(keys.contains((char)(nc+32))){
						q.add(new Pair(nx,ny));
					}else{
						nokey.computeIfAbsent(nc,k->new ArrayList<>());
						nokey.get(nc).add(new Pair(nx,ny));
					}
					visit[nx][ny] = true;
					continue;
				}

				//열쇠면
				if('a'<=nc && nc<='z' && !visit[nx][ny]){
					keys.add(nc);
					q.add(new Pair(nx,ny));
					visit[nx][ny] = true;

					if(nokey.containsKey((char)(nc-32))){
						q.addAll(nokey.get((char)(nc-32)));
					}
					continue;
				}

				//문서면
				if(nc == '$'){
					q.add(new Pair(nx,ny));
					visit[nx][ny] = true;
					answer++;
				}
			}
		}
	}

	//32
	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		T = Integer.parseInt(br.readLine());
		while(T-->0){
			init();
			findEnter();
			bfs();
			System.out.println(answer);
		}
	}
}
