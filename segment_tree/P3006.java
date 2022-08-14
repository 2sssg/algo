package segment_tree;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class P3006 {
	static int n;
	static boolean flag;
	static List<Pair> arr;
	static int[] seg;

	static void init() throws IOException {
		arr = new ArrayList<>();
		n = rn();
		seg = new int[4*n];
		for(int i=1; i<=n; ++i) arr.add(new Pair(rn(),i));
		arr.sort(Comparator.comparingInt(o->o.x));
		treeinit(1,n,1);
	}

	static int treeinit(int s, int e, int node){
		if(s==e) return seg[node] = 1;
		int mid = (s+e)/2;
		return seg[node] = treeinit(s, mid, node*2)+treeinit(mid+1, e, node*2+1);
	}

	static int query(int s, int e, int node, int l, int r){
		if(r<=s || e<=l) return 0;
		if(l<=s && r>=e) return seg[node];
		int mid = (s+e)/2;
		return query(s, mid, node*2, l, r) + query(mid+1, e, node*2+1, l, r);
	}

	static void erase(int s, int e, int node, int idx){
		if(s>idx || e<idx) return;
		seg[node]--;
		if(s==e) return;
		int mid = (s+e)/2;
		erase(s, mid, node*2, idx);
		erase(mid+1, e, node*2+1, idx);
	}


	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
		for(int i=0,j=arr.size()-1; i<=j; ++i,--j){
			erase(1,n,1,arr.get(i).y);
			bw.append(Integer.toString(query(1,n,1,1,arr.get(i).y))).append("\n");
			if(i==j) break;
			erase(1,n,1,arr.get(j).y);
			bw.append(Integer.toString(query(1,n,1,arr.get(j).y,n))).append("\n");
		}
		bw.flush();
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
