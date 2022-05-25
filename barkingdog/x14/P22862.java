package barkingdog.x14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P22862 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N,K,count,ans,idx,max;
    static List<Integer> l = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        l.add(0);
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            count = 0;
            while(st.hasMoreTokens()&&(Integer.parseInt(st.nextToken())&1)==0) count++;
            l.add(l.get(idx++)+count);
        }
        int s = l.size();
        for(int i=0; i<s; ++i) {
            max = i+K+1;
            if(max>=s) max = s-1;

            ans = Math.max(ans,l.get(max)-l.get(i));
        }

        System.out.println(ans);
    }
}
