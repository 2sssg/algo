package kmp;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P16916 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String s,p;
	static int[] pi;

	static void makePi(int len){
		pi = new int[len];
		int idx = 0;
		for(int i=1; i<len; ++i){
			while(idx>0 && p.charAt(i) != p.charAt(idx)) idx = pi[idx-1];
			if(p.charAt(i)==p.charAt(idx)) pi[i] = ++idx;
		}
	}

	static int kmp(){
		int n1 = s.length();
		int n2 = p.length();
		makePi(n2);
		int idx = 0;
		for(int i=0; i<n1; ++i){
			while(idx>0 && s.charAt(i) != p.charAt(idx)) idx = pi[idx-1];
			if(s.charAt(i) == p.charAt(idx)){
				if(idx == n2-1){
					return 1;
				}else{
					idx++;
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		s=br.readLine(); p=br.readLine();
		System.out.println(kmp());
	}
}
