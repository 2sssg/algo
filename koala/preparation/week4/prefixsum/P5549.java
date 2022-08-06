package koala.preparation.week4.prefixsum;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P5549 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int r,c,q,x1,x2,y1,y2;
	static int[][] j,o,i;
	static StringBuilder sb = new StringBuilder();

	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() {return Integer.parseInt(st.nextToken());}


	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		est(); r=rstn(); c=rstn();
		q = Integer.parseInt(br.readLine());
		j = new int[r+1][c+1]; o = new int[r+1][c+1]; i = new int[r+1][c+1];
		for(int x=1; x<=r; ++x){
			String temp = br.readLine();
			for(int y=1; y<=c; ++y){
				j[x][y] = j[x][y-1] + j[x-1][y]-j[x-1][y-1];
				o[x][y] = o[x][y-1] + o[x-1][y]-o[x-1][y-1];
				i[x][y] = i[x][y-1] + i[x-1][y]-i[x-1][y-1];
				if(temp.charAt(y-1) == 'J'){
					j[x][y]++;
				}else if(temp.charAt(y-1)=='O'){
					o[x][y]++;
				}else{
					i[x][y]++;
				}
			}
		}

		while(q-->0){
			est(); x1 =rstn(); y1=rstn(); x2=rstn(); y2=rstn();
			sb.append(j[x2][y2]-j[x1-1][y2]-j[x2][y1-1]+j[x1-1][y1-1]).append(" ")
				.append(o[x2][y2]-o[x1-1][y2]-o[x2][y1-1]+o[x1-1][y1-1]).append(" ")
				.append(i[x2][y2]-i[x1-1][y2]-i[x2][y1-1]+i[x1-1][y1-1]).append("\n");
		}
		System.out.println(sb);
	}
}
