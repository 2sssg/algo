package extra;

import java.io.*;

public class P2220 {
	static int n;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		n = rn();
		arr = new int[n + 1];
		for(int i = 1; i < n; i++) {
			for(int j = i; j > 1; j /= 2) arr[j] = arr[j/2];
			arr[1] = i + 1;
		}
		arr[n] = 1;
		for(int i=1; i<=n; i++) sb.append(arr[i]).append(" ");
		System.out.println(sb);
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
}
