package kakao.test.problem3;

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
	 * The function accepts INTEGER_ARRAY box as parameter.
	 */

	public static int solution(List<Integer> box) {
		int n = box.size();

		long[] sumArr = new long[n];
		sumArr[0] = box.get(0);
		for (int i = 1; i < n; ++i) {
			sumArr[i] = sumArr[i - 1] + box.get(i);
		}

		for (int i = n - 1; i > 0; --i) {
			long cur = sumArr[i];
			int candidate = (int) Math.ceil((double)cur / (i + 1));
			if (candidate < box.get(i)) {
				box.set(i - 1, box.get(i - 1) + box.get(i) - candidate);
				sumArr[i - 1] += (box.get(i) - candidate);
				box.set(i, candidate);
			}
		}
		return box.stream().mapToInt(Integer::intValue).max().getAsInt();
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		int boxCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> box = IntStream.range(0, boxCount).mapToObj(i -> {
					try {
						return bufferedReader.readLine().replaceAll("\\s+$", "");
					} catch (IOException ex) {
						throw new RuntimeException(ex);
					}
				})
				.map(String::trim)
				.map(Integer::parseInt)
				.collect(toList());

		int result = Result.solution(box);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
