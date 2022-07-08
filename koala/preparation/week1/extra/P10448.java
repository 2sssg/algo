package koala.preparation.week1.extra;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class P10448 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static TreeSet<Integer> ts = new TreeSet<>();
	static int[] arr = new int[1002];

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		for(int i=1; i<1001; ++i){
			arr[i] = i*(i+1)/2;
			ts.add(i*(i+1)/2);
		}

		int t = Integer.parseInt(br.readLine());
		l: while(t-->0){
			int n = Integer.parseInt(br.readLine());
			for(int i=1; i<1001; ++i){
				if(arr[i]>n) break;
				for(int j=1; j<1001; ++j){
					if(arr[i]+arr[j]>n) break;
					if(ts.contains(n-(arr[i]+arr[j]))){
						System.out.println("1");
						continue l;
					}
				}
			}
			System.out.println("0");
		}



	}
}
