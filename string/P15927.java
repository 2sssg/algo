package string;


import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P15927 {
	static int l,r;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		char [] s  = br.readLine().toCharArray();
		l = 0;
		r = s.length-1;
		char c = s[0];
		boolean flag = true;
		for(int i =1 ;i <=r;i++)if(s[i]!=c) flag = false;
		if(flag) {System.out.println("-1"); return;}
		flag = true;

		while(l<r) {
			if(s[l]==s[r]) {l++;r--;}
			else {flag = false;break;}
		}
			System.out.println(flag?s.length-1:s.length);
	}

}