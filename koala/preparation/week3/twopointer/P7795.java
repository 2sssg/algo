package koala.preparation.week3.twopointer;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P7795 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] a,b;
	static int t,n,m;


	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		t = Integer.parseInt(br.readLine());
		while(t-->0){
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
			a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			b = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			Arrays.sort(a);
			Arrays.sort(b);
			int bidx = 0;
			int answer = 0;
			for(int aidx=0; aidx<a.length; ++aidx){
				while(bidx< b.length && a[aidx]>b[bidx]) bidx++;
				answer += bidx;
			}
			System.out.println(answer);

		}

	}
}
