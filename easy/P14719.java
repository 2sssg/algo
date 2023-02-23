package easy;

import java.io.*;
import java.util.*;

public class P14719 {
	static int ans;
	static int[] arr;
	static Pair[] arr2;
	public static void main(String[] args) throws IOException {
		r(); arr = ra();
		arr2 = new Pair[arr.length];
		for (int i = 0; i < arr.length; ++i) arr2[i] = new Pair(0, 0);
		arr2[0].x = arr[0]; arr2[arr.length - 1].y = arr[arr.length - 1];
		for (int i = 1; i < arr.length; ++i) arr2[i].x = max(arr2[i - 1].x, arr[i]);
		for (int i = arr.length - 2; i >= 0; --i) arr2[i].y = max(arr2[i + 1].y, arr[i]);
		for (int i = 0; i < arr.length; ++i) ans += (min(arr2[i].x, arr2[i].y) - arr[i]);
		System.out.println(ans);
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String r() throws IOException {return br.readLine();}
	static int[] ra() throws IOException {return Arrays.stream(r().split(" ")).mapToInt(Integer::parseInt).toArray();}
	static class Pair{int x,y;public Pair(int x, int y) {this.x = x;this.y = y;}}
	static int max(int... temp) {return Arrays.stream(temp).max().getAsInt();}
	static int min(int... temp) {return Arrays.stream(temp).min().getAsInt();}
}
