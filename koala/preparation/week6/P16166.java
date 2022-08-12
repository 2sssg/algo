package koala.preparation.week6;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;
import java.util.StringTokenizer;

public class P16166 {
	static int n,dest;
	static HashSet<Integer>[] adjList;
	static HashMap<Integer,Integer> d;

	static int bfs(){
		Queue<Integer> q = new ArrayDeque<>();
		q.add(0);
		d.put(0,0);

		while(!q.isEmpty()){
			int cur = q.poll();
			if(cur==dest) return d.get(cur);
			for(int i=0; i<n; ++i){
				if(adjList[i].contains(cur)){
					for(int nxt: adjList[i]){
						if(!d.containsKey(nxt)){
							q.add(nxt);
							d.put(nxt,d.get(cur)+1);
						}
					}
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		d=new HashMap<>();
		n=rstn();

		adjList = new HashSet[n];
		for(int i=0; i<n; ++i){
			adjList[i] = new HashSet<>();
			int cnt = rstn();
			while(cnt-->0){
				adjList[i].add(rstn());
			}
		}
		dest = rstn();
		if (dest == 0) {
			System.out.println(0);
			return;
		}
		System.out.println(bfs()-1);
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
}
