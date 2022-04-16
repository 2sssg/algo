package barkingdog.x02;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P10871 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
//        내가 짠 방식인데 다른방법 존재함
//        int N,X;
//        int[] A;
//        st = new StringTokenizer(br.readLine());
//        N = Integer.parseInt(st.nextToken());
//        X = Integer.parseInt(st.nextToken());
//        A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//
//        for(int Anum: A){
//            if(Anum < X) {
//                bw.write(String.valueOf(Anum));
//                bw.write(" ");
//            }
//        }

        int N,X,a;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        while(N-- != 0){
            a = Integer.parseInt(st.nextToken());
            bw.write(a<X?a+" ":"");
        }
        bw.flush();
        bw.close();
    }
}
