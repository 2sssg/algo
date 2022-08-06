package koala.preparation.week4.binarysearch;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P13905 {
	static class Pair{
		int v,w;
		public Pair(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int v,e;
	static List<Pair>[] adjList;
	static int me,heybin;
	static int low,high;
	static int mid;
	static boolean[] visit;

	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() {return Integer.parseInt(st.nextToken());}


	static void init() throws IOException {
		est(); v=rstn(); e=rstn();

		visit = new boolean[v+1];

		adjList = new ArrayList[v+1];
		for(int i=0; i<=v; ++i) adjList[i] = new ArrayList<>();

		est(); me=rstn(); heybin=rstn();

		for(int i=0; i<e; ++i){
			est();
			int v1 = rstn(),v2=rstn(), w=rstn();
			adjList[v1].add(new Pair(v2,w));
			adjList[v2].add(new Pair(v1,w));
		}
		low = 0;
		high = 1000005;
	}

	static boolean dfs(int cur){
		if(cur == heybin) return true;
		for(Pair next: adjList[cur]){
			if(visit[next.v]) continue;
			if(next.w<mid) continue;
			visit[next.v] = true;
			if(dfs(next.v)) return true;
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();

		init();

		while(low+1<high){
			mid = (low+high)/2;
//			System.out.println("low : " + low);
//			System.out.println("mid : " + mid);
//			System.out.println("high : " + high);
//			System.out.println();
			Arrays.fill(visit,false);
			visit[me] = true;
			if(dfs(me)){
				low = mid;
			}else{
				high = mid;
			}
		}
//		System.out.println("low : " + low);
//		System.out.println("high : " + high);
		System.out.println(low);
	}
}
