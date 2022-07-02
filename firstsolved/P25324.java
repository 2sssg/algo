package firstsolved;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Locale;
import java.util.Locale.Builder;
import java.util.Queue;
import java.util.StringTokenizer;

public class P25324 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int MODNUM = 1000000007;
	static int[][] arr = new int[100002][52];


	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();

		String sentence = br.readLine().toUpperCase(Locale.ROOT);
		for(int i=1; i<sentence.length()+1; ++i){
			char temp = sentence.charAt(i);
			if(temp == ' '||temp==','||temp=='.') continue;
			arr[i][temp-'A'] = 1;
			arr[i][temp-'A'+26] = 1;
		}
		for(int i=1; i<100002; ++i){
			for(int j=0; j<26; ++j){
				if(j==0){
					arr[i+1][j+1] += arr[i][j]/2;
				}
				else if(j==25){
					arr[i+1][j-1] += arr[i][j]/2;
				}else{
					arr[i+1][j+1] += arr[i][j]/2;
					arr[i+1][j-1] += arr[i][j]/2;
				}
			}
		}
		int cnt = Integer.parseInt(br.readLine());
		while(cnt-->0){}
	}
}

