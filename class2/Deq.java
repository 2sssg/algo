package class2;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Deq {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        Deque<Integer> deq = new LinkedList<>();
        int N;

        /////////////////////////////////////////////

        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            switch(st.nextToken()){
                case "push_front":
                    deq.addFirst(Integer.parseInt(st.nextToken()));
                    break;

                case "push_back":
                    deq.addLast(Integer.parseInt(st.nextToken()));
                    break;

                case "pop_front":
                    if(deq.isEmpty()){
                        bw.write("-1");
                    }else{
                        bw.write(String.valueOf(deq.pollFirst()));
                    }
                    bw.write("\n");
                    break;

                case "pop_back":
                    if(deq.isEmpty()){
                        bw.write("-1");
                    }else{
                        bw.write(String.valueOf(deq.pollLast()));
                    }
                    bw.write("\n");
                    break;

                case "size":
                    bw.write(String.valueOf(deq.size()));
                    bw.write("\n");
                    break;

                case "empty":
                    bw.write(deq.isEmpty()?"1\n":"0\n");
                    break;

                case "front":
                    bw.write(deq.isEmpty()?"-1":String.valueOf(deq.peekFirst()));
                    bw.write("\n");
                    break;

                case "back":
                    bw.write(deq.isEmpty()?"-1":String.valueOf(deq.peekLast()));
                    bw.write("\n");
                    break;

            }
        }

        bw.flush();
        bw.close();

    }
}
