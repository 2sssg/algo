package barkingdog.x16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1202 {
    static class Jewel implements Comparable<Jewel>{
        int m; int v;

        public Jewel(int m, int v) {
            this.m = m;
            this.v = v;
        }

        @Override
        public int compareTo(Jewel o) {
            return o.v-this.v;
        }

        @Override
        public String toString() {
            return "Jewel{" +
                    "m=" + m +
                    ", v=" + v +
                    '}';
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Jewel[] jewels;
    static TreeSet<Integer> ts = new TreeSet<>();
    static HashMap<Integer,Integer> hm = new HashMap<>();
    static int N,K; // 보석개수, 가방개수
    static int M,V; //무게, 값
    static int C; // 가방의 무게
    static long ans;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        jewels = new Jewel[N];
        for(int i=0; i<N; ++i) {
            st = new StringTokenizer(br.readLine());
            jewels[i] = new Jewel(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(jewels);
        for(int i=0; i<K; ++i){
            C = Integer.parseInt(br.readLine());
            ts.add(C);
            hm.put(C,hm.getOrDefault(C,0)+1);
        }
        for(Jewel j : jewels){
            if(ts.ceiling(j.m)==null){
                System.out.println("넣을 수 있는 가방이없어요 그래서 넘어갈게요");
                continue;
            }else{
                M = ts.ceiling(j.m);
            }
            if(hm.get(M)==1){
                ts.remove(M);
            }else{
                hm.put(M,hm.get(M)-1);
            }
            ans += j.v;
        }
        System.out.println(ans);

    }
}
