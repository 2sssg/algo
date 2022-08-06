package kmp;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P16172 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String s,p;
	static int[] pi;

	static void makePi(int len){
		pi = new int[len];
		for(int i=1,idx=0; i<len; ++i){
			while(idx>0 && p.charAt(i) != s.charAt(idx)) idx = pi[idx-1];
			if(p.charAt(i) == p.charAt(idx)) pi[i] = ++idx;
		}
	}

	static int kmp(){
		makePi(p.length());
		for(int i=0,idx=0; i<s.length(); ++i){
			while(idx>0 && s.charAt(i) != p.charAt(idx)) idx = pi[idx-1];
			if(s.charAt(i) == p.charAt(idx) && ++idx == p.length()) return 1;
		}
		return 0;
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		s = br.readLine().replaceAll("[0-9]",""); p = br.readLine();
		System.out.println(kmp());
	}
}
