package koala.preparation.week1.extra;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P15813 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		br.readLine();
		System.out.println(Arrays.stream(br.readLine().split("")).mapToInt(p->p.charAt(0)-'A'+1).sum());
	}
}
