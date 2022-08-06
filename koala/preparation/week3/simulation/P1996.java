package koala.preparation.week3.simulation;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class P1996 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[][] answer,arr;
	static int[][] d = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};

	static int n;

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		answer = new int[n][n];
		for(int i=0; i<n; ++i)
			arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(p->p.equals(".")?0:p.charAt(0)-'0').toArray();
		for(int i=0; i<n; ++i){
			for(int j=0; j<n; ++j){
				if(arr[i][j]>0) {
					answer[i][j] = -1;
					continue;
				}
				for(int[] t: d){
					int nx = i+t[0];
					int ny = j+t[1];
					if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
					answer[i][j] += arr[nx][ny];
				}
			}
		}
		for(int i=0; i<n; ++i){
			Arrays.stream(answer[i])
				.mapToObj(String::valueOf)
				.map(p->Integer.parseInt(p)==-1?"*":p)
				.map(p->p.length()>1?"M":p)
				.forEach(p-> {
					try {
						bw.write(p);
					} catch (IOException e) {
						e.printStackTrace();
					}
				});
			bw.write("\n");
		}

//
//		for(int i=0; i<n; ++i){
//			for(int j=0; j<n; ++j){
//				if(answer[i][j]==-1){
//					bw.write("*");
//				}else if(answer[i][j]>9){
//					bw.write("M");
//				}else{
//					bw.write(String.valueOf(answer[i][j]));
//				}
//			}
//			bw.write("\n");
//		}
		bw.flush();
		bw.close();
	}
}
