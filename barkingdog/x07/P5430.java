package barkingdog.x07;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P5430 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int T,len;
    static char[] func;
    static Deque<Integer> dq = new LinkedList<>();
    static boolean isRev;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        l:while(T-->0){
            isRev = false;
            dq.clear();
            sb.setLength(0);
            func = br.readLine().toCharArray();
            len = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine().replaceAll("[\\[\\]]",""),",");
            while(st.hasMoreTokens()) dq.addLast(Integer.parseInt(st.nextToken()));
            for(char c : func){
                if(c == 'R')isRev = !isRev;
                else{
                    if(isRev){
                        if(!dq.isEmpty()) dq.pollLast();
                        else{
                            bw.write("error\n");
                            continue l;
                        }
                    }else{
                        if(!dq.isEmpty()) dq.pollFirst();
                        else{
                            bw.write("error\n");
                            continue l;
                        }
                    }
                }
            }
            sb.append("[");
            while(!dq.isEmpty()){
                if(!isRev){
                    sb.append(dq.pollFirst()).append(",");
                }else{
                    sb.append(dq.pollLast()).append(",");
                }
            }
            sb.setLength(sb.length()==1?sb.length():sb.length()-1);
            sb.append("]\n");
            bw.write(sb.toString());

        }
        bw.flush();
        bw.close();
    }
}
