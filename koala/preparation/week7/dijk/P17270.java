package koala.preparation.week7.dijk;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P17270 {
	static int n,m, 	j,s,	ds;
	static List<Pair>[] adjList;
	static int[] jd,sd;
	static List<Triple> answer;

	static void init() throws IOException {
		n=rstn(); m=rstn();
		adjList = new ArrayList[n+1];
		answer = new ArrayList<>();
		ds = Integer.MAX_VALUE;
		for(int i=1; i<=n; ++i) adjList[i] = new ArrayList<>();
		for(int i=0; i<m; ++i){
			int v1=rstn(),v2=rstn(),w=rstn();
			adjList[v1].add(new Pair(v2,w));
			adjList[v2].add(new Pair(v1,w));
		}
		j=rstn();s=rstn();
	}

	static int[] dijk(int cur){
		int[] d = new int[n+1];
		Arrays.fill(d,0x3f3f3f3f);
		PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(o->o.y));
		pq.add(new Pair(cur,0));
		d[cur] = 0;

		while(!pq.isEmpty()){
			Pair p = pq.poll();
			if(d[p.x] != p.y) continue;
			for(Pair nxt : adjList[p.x]){
				int nd = p.y+nxt.y;
				if(d[nxt.x]>nd){
					pq.add(new Pair(nxt.x,nd));
					d[nxt.x] = nd;
				}
			}
		}
		return d;
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
		jd = dijk(j);
		sd = dijk(s);
//		System.out.println(Arrays.toString(jd));
//		System.out.println(Arrays.toString(sd));
		int min = Integer.MAX_VALUE;
		for(int i=1; i<=n; ++i){
			if(i==s || i==j) continue;
			min = Math.min(jd[i]+sd[i],min);
			if(jd[i] > sd[i]) continue;
			answer.add(new Triple(jd[i]+sd[i],jd[i],i));
		}
		answer.sort(((o1, o2) -> o1.x == o2.x ? o1.y == o2.y ? o1.z - o2.z : o1.y - o2.y : o1.x - o2.x));
		System.out.println(answer.isEmpty() || answer.get(0).x!=min?-1:answer.get(0).z);
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
