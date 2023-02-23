package extra;

import java.io.*;
import java.math.BigInteger;

public class P5615 {
	static int n, cnt;

	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		while(n-- > 0) if(BigInteger.valueOf(Long.parseLong(br.readLine())* 2 + 1).isProbablePrime(10)) cnt++;
		System.out.println(cnt);
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

}
