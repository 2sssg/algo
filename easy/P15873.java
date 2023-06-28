package easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P15873 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		String temp = br.readLine();
		if (temp.length() == 2) {
			System.out.println((int)(temp.toCharArray()[0] - '0') + (int)(temp.toCharArray()[1] - '0'));
		} else if(temp.length() == 3) {
			System.out.println(Integer.parseInt(temp.replaceAll("10", "")) + 10);
		} else {
			System.out.println(20);
		}
	}
}
