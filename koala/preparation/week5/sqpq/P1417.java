package koala.preparation.week5.sqpq;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1417 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n,d,min;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		n= Integer.parseInt(br.readLine());
		d= Integer.parseInt(br.readLine());
		arr = new int[n-1];
		for(int i=0; i<arr.length; i++)
			arr[i] = Integer.parseInt(br.readLine());

		if(n == 1) {	// 후보가 자신 혼자인경우
			System.out.println("0");
			return;
		}

		while(true) {
			Arrays.sort(arr);
			boolean flag = true;
			int last = arr.length-1;
			if(d <= arr[arr.length-1]) {
				d++;
				arr[last] --;
				min ++;
				flag = false;
			}
			if(flag) break;
		}
		System.out.println(min);
	}

}
