package segment_tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2104 {

	public static int N;
	public static long Num[];

	public static void main(String[] args) throws IOException {
		N = rn();
		Num = ra();
		System.out.println(Math.max(input(0, N-1), input1(0, N-1)));
	}

	public static long input(int start, int end) {
		if (start > end)
			return -1;
		if (start == end)
			return Num[start] * Num[start];
		int mid = (start + end) / 2;
		long max = Math.max(input(start, mid), input(mid+1, end));

		int left = mid;
		int right = mid+1;
		long sum = Num[left] + Num[right];
		long min = Math.min(Num[left], Num[right]);
		max = Math.max(max, min * sum);
		while (left > start || right < end) {
			if (right < end && (left == start || Num[left-1] <  Num[right+1])) {
				right++;
				sum += Num[right];
				min = Math.min(min, Num[right]);
			} else {
				left--;
				sum += Num[left];
				min = Math.min(min, Num[left]);
			}
			max = Math.max(max, min * sum);
		}

		return max;
	}

	public static long input1(int start, int end) {
		if (start > end)
			return -1;
		if (start == end)
			return Num[start] * Num[start];
		int mid = (start + end) / 2;
		long max = Math.max(input1(start, mid-1), input1(mid+1, end));

		long sum = Num[mid];
		long min = Num[mid];
		int left = mid;
		int right = mid;
		while (right - left < end - start) {
			long leftValue;
			long rightValue;

			if (left > start)
				leftValue = Num[left-1];
			else
				leftValue = -1;
			if (right < end)
				rightValue = Num[right+1];
			else
				rightValue = -1;

			if (leftValue > rightValue) {
				sum += leftValue;
				min = Math.min(min, leftValue);
				left--;
			} else {
				sum += rightValue;
				min = Math.min(min, rightValue);
				right++;
			}

			max = Math.max(max, sum * min);
		}
		return max;
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	private static int swap(int localA, int localB) {return localA;}
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
	static long[] ra() throws IOException {return Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();}
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static boolean chk(int x, int y, int n, int m){return x<0 || y<0 || x>=n || y>=m;}
	static class Pair{int x,y;public Pair(int x, int y) {this.x = x;this.y = y;}}
	static class Triple{ int x,y,z;public Triple(int x, int y,int z) {this.x = x;this.y = y;this.z = z;}}
	static class Quad{ int w,x,y,z;public Quad(int w, int x, int y,int z) {this.w = w; this.x = x;this.y = y;this.z = z;}}
	static final int IINF = Integer.MAX_VALUE;
	static final long LINF = Long.MAX_VALUE;
	static final int HIINF = Integer.MAX_VALUE / 2;
	static final long HLINF = Long.MAX_VALUE / 2;
}