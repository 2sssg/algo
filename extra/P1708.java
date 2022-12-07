package extra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class P1708 {
	static Pair root = new Pair(Long.MAX_VALUE, Long.MAX_VALUE);
	static int n;
	static List<Pair> points = new ArrayList<>();
	static int ccw(Pair p1, Pair p2, Pair p3) {
		long result = (p1.x * p2.y + p2.x * p3.y + p3.x * p1.y) - (p2.x * p1.y + p3.x * p2.y + p1.x * p3.y);
		if (result > 0) return 1;
		else if (result < 0) return -1;
		else return 0;
	}

	static long dist(Pair p1, Pair p2) {
		return (p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y);
	}

	public static void main(String[] args) throws IOException {
		n = rn();
		for (int i = 0; i < n; ++i) points.add(new Pair(rstn(), rstn()));
		for (Pair point : points) if ((point.y < root.y) || (point.y == root.y && point.x < root.x)) root = point;
		points.sort((o1, o2) -> {
			int result = ccw(root, o1, o2);
			if (result > 0) return -1;
			else if (result < 0) return 1;
			else if (dist(root, o1) > dist(root, o2)) return 1;
			return -1;
		});
		Stack<Pair> stack = new Stack<>();
		stack.add(root);
		for (int i = 1; i < points.size(); i++) {
			while (stack.size() > 1
					&& (ccw(stack.get(stack.size() - 2), stack.get(stack.size() - 1), points.get(i)) <= 0))
				stack.pop();
			stack.add(points.get(i));
		}
		System.out.println(stack.size());
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
	static class Pair{long x,y;public Pair(long x, long y) {this.x = x;this.y = y;}}
	static class Triple{ int x,y,z;public Triple(int x, int y,int z) {this.x = x;this.y = y;this.z = z;}}
	static class Quad{ int w,x,y,z;public Quad(int w, int x, int y,int z) {this.w = w; this.x = x;this.y = y;this.z = z;}}
}
