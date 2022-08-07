package segment_tree;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P9426 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n,k;
	static int[] tree,arr;

	static void update(int s, int e, int node, int idx,int diff){
		if(s>idx || e<idx) return;
		tree[node] += diff;
		if(s==e) return;
		update(s,(s+e)/2, node*2, idx,diff);
		update((s+e)/2+1,e, node*2+1, idx,diff);
	}

	static int query(int s, int e, int node,int cnt){
		if(s==e) return s;
		if(tree[node*2]>=cnt) return query(s,(s+e)/2, node*2,cnt);
		else return query((s+e)/2+1, e, node*2+1, cnt-tree[node*2]);
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); k = Integer.parseInt(st.nextToken());
		tree = new int[65535*4+1];
		arr = new int[n+1];
		long sum = 0;
		for(int i=1; i<=n; ++i){
			arr[i] = Integer.parseInt(br.readLine());
			update(0,65537,1,arr[i],1);
			if(i>=k){
				sum += query(0,65537,1,(k+1)/2);
				update(0,65537,1,arr[i-k+1],-1);
			}

		}
		System.out.println(sum);
	}
}
