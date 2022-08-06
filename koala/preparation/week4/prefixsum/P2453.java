package koala.preparation.week4.prefixsum;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2453 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int[] ria() throws IOException {return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();}
	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		int[] param = ria(),arr = ria();
		for(int i=1; i<param[0]; ++i) arr[i] = arr[i]+arr[i-1];
		int answer = arr[param[1]-1];
		for(int i=0; i<param[0]-param[1]; ++i) answer = Math.max(answer,arr[i+param[1]]-arr[i]);
		System.out.println(answer);
	}
}
