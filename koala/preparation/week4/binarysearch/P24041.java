package koala.preparation.week4.binarysearch;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class P24041 {
	static class Ingrediant{
		long s,l;
		public Ingrediant(int s, int l) {
			this.s = s;
			this.l = l;
		}

		@Override
		public String toString() {
			return "Ingrediant{" +
				"s=" + s +
				", l=" + l +
				'}';
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n,g,k;
	static Ingrediant[] ingrediants;
	static boolean[] canTrash;
	static int[] use;


	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() {return Integer.parseInt(st.nextToken());}

	static long para(long mid){
		ArrayList<Long> l = new ArrayList<>();
		long result = 0;
		for(int i=0; i<n; ++i){
			if(canTrash[i]){
				l.add(ingrediants[i].s * Math.max(1,mid-ingrediants[i].l));
			}else{
				result += ingrediants[i].s*Math.max(1,mid-ingrediants[i].l);
				if(result>g) return g+1;
			}
		}

		Collections.sort(l);
		for(int i=0; i<l.size()-k; ++i){
			result += l.get(i);
			if(result>g) return g+1;
		}
		return result;
	}



	static void init() throws IOException {
		est();
		n = rstn(); g = rstn(); k = rstn();
		ingrediants = new Ingrediant[n];
		canTrash = new boolean[n];
		use = new int[k];
		for(int i=0; i<n; ++i){
			est();
			ingrediants[i] = new Ingrediant(rstn(),rstn());
			if(rstn()==1) canTrash[i] = true;
		}


	}
	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
		long low = 0;
		long high = Integer.MAX_VALUE;
		while(low+1<high){
			long mid = (low+high)/2;
//			System.out.println("mid : "+ mid);
//			System.out.println("para : "+para(mid));
//			System.out.println();
			if(para(mid)<=g) low = mid;
			else high = mid;
		}
		System.out.println(low);
	}
}
