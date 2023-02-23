package kmp;

import java.io.*;
import java.util.*;
public class P3356 {
	static int n;
	static String s;

	static int makepi(String subp, int length){
		int[] pi = new int[length];
		int idx = 0;
		for(int i=1; i<length; ++i){
			while(idx>0 && subp.charAt(i) != subp.charAt(idx)) idx = pi[idx - 1];
			if(subp.charAt(i) == subp.charAt(idx)) pi[i] = ++idx;
		}
		return pi[length - 1];
	}

	public static void main(String[] args) throws IOException {
		n = rn();
		s = br.readLine();
		System.out.println(s.length() - makepi(s, s.length()));
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
}
