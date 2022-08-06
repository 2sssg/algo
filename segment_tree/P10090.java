package segment_tree;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P10090 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;
	static int[] tree,arr;

	static long query(int s, int e, int node, int l, int r){
		if(e<l || s>r) return 0;
		if(l<=s && r>=e) return tree[node];
		int mid = (s+e)/2;
		return query(s,mid,node*2,l,r) + query(mid+1, e, node*2+1, l, r);
	}

	static int update(int s, int e, int node, int idx){
		if(e < idx || idx < s) return tree[node];
		if(s == e) return ++tree[node];
		int mid = (s+e)/2;
		return tree[node] = update(s, mid, node*2, idx) + update(mid+1, e, node*2+1, idx);
	}



	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1];
		tree = new int[4*n];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; ++i) arr[i] = Integer.parseInt(st.nextToken());
		long sum = 0;
		for(int i=n; i>0; --i){
			sum += query(1,n,1,1,arr[i]-1);
			update(1,n,1,arr[i]);
		}
		System.out.println(sum);



	}
}
