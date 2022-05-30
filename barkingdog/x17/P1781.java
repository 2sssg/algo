package barkingdog.x17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1781 {
    static class Cup implements Comparable<Cup> {
        int num;
        int deadline;
        int reward;

        public Cup(int num, int deadline, int reward) {
            this.num = num;
            this.deadline = deadline;
            this.reward = reward;
        }


        @Override
        public int compareTo(Cup o) {
            if(this.deadline == o.deadline){
                return o.reward-this.reward;
            }
            return o.deadline-this.deadline;
        }

        @Override
        public String toString() {
            return "Cup{" +
                    "num=" + num +
                    ", deadline=" + deadline +
                    ", reward=" + reward +
                    '}';
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PriorityQueue<Cup> pq = new PriorityQueue<>();
    static PriorityQueue<Integer> rpq = new PriorityQueue<>(Collections.reverseOrder());
    static Cup cup;
    static int N,dl,rw,day;
    static long ans;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for(int i=1; i<=N; ++i){
            st = new StringTokenizer(br.readLine());
            dl = Integer.parseInt(st.nextToken());
            rw = Integer.parseInt(st.nextToken());
            pq.add(new Cup(i,dl,rw));
        }
        dl = 0;
        day = 0;
        int temp = pq.peek().deadline;
        for(int i=temp-1; i>=0; --i){
            while(!pq.isEmpty() && pq.peek().deadline>i) {
                rpq.add(pq.poll().reward);
            }
            if (!rpq.isEmpty()){
                ans += rpq.poll();
            }

        }
        System.out.println(ans);

//        while(!pq.isEmpty()){
//            cup = pq.poll();
////            dl = cup.deadline;
////            while(!pq.isEmpty() && pq.peek().deadline<=day){
////                pq.poll();
////            }
////            if(pq.isEmpty()) break;
////            System.out.println(cup);
//            ans += cup.reward;
//            day++;
//            dl = cup.deadline;
//            while(!pq.isEmpty() && dl == pq.peek().deadline) pq.poll();
//        }
//        System.out.println(ans);
    }
}