package extra;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P4446 {
	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();

		int amount = Integer.parseInt(br.readLine());
		int num = Integer.parseInt(br.readLine());
		while (num-- > 0)
		{
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			amount -= (a*b);
		}
		if(amount == 0)
			bw.write("Yes");
		else
			bw.write("No");
		bw.flush();
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

}
//abcdefghijklmnopqrstuvwxyz