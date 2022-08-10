package koala.preparation.week6;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import library.UsefulForAlgo;

public class P12273 {
	static int t,n,m;
	static int[][] arr,w,d;
	static Pair s,e;

	static void init() throws IOException {
		arr = new int[n=rstn()][m=rstn()];
		w = new int[n][m];
		d = new int[n][m];
		for(int i=0; i<n; ++i) Arrays.fill(w[i],-1);
		for(int i=0; i<n; ++i) Arrays.fill(d[i],0x3f3f3f3f);
		s = new Pair(rstn(),rstn());
		e = new Pair(rstn(),rstn());
		for(int i=0; i<n; ++i) arr[i] = ra();
	}

	static String dijkstra(){
		PriorityQueue<Quad> pq = new PriorityQueue<>((o1,o2)-> o1.z==o2.z?o2.w-o1.w:o1.z-o2.z);
		pq.add(new Quad(arr[s.x][s.y],s.x,s.y,0));
		w[s.x][s.y] = arr[s.x][s.y];
		d[s.x][s.y] = 0;

		while(!pq.isEmpty()){
			Quad q = pq.poll();
			if(w[q.x][q.y] != q.w) continue;
//			System.out.println(q.x + " , " + q.y);
			if(q.x == e.x && q.y==e.y) return String.valueOf(w[q.x][q.y]);
			for(int i=0; i<4; ++i){
				int nx = q.x + dx[i];
				int ny = q.y + dy[i];
				if(chk(nx,ny,n,m)) continue;
				int nw = q.w + arr[nx][ny];
				int nz = q.z+1;
				if(arr[nx][ny] == -1) continue;
				if(w[nx][ny]<nw && d[nx][ny]>=nz){
					pq.add(new Quad(nw,nx,ny,nz));
					w[nx][ny] = nw;
					d[nx][ny] = nz;
				}
			}
		}
		return "Mission Impossible.";
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		t = rn();
		for(int i=1; i<=t; ++i){
			init();
			sb.append("Case #").append(i).append(": ").append(dijkstra()).append("\n");
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
