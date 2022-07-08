package koala.preparation.week1.extra;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1543 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		String s1 = br.readLine();
		String s2 = br.readLine();
		int count = 0;
		l:for(int i=0; i<s1.length()-s2.length()+1; ++i){
			int idx = 0;
			if(s1.charAt(i) == s2.charAt(idx)){
				for(int j=i; j<s1.length() && idx<s2.length(); ++j){
					if(s1.charAt(j)!=s2.charAt(idx++)) continue l;
				}
				count++;
				i += s2.length()-1;
			}
		}
		System.out.println(count);
	}
}

