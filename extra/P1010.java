package extra;

import java.io.*;
import java.util.StringTokenizer;

public class P1010 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static long fac(int count){
        if(arr[count] != 0){
            return arr[count];
        }
        arr[count] = count*fac(count-1);
        return arr[count];
    }

    static int N,l,r,ans;
    static long[] arr = new long[31];
    public static void main(String[] args) throws IOException {
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 2;
//        N = Integer.parseInt(br.readLine());
//        arr[0] = 1;
//        arr[1] = 1;
//        arr[2] = 2;
//        while(N-->0){
//            ans = 0;
//            st = new StringTokenizer(br.readLine());
//            l = Integer.parseInt(st.nextToken());
//            r = Integer.parseInt(st.nextToken());
//            bw.write(String.valueOf(ans));
//            bw.write("\n");
//        }

    }
}
