package koala.preparation.week1.bruteforce;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1051 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n,m;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken()); m=Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		for(int i=0; i<n; ++i)
			arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();

		int size = Math.min(n,m)-1;
		outer : for(int i=size; i>=0; --i){
			for(int j=0; j<n-i; ++j){
				for(int k=0; k<m-i; ++k){
					if((arr[j][k]==arr[j+i][k])&&(arr[j][k]==arr[j+i][k+i])&&(arr[j][k]==arr[j][k+i])){
						System.out.println((i+1)*(i+1));
						System.exit(0);
						break outer;
					}
				}
			}
		}

	}
}
