package koala.preparation.week6;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class P12851 {
	static int n,m,answer=Integer.MAX_VALUE,cnt;
	static int[] d = new int[200005];
	static Queue<Integer> q = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		Arrays.fill(d,-1);
		n=rstn(); m=rstn();

		q.add(n);
		d[n]=0;

		while(!q.isEmpty()){
			int cur = q.poll();
			if(d[cur]<answer) {
				if(cur+1<=200000 ){
					if(d[cur+1] == -1){
						q.add(cur+1);
						d[cur+1] = d[cur]+1;
						if(cur+1==m && answer == Integer.MAX_VALUE) answer = d[cur+1];
					}
					if(d[cur+1] == answer && cur+1 == m) cnt++;
				}

				if(cur-1>=0){
					if(d[cur-1]==-1){
						q.add(cur-1);
						d[cur-1] = d[cur]+1;
						if(cur-1==m && answer == Integer.MAX_VALUE) answer = d[cur-1];
					}
					if(d[cur-1] == answer && cur-1 == m) cnt++;
				}


				if(cur!=0 &&cur*2<=200002){
					if(d[cur*2]==-1){
						q.add(cur*2);
						d[cur*2] = d[cur]+1;
						if(cur*2==m && answer == Integer.MAX_VALUE) answer = d[cur*2];
					}
					if(d[cur*2] == answer && cur*2 == m) cnt++;
				}
			}
		}
		System.out.println(answer);
		System.out.println(cnt);
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
}
