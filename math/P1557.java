package math;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1557 {
	static final int MX = 1_000_000;
	static long k, lo, hi;
	static long[] arr = new long[1_234_567];
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static long sfi(long mid){
		long cnt = 0;
		for(long i = 1; i * i <= mid; i++)
			cnt += arr[(int)i] * mid / (i * i);
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		k = Long.parseLong(br.readLine());
		arr[1] = 1;
		for(int i = 1; i <= MX; i++)
			for(int j = 2 * i; j <= MX; j += i)
				arr[j] -= arr[i];
		hi = 100000000000L;
		while(lo < hi - 1){
			long mid = (lo + hi) / 2;
			if(mid - sfi(mid) < k) lo = mid;
			else hi = mid;
		}
		System.out.println(hi);
	}
}
