package class2;

import java.io.*;
import java.util.*;

public class QueueB {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        Deque<Integer> queue = new LinkedList<>();
        int N;

        /////////////////////////////////////////////

        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            switch(st.nextToken()){
                case "push":
                    queue.add(Integer.parseInt(st.nextToken()));
                    break;

                case "pop":
                    if(queue.isEmpty()){
                        bw.write("-1");
                    }else{
                        bw.write(String.valueOf(queue.poll()));
                    }
                    bw.write("\n");
                    break;

                case "size":
                    bw.write(String.valueOf(queue.size()));
                    bw.write("\n");
                    break;

                case "empty":
                    bw.write(queue.isEmpty()?"1\n":"0\n");
                    break;

                case "front":
                    bw.write(queue.isEmpty()?"-1":String.valueOf(queue.peekFirst()));
                    bw.write("\n");
                    break;

                case "back":
                    bw.write(queue.isEmpty()?"-1":String.valueOf(queue.peekLast()));
                    bw.write("\n");
                    break;

            }
        }

        bw.flush();
        bw.close();

    }
}
