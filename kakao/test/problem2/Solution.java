package kakao.test.problem2;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

	/*
	 * Complete the 'solution' function below.
	 *
	 * The function is expected to return an INTEGER.
	 * The function accepts following parameters:
	 *  1. INTEGER_ARRAY cost
	 *  2. INTEGER x
	 */
	static final int MOD = 1_000_000_007;

	public static int solution(List<Integer> cost, int x) {
		// n = 물감의 갯수
		// x = 가지고 있는 금액
		// cost = 물감의 가격 배열
		int n = cost.size();
		long answer = 0;
		for (int i = n - 1; i >= 0 && x > 0; --i) {
			if (cost.get(i) <= x) {
				x -= cost.get(i);
				long cnt = 1;
				for (int j = 0; j < i; ) {
					if (j + 30 < i) {
						cnt = cnt << 30;
						cnt /= MOD;
						j += 30;
						continue;
					}
					cnt = cnt << 1;
					cnt %= MOD;
					j++;
				}
				answer += cnt;
				answer %= MOD;
			}
		}
		return (int) answer;
	}
}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		int costCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> cost = IntStream.range(0, costCount).mapToObj(i -> {
					try {
						return bufferedReader.readLine().replaceAll("\\s+$", "");
					} catch (IOException ex) {
						throw new RuntimeException(ex);
					}
				})
				.map(String::trim)
				.map(Integer::parseInt)
				.collect(toList());

		int x = Integer.parseInt(bufferedReader.readLine().trim());

		int result = Result.solution(cost, x);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
