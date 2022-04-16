package barkingdog.x03;

import java.io.*;

public class P10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = new int[26];
        String s = br.readLine();
        for(char alpha: s.toCharArray()) arr[alpha-'a']++;
        for(int cnt: arr) bw.write(cnt+" ");
        bw.flush();
        bw.close();
    }
}
