package segment_tree;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1280 {
	static int n,cnt;
	static long sum;
	static final int s = 200000;
	static Pair[] seg;
	static final long mod = 1000000007;
	static long answer;

	static void init() throws IOException {
		answer = 1;
		n=rn();
		seg = new Pair[4*s+1];
		for(int i=0; i<=4*s; ++i) seg[i] = new Pair(0,0);
	}

	static void update(int s, int e, int node, int idx, int diff){
		if(idx<s || idx>e) return;
		seg[node].y += diff;
		seg[node].x++;
		if(s==e) return;
		int mid = (s+e)/2;
		update(s, mid, node*2, idx, diff);
		update(mid+1, e, node*2+1, idx, diff);
	}

	static void query(int s, int e, int node, int l, int r){
		if(s>r || e<l) return;

		if(l<=s && e<=r){
			cnt += seg[node].x;
			sum += seg[node].y;
			return;
		}
		int mid = (s+e)/2;
		query(s, mid, node*2, l, r);
		query(mid+1, e, node*2+1, l, r);
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
		int cur = rn();
		update(0,s,1,cur, cur);

		for(int i=2; i<=n; ++i){
			int pos = rn();

			cnt = 0;
			sum = 0;
			query(0,s,1,0, Math.max(pos - 1, 0));
			long left = ((long)cnt *pos)-sum;

			cnt = 0;
			sum = 0;
			query(0,s,1,Math.min(s,pos+1),s);
			long right = sum - ((long)cnt *pos);

			long tempanswer = left+right;
			answer = (answer*(tempanswer))%mod;

			update(0,s,1,pos,pos);
		}
		System.out.println(answer);

	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
	static int[] ra() throws IOException {return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();}
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static boolean chk(int x, int y, int n, int m){return x<0 || y<0 || x>=n || y>=m;}
	static class Pair{int x;long y;public Pair(int x, long y) {this.x = x;this.y = y;}

		@Override
		public String toString() {
			return "Pair{" +
				"x=" + x +
				", y=" + y +
				'}';
		}
	}
	static class Triple{ int x,y,z;public Triple(int x, int y,int z) {this.x = x;this.y = y;this.z = z;}}
	static class Quad{ int w,x,y,z;public Quad(int w, int x, int y,int z) {this.w = w; this.x = x;this.y = y;this.z = z;}}
}
