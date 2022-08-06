package segment_tree;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1725 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;
	static int[] arr,tree;

	static void init() throws IOException {
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1];
		tree = new int[4*n+1];
		arr[0] = Integer.MAX_VALUE;
		for(int i=1; i<=n; ++i) arr[i] = Integer.parseInt(br.readLine());
	}

	static int treeinit(int s, int e, int node){
		if(s==e) return tree[node] = s;
		int left = treeinit(s,(s+e)/2,node*2);
		int right = treeinit((s+e)/2+1,e,node*2+1);
		return tree[node] = arr[left]<=arr[right]?left:right;
	}

	static int query(int s, int e, int node, int l, int r){
		if(s>r || e<l) return 0;
		if(l<=s && r>=e) return tree[node];
		int left = query(s,(s+e)/2, node*2, l,r);
		int right = query((s+e)/2+1,e,node*2+1,l,r);
		return arr[left]<=arr[right]?left:right;
	}

	static long calc(int s, int e){
		if(s>e)return -1;
		if(s==e) return arr[s];
		int mhi = query(1,n,1,s,e);
		long max = (long)(e-s+1) * (long)arr[mhi];
		max = Math.max(max,calc(s,mhi-1));
		max = Math.max(max,calc(mhi+1,e));
		return max;
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
		treeinit(1,n,1);
		System.out.println(calc(1,n));

	}
}

