package koala.preparation.week6.bfsdfs;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P4184 {
	static int n,m,k;
	static int[][] arr;

	static void init() throws IOException {
		est(); n=rstn(); m=rstn();
		arr = new int[n][m];
		for(int i=0; i<n; ++i) arr[i] = ra();
		k=rn();
	}

	static int dijkstra(int sx, int sy, int ex, int ey){
		Deque<Triple> dq = new ArrayDeque<>();
		int[][] d = new int[n][m];
		for(int i=0; i<n; ++i) Arrays.fill(d[i],0x3f3f3f3f);
		dq.add(new Triple(sx,sy,0));
		d[sx][sy] = 0;
		while(!dq.isEmpty()){
			Triple t = dq.pollFirst();
			if(t.z>d[t.x][t.y]) continue;
			for(int i=0; i<8; ++i){
				int nx = t.x+dx[i];
				int ny = t.y+dy[i];
				int dist = i == arr[t.x][t.y]?t.z:t.z+1;
				if(chk(nx,ny,n,m)) continue;
				if(d[nx][ny]>dist){
					d[nx][ny] = dist;
					if(i==arr[t.x][t.y]) dq.addFirst(new Triple(nx,ny,dist));
					else dq.addLast(new Triple(nx,ny,dist));
				}
			}
		}
		return d[ex][ey];

	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
		for(int i=0; i<k; ++i){
			est();
			sb.append(dijkstra(rstn()-1,rstn()-1,rstn()-1,rstn()-1)).append("\n");
		}
		System.out.println(sb.toString());

	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() {return Integer.parseInt(st.nextToken());}
	static int[] ra() throws IOException {return Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();}
	static int[] dx = {-1,-1,0,1,1,1,0,-1};
	static int[] dy = {0,1,1,1,0,-1,-1,-1};
	static boolean chk(int x, int y, int n, int m){return x<0 || y<0 || x>=n || y>=m;}
	static class Pair{int x,y;public Pair(int x, int y) {this.x = x;this.y = y;}}
	static class Triple{ int x,y,z;public Triple(int x, int y,int z) {this.x = x;this.y = y;this.z = z;}}
}
