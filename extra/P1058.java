package extra;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1058 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n;
	static int[][] root,d;

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		n = Integer.parseInt(br.readLine());
		root = new int[n][n];
		d = new int[n][n];
		for(int i=0; i<n; ++i){
			Arrays.fill(d[i],0x3f3f3f3f);
			d[i][i] = 0;
		}
		for(int i=0; i<n; ++i){
			String temp = br.readLine();
			for(int j=0; j<n; ++j){
				if(temp.charAt(j)=='Y'){
					d[i][j] = 1;
					d[j][i] = 1;
				}
			}
		}
		for(int i=0; i<n; ++i)
			for(int j=0; j<n; ++j)
				for(int k=0; k<n; ++k)
					d[j][k] = Math.min(d[j][k],d[j][i] + d[i][k]);

		int answer = 0;

		for(int[] t: d)
			answer = Math.max(answer,Arrays.stream(t).filter(p->p<=2&&p>0).toArray().length);

		System.out.println(answer);
	}
}
