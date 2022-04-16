package class2;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Yosipuss {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> people = new LinkedList<>();
        StringTokenizer st;
        int N,K;

        /////////////////////////////////////////////////////////////////


        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        bw.write("<");
        for(int i=1; i<=N;i++){
            people.add(i);
        }
        while(!people.isEmpty()){
            for(int i=1; i<K; i++){
                people.add(people.poll());
            }
            bw.write(String.valueOf(people.poll()));
            if(people.isEmpty()) break;
            bw.write(", ");
            if(people.size() == 1 || people.isEmpty()){
                if(!people.isEmpty()) bw.write(String.valueOf(people.poll()));
                break;

            }

        }

        bw.write(">");

        bw.flush();
        bw.close();


    }
}
