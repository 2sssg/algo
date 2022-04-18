package barkingdog.x08;

import java.io.*;
import java.util.Stack;

public class P2504 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String s;
    static Stack<Pair> st = new Stack<>();
    static int tempNum, ans;

    public static void main(String[] args) throws IOException {
        s = br.readLine();
        for(char c : s.toCharArray()){
            tempNum = 0;
            if(c=='(' || c=='[') st.push(new Pair(false,Character.toString(c)));
            else{
                if(st.isEmpty()){
                    System.out.println("0");
                    System.exit(0);
                }else{
                    if(!st.peek().x){ //닫힌 괄호가 들어올 때
                        if(st.peek().y.equals("(") && c==')') {
                            st.pop();
                            st.push(new Pair(true,"2"));
                        }
                        else if(st.peek().y.equals("[") && c==']') {
                            st.pop();
                            st.push(new Pair(true,"3"));
                        }else{
                            System.out.println("0");
                            System.exit(0);
                        }
                    }else{
                        while(!st.isEmpty() && st.peek().x) tempNum += Integer.parseInt(st.pop().y);
                        if(!st.isEmpty()){
                            if(st.peek().y.equals("(") && c ==')') {
                                st.pop();
                                st.push(new Pair(true,String.valueOf(tempNum*2)));
                            }
                            else if(st.peek().y.equals("[") && c ==']') {
                                st.pop();
                                st.push(new Pair(true,String.valueOf(tempNum*3)));
                            }else{
                                System.out.println("0");
                                System.exit(0);
                            }
                        }else{
                            System.out.println("0");
                            System.exit(0);
                        }

                    }
                }

            }
        }
        while(!st.isEmpty()) {
            if(!st.peek().x){
                System.out.println("0");
                System.exit(0);
            }
            ans+= Integer.parseInt(st.pop().y);
        }
        System.out.println(ans);
    }



    static class Pair{
        boolean x;
        String y;

        public Pair(boolean x, String y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "x=" + x +
                    ", y='" + y + '\'' +
                    '}';
        }
    }
}
