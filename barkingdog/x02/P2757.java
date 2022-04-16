package barkingdog.x02;

import java.io.*;
import java.util.Arrays;

public class P2757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] array;
        array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        bw.write(Arrays.toString(array).replaceAll("[,\\[\\]]",""));
        bw.flush();
        bw.close();
    }
}
