package kmp;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P1786 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static String t,p;
	static int[] pi;

	static void makepi(int length){
		pi = new int[length];
		int idx = 0;
		for(int i=1; i<length; ++i){
			while(idx>0 && p.charAt(i)!=p.charAt(idx)) idx = pi[idx-1];
			if(p.charAt(i)==p.charAt(idx)) pi[i] = ++idx;
		}
	}

	static void kmp(){
		makepi(p.length());
		int answer = 0;
		int idx = 0;
		for(int i=0; i<t.length(); ++i){
			while(idx>0 && t.charAt(i) != p.charAt(idx)) idx = pi[idx-1];
			if(t.charAt(i) == p.charAt(idx)) {
				if(idx==p.length()-1){
					answer++;
					sb.append(i-idx+1).append(" ");
					idx = pi[idx];
				}
				else idx++;
			}
		}
		System.out.println(answer);
		System.out.println(sb.toString());

	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		t = br.readLine();
		p = br.readLine();
		sb.setLength(0);
		kmp();
	}

}
