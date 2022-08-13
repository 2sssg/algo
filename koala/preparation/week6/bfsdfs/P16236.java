package koala.preparation.week6.bfsdfs;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import library.UsefulForAlgo;

public class P16236 {
	static class Pair implements Comparable<Pair>{
		int x,y,dist;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
			this.dist = 0;
		}

		public Pair(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}

		@Override
		public int compareTo(Pair o) {
			if(this.dist == o.dist){
				if(this.x==o.x){
					return this.y-o.y;
				}
				return this.x-o.x;
			}
			return this.dist - o.dist;
		}
	}
	static int n,answer;
	static int[][] arr;
	static Pair babyshark;
	static int size,eat;
	static PriorityQueue<Pair> q = new PriorityQueue<>();

	static void init() throws IOException {
		size = 2;
		eat = 0;
		answer = 0;
		n = rn();
		arr = new int[n][n];
		for(int i=0; i<n; ++i) arr[i] = ra();
		for(int i=0; i<n; ++i) for(int j=0; j<n; ++j) if(arr[i][j]==9) babyshark = new Pair(i,j);
		arr[babyshark.x][babyshark.y] = 0;
	}

	static int bfs(){
		boolean[][] visit = new boolean[n][n];
		q.add(babyshark);
		visit[babyshark.x][babyshark.y] = true;
		while(!q.isEmpty()){
			Pair p = q.poll();
			if(arr[p.x][p.y]!=0 && arr[p.x][p.y]<size){
				arr[p.x][p.y] = 0;
				if(size==++eat) {
					eat = 0;
					size++;
				}
				q.clear();
				babyshark.x = p.x;
				babyshark.y = p.y;
				babyshark.dist = 0;
				return p.dist;
			}
			for(int i=0; i<4; ++i){
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				if(chk(nx,ny,n,n)) continue;
				if(visit[nx][ny]) continue;
				if(arr[nx][ny]>size) continue;
				q.add(new Pair(nx,ny,p.dist+1));
				visit[nx][ny] = true;
			}
		}
		return 0;
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
		while(true){
			int cnt = bfs();
//			UsefulForAlgo.testPrint(arr);
			if(cnt==0) break;
			answer += cnt;
		}
		System.out.println(answer);

	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() {return Integer.parseInt(st.nextToken());}
	static int[] ra() throws IOException {return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();}
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static boolean chk(int x, int y, int n, int m){return x<0 || y<0 || x>=n || y>=m;}
}
