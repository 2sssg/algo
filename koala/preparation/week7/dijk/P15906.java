package koala.preparation.week7.dijk;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P15906 {
	static int n,t,r,c;
	static char[][] arr;

	static void init() throws IOException {
		arr = new char[n=rstn()][n]; t=rstn();r=rstn()-1;c=rstn()-1;
		for(int i=0; i<n; ++i) arr[i]=rca();
	}

	static int dijk(){
		int[][][] d = new int[n][n][2];
		for(int i=0; i<n; ++i) for(int j=0; j<n; ++j) Arrays.fill(d[i][j],Integer.MAX_VALUE);
		//변신 x y 소요턴수
		PriorityQueue<Quad> pq = new PriorityQueue<>(Comparator.comparingInt(o->o.z));
		pq.add(new Quad(0,0,0,0));
		d[0][0][0] = 0;

		while(!pq.isEmpty()){
			Quad cur = pq.poll();
			if(d[cur.x][cur.y][cur.w] < cur.z) continue;
			if(cur.x==r && cur.y==c) return Math.min(d[r][c][0],d[r][c][1]);
			for(int i=0; i<4; ++i){
				int nx = cur.x+dx[i];
				int ny = cur.y+dy[i];
				int nz = cur.z+1;
				if(chk(nx,ny,n,n)) continue;
				if(d[nx][ny][0]>nz){
					pq.add(new Quad(0,nx,ny,nz));
					d[nx][ny][0] = nz;
				}

				while(!chk(nx,ny,n,n)&&arr[nx][ny] != '#'){
					nx += dx[i];
					ny += dy[i];
				}

				if(chk(nx,ny,n,n)) continue;
				nz += cur.w==1?0:t;
				if(d[nx][ny][1]>nz){
					d[nx][ny][1] = nz;
					pq.add(new Quad(1,nx,ny,nz));
				}
			}
		}
		return Math.min(d[r][c][0],d[r][c][1]);
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
		System.out.println(dijk());
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
	static char[] rca() throws IOException {return br.readLine().toCharArray();}
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static boolean chk(int x, int y, int n, int m){return x<0 || y<0 || x>=n || y>=m;}
	static class Quad{ int w,x,y,z;public Quad(int w, int x, int y,int z) {this.w = w; this.x = x;this.y = y;this.z = z;}}
}
