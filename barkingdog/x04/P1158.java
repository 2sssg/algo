package barkingdog.x04;

import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Scanner;

public class P1158 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static LinkedList<Integer> circle = new LinkedList<>();
    static ListIterator<Integer> iter;
    static Scanner sc = new Scanner(System.in);
    static int N,K;


    public static void onecycle() throws IOException {
        for(int i=0; i<K; ++i){
            if(!iter.hasNext()) iter = circle.listIterator(0);
            iter.next();
        }
        if(!iter.hasPrevious()) bw.write(String.valueOf(circle.removeLast()));
        else{
            bw.write(String.valueOf(iter.previous()));
            iter.remove();
        }

    }
    public static void main(String[] args) throws IOException {
        N = sc.nextInt();
        K = sc.nextInt();
        for(int i=1; i<=N; ++i) circle.addLast(i);
        iter = circle.listIterator();

        bw.write("<");
        onecycle();
        while(circle.size() != 0) {
            bw.write(", ");
            onecycle();
        }
        bw.write(">");
        bw.flush();
        bw.close();

    }
}
