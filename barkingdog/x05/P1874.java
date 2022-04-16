package barkingdog.x05;

import java.io.*;
import java.util.Stack;

public class P1874 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static int n,current;
    static int item = 1;
    static boolean flag;
    static Stack<Integer> s = new Stack<>();

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        while(n-- > 0){
            current = Integer.parseInt(br.readLine());
            while(current >= item){
                sb.append("+\n");
                s.push(item++);
            }

            if(!s.isEmpty()){
                if(s.peek() == current){
                    s.pop();
                    sb.append("-\n");
                    continue;
                }else flag = true;
            }else flag = true;
            break;
        }
        if(flag) {
            sb.setLength(0);
            sb.append("NO");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
