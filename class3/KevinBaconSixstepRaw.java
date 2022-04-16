package class3;

import java.io.*;
import java.util.*;

public class KevinBaconSixstepRaw {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N,relation, f1,f2,qpoll,count;
        int[][] friendGraph;
        int[] flag,bacon;
        Queue<Integer> q = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        relation = Integer.parseInt(st.nextToken());
        friendGraph = new int[relation+1][relation+1];
        flag = new int[relation+1];
        bacon = new int[relation+1];
        for(int i=1; i<relation+1; i++){
            st = new StringTokenizer(br.readLine());
            f1 = Integer.parseInt(st.nextToken());
            f2 = Integer.parseInt(st.nextToken());
            friendGraph[f1][f2] = 1;
            friendGraph[f2][f1] = 1;
        }

        for(int i=0; i<relation+1; i++){
            System.out.println(Arrays.toString(friendGraph[i]));
        }

        for(int i=1; i<N+1; i++){
            Arrays.fill(flag,0);
            q.add(i);
//            flag[i] = 1;
            count = 0;
            l: while(!q.isEmpty()){
                count++;
//                while(flag[q.peek()] == 1){
//                    q.poll();
//                    if(q.isEmpty()) break l;
//                }
                qpoll = q.poll();

                for(int j=0; j<N+1; j++){
                    if(friendGraph[qpoll][j] == 1 && flag[j] != 1){
                        q.add(j);
                        flag[j] = 1;
                        bacon[i] += count;
                    }
                }
            }
        }

        System.out.println(Arrays.toString(bacon));




    }
}
