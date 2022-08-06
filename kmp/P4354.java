package kmp;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P4354 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		while(true){
			String s = br.readLine();
			if(s.equals(".")) break;
			int[] pi = new int[s.length()];
			int idx = 0;
			for(int i=1; i<s.length(); ++i){
				while(idx>0 && s.charAt(i) != s.charAt(idx)) idx = pi[idx-1];
				if(s.charAt(i) == s.charAt(idx)) pi[i] = ++idx;
			}
			System.out.println((s.length()%(s.length()-pi[s.length()-1]))!=0?1:s.length()/(s.length()-pi[s.length()-1]));
		}
	}
}
