package extra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class P2512 {
	static int n, max;
	static int[] arr;

	static boolean f(int limit) {
		AtomicInteger sum = new AtomicInteger();
		Arrays.stream(arr).forEach(elem -> sum.addAndGet(Math.min(elem, limit)));
		return sum.intValue() <= max;
	}

	public static void main(String[] args) throws IOException {
		n=rn(); arr=ra(); max = rn();
		int low = 0;
		int high = Arrays.stream(arr).max().getAsInt();

		if (Arrays.stream(arr).sum() <= max) {
			System.out.println(Arrays.stream(arr).max().getAsInt());
			return ;
		}
		while (low + 1 < high) {
			int mid = (low + high) / 2;
			if (f(mid)) low = mid;
			else high = mid;
		}
		System.out.println(low);
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static int[] ra() throws IOException {return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();}
}
