package segment_tree;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P1275 {
	static int n,q,x,y,a,b;
	static int[] arr;
	static long[] seg;

	static void init() throws IOException {
		n=rstn(); q=rstn();
		arr = new int[n+1];
		seg = new long[4*n];
		for(int i=1; i<=n; ++i) arr[i] = rstn();
		seginit(1,n,1);
	}

	static long seginit(int s, int e, int node){
		if(s==e) return seg[node] = arr[s];
		int mid = (s+e)/2;
		return seg[node] = seginit(s, mid, node*2) + seginit(mid+1, e, node*2+1);
	}

	static long query(int s, int e, int node, int l, int r){
		if(s>r || e<l) return 0;
		if(l<=s && e<=r) return seg[node];
		int mid = (s+e)/2;
		return query(s, mid, node*2, l, r) + query(mid+1, e, node*2+1, l, r);
	}

	static void update(int s, int e, int node, int idx, long diff){
		if(idx<s || idx>e) return;
		seg[node] += diff;
		if(s==e) return;
		int mid = (s+e)/2;
		update(s, mid, node*2, idx, diff);
		update(mid+1, e, node*2+1, idx, diff);
	}

	static long onecycle() throws IOException {
		x=rstn(); y=rstn(); a=rstn(); b=rstn();
		if(y<x) {x = x^y;y = x^y;x = x^y;}
		long ret = query(1, n, 1, x, y);
		long diff = (long)b - (long)arr[a];
		arr[a] = b;
		update(1, n, 1, a, diff);
		return ret;
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
		while(q-->0) bw.append(Long.toString(onecycle())).append("\n");
		bw.flush();
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int swap(int a, int b){return a;}
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
}
