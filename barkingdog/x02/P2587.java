package barkingdog.x02;

import java.io.*;
import java.util.Arrays;

public class P2587 {
    static int[] arr = new int[5];
    static int sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i=0; i<5; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        Arrays.sort(arr);
        bw.write(String.valueOf(sum/5));
        bw.write("\n");
        bw.write(String.valueOf(arr[2]));
        bw.flush();
        bw.close();
    }
}
