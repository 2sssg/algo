package class2;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class StackB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Stack<Integer> stack = new Stack<>();
        int N;

        /////////////////////////////////////////////

        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            switch(st.nextToken()){
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;

                case "pop":
                    if(stack.isEmpty()){
                        bw.write("-1");
                    }else{
                        bw.write(String.valueOf(stack.pop()));
                    }
                    bw.write("\n");
                    break;

                case "size":
                    bw.write(String.valueOf(stack.size()));
                    bw.write("\n");
                    break;

                case "empty":
                    bw.write(stack.isEmpty()?"1\n":"0\n");
                    break;

                case "top":
                    bw.write(stack.isEmpty()?"-1":String.valueOf(stack.peek()));
                    bw.write("\n");
                    break;

            }
        }

        bw.flush();
        bw.close();
    }
}
