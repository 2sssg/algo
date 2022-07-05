package koala.preparation.week1.bruteforce;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P1969 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int n,m,idx,v;
	static int[][] arr ;
	static int[] answer;

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
		arr = new int[m][26];
		answer = new int[m];
		for(int i=0; i<n; ++i){
			int j=0;
			for(char c: br.readLine().toCharArray()){
				arr[j++][c-'A']++;
			}
		}
		int sum = 0;
		for(int i=0; i<m; ++i){
			v=-1;
			for(int j=0; j<26; ++j){
				if(v<arr[i][j]){
					v = arr[i][j];
					idx = j;
				}
			}
			bw.write(String.valueOf((char)(idx+'A')));
			sum += n-arr[i][idx];
		}
		bw.write("\n");
		bw.write(String.valueOf(sum));
		bw.flush();

	}
}
