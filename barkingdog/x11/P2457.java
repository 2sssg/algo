package barkingdog.x11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2457 {
    static class Flower implements Comparable<Flower> {
        int startM;
        int startD;
        int endM;
        int endD;

        public Flower(int startM, int startD, int endM, int endD) {
            this.startM = startM;
            this.startD = startD;
            this.endM = endM;
            this.endD = endD;
        }

        @Override
        public String toString() {
            return "Flower{" +
                    "startM=" + startM +
                    ", startD=" + startD +
                    ", endM=" + endM +
                    ", endD=" + endD +
                    '}';
        }

        @Override
        public int compareTo(Flower o) {
            if(this.startM == o.startM){
                if(this.startD == o.startD){
                    if(this.endM == o.endM){
                        return this.endD-o.endD;
                    }
                    return this.endM - o.endM;
                }
                return this.startD-o.startD;
            }
            return this.startM - o.startM;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Flower> flowers = new ArrayList<>();
    static int N,ans,curStartM,curStartD, curEndM,curEndD, curFlower;
    static Flower flower ;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; ++i){
            st = new StringTokenizer(br.readLine());
            flowers.add(new Flower(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        Collections.sort(flowers);
        System.out.println(flowers);
        for(int i=0; i<N; ++i){
            flower = flowers.get(i);
            if(flower.startM<3){
                if(flower.endM==curEndM){
                    if(flower.endD>curEndD){
                        curStartM = flower.startM;
                        curStartD = flower.startD;
                        curEndD = flower.endD;
                        curFlower = i;
                    }
                }else if(flower.endM>curEndM){
                    curStartM = flower.startM;
                    curStartD = flower.startD;
                    curEndM = flower.endM;
                    curEndD = flower.endD;
                    curFlower = i;
                }
            }else{
                if (curEndM <3){
                    ans = 0;
                    break;
                }
                if(curEndM<flower.startM || ((curEndM==curStartM)&&curEndD<flower.startD)){
                    curFlower = i-1;

                }
            }
        }

    }
}
