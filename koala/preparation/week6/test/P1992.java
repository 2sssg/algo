package koala.preparation.week6.test;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1992 {
	static int n;
	static int[][] arr;

	static boolean chk(int x1, int y1, int x2, int y2){
		int chknum = arr[x1-1][y1-1];
		for(int x=x1-1; x<x2; ++x){
			for(int y=y1-1; y<y2; ++y){
				if(arr[x][y] != chknum) return false;
			}
		}
		return true;
	}

	static void f(int x1, int y1, int x2, int y2) throws IOException {
		if(chk(x1,y1,x2,y2)) {
			bw.append(Integer.toString(arr[x1-1][y1-1]));
			return;
		}
		bw.append("(");
		f(x1,y1,(x1+x2)/2,(y1+y2)/2);
		f(x1,(y1+y2)/2+1,(x1+x2)/2,y2);
		f((x1+x2)/2+1,y1,x2,(y1+y2)/2);
		f((x1+x2)/2+1,(y1+y2)/2+1,x2,y2);
		bw.append(")");
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		arr = new int[n=rstn()][n];
		for(int i=0; i<n; ++i) arr[i] = ra();
		f(1,1,n,n);
		bw.flush();
	}
	////////////////////////////////bfs/////////////////////////////////////////////
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
	static int[] ra() throws IOException {return Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();}
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static class Pair{int x,y;public Pair(int x, int y) {this.x = x;this.y = y;}}
	static class Triple{ int x,y,z;public Triple(int x, int y,int z) {this.x = x;this.y = y;this.z = z;}}
	static class Quad{ int w,x,y,z;public Quad(int w, int x, int y,int z) {this.w = w; this.x = x;this.y = y;this.z = z;}}
	////////////////////////////////bfs/////////////////////////////////////////////
}
