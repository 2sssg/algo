package extra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P1307 {

	public static void main(String[] args) throws IOException {
		int n = rn();
		List<Integer> l = Arrays.stream(ra()).boxed().sorted().collect(Collectors.toList());
		System.out.println((n & 1) == 1 ? l.get(n / 2) * l.get(n / 2) : l.get(0) * l.get(n - 1));
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static int[] ra() throws IOException {return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();}
}
