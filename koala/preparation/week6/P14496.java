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
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P14496 {
	static List<Integer>[] adjList;
	static int a,b,n,m;
	static Queue<Integer> q = new ArrayDeque<>();
	static int[] d = new int[1001];
	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		Arrays.fill(d,-1);
		a=rstn(); b=rstn(); n=rstn(); m=rstn();
		adjList = new ArrayList[n+1];
		for(int i=0; i<=n; ++i) adjList[i] = new ArrayList<>();
		for(int i=0; i<m; ++i){
			int v1 = rstn(),v2=rstn();
			if(v1==v2) continue;
			adjList[v1].add(v2);
			adjList[v2].add(v1);
		}
		q.add(a);
		d[a] = 0;
		while(!q.isEmpty()){
			int cur = q.poll();
			if(cur==b){
				System.out.println(d[cur]);
				return;
			}
			for(int nxt: adjList[cur]){
				if(d[nxt]!=-1) continue;
				q.add(nxt);
				d[nxt] = d[cur]+1;
			}
		}
		System.out.println(-1);
	}
	////////////////////////////////bfs/////////////////////////////////////////////
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
	////////////////////////////////bfs/////////////////////////////////////////////
}
