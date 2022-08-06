package koala.preparation.week4.prefixsum;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P16507 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[] arr;
	static int n,m,q;

	static int sum(int x1,int y1,int x2, int y2){
		int result = 0;
		for(int i=x1; i<=x2; ++i) {
			if(i*m+y1-1==-1) result += arr[i*m+y2];
			else result += arr[i*m+y2] - arr[i*m+y1-1];
		}
		return result/area(x1,y1,x2,y2);
	}
	static int area(int x1,int y1,int x2, int y2){
		return (x2-x1+1)*(y2-y1+1);
	}

	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() {return Integer.parseInt(st.nextToken());}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		est(); n=rstn(); m=rstn(); q=rstn();
		arr = new int[n*m];
		for(int i=0; i<n; ++i){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; ++j){
				if(i==0 && j==0) arr[0] = Integer.parseInt(st.nextToken());
				else arr[i*m+j] = arr[i*m+j-1]+Integer.parseInt(st.nextToken());
			}
		}
		while(q-->0){
			est();
			bw.write(String.valueOf(sum(rstn()-1,rstn()-1,rstn()-1,rstn()-1)));
			bw.write("\n");
		}
		bw.flush();
	}
}
