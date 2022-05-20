package barkingdog.x12;

import java.io.*;
import java.util.StringTokenizer;

public class P3036 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int gcd(int a, int b){
        if(b == 0){
            return a;
        }else{
            return gcd(b, a%b);
        }
    }

    static int N,firstgear,g;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i=0; i<N; ++i) arr[i] = Integer.parseInt(st.nextToken());
        firstgear = arr[0];
        for(int i=1; i<N; ++i){
            g = gcd(arr[i],firstgear);
            bw.write(String.valueOf(firstgear/g));
            bw.write("/");
            bw.write(String.valueOf(arr[i]/g));
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
