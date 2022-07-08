package koala.preparation.week1.extra;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1057 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n,k,l;

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); k = Integer.parseInt(st.nextToken()); l = Integer.parseInt(st.nextToken());

		// (k+1)/2 == (l+1)/2 그 경기에 붙는다.
		// (자기번호+1)/2 => 다음 경기 시드

		int count = 1;
		while((k+1)/2 != (l+1)/2){
			count++;
			k = (k+1)/2;
			l = (l+1)/2;
		}

		System.out.println(count);
	}
}
