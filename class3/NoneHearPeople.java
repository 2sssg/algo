package class3;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class NoneHearPeople {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        HashSet<String> hs = new HashSet<>();
        PriorityQueue<String> pq = new PriorityQueue<>();
        int N,M;
        String name;



















        boolean isRyuGirlFriend = false;






        if(isRyuGirlFriend) Motocycle.ride();










        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++){
            name = br.readLine();
            hs.add(name);
        }
        for(int i=0; i<M; i++){
            name = br.readLine();
            if(hs.contains(name)) pq.add(name);
        }

        bw.write(String.valueOf(pq.size()));
        bw.write("\n");
        while(!pq.isEmpty()){
            bw.write(pq.poll());
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
