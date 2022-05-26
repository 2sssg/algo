package barkingdog.x15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P1351 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static HashMap<Long,Long> m = new HashMap<>();

    static long N,P,Q;

    static long func(long target){
        if(m.containsKey(target)){
            return m.get(target);
        }
        long temp = func(target/Q)+func(target/P);
        m.put(target,temp);
        return m.get(target);
    }
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());
        m.put((long)0,(long)1);
        System.out.println(func(N));


    }
}
