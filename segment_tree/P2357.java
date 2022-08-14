package segment_tree;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2357 {
	static int n,m;
	static int[] arr,minseg,maxseg;

	static void init() throws IOException {
		n=rstn(); m=rstn();
		arr = new int[n+1]; minseg = new int[4*n]; maxseg = new int[4*n];
		for(int i=1; i<=n; ++i) arr[i] = rn();
		minseginit(1,n,1);
		maxseginit(1,n,1);
	}

	static int minseginit(int s, int e, int node){
		if(s==e) return minseg[node] = arr[s];
		int mid = (s+e)/2;
		return minseg[node] = Math.min(minseginit(s,mid,node*2),minseginit(mid+1,e,node*2+1));
	}

	static int maxseginit(int s, int e, int node){
		if(s==e) return maxseg[node] = arr[s];
		int mid = (s+e)/2;
		return maxseg[node] = Math.max(maxseginit(s,mid,node*2),maxseginit(mid+1,e,node*2+1));
	}

	static int minquery(int s, int e, int node, int l, int r){
		if(s>r || e<l) return Integer.MAX_VALUE;
		if(l<=s && e<=r) return minseg[node];
		int mid = (s+e)/2;
		return Math.min(minquery(s, mid, node*2, l, r),minquery(mid+1, e, node*2+1, l, r));
	}


	static int maxquery(int s, int e, int node, int l, int r){
		if(s>r || e<l) return 0;
		if(l<=s && e<=r) return maxseg[node];
		int mid = (s+e)/2;
		return Math.max(maxquery(s, mid, node*2, l, r),maxquery(mid+1, e, node*2+1, l, r));
	}


	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
		while(m-->0){
			int l = rstn(),r=rstn();
			bw.append(Integer.toString(minquery(1,n,1,l,r)))
				.append(" ")
				.append(Integer.toString(maxquery(1,n,1,l,r)))
				.append("\n");
		}
		bw.flush();
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
}
