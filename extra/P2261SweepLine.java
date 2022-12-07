package extra;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class P2261SweepLine {

	static List<Pair> p;
	static int n;

	// 두 Point의 거리를 반환하는 메소드
	private static int dist(Pair o1, Pair o2) {
		return (o1.x - o2.x) * (o1.x - o2.x) + (o1.y - o2.y) * (o1.y - o2.y);
	}

	public static void main(String[] args) throws IOException {
		n = rn();
		p = new ArrayList<>();
		for(int i = 0; i < n; i++) p.add(new Pair(rstn(), rstn()));
		p.sort(Comparator.comparingInt(o -> o.x));
		TreeSet<Pair> set = new TreeSet<>((o1, o2) -> {
			if (o1.y == o2.y) return o1.x - o2.x;
			return o1.y - o2.y;
		});
		int minDist = dist(p.get(0), p.get(1));
		set.add(p.get(0));
		set.add(p.get(1));
		int lowestIdx = 0;	// 왼쪽 끝점
		for(int i = 2; i < n; i++) {
			Pair benchPoint = p.get(i);
			while(lowestIdx < i) {
				Pair target = p.get(lowestIdx);
				int xDist = benchPoint.x - target.x;
				if(xDist * xDist > minDist) {
					set.remove(target);
					lowestIdx++;
				}
				else break;
			}
			int sqrtMinDist = (int)Math.sqrt(minDist) + 1;
			TreeSet<Pair> ySub = (TreeSet<Pair>) set.subSet(new Pair(-100000, benchPoint.y - sqrtMinDist), new Pair(100000, benchPoint.y + sqrtMinDist));
			for(Pair v : ySub) {
				minDist = Math.min(minDist, dist(benchPoint, v));
			}
			set.add(benchPoint);
		}
		System.out.println(minDist);
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