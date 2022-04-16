package queue;

import java.io.*;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class RotationQueue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Deque<Integer> numList = new LinkedList<>();
        int N,M,findNum,size;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        size = N;

        for(int i=1; i<size+1; i++){
            numList.addLast(i);
        }
        st = new StringTokenizer(br.readLine());

        while(st.hasMoreTokens()){
            findNum = Integer.parseInt(st.nextToken());
        }


    }
}
