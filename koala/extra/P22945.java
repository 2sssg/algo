package koala.extra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P22945 {
	static int n;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		n = rn(); arr = ra();
		int max = 0;
		int i = 0, j = n - 1;
		while(i < j) {
			max = Math.max(max, (j - i - 1) * Math.min(arr[i],arr[j]));
			if (arr[i] < arr[j]) i++;
			else j--;
		}
		System.out.println(max);
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int[] ra() throws IOException {return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();}
}
