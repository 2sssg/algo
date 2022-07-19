package extra;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1769 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String num;
	static int dep;
	static boolean isThree;

	static String f(String n){
		return String.valueOf(Arrays.stream(n.split("")).mapToInt(p->p.charAt(0)-'0').sum());
	}

	static void findnum(String n, int depth){
		if(n.length()==1){
			dep = depth;
			if(Integer.parseInt(n)%3==0) isThree = true;
			return;
		}
		findnum(f(n),depth+1);
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		findnum(br.readLine(),0);
		System.out.println(dep);
		System.out.println(isThree?"YES":"NO");
	}
}
