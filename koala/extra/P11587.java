package koala.extra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11587 {
	static int n;
	static int[] arr;
	static int k;

	static void f(int[] array, int depth) {
		if (depth == k) {
			Arrays.sort(array);
			sb.append(Arrays.toString(array).replaceAll("[\\[\\],]", "")).append(" ");
			return ;
		}
		f(Arrays.copyOfRange(array, 0, array.length / 2), depth * 2);
		f(Arrays.copyOfRange(array, array.length / 2, array.length), depth * 2);
	}

	public static void main(String[] args) throws IOException {
		n = rn(); arr = ra(); k = rn();
		f(arr, 1);
		System.out.println(sb);
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int[] ra() throws IOException {return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();}
}
