package segment_tree;

import Constant.Source;
import java.io.*;
import java.util.*;

public class P3745 {
	static int n;
	static Pair[] pairs;
	static int[] seg;

	static void init() throws IOException {
		n=Integer.parseInt(br.readLine().trim());
		pairs = new Pair[n+1];
		seg = new int[4*n];
		est();
		pairs[0] = new Pair(Integer.MIN_VALUE,Integer.MAX_VALUE);
		for(int i=1; i<=n; ++i) pairs[i] = new Pair(rstn(),i);
		Arrays.sort(pairs, (o1,o2)->o1.x==o2.x?o2.y>o1.y?1:-1:o1.x>o2.x?1:-1);
	}

	static int update(int s, int e, int node, int idx){
		if(s>idx || e<idx) return seg[node];
		if(s==e) return seg[node] = query(1, n, 1, 1, s-1)+1;
		int mid = (s+e)/2;
		return seg[node] = Math.max(update(s, mid, node*2, idx),update(mid+1, e, node*2+1, idx));
	}

	static int query(int s, int e, int node, int l, int r){
		if(l>e || s>r) return 0;
		if(l<=s && e<=r) return seg[node];
		int mid = (s+e)/2;
		return Math.max(query(s, mid, node*2, l, r),query(mid+1, e, node*2+1, l, r));
	}

	public static void main(String[] args) {
		br = Source.getBufferedReader();
		while(true){
			try{
				init();
				int answer = 0;
				for(int i=1; i<=n; ++i){
					update(1,n,1, pairs[i].y);
				}
				System.out.println(seg[1]);
			}catch (Exception e){
				break;
			}
		}

	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
	static class Pair{int x,y;public Pair(int x, int y) {this.x = x;this.y = y;}}
}
