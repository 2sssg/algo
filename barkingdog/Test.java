package barkingdog;

import java.io.*;
import java.util.*;

public class Test {
    static class Temp implements Comparable<Temp>{
        int x;
        int y;

        @Override
        public int compareTo(Temp o) {
            return this.x-o.x;
        }

        public Temp(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Temp{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
    public static void main(String[] args) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.add(1);
        q.add(1);
        q.add(1);
        q.add(1);
        q.add(1);
        q.add(1);
        q.add(1);
        System.out.println(q);

        TreeSet<Temp> t = new TreeSet<>();
        t.add(new Temp(1,1));
        t.remove(new Temp(1,0));
        t.add(new Temp(1,2));
        t.add(new Temp(1,3));
        t.add(new Temp(1,4));
        t.add(new Temp(1,5));
        System.out.println(t);

//        PriorityQueue<Temp> t = new PriorityQueue<>();
//        t.add(new Temp(1,1));
//        t.add(new Temp(1,2));
//        t.add(new Temp(1,3));
//        t.add(new Temp(1,4));
//        t.add(new Temp(1,5));
//        System.out.println(t);



    }
}
