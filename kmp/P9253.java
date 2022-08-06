package kmp;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9253 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String t1,t2,p;
	static int[] pi;

	static void makepi(int n){
		pi = new int[n];
		int idx = 0;
		for(int i=1; i<n; ++i){
			while(idx>0 && p.charAt(i) != p.charAt(idx)) idx = pi[idx-1];
			if(p.charAt(i)==p.charAt(idx)) pi[i] = ++idx;
		}
	}

	static boolean kmp(String t){
		int idx = 0;
		for(int i=0; i<t.length(); ++i){
			while(idx>0 && t.charAt(i) != p.charAt(idx)) idx = pi[idx-1];
			if(t.charAt(i) == p.charAt(idx)) if(idx++ == p.length()-1) return true;
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		t1 = br.readLine(); t2 = br.readLine(); p = br.readLine();
		makepi(p.length());
		System.out.println(kmp(t1)&&kmp(t2)?"YES":"NO");
	}
}

