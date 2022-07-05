package koala.preparation.week1.bruteforce;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class P3040 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[] arr = new int[9];
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		int num = -100;

		for(int i=0; i<9; ++i) {
			arr[i] = rn();
			num += arr[i];
		}

		outer :for(int i=0; i<8; ++i){
			for(int j=i+1; j<9; ++j){
				if(arr[i]+arr[j]==num){
					for(int k=0; k<9; ++k){
						if(arr[k]!=arr[i] && arr[k]!=arr[j]){
							bw.write(String.valueOf(arr[k]));
							bw.write("\n");
						}
					}
					break outer;
				}
			}
		}
		bw.flush();

	}
}
