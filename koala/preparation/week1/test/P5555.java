package koala.preparation.week1.test;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P5555 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static char[] arr;
	static char[] find;
	static int n,answer;

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		answer = 0;
		find = br.readLine().toCharArray();
		n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; ++i){
			String temp = br.readLine();
			arr = new char[temp.length()+find.length-1];
			for(int j=0; j<temp.length(); ++j){
				arr[j] = temp.charAt(j);
			}
			for(int j=temp.length(); j<arr.length; ++j){
				arr[j] = arr[j-temp.length()];
			}
			for(int j=0; j<arr.length-find.length+1; ++j){
				int count = 0;
				for(int k=0; k<find.length; ++k){
					if(arr[j+k]==find[k]){
						count++;
					}else{
						break;
					}
				}
				if(count == find.length){
					answer++;
					break;
				}
			}
		}
		System.out.println(answer);


	}
}
