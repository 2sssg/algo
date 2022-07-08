package koala.preparation.week1.extra;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1120 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		st = new StringTokenizer(br.readLine());
		String s1 = st.nextToken();
		String s2 = st.nextToken();
		char[] arr = new char[Math.max(s1.length(),s2.length())];
		char[] arr2 = new char[arr.length];
		for(int i=0; i<arr.length; ++i){
			if(s1.length()>i){
				arr[i] = s1.charAt(i);
			}else{
				arr[i] = '.';
			}
			arr2[i] = s2.charAt(i);
		}
		int answer = Integer.MAX_VALUE;
		for(int i=0; i<=s2.length()-s1.length(); ++i){
			int tempanswer = 0;
			for(int j=0; j<arr.length; ++j){
				if(arr[j]!=arr2[j]){
					tempanswer++;
				}
			}
			answer = Math.min(answer,tempanswer);
			for(int j=s2.length()-1; j>0; --j){
				arr[j] = arr[j-1];
			}
			arr[0] = '.';
		}
		System.out.println(answer - (s2.length()-s1.length()));
	}
}
