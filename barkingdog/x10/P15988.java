package barkingdog.x10;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P15988 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int T;
	static int[] arr = new int[1000001];
	static int MODNUM = 1000000009;


	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		T = Integer.parseInt(br.readLine());
		arr[1] = 1; arr[2] = 2; arr[3] = 4;
		for(int i=4; i<1000001; ++i){
			arr[i] = (arr[i-1]+arr[i-2])%MODNUM;
			arr[i] = (arr[i]+arr[i-3])%MODNUM;
		}
		while(T-->0) System.out.println(arr[Integer.parseInt(br.readLine())]);

	}
}


