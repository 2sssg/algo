package extra;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.regex.Pattern;

public class P1013 {
	static int n;
	static final String pattern = "(100+1+|01)+";
	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		n = rn();
		while (n-- > 0) bw.write(Pattern.matches(pattern, br.readLine())?"YES\n":"NO\n");
		bw.flush();
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
}
