package barkingdog.x10;

import java.io.*;
import java.util.StringTokenizer;

public class P10942 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static boolean chk(int s, int e){
        return s<0 || e>=N;
    }
    static int even(int s, int e,int cnt){
        if(chk(s,e) || arr[s] != arr[e]){
            return cnt;
        }
        return even(s-1, e+1,cnt+1);
    }

    static int N,T,s,e;
    static int[] arr,evenArr, oddArr;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        evenArr = new int[N];
        oddArr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; ++i) arr[i] = Integer.parseInt(st.nextToken());
        for(int i=0; i<N; ++i){
            oddArr[i] = even(i-1,i+1,1);
            evenArr[i] = even(i,i+1,0);
        }
        T = Integer.parseInt(br.readLine());
        while(T-->0){
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            if(((e-s+1)&1) == 1){
                if(oddArr[(s+e)/2 - 1]>=(e-s+2)/2 )bw.write("1\n");
                else bw.write("0\n");
            }else{
                if(evenArr[(s+e)/2 - 1]>=(e-s+2)/2 )bw.write("1\n");
                else bw.write("0\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
