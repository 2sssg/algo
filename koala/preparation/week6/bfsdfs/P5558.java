package koala.preparation.week6.bfsdfs;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class P5558 {
	static int n,m,k;
	static char[][] arr;
	static Pair mouse;
	static int size,answer;

	static void init() throws IOException {
		est(); n=rstn(); m=rstn(); k=rstn();
		size = 1;
		answer = 0;
		arr = new char[n][m];
		for(int i=0; i<n; ++i) arr[i] = br.readLine().toCharArray();
		for(int i=0; i<n; ++i) for(int j=0; j<m; ++j) if(arr[i][j]=='S') mouse = new Pair(i,j);
	}

	static int bfs(){
		Queue<Pair> q = new ArrayDeque<>();
		int[][] d = new int[n][m];
		for(int i=0; i<n; ++i) Arrays.fill(d[i],-1);
		q.add(mouse);
		d[mouse.x][mouse.y] = 0;

		while(!q.isEmpty()){
			Pair p = q.poll();
			if('0'<=arr[p.x][p.y]&&arr[p.x][p.y]<='9'&&arr[p.x][p.y]-'0'<=size){
				size++;
				mouse.x = p.x;
				mouse.y = p.y;
				arr[p.x][p.y] = '.';
				return d[p.x][p.y];
			}
			for(int i=0; i<4; ++i){
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				if(chk(nx,ny,n,m)) continue;
				if(d[nx][ny] != -1 || arr[nx][ny] == 'X') continue;
				q.add(new Pair(nx,ny));
				d[nx][ny] = d[p.x][p.y] + 1;
			}
		}
		return 0;
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
		while(k-->0){
			answer += bfs();
		}
		System.out.println(answer);
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() {return Integer.parseInt(st.nextToken());}
	static int[] ra() throws IOException {return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();}
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static boolean chk(int x, int y, int n, int m){return x<0 || y<0 || x>=n || y>=m;}
	static class Pair{int x,y;public Pair(int x, int y) {this.x = x;this.y = y;}}
	static class Triple{ int x,y,z;public Triple(int x, int y,int z) {this.x = x;this.y = y;this.z = z;}}
}
