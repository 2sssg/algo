package kakao.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2002 {

	static int n, answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		n = rn();
		String in[] = new String[n];
		String out[] = new String[n];
		boolean check[] = new boolean[n];
		for(int i = 0; i < n; i++) in[i]=br.readLine();
		for(int i = 0; i < n; i++) out[i]=br.readLine();
		for (int i = 0; i < n; i++) {
			String carNumber = in[i];
			for (int j = 0; j < n; j++) {
				if (out[j].equals(carNumber)) {
					check[j]=true;
					break;
				}
				if(check[j]) continue;
				answer++;
				check[j] = true;
			}
		}

		System.out.println(answer);

	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
}
