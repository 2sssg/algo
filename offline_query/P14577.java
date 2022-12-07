package offline_query;

import Constant.Source;
import java.util.*;
import java.io.*;

public class P14577 {

	static int n, q, s, idx, seg[];
	static long node[], temp[];
	static List<Long> list = new  ArrayList<>(), reverse = new ArrayList<>();
	static List<Query> queries = new  ArrayList<>();
	static Map<Long, Integer> map = new HashMap<>();

	static class Query{
		int t, n, k;
		long l, r;
		Query(int t, int n, int k) {
			this.t = t;
			this.n = n;
			this.k = k;
		}
		Query(int t, long l, long r) {
			this.t = t;
			this.l = l;
			this.r = r;
		}
		Query(int t, int k){
			this.t = t;
			this.k = k;
		}
	}
	static void update(int n, int k) {
		for(int i=map.get(node[n]) + s; i > 0; i /= 2) seg[i]--;
		for(int i=map.get(node[n] += k) + s; i > 0; i /= 2) seg[i]++;
	}
	static int cnt(int l, int r, int idx, int start, int end) {
		if(r < start || end < l) return 0;
		if(l <= start && end <= r) return seg[idx];
		int mid = (start + end) >> 1;
		return cnt(l, r, idx*2, start, mid) + cnt(l, r, idx * 2 + 1, mid + 1, end);
	}
	static long find(int idx, int k) {
		while(idx < s) {
			idx *= 2;
			if(seg[idx] < k)
				k -= seg[idx++];
		}
		return reverse.get(idx - s);
	}
	public static void main(String[] args) throws Exception {
		br = Source.getBufferedReader();
		n = rstn() + 1; q = rstn();
		node = new long[n];
		temp = new long[n];

		st = new StringTokenizer(br.readLine());
		for(int i = 1; i < n; i++)
			list.add(node[i] = temp[i] = Long.parseLong(st.nextToken()));

		while(q-- > 0) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			if(t == 4) queries.add(new Query(t, Integer.parseInt(st.nextToken())));
			else if (t == 3) {
				long l = Long.parseLong(st.nextToken()), r = Long.parseLong(st.nextToken());
				list.add(l);
				list.add(r);
				queries.add(new Query(t, l, r));
			}else {
				int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
				if(t == 2) k = -k;
				list.add(temp[n] += k);
				queries.add(new Query(t, n, k));
			}
		}
		Collections.sort(list);
		for(long n : list) {
			if(map.get(n) == null) {
				map.put(n, idx++);
				reverse.add(n);
			}
		}

		for(s = 1; s <= idx; s *= 2);
		seg = new int[s*2];

		for(int i = 1; i < n; i++)
			seg[map.get(node[i]) + s]++;

		for(int i = s - 1; i > 0; i--)
			seg[i] = seg[i * 2] + seg[i * 2 + 1];

		for(Query q : queries)
			switch (q.t) {
				case 3 : bw.write(cnt(map.get(q.l), map.get(q.r), 1, 0, s - 1) + "\n"); break;
				case 4 : bw.write(find(1, n - q.k) + "\n"); break;
				default: update(q.n, q.k);
			}
		bw.close();
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	private static int swap(int localA, int localB) {return localA;}
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
	static int[] ra() throws IOException {return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();}
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static boolean chk(int x, int y, int n, int m){return x<0 || y<0 || x>=n || y>=m;}
	static class Pair{int x,y;public Pair(int x, int y) {this.x = x;this.y = y;}}
	static class Triple{ int x,y,z;public Triple(int x, int y,int z) {this.x = x;this.y = y;this.z = z;}}
	static class Quad{ int w,x,y,z;public Quad(int w, int x, int y,int z) {this.w = w; this.x = x;this.y = y;this.z = z;}}
}