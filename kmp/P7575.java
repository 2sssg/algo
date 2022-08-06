package kmp;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

public class P7575 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n,k,patternidx,low,minsize=Integer.MAX_VALUE;
	static List<Integer>[] slist;
	static int[] reversepattern;
	static int[] pi;
	static int[] reversepi;

	static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		slist = new ArrayList[n];
		for(int i=0; i<n; ++i){
			slist[i] = new ArrayList<>();
			int tempsize = Integer.parseInt(br.readLine());
			if(tempsize<minsize){
				minsize = tempsize;
				patternidx = i;
			}
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) slist[i].add(Integer.parseInt(st.nextToken()));
		}
	}
	static boolean find(){
		for(int i=0; i<=minsize-k; ++i){
			low = i;
			reversepattern = new int[k];
			for(int j=low+k-1; j>=low; --j){
				reversepattern[low+k-1 - j] = slist[patternidx].get(j);
			}
			if(kmp()) return true;
		}
		return false;
	}

	static void makePi(){
//		for(int i=low; i<low+k; ++i){
//			System.out.print(slist[patternidx].get(i)+" ");
//		}
		pi = new int[k];
		int idx = 0;
		for(int i=1; i<k; ++i){
			while(idx>0 && slist[patternidx].get(i+low)!=slist[patternidx].get(idx+low)) idx = pi[idx-1];
			if(slist[patternidx].get(i+low)==slist[patternidx].get(idx+low)) pi[i] = ++idx;
		}
	}
	static void makeReversePi(){
		reversepi = new int[k];
//		System.out.println(Arrays.toString(reversepattern));
		int idx = 0;
		for(int i=1; i<k; ++i){
			while(idx>0 && reversepattern[i] != reversepattern[idx]) idx = reversepi[idx-1];
			if(reversepattern[i] == reversepattern[idx]) reversepi[i] = ++idx;
		}
	}

	static boolean kmp(){
		makePi();
		makeReversePi();
//		System.out.println(Arrays.toString(pi));
//		System.out.println(Arrays.toString(reversepi));
//		System.out.println();
		l: for(List<Integer> s : slist){
			int idx = 0;
			for(int i=0; i<s.size(); ++i){
				while(idx>0 && !Objects.equals(s.get(i), slist[patternidx].get(idx+low))) idx = pi[idx-1];
				if(Objects.equals(s.get(i), slist[patternidx].get(idx+low))) {
					if(idx == k-1) continue l;
					else idx++;
				}
			}
			idx = 0;
			for(int i=0; i<s.size(); ++i){
				while(idx>0 && s.get(i) != reversepattern[idx]) idx = reversepi[idx-1];
				if(s.get(i) == reversepattern[idx]){
					if(idx == k-1) continue l;
					else idx++;
				}
			}
			return false;
		}
		return true;
	}


	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
		System.out.println(find()?"YES":"NO");

	}
}
