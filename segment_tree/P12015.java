package segment_tree;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P12015 {
	static class Pair{
		int x,y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int n,answer;
	static int[] tree;
	static Pair[] pairs;

	static int update(int s, int e, int node, int idx){
		if(idx<s || e<idx) return tree[node];
		if(s==e) return tree[node] = query(1,n,1,1,e-1)+1;
		int mid = (s+e)/2;
		return tree[node] = Math.max(update(s,mid,node*2,idx),update(mid+1, e, node*2+1, idx));
	}

	static int query(int s, int e, int node, int l, int r){
		if(r<s || l>e) return 0;
		if(l<=s && e<=r) return tree[node];
		int mid = (s+e)/2;
		return Math.max(query(s,mid,node*2,l,r),query(mid+1, e, node*2+1,l,r));
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		n= Integer.parseInt(br.readLine());
		pairs = new Pair[n+1];
		pairs[0] = new Pair(-1,-1);
		tree = new int[4*n];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; ++i) pairs[i] = new Pair(Integer.parseInt(st.nextToken()),i);
		Arrays.sort(pairs,(o1,o2)->o1.x==o2.x?o2.y-o1.y:o1.x-o2.x);

		for(int i=1; i<=n; ++i){
			update(1,n,1,pairs[i].y);
			System.out.println(Arrays.toString(tree));
		}
		System.out.println(tree[1]);

	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
}
