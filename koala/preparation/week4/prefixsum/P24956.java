package koala.preparation.week4.prefixsum;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P24956 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static long w,h,e,answer;
	static final int MOD = 1000000007;

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		for(char c : br.readLine().toCharArray()){
			if(c=='W') w++;
			else if(c=='H') h += w;
			else if(c=='E'){
				answer = (2*answer+e)%MOD;
				e += h;
			}
		}
		System.out.println(answer);

	}
}
