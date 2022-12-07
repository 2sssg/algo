package extra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1252 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] temp = br.readLine().split(" ");
		int carry = 0;
		int i;
		for (i = 0; temp[0].length() - i - 1 >= 0 && temp[1].length() - i - 1 >= 0; ++i) {
			int fir = temp[0].charAt(temp[0].length() - 1 - i) - '0';
			int sec = temp[1].charAt(temp[1].length() - 1 - i) - '0';
			int sum = fir + sec + carry;
			carry = sum >= 2 ? 1 : 0;
			sum -= (sum >= 2 ? 2 : 0);
			sb.insert(0, sum);
		}
		for (; temp[1].length() - i - 1 >= 0; ++i) {
			int sum = carry + (temp[0].charAt(i) -'0');
			carry = sum >= 2 ? 1 : 0;
			sum -= (sum >= 2 ? 2 : 0);
			sb.insert(0, sum);
		}
		for (; temp[0].length() - i - 1 >= 0; ++i) {
			int sum = carry + (temp[1].charAt(i) -'0');
			carry = sum >= 2 ? 1 : 0;
			sum -= (sum >= 2 ? 2 : 0);
			sb.insert(0, sum);
		}
		if (carry == 1) sb.insert(0, '1');
		System.out.println(sb);

	}
}
