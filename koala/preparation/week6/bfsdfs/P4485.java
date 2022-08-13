package koala.preparation.week6.bfsdfs;

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

public class P4485 {
	static int n,idx;
	static int[][] arr;

	static boolean init() throws IOException {
		n = rn();
		idx++;
		arr = new int[n][n];
		for(int i=0; i<n; ++i) arr[i] = ra();
		return n!=0;
	}

	static int dijkstra(){
		PriorityQueue<Triple> pq = new PriorityQueue<>(Comparator.comparingInt(o->o.z));
		int[][] d = new int[n][n];
		for(int i=0; i<n; ++i) Arrays.fill(d[i],0x3f3f3f3f);
		pq.add(new Triple(0,0,arr[0][0]));
		d[0][0] = arr[0][0];

		while(!pq.isEmpty()){
			Triple t = pq.poll();
			if(d[t.x][t.y]<t.z) continue;
			for(int i=0; i<4; ++i){
				int nx = t.x+dx[i];
				int ny = t.y+dy[i];
				if(chk(nx,ny,n,n)) continue;
				int dist = t.z+arr[nx][ny];
				if(d[nx][ny]<=dist) continue;
				pq.add(new Triple(nx,ny,dist));
				d[nx][ny] = dist;
			}
		}
		return d[n-1][n-1];
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		while(init()) sb.append("Problem ").append(idx).append(": ").append(dijkstra()).append("\n");
		System.out.println(sb.toString());

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
