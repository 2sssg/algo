package barkingdog.x1B;

import Constant.Source;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2887 {
    static class Triple{
        int x;
        int y;
        int z;

        public Triple(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
        public int getDist(Triple t){
            return Math.min(Math.min(Math.abs(this.x-t.x),Math.abs(this.y-t.y)),Math.abs(this.z-t.z));
        }
    }
    static class Pair implements Comparable<Pair>{
        int v;
        int w;

        public Pair(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Pair o) {
            return this.w-o.w;
        }


        @Override
        public String toString() {
            return "Pair{" +
                    "v=" + v +
                    ", w=" + w +
                    '}';
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Triple> l = new ArrayList<>();
    static PriorityQueue<Pair> q = new PriorityQueue<>();
    static TreeSet<Pair> t = new TreeSet<>();
    static Pair[] pairs,pairs2;
//    static int[] dist;
    static boolean[] chk;


    static int N,cnt;
    static long ans;

    public static void main(String[] args) throws IOException {
        t.clear();
//        q.clear();
        br = Source.getBufferedReader();
        N = Integer.parseInt(br.readLine());
        chk = new boolean[N];
        pairs = new Pair[N];
        pairs2 = new Pair[N];
//        dist = new int[N*(N+1)/2];
        for(int i=0; i<N; ++i){
            st = new StringTokenizer(br.readLine());
            l.add(new Triple(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        // 0,0  0,1  0,2  0,3  0,4
        // 0,1  1,1  1,2  1,3  1,4
        // 0,2  1,2  2,2  3,2  4,2
        // 0,3  1,3  2,3  3,3  4,3
        // 0,4  1,4  2,4  3,4  4,4
        int[] arr = new int[N];
        Arrays.fill(arr,Integer.MAX_VALUE);
//        for(int i=0; i<N-1; ++i){
//            for(int j=i+1; j<N; ++j){
//                int d = l.get(i).getDist(l.get(j));
//                arr[i] = Math.min(d,arr[i]);
//                arr[j] = Math.min(d,arr[j]);
//            }
//        }
        chk[0] = true;
        for(int i=1; i<N; ++i){
            q.add(new Pair(i,l.get(0).getDist(l.get(i))));
        }
        cnt = 1;
        ans = 0;
        Pair p,temp,temp2;

        while(cnt<N){
            System.out.println(q);
            p = q.poll();
//            if(dist[p.v*(p.v+1)/2] == -1) continue;
            if(chk[p.v]) continue;
            System.out.println(p);
            cnt++;
            ans += p.w;
//            dist[p.v*(p.v+1)/2] = -1;
            chk[p.v] = true;
            for(int i=0; i<N; ++i){
                int dist = l.get(p.v).getDist(l.get(i));
                if(chk[i]) continue;
                q.add(new Pair(i,dist));
//                temp2 = t.ceiling(temp);
//                if(temp2!=null){
//                    if(temp2.v==i && dist<temp2.w){
//                        t.remove(temp);
//                        t.add(temp);
//                    }
//                }else{
//                    t.add(temp);
//                }
//                if(t.contains(temp)){
//                    if(dist<t.ceiling(temp).w){
//                        t.remove(temp);
//                        t.add(temp);
//                    }
//                }else{
//                    t.add(temp);
//                }
            }
        }

        System.out.println(ans);

    }
}

