package koala.preparation.week6.bfsdfs;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P18232 {
	static int n,m;
	static int s,e;
	static List<Integer>[] adjList;

	static void init() throws IOException {
		n=rstn(); m=rstn(); s=rstn(); e=rstn();
		adjList = new ArrayList[n+1];
		for(int i=0; i<=n; ++i) adjList[i] = new ArrayList<>();
		for(int i=0; i<m; ++i) {
			int v1=rstn(),v2=rstn();
			adjList[v1].add(v2);
			adjList[v2].add(v1);
		}
	}

	static int bfs(){
		Queue<Integer> q = new ArrayDeque<>();
		int[] d = new int[n+1];
		Arrays.fill(d,-1);
		q.add(s);
		d[s] = 0;

		while(!q.isEmpty()){
			int cur = q.poll();
			if(cur==e) return d[cur];
			if(cur-1>=1 && d[cur-1]==-1){
				q.add(cur-1);
				d[cur-1] = d[cur]+1;
			}
			if(cur+1<=n && d[cur+1]==-1){
				q.add(cur+1);
				d[cur+1] = d[cur]+1;
			}
			for(int nxt: adjList[cur]){
				if(d[nxt] != -1) continue;
				q.add(nxt);
				d[nxt] = d[cur]+1;
			}
		}
		return -1;
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
		System.out.println(bfs());
	}
	////////////////////////////////bfs/////////////////////////////////////////////
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
	////////////////////////////////bfs/////////////////////////////////////////////
}
