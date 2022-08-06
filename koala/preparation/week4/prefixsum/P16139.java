package koala.preparation.week4.prefixsum;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P16139 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[][] arr = new int[200005][26];
	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		String word = br.readLine();
		int len = word.length();
		for(int i=0; i<len; ++i){
			arr[i+1] = arr[i].clone();
			arr[i+1][word.charAt(i)-'a']++;
		}
		int n = Integer.parseInt(br.readLine());
		while(n-->0){
			st = new StringTokenizer(br.readLine());
			char find = st.nextToken().charAt(0);
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			bw.write(String.valueOf(arr[right+1][find-'a'] - arr[left][find-'a']));
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
}
