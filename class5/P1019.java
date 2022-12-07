package class5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P1019 {
	static int[] cnt = new int[10];
	static int start, end, digit;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		digit = 1;
		start = 1;
		end = Integer.parseInt(br.readLine());

		while (start <= end) {
			while (start % 10 != 0 && start <= end) {
				calc(start, digit);
				start++;
			}
			while(end % 10 != 9 && start <= end) {
				calc(end, digit);
				end--;
			}
			if (start > end) break;
			start /= 10;
			end /= 10;
			for(int i = 0 ; i < 10 ; ++i) cnt[i] += (end - start + 1) * digit;
			digit *= 10;
		}
		for (int i : cnt) bw.append(Integer.toString(i)).append(" ");
		bw.flush();
	}

	static void calc(int cur, int digit) {
		while(cur > 0) {
			cnt[cur % 10] += digit;
			cur /= 10;
		}
	}
}
