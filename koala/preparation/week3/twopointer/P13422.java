package koala.preparation.week3.twopointer;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import library.UsefulForAlgo;

public class P13422 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int t,n,m,k,answer;
	static long[] arr;

	static long rstn(){return Long.parseLong(st.nextToken());}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		t = Integer.parseInt(br.readLine());
		while(t-->0){
			answer = 0;
			st = new StringTokenizer(br.readLine());
			n = (int)rstn(); m = (int)rstn(); k = (int)rstn();
			if(n==m){
				bw.write(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sum()<k?"1":"0");
				bw.write("\n");
				continue;
			}
			arr = new long[n+m];
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=n; ++i) arr[i] = rstn()+arr[i-1];
			for(int i=n+1; i<n+m; ++i) arr[i] = (arr[i-n]-arr[i-n-1])+arr[i-1];
			UsefulForAlgo.testPrint(arr);
			for(int i=0; i<n; ++i){
				long money = arr[i+m]-arr[i];
				if(money<k) answer++;
			}
			bw.write(String.valueOf(answer));
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
}
