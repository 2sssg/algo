package koala.preparation.week6;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class P12761 {
	static int n,m,answer;
	static int[] d = new int[100005];
	static int[] jump = new int[3];
	static Queue<Integer> q = new ArrayDeque<>();
	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		Arrays.fill(d,-1);
		jump[0]=1; jump[1]=rstn(); jump[2]=rstn(); n=rstn(); m=rstn();
		q.add(n);
		d[n] = 0;
		while(!q.isEmpty()){
			int cur = q.poll();
			if(cur==m) answer = d[cur];
			for(int i=0; i<3; ++i){
				int nxt = cur-jump[i];
				if(nxt>=0 && d[nxt]==-1){
					q.add(nxt);
					d[nxt] = d[cur]+1;
				}
				nxt = cur+jump[i];
				if(nxt<=100000 && d[nxt]==-1){
					q.add(nxt);
					d[nxt] = d[cur]+1;
				}
			}
			if(cur*jump[1]<=100000 && d[cur*jump[1]]==-1){
				q.add(cur*jump[1]);
				d[cur*jump[1]] = d[cur]+1;
			}
			if(cur*jump[2]<=100000 && d[cur*jump[2]]==-1){
				q.add(cur*jump[2]);
				d[cur*jump[2]] = d[cur]+1;
			}
		}
		System.out.println(answer);
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
}
