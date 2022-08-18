package koala.preparation.week7.dijk;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P13911 {
	static int v,e;
	static HashMap<Integer,Integer>[] adjList;
	static int[] d,macd, stard;
	static int mcnt,scnt,marea,sarea,answer;
	static List<Integer> mac,star;
	static PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(o->o.y));

	static void init() throws IOException {
		v=rstn(); e=rstn();
		answer = Integer.MAX_VALUE;
		adjList = new HashMap[v+1];
		for(int i=1; i<=v; ++i) adjList[i] = new HashMap<>();
		for(int i=0; i<e; ++i){
			int v1=rstn(),v2=rstn(),w=rstn();
			adjList[v1].put(v2,Math.min(adjList[v1].getOrDefault(v2,Integer.MAX_VALUE),w));
			adjList[v2].put(v1,Math.min(adjList[v2].getOrDefault(v1,Integer.MAX_VALUE),w));
		}
		mac = new ArrayList<>();
		star = new ArrayList<>();
		mcnt=rstn(); marea=rstn();
		for(int i=0; i<mcnt; ++i) mac.add(rstn());
		scnt=rstn(); sarea=rstn();
		for(int i=0; i<scnt; ++i) star.add(rstn());
	}

	static void dijk(int area){
		while(!pq.isEmpty()){
			Pair p = pq.poll();
			if(d[p.x] != p.y) continue;
			for(Entry<Integer, Integer> nxt : adjList[p.x].entrySet()){
				int nd = p.y+nxt.getValue();
				if(nd > area) continue;
				if(d[nxt.getKey()]>nd){
					pq.add(new Pair(nxt.getKey(),nd));
					d[nxt.getKey()] = nd;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();

		d = new int[v+1];
		Arrays.fill(d,Integer.MAX_VALUE);
		for(int macpos: mac){
			d[macpos] = 0;
			pq.add(new Pair(macpos,0));
		}
		dijk(marea);
		macd = d.clone();

		Arrays.fill(d,Integer.MAX_VALUE);
		for(int starpos: star){
			d[starpos] = 0;
			pq.add(new Pair(starpos,0));
		}
		dijk(sarea);
		stard = d.clone();

		for(int i=1; i<=v; ++i){
			if(macd[i] == Integer.MAX_VALUE || stard[i]==Integer.MAX_VALUE || macd[i]==0 || stard[i]==0) continue;
			answer = Math.min(macd[i]+stard[i],answer);
		}
		System.out.println(answer==Integer.MAX_VALUE?-1:answer);
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
