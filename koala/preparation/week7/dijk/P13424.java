package koala.preparation.week7.dijk;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P13424 {
	static int t,n,m,k,answer,distance;
	static int[][] d;
	static int[] friends,dist;

	static void init() throws IOException {
		n=rstn(); m=rstn();
		answer = 0;
		distance = Integer.MAX_VALUE;
		dist = new int[n+1];
		d = new int[n+1][n+1];
		for(int i=0; i<=n; ++i) {Arrays.fill(d[i],0x3f3f3f3f);d[i][i]=0;}
		for(int i=0; i<m; ++i){int v1=rstn(),v2=rstn(),w=rstn();d[v1][v2] = w;d[v2][v1] = w;}
		k=rn();
		friends = ra();
	}


	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		t=rn();
		while(t-->0){
			init();
			for(int i=1; i<=n; ++i) for(int j=1; j<=n; ++j) for(int k=1; k<=n; ++k) d[j][k] = Math.min(d[j][k],d[j][i]+d[i][k]);
			for(int f: friends) for(int j=1; j<=n; ++j) dist[j] += d[f][j];
			for(int i=1; i<=n; ++i){if(distance>dist[i] ){distance = dist[i];answer = i;}}
			bw.append(Integer.toString(answer)).append("\n");
		}
		bw.flush();
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
	static int[] ra() throws IOException {return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();}
}
