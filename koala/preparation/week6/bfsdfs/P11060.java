package koala.preparation.week6.bfsdfs;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class P11060 {
	static int n;
	static int[] arr,d;
	static Queue<Integer> q = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		n=rn();
		arr = ra();
		d = new int[n];
		Arrays.fill(d,-1);
		q.add(0);
		d[0] = 0;
		while(!q.isEmpty()){
			int cur = q.poll();
			int a = arr[cur];
			for(int i=1; i<=a; ++i){
				int nx = cur+i;
				if(nx>=n) break;
				if(d[nx] != -1) continue;
				q.add(nx);
				d[nx] = d[cur]+1;
			}
		}
		System.out.println(d[n-1]);
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
	static int[] ra() throws IOException {return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();}
}
