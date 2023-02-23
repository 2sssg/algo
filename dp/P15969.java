package dp;

import java.io.*;
import java.util.*;

public class P15969 {

	public static void main(String[] args) throws IOException {
		r(); int[] arr = ra();
		System.out.println(max(arr) - min(arr));
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static String r() throws IOException {return br.readLine();}
	static int[] ra() throws IOException {return Arrays.stream(r().split(" ")).mapToInt(Integer::parseInt).toArray();}
	static int max(int... temp) {return Arrays.stream(temp).max().getAsInt();}
	static int min(int... temp) {return Arrays.stream(temp).min().getAsInt();}
	////////////////////////////// 함수 //////////////////////////////////////////////
}
