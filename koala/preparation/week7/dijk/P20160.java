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
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P20160 {
	static int v,e,s;
	static HashMap<Integer,Integer>[] adjList;
	static int[] seq,mydist,yogultdist;
	static List<Integer> answer ;

	static void init() throws IOException {
		v=rstn(); e=rstn();
		answer = new ArrayList<>();
		adjList = new HashMap[v+1];
		for(int i=1; i<=v; ++i) adjList[i] = new HashMap<>();
		for(int i=0; i<e; ++i){
			int v1=rstn(),v2=rstn(),w=rstn();
			adjList[v1].put(v2,Math.min(adjList[v1].getOrDefault(v2,Integer.MAX_VALUE),w));
			adjList[v2].put(v1,Math.min(adjList[v2].getOrDefault(v1,Integer.MAX_VALUE),w));
		}
		System.out.println(adjList[1]);
		seq = ra();
		s=rn();
	}

	static void myDijk(){
		mydist = new int[v+1];
		Arrays.fill(mydist,Integer.MAX_VALUE);
		PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(o->o.y));
		pq.add(new Pair(s,0));
		mydist[s] = 0;
		while(!pq.isEmpty()){
			Pair p = pq.poll();
			if(mydist[p.x] != p.y) continue;
			for(Entry<Integer,Integer> en : adjList[p.x].entrySet()){
				if(mydist[en.getKey()] > p.y+en.getValue()){
					mydist[en.getKey()] =  p.y+en.getValue();
					pq.add(new Pair(en.getKey(),p.y+en.getValue()));
				}
			}
		}
	}

	static int[] yogultDijk(int ys){
		int[] d = new int[v+1];
		Arrays.fill(d,Integer.MAX_VALUE);
		PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(o->o.y));
		pq.add(new Pair(ys,0));
		d[ys] = 0;
		while(!pq.isEmpty()){
			Pair p = pq.poll();
			if(d[p.x] != p.y) continue;
			for(Entry<Integer,Integer> en : adjList[p.x].entrySet()){
				if(d[en.getKey()] > p.y+en.getValue()){
					d[en.getKey()] =  p.y+en.getValue();
					pq.add(new Pair(en.getKey(),p.y+en.getValue()));
				}
			}
		}
		return d;
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
		myDijk();
		if(seq[0] == s) answer.add(s);
		int pre = seq[0];
		int sum = 0;
		for(int i=1; i<10; ++i){
			int[] di = yogultDijk(pre);
			if(di[seq[i]] != Integer.MAX_VALUE){
				sum += di[seq[i]];
				if(mydist[seq[i]] <= sum){
					answer.add(seq[i]);
				}
				pre = seq[i];
			}
		}
		Collections.sort(answer);
		System.out.println(answer.isEmpty()?-1:answer.get(0));

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
	static class Pair{int x,y; public Pair(int x, int y) {this.x = x;this.y = y;}

		@Override
		public String toString() {
			return "Pair{" +
				"x=" + x +
				", y=" + y +
				'}';
		}
	}
	static class Triple{ int x,y,z;public Triple(int x, int y,int z) {this.x = x;this.y = y;this.z = z;}}
	static class Quad{ int w,x,y,z;public Quad(int w, int x, int y,int z) {this.w = w; this.x = x;this.y = y;this.z = z;}}
}
