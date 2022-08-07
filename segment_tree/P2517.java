package segment_tree;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class P2517 {
	static class Pair{
		int x,y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Pair{" +
				"x=" + x +
				", y=" + y +
				'}';
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n;
	static Pair[] ps;
	static int[] tree;
	static int[] answer;

	static int query(int s,int e, int node, int l, int r){
		if(s>r || e<l) return 0;
		if(s>=l && e<=r) return tree[node];
		int mid = (s+e)/2;
		return query(s,mid,node*2,l,r) + query(mid+1, e, node*2+1, l, r);
	}

	static void update(int s, int e, int node, int idx, int diff){
		if(idx<s || idx>e) return;
		tree[node] += diff;
		if(s==e) return;
		int mid = (s+e)/2;
		update(s, mid, node*2, idx, diff);
		update(mid+1, e, node*2+1, idx, diff);
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		n = Integer.parseInt(br.readLine());
		tree = new int[4*n+1];
		ps = new Pair[n+1];
		answer = new int[n+1];
		ps[0] = new Pair(-1,0);
		for(int i=1; i<=n; ++i) ps[i] = new Pair(Integer.parseInt(br.readLine()),i);
		Arrays.sort(ps,(o1,o2)-> o1.x==o2.x?o1.y-o2.y:o1.x-o2.x);
		for(int i=1; i<=n; ++i){
			answer[ps[i].y] = ps[i].y-query(1,n,1,1,ps[i].y);
			update(1,n,1,ps[i].y,1);
		}
		for(int i=1; i<=n; ++i){
			bw.write(String.valueOf(answer[i]));
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
}
