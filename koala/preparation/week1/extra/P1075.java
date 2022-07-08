package koala.preparation.week1.extra;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1075 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n,k;
	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		n = (Integer.parseInt(br.readLine())/100)*100;
		k = Integer.parseInt(br.readLine());
		if(((n/k)*k+k)-n==k){
			System.out.println("00");
		} else if(((n/k)*k+k)-n<10){
			System.out.printf("0%d",((n/k)*k+k)-n);
		}else{
			System.out.println(((n/k)*k+k)-n);
		}
		System.out.println();
	}
}
