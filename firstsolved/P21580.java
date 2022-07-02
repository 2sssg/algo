package firstsolved;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P21580 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,M;
	static int[][] arr;
	static boolean[] visit;


	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visit = new boolean[M];
		arr = new int[N][M];

		char[] temp1 = br.readLine().toCharArray();
		for(int i=0; i<M; ++i){
			if(temp1[i]!='*'){
				arr[0][i] = temp1[i]-'0';
				visit[i] = true;
			}
		}
		for(int i=1; i<N; ++i){
			char[] temp = br.readLine().toCharArray();
			for(int j=0; j<M; ++j){
				if(temp[j]!='*' && !visit[j]){
					int num = (temp[j]-'0')-(i%9);
					if(num<0){
						num += 10;
					}
					arr[0][j] = num;
					visit[j] = true;
				}
			}
		}

		System.out.println(Arrays.toString(arr[0]));




	}
}
