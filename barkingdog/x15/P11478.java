package barkingdog.x15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class P11478 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static HashSet<String> hs = new HashSet<>();
    static String s;
    static int N;
    public static void main(String[] args) throws IOException {
        s = br.readLine();
        N = s.length();
        for(int i=1; i<=N; ++i){
            for(int j=0; j<=N-i; ++j){
                hs.add(s.substring(j,j+i));
            }
        }
        System.out.println(hs.size());

    }
}
