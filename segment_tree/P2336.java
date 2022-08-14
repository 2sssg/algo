package segment_tree;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2336 {
	static int n,answer;
	static int[] exam1,exam2,exam3,tree;

	static void init() throws IOException {
		n = rn();
		exam1 = new int[n+1]; exam2 = new int[n+1]; exam3 = new int[n+1];
		for(int i=1; i<=n; ++i) exam1[i] = rstn();
		for(int i=1; i<=n; ++i) exam2[rstn()] = i;
		for(int i=1; i<=n; ++i) exam3[rstn()] = i;
		tree = new int[4*n];
		Arrays.fill(tree,Integer.MAX_VALUE);
	}

	static int update(int s, int e, int node, int idx, int diff){
		if(idx<s || idx>e) return tree[node];
		if(s==e) return tree[node] = diff;
		int mid = (s+e)/2;
		return tree[node] = Math.min(update(s,mid,node*2,idx,diff), update(mid+1, e, node*2+1, idx, diff));
	}

	static int query(int s, int e, int node, int l, int r){
		if(e<l || s>r) return Integer.MAX_VALUE;
		if(l<=s && e<=r) return tree[node];
		int mid = (s+e)/2;
		return Math.min(query(s,mid,node*2,l,r),query(mid+1, e, node*2+1, l, r));
	}

	static boolean amazing(int cur){
		update(1,n,1,exam2[cur],exam3[cur]);
		return query(1,n,1,1,exam2[cur]) == exam3[cur];
	}



	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
		for(int i=1; i<=n; ++i) answer += amazing(exam1[i])?1:0;
		System.out.println(answer);
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
}
