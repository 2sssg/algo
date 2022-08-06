package koala.preparation.week3.twopointer;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P15831 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n,b,w;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		arr = Arrays.stream(br.readLine().split("")).mapToInt(p->p.charAt(0)-'A').toArray();
		int answer =0;
		int black=0;
		int white=0;
		int en = 0;
		if(arr[0]==1){
			black++;
		}else{
			white++;
		}
		for(int be=0; be<n; ++be){
			while(en<n-1 && black<=b) {
				en++;
				if(arr[en]==22)white++;
				else black++;
			}
//			System.out.println("be : " + be);
//			System.out.println("en : " + en);
//			System.out.println("white : " + white);
//			System.out.println("black : " + black);
//			System.out.println();
			if(black<=b && white>=w){
				answer = black+white;
			}
			else if(white>=w){
				answer = Math.max(white+black-1,answer);
			}
			if(arr[be]==1){
				black--;
			}else{
				white--;
			}
		}
		System.out.println(answer);
	}
}
