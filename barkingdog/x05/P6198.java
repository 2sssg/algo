package barkingdog.x05;

import java.io.*;
import java.util.Stack;

public class P6198 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//    static Stack<Building> st = new Stack<>();
//    static Stack<Integer> tmpst = new Stack<>();
//    static int N, cnt,curH;
//    static long result;

    static Stack<Integer> st = new Stack<>();
    static int N,curH;
    static long result;
    public static void main(String[] args) throws IOException {
//        N = Integer.parseInt(br.readLine());
//
//        while(N-- > 0) tmpst.push(Integer.parseInt(br.readLine()));
//        st.push(new Building(1000000005,0));
//        while(!tmpst.isEmpty()){
//            cnt = 0;
//            curH = tmpst.pop();
//            while(st.peek().x<curH){
//                result += st.peek().y;
//                cnt += st.pop().y;
//                cnt++;
//            }
//            st.push(new Building(curH,cnt));
//        }
//        while(!st.isEmpty()) result += st.pop().y;
//        bw.write(String.valueOf(result));
//        bw.flush();
//        bw.close();

        //////////////////////위에는 내가 푼거/////////////////////////////
        //////////////////////밑에는 답지 보고 새로풀어본거/////////////////////////////

        N = Integer.parseInt(br.readLine());
        while(N-- > 0){
            curH = Integer.parseInt(br.readLine());
            while((!st.isEmpty()) && st.peek() <= curH) st.pop();
            result += st.size();
            st.push(curH);
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
//    static class Building{
//        public int x;
//        public int y;
//        public Building(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//    }
}
