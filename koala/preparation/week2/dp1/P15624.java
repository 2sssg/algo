package koala.preparation.week2.dp1;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P15624 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n;
	static int[] arr = new int[1000005];
	static int MODNUM = 1000000007;

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		arr[0] = 0;
		arr[1] = 1;
		for(int i=2; i<1000003; ++i) arr[i] = (arr[i-1]+arr[i-2])%MODNUM;
		System.out.println(arr[Integer.parseInt(br.readLine())]);
	}
}
