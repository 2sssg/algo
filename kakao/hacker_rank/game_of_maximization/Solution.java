package kakao.hacker_rank.game_of_maximization;

import java.io.*;
import java.util.*;

public class Solution {
	static int n;
	static int[] arr;
	static List<Integer> l,r;
	public static void main(String[] args) throws IOException {
		n = rn(); arr = ra();
		l = new ArrayList<>();
		r = new ArrayList<>();

		for (int i = 0; i < arr.length; ++i) {
			if ((i & 1)== 0) {
				l.add(arr[i]);
			} else {
				r.add(arr[i]);
			}
		}

		System.out.println(2 * Math.min(l.stream().mapToInt(Integer::intValue).sum(), r.stream().mapToInt(Integer::intValue).sum()));

	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static int[] ra() throws IOException {return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();}
}