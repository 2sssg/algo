package koala.preparation.week6;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import library.UsefulForAlgo;

public class P5980 {
	static int n,m;
	static char[][] arr;
	static HashMap<Character, List<Pair>> slide;
	static Pair cow;

	static void init() throws IOException {
		est(); n=rstn(); m=rstn();
		slide = new HashMap<>();
		for(int i='A'; i<='Z'; ++i) slide.put((char)i,new ArrayList<>());
		arr = new char[n][m];
		for(int i=0; i<n; ++i){
			String temp = br.readLine();
			for(int j=0; j<m; ++j){
				arr[i][j] = temp.charAt(j);
				if('A'<=arr[i][j] && arr[i][j]<='Z'){
					slide.get(arr[i][j]).add(new Pair(i,j));
				}else if(arr[i][j]=='@'){
					cow = new Pair(i,j);
				}
			}
		}
	}

	static int bfs(){
		Queue<Pair> q = new ArrayDeque<>();
		int[][] d = new int[n][m];
		for(int i=0; i<n; ++i) Arrays.fill(d[i],-1);

		q.add(cow);
		d[cow.x][cow.y] = 0;

		while(!q.isEmpty()){
			Pair p = q.poll();
			if(arr[p.x][p.y] == '=') {
				return d[p.x][p.y];
			}
			for(int i=0; i<4; ++i){
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				if(chk(nx,ny,n,m)) continue;
				if(arr[nx][ny] == '#') continue;
				if('A'<=arr[nx][ny] && arr[nx][ny]<='Z'){
					for(Pair sp : slide.get(arr[nx][ny])){
						if(nx==sp.x && ny==sp.y) continue;
						if(d[sp.x][sp.y] != -1) continue;
						q.add(sp);
						d[sp.x][sp.y] = d[p.x][p.y]+1;
					}
				}else{
					if(d[nx][ny] != -1) continue;
					q.add(new Pair(nx,ny));
					d[nx][ny] = d[p.x][p.y]+1;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
		System.out.println(bfs());
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
