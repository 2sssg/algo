package extra;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P5598 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		Arrays.stream(br.readLine().split("")).mapToInt(p->p.charAt(0)-3<'A'?p.charAt(0)+23:p.charAt(0)-3).forEach(p-> System.out.print((char)p));
	}
}
