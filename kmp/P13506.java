package kmp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P13506 {
	static String t,p;
	static int pLength;
	static int[] pi;

	static void makepi(int length){
		pi = new int[length];
		int idx = 0;
		for(int i=1; i<length; ++i){
			while(idx>0 && p.charAt(i)!=p.charAt(idx)) idx = pi[idx-1];
			if(p.charAt(i)==p.charAt(idx)) pi[i] = ++idx;
		}
	}

	public static void main(String[] args) throws IOException {
		p = br.readLine();
		pLength = p.length();
		makepi(pLength);
		int presubLength = pi[pLength - 1];
		String pattern = "";
		out: while(presubLength > 0) {
			for(int i=1; i < pLength - 1; i++) {
				if(pi[i] == presubLength) {
					pattern = p.substring(i - presubLength + 1, i + 1);
					break out;
				}
			}
			presubLength = pi[presubLength - 1];
		}

		System.out.println(pattern.isEmpty() ? "-1" : pattern);
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
