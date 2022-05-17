package barkingdog.x11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1700 {
    static class Pair implements Comparable<Pair>{
        int num;
        int nextidx;

        @Override
        public int compareTo(Pair o) {
            return o.nextidx - this.nextidx;
        }

        public Pair setNextidx(int nextidx) {
            this.nextidx = nextidx;
            return this;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return num == pair.num;
        }


        @Override
        public String toString() {
            return "Pair{" +
                    "num=" + num +
                    ", nextidx=" + nextidx +
                    '}';
        }

        public Pair(int num) {
            this.num = num;
        }

        public Pair(int num, int nextidx) {
            this.num = num;
            this.nextidx = nextidx;
        }
    }
    static class Multi{
        int manum;
        Queue<Integer> q = new ArrayDeque<>();

        public Multi(int manum, int idx) {
            this.manum = manum;
            q.add(idx);
        }

        public Multi(int manum) {
            this.manum = manum;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Multi multi = (Multi) o;
            return manum == multi.manum;
        }


        @Override
        public String toString() {
            return "Multi{" +
                    "manum=" + manum +
                    ", q=" + q +
                    '}';
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PriorityQueue<Pair> pq = new PriorityQueue<>();

    static List<Multi> lq = new ArrayList<>();
    static int N,multicnt,ans;
    static int[] arr;


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        multicnt = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        int idx=0;
        while(st.hasMoreTokens()){
            int cur = Integer.parseInt(st.nextToken());
            arr[idx] = cur;
            boolean isin = false;
            for(int i=0; i<lq.size(); ++i){
                if (lq.get(i).manum == cur){
                    lq.get(i).q.add(idx++);
                    isin = true;
                }
            }
            if(!isin){
                lq.add(new Multi(cur,idx++));
            }
        }
        for(Multi m : lq){
            m.q.add(N+1);
            m.q.poll();
        }

        for(int i=0; i<N; ++i){
            Multi m=null;
            for(Multi mm : lq){
                if(arr[i] == mm.manum){
                    m = mm;
                    break;
                }
            }
            if(pq.contains(new Pair(arr[i]))){
                List<Pair> temp = new ArrayList<>();
                while(pq.peek().num != m.manum){
                    temp.add(pq.poll());
                }
                pq.add(pq.poll().setNextidx(m.q.poll()));
                pq.addAll(temp);
                continue;
            }
            if(pq.size()<multicnt){

            }else{
                ans++;
                pq.poll();
            }
            pq.add(new Pair(arr[i],m.q.poll()));
        }
        System.out.println(ans);
    }
}

/*
3 8
1 2 3 4 1 1 1 2
1

2 5
5 2 2 3 5
1

3 11
11 8 11 7 2 8 2 7 5 10 2
3

2 7
2 3 2 3 1 2 7
답: 2

2 5
5 2 2 3 5
답: 1

2 4
5 3 1 5
답: 1

3 6
1 1 1 1 2 3
답: 0

3 8
1 2 3 4 1 1 1 2
답: 1

2 15
3 2 1 2 1 2 1 2 1 3 3 3 3 3 3
답: 2

1 3
1 2 1
답: 2

3 14
1 4 3 2 5 4 3 2 5 3 4 2 3 4
4

3 9
1 2 3 4 1 1 1 1 3
1

2 11
1 2 3 4 5 1 1 1 2 2 2
4
*/
