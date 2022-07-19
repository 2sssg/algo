package koala.preparation.week2.test;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class P2799 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n,m;
	static String open = "....";
	static String close = "****";
	static int[] answer;

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		answer = new int[5];
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		for(int i=0; i<n; ++i){
			br.readLine();
			HashSet<Integer> hs = new HashSet<>();
			for(int j=0; j<4; ++j){
				String[] temp = br.readLine().split("#");
				for(int k=1; k<=m; ++k){
					if(j==3 && temp[k].equals(close)){
						answer[j+1]++;
					}
					else if(!hs.contains(k) && temp[k].equals(open)){
						hs.add(k);
						answer[j]++;
					}

				}
			}
		}
//		br.readLine();
		for(int i=0; i<5; ++i){
			System.out.printf("%d ",answer[i]);
		}
	}
}
