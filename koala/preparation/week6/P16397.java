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

public class P16397 {
	static int n,t,g;
	static int[] d = new int[100000];

	static String bfs(){
		Queue<Integer> q = new ArrayDeque<>();
		q.add(n);
		d[n] = 0;
		while(!q.isEmpty()){
			int cur = q.poll();
			if(cur==g) return String.valueOf(d[cur]);
			if(d[cur]!=t){
				if(cur+1<100000 && d[cur+1] == -1){
					q.add(cur+1);
					d[cur+1] = d[cur] + 1;
				}
				int temp = cur*2;
				int temp2 = (int)Math.pow(10,String.valueOf(temp).length()-1);
				temp = temp%temp2 + (temp/temp2 -1)*temp2;
				if(cur!=0&&cur*2<100000 && temp<100000&&d[temp] == -1){
					q.add(temp);
					d[temp] = d[cur] + 1;
				}
			}
		}
		return "ANG";

	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		n=rstn(); t=rstn(); g=rstn();
		Arrays.fill(d,-1);
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
	static boolean chk(int x, int y, int n, int m){return x<0 || y<0 || x>=n || y>=m;}
	static class Pair{int x,y;public Pair(int x, int y) {this.x = x;this.y = y;}}
	static class Triple{ int x,y,z;public Triple(int x, int y,int z) {this.x = x;this.y = y;this.z = z;}}
	static class Quad{ int w,x,y,z;public Quad(int w, int x, int y,int z) {this.w = w; this.x = x;this.y = y;this.z = z;}}
	////////////////////////////////bfs/////////////////////////////////////////////
}
