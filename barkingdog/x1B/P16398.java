package barkingdog.x1B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class P16398 {
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
    static PriorityQueue<Pair> q = new PriorityQueue<>();


    static int N;
    static int[][] adjList;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        adjList = new int[N][N];
        visit = new boolean[N];
        for(int i=0; i<N; ++i) {
            adjList[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        q.add(new Pair(1,0));
        long ans=0;
        int cnt=0;
        while(cnt<N){
            Pair p = q.poll();
            if(visit[p.v-1]) continue;
            cnt++;
            ans += p.w;
            visit[p.v-1] = true;
            for(int i=1; i<=N; ++i){
                if(visit[i-1]) continue;
                q.add(new Pair(i,adjList[p.v-1][i-1]));
            }

        }
        System.out.println(ans);

    }
}


//10
//0 18 5 10 5 12 13	7 18 9
//18 0 5 9 15 10 20 14 3 13
//5 5 0 13 7 20	0 15 7 16
//10 9 13 0 1 2	17 19 5	4
//5 15 7 1 0 0 12 11 4 12
//12 10 20 2 0 0 14	17 12 2
//13 20 0 17 12 14 0 1 20 14
//7 14 15 19 11	17 1 0 18 6
//18 3 7 5 4 12 20 18 0	14
//9 13 16 4	12 2 14	6 14 0

//10
//0 8 0 0 1 1 8 5 3 2
//8 0 2 0 1 8 8 2 4 2
//0 2 0 4 1 6 7 5 1 7
//0 0 4 0 6 1 8 3 2 2
//1 1 1 6 0 4 5 4 0 3
//1 8 6 1 4 0 4 7 5 3
//8 8 7 8 5 4 0 1 6 3
//5 2 5 3 4 7 1 0 5 6
//3 4 1 2 0 5 6 5 0 8
//2 2 7 2 3 3 3 6 8 0