package koala.preparation.week5.sqpq;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P1935 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n;
	static double[] arr;
	static String form;
	static Stack<Double> s = new Stack<>();

	static void calc(char sign){
		double second = s.pop();
		double first = s.pop();
		switch(sign){
			case '+':
				s.push(first+second);
				break;
			case '-':
				s.push(first-second);
				break;
			case '*':
				s.push(first*second);
				break;
			default:
				s.push(first/second);
				break;
		}
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		n = Integer.parseInt(br.readLine());
		form = br.readLine();
		arr = new double[n];
		for(int i=0; i<n; ++i) arr[i] = Integer.parseInt(br.readLine());
		for(int i=0; i<form.length(); ++i){
			if('A'<=form.charAt(i) && form.charAt(i)<='Z') s.push(arr[form.charAt(i)-'A']);
			else calc(form.charAt(i));
		}
		System.out.printf("%.2f",s.pop());
	}
}
