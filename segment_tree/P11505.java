package segment_tree;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11505 {
	static int n,m,k;
	static int[] arr;
	static long[] tree;
	static final long MODNUM = 1000000007;

	static void update(int s, int e, int node, int idx, long diff, long origin){
		if(idx<s || idx>e) return;
		tree[node] = (tree[node]/origin*diff)%MODNUM;
		if(s==e) return;
		update(s,(s+e)/2,node*2, idx, diff,origin);
		update((s+e)/2+1, e, node*2+1, idx, diff,origin);
	}

	static long query(int s, int e, int node, int l, int r){
		if(s>r || e<l) return 1;
		if(s>=l && e<=r) return tree[node];
		int mid = (s+e)/2;
		return (query(s,mid,node*2, l, r)*query(mid+1, e,node*2+1, l, r))%MODNUM;
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		est(); n=rstn(); m=rstn(); k=rstn();
		arr = new int[n+1];
		tree = new long[4*n];
		Arrays.fill(tree,1);
		for(int i=1; i<=n; ++i) arr[i] = rn();
		int cnt = m+k;
		for(int i=1; i<=n; ++i) {
			update(1,n,1,i,arr[i],1);
		}
		while(cnt-->0){
			est();
			int type = rstn();
			int b = rstn(),c=rstn();
			if(type==1){
				long origin = arr[b];
				arr[b] = c;
				update(1,n,1,b,arr[b],origin);
			}else{
				System.out.println(query(1,n,1,b,c));
			}
		}


	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() {return Integer.parseInt(st.nextToken());}
	static int[] ra() throws IOException {return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();}
}
