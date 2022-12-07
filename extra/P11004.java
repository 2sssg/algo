package extra;

import java.io.*;
import java.util.*;
import java.util.stream.*;
public class P11004 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine().split(" ")[1]);
		System.out.println(Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.boxed()
				.sorted()
				.collect(Collectors.toList()).get(k - 1));
	}
}

