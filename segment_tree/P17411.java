package segment_tree;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P17411 {
	static int n,S,x,y;
	static final int mod = 1000000007;
	static List<Pair> pairs;
	static Pair zero = new Pair(0,0);
	static Pair[] seg;
	static void init() throws IOException {
		n=rn();
		pairs = new ArrayList<>();
		for(S=1; S<n; S*=2);
		seg = new Pair[S*2];
		for(int i=0; i<S*2; ++i) seg[i] = new Pair(0,0);
		est();
		pairs.add(new Pair(Integer.MIN_VALUE,Integer.MAX_VALUE));
		for(int i=1; i<=n; ++i) pairs.add(new Pair(rstn(),i));
		pairs.sort((o1, o2) -> o1.x == o2.x ? o2.y > o1.y ? 1 : -1 : o1.x > o2.x ? 1 : -1);
	}

	static void update1(int s, int e,int node,int idx,Pair p){
		if(s>idx || e<idx) return;
		if(seg[node].x == p.x){
			seg[node].y = (seg[node].y + p.y)%mod;
		}else if(seg[node].x<p.x){
			seg[node].x = p.x;
			seg[node].y = p.y;
		}
		if(s==e) return;
		int mid = (s+e)/2;
		update1(s, mid, node*2, idx, p);
		update1(mid+1, e, node*2+1, idx, p);
	}




	static Pair query(int s, int e, int node, int l, int r){
		if(l>e || s>r) return new Pair(0,0);
		if(l<=s && e<=r) return new Pair(seg[node]);
		int mid = (s+e)/2;
		Pair left = query(s, mid, node*2, l, r);
		Pair right = query(mid+1, e, node*2+1, l, r);
		if(left.x==right.x){
			return new Pair(left.x,(left.y+right.y)%mod);
		}else if(left.x>right.x){
			return new Pair(left);
		}else{
			return new Pair(right);
		}
	}


	public static void main(String[] args) throws IOException{
		br = Source.getBufferedReader();
		init();
		for(int i=1; i<=n; ++i){
			Pair p = query(1,S,1,1,(int)pairs.get(i).y-1);
			++p.x;
			p.y = Math.max(1,p.y);
//			System.out.println(p);
			update1(1,S,1,(int)pairs.get(i).y, p);
		}
		System.out.println(seg[1].x + " " + seg[1].y);
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
	static class Pair{int x; long y; public Pair(int x, long y) {this.x = x;this.y = y;}

		public Pair(Pair p) {
			this.x = p.x;
			this.y = p.y;
		}

		@Override
		public String toString() {
			return "Pair{" +
				"x=" + x +
				", y=" + y +
				'}';
		}
	}
}

