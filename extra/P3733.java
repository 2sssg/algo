package extra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P3733 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		while(true) {
			try {
				int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
					.toArray();
				System.out.println(temp[1] / (temp[0] + 1));
			}catch (Exception e){
				break;
			}
		}


	}

}
