package koala.preparation.week1.bruteforce;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class P10974 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n;
	static int[] arr = new int[9];
	static boolean[] visit = new boolean[9];

	static void f(int depth) throws IOException {
		if(depth==n){
			bw.write(Arrays.toString(Arrays.stream(arr).filter(p->p!=0).toArray()).replaceAll("[\\[,]","").replace("]","\n"));
			return;
		}
		for(int i=1; i<=n; ++i){
			if(visit[i]) continue;
			arr[depth] = i;
			visit[i] = true;
			f(depth+1);
			visit[i] = false;
		}

	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		n = Integer.parseInt(br.readLine());
		f(0);
		bw.flush();
	}
}
