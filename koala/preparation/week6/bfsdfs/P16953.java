package koala.preparation.week6.bfsdfs;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P16953 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st ;

	public static void main(String[] args) throws Exception {
		br = Source.getBufferedReader();
		st = new StringTokenizer(br.readLine());

		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		int ans = 1;
		while (B != A) {
			if (B < A) {ans = -1;break;}
			String str = String.valueOf(B);
			if (str.charAt(str.length() - 1) != '1' && B % 2 != 0) {
				ans = -1;
				break;
			}
			if (B % 2 == 0) B >>= 1;
		 	else {
				str = str.substring(0, str.length() - 1);
				B = Long.parseLong(str);
			}
			ans++;
		}

		bw.write(ans + "\n");
		bw.flush();
	}

}
