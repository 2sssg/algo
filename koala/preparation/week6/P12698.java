package koala.preparation.week6;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import library.UsefulForAlgo;

public class P12698 {
	static int n,m;
	static char[][] arr;
	static int[][] d;
	static Pair s,e;

	static void init() throws IOException {
		arr = new char[n=rstn()][m=rstn()];
		for(int i=0; i<n; ++i) arr[i] = br.readLine().toCharArray();
		d = new int[n][m];
		for(int i=0; i<n; ++i) Arrays.fill(d[i],0x3f3f3f3f);
		for(int i=0; i<n; ++i){
			for(int j=0; j<m; ++j){
				if(arr[i][j]=='O') s = new Pair(i,j);
				else if(arr[i][j]=='X') e = new Pair(i,j);
			}
		}
	}

	static String bfs(){
		PriorityQueue<Triple> q = new PriorityQueue<>(Comparator.comparingInt(o->o.z));
		q.add(new Triple(s.x,s.y,0));
		d[s.x][s.y] = 0;

		while(!q.isEmpty()){
			Triple p = q.poll();
			if(d[p.x][p.y] != p.z) continue;
			if(arr[p.x][p.y] == 'X') return String.valueOf(d[p.x][p.y]);
			for(int i=0; i<4; ++i){
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				if(chk(nx,ny,n,m)) continue;
				if(arr[nx][ny] == '#') continue;
				if(d[nx][ny]>p.z+1){
					d[nx][ny] = p.z + 1;
					q.add(new Triple(nx,ny,d[nx][ny]));
				}
			}
			int dist = Integer.MAX_VALUE;
			int tempdist = 1;
			Pair[] portal = new Pair[4];
			portal[0]=new Pair(p.x,p.y);
			portal[1]=new Pair(p.x,p.y);
			portal[2]=new Pair(p.x,p.y);
			portal[3]=new Pair(p.x,p.y);

			while(0<=portal[0].y-1 && arr[portal[0].x][portal[0].y-1]!='#') {
				tempdist++;
				portal[0].y--;
			}
			dist = Math.min(dist,tempdist);
			tempdist = 1;
			while(portal[1].y+1<m && arr[portal[1].x][portal[1].y+1]!='#') {
				tempdist++;
				portal[1].y++;
			}
			dist = Math.min(dist,tempdist);
			tempdist = 1;
			while(0<=portal[2].x-1 && arr[portal[2].x-1][portal[2].y]!='#') {
				tempdist++;
				portal[2].x--;
			}
			dist = Math.min(dist,tempdist);
			tempdist = 1;
			while(portal[3].x+1<n && arr[portal[3].x+1][portal[3].y]!='#') {
				tempdist++;
				portal[3].x++;
			}
			dist = Math.min(dist,tempdist);

			for(int i=0; i<4; ++i){
				int nx = portal[i].x;
				int ny = portal[i].y;
				int nz = d[p.x][p.y]+dist;
				if(d[nx][ny]>nz) {
					d[nx][ny] = nz;
					q.add(new Triple(nx,ny,nz));
				}
			}
		}
		return "THE CAKE IS A LIE";
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		int t = rn();
		for(int i=1; i<=t; ++i){
			init();
			sb.append("Case #").append(i).append(": ").append(bfs()).append("\n");
		}
		System.out.println(sb.toString());
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
	static class Pair{int x,y;public Pair(int x, int y) {this.x = x;this.y = y;}}
	static class Triple{ int x,y,z;public Triple(int x, int y,int z) {this.x = x;this.y = y;this.z = z;}}
	static class Quad{ int w,x,y,z;public Quad(int w, int x, int y,int z) {this.w = w; this.x = x;this.y = y;this.z = z;}}
}
