package kaupc;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;
import java.util.StringTokenizer;

public class B {
	static int n;
	static String a,b;
	static HashMap<String, HashSet<String>> upmap;
	static HashMap<String, HashSet<String>> downmap;
	public static void main(String[] args) throws IOException {

		n = rn();
		upmap = new HashMap<>();
		downmap = new HashMap<>();
		while (n-->1) {
			est();
			a = st.nextToken();
			b = st.nextToken();
			if (!upmap.containsKey(a)) {
				upmap.put(a, new HashSet<>());
			}
			upmap.get(a).add(b);
			if (!downmap.containsKey(b)) {
				downmap.put(b, new HashSet<>());
			}
			downmap.get(b).add(a);
		}
		est();
		a =st.nextToken();
		b = st.nextToken();

		Queue<String> q = new ArrayDeque<>();
		q.add(a);
		HashSet<String> visit = new HashSet<>();
		while (!q.isEmpty()){
			String temp = q.poll();
			if (temp.equals(b))
			{
				System.out.println(1);
				System.exit(0);
			}
			if (!upmap.containsKey(temp)) continue;
			for(String nxt : upmap.get(temp))
			{
				if (visit.contains(nxt)) continue;
				q.add(nxt);
				visit.add(nxt);
			}
		}
		q.add(a);
		visit.clear();
		while (!q.isEmpty()){
			String temp = q.poll();
			if (temp.equals(b)){
				System.out.println(1);
				System.exit(0);
			}
			if (!downmap.containsKey(temp)) continue;
			for(String nxt : downmap.get(temp))
			{
				if (visit.contains(nxt)) continue;
				q.add(nxt);
				visit.add(nxt);
			}
		}
		System.out.println(0);

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
	static class Pair{int x,y;public Pair(int x, int y) {this.x = x;this.y = y;}}
	static class Triple{ int x,y,z;public Triple(int x, int y,int z) {this.x = x;this.y = y;this.z = z;}}
	static class Quad{ int w,x,y,z;public Quad(int w, int x, int y,int z) {this.w = w; this.x = x;this.y = y;this.z = z;}}
}
