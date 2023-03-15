package extra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1343 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		String temp = br.readLine().replace("XXXX","AAAA").replace("XX","BB");
		System.out.println(temp.contains("X")?-1:temp);
	}
}
