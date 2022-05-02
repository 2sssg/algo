package barkingdog.x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P14891 {
    //톱니바퀴
    //N = 0
    //S = 1
    static class Gear{
        Deque<Integer> l;
        Deque<Integer> r;
        int gearNum;

        public Gear(int gearNum) {
            this.gearNum = gearNum;
            this.l = new ArrayDeque<>();
            this.r = new ArrayDeque<>();
        }

        @Override
        public String toString() {
            return "l "+l + "r "+r;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int rn() throws IOException {return Integer.parseInt(br.readLine());}
    static void est() throws IOException {st = new StringTokenizer(br.readLine());}
    static int rstn() throws IOException{return Integer.parseInt(st.nextToken());}
    static void rotate(int gearnum, int dir){
        if(isrotate[gearnum-1] == 1){
            return;
        }
        isrotate[gearnum-1] = 1;
        if(dir == 1){
            if(gearnum == 1){
                if(!Objects.equals(gears[gearnum - 1].r.peekFirst(), gears[gearnum].l.peekFirst())){
                    rotate(gearnum+1, dir*(-1));
                }
            }else if(gearnum == 4){
                if(!Objects.equals(gears[gearnum - 1].l.peekFirst(), gears[gearnum-2].r.peekFirst())) {
                    rotate(gearnum - 1, dir * (-1));
                }
            }else{
                if(!Objects.equals(gears[gearnum - 1].r.peekFirst(), gears[gearnum].l.peekFirst())){
                    rotate(gearnum+1, dir*(-1));
                }
                if(!Objects.equals(gears[gearnum - 1].l.peekFirst(), gears[gearnum-2].r.peekFirst())) {
                    rotate(gearnum - 1, dir * (-1));
                }
            }
            gears[gearnum-1].l.addFirst(gears[gearnum-1].r.pollLast());
            gears[gearnum-1].r.addFirst(gears[gearnum-1].l.pollLast());
//            System.out.println("dir 1");
//            for(int i=0; i<4; i++){
//                System.out.println(gears[i].toString());
//            }
//            System.out.println();
        }else{
            if(gearnum == 1){
                if(!Objects.equals(gears[gearnum - 1].r.peekFirst(), gears[gearnum].l.peekFirst())){
                    rotate(gearnum+1, dir*(-1));
                }
            }else if(gearnum == 4){
                if(!Objects.equals(gears[gearnum - 1].l.peekFirst(), gears[gearnum-2].r.peekFirst())) {
                    rotate(gearnum - 1, dir * (-1));
                }
            }else{
                if(!Objects.equals(gears[gearnum - 1].r.peekFirst(), gears[gearnum].l.peekFirst())){
                    rotate(gearnum+1, dir*(-1));
                }
                if(!Objects.equals(gears[gearnum - 1].l.peekFirst(), gears[gearnum-2].r.peekFirst())) {
                    rotate(gearnum - 1, dir * (-1));
                }
            }
            gears[gearnum-1].l.addLast(gears[gearnum-1].r.pollFirst());
            gears[gearnum-1].r.addLast(gears[gearnum-1].l.pollFirst());
//            System.out.println("dir-1");
//            for(int i=0; i<4; i++){
//                System.out.println(gears[i].toString());
//            }
//            System.out.println();
        }
    }



    static int[] brArray;
    static Gear[] gears = new Gear[4];
    static int[] isrotate = new int[4];
    static int K,gn,direction;
    public static void main(String[] args) throws IOException {
        for(int i=1; i<5; ++i){
            gears[i-1] = new Gear(i);
            brArray = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            for(int j=2; j<6; ++j) gears[i-1].r.addLast(brArray[j]);
            for(int j=6; j<8; ++j) gears[i-1].l.addLast(brArray[j]);
            for(int j=0; j<2; ++j) gears[i-1].l.addLast(brArray[j]);
        }
//        for(int i=0; i<4; i++){
//            System.out.println(gears[i].toString());
//        }
        K = rn();
        while(K-->0){
            est(); gn = rstn(); direction = rstn();
            Arrays.fill(isrotate,0);
            rotate(gn,direction);
        }
        int ans = 0;
        for(int i=0; i<4; i++){
            gears[i].l.pollLast();
            ans += gears[i].l.pollLast()<<i;
        }
        System.out.println(ans);
    }
}
