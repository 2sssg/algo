package kaupc;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class D {
	static int n,k;
	static int[] arr;
	static PriorityQueue<Pair> pq = new PriorityQueue<>();

	static void init() throws IOException {
		n=rstn(); k=rstn();
		arr = ra();
	}
	public static void main(String[] args) throws IOException {
		init();
		for (int i=0; i<k; ++i){
			pq.add(new Pair(arr[i], i));
		}
		int min = pq.peek().x;
		for (int i = 0; i < n - k + 1; ++i){
			pq.add(new Pair(arr[i+k-1], i+k-1));
			while (pq.peek().y < i){
				pq.poll();
			}
			if (min < pq.peek().x){
				min = pq.peek().x;
			}
		}
		System.out.println(min);

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
	static class Pair implements Comparable<Pair>
	{
		int x,y;public Pair(int x, int y) {this.x = x;this.y = y;}


		@Override
		public String toString() {
			return "Pair{" +
				"x=" + x +
				", y=" + y +
				'}';
		}

		@Override
		public int compareTo(Pair o) {
			if (o.x == this.x)
				return o.y - this.y;
			return this.x - o.x;
		}
	}
	static class Triple{ int x,y,z;public Triple(int x, int y,int z) {this.x = x;this.y = y;this.z = z;}}
	static class Quad{ int w,x,y,z;public Quad(int w, int x, int y,int z) {this.w = w; this.x = x;this.y = y;this.z = z;}}
}
