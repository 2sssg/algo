package koala.preparation.week6;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class P13700 {
	static int n,s,d,f,b,k;
	static int[] visit;

	static String bfs(){
		Queue<Integer> q = new ArrayDeque<>();
		q.add(s);
		visit[s] = 0;

		while(!q.isEmpty()){
			int cur = q.poll();
			if(cur == d) return String.valueOf(visit[cur]);
			int back = cur-b;
			int forward = cur+f;
			if(!chk(back,n) && visit[back]==-1){
				q.add(back);
				visit[back] = visit[cur] +1;
			}
			if(!chk(forward,n) && visit[forward] == -1){
				q.add(forward);
				visit[forward] = visit[cur]+1;
			}
		}
		return "BUG FOUND";
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		n=rstn(); s=rstn(); d=rstn(); f=rstn(); b=rstn(); k=rstn();
		visit = new int[n+1];
		Arrays.fill(visit,-1);
		while(k-->0) visit[rstn()] = -2;
		System.out.println(bfs());
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
	static boolean chk(int x,int n){return x<1 || x>n;}
	static class Pair{int x,y;public Pair(int x, int y) {this.x = x;this.y = y;}}
	static class Triple{ int x,y,z;public Triple(int x, int y,int z) {this.x = x;this.y = y;this.z = z;}}
	static class Quad{ int w,x,y,z;public Quad(int w, int x, int y,int z) {this.w = w; this.x = x;this.y = y;this.z = z;}}
	////////////////////////////////bfs/////////////////////////////////////////////
}
