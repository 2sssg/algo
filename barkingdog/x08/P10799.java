package barkingdog.x08;

import java.io.*;
import java.util.Stack;

public class P10799 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Stack<Character> st = new Stack<>();
    static String m;
    static int ans;
    static boolean isBeforecharleft;

    public static void main(String[] args) throws IOException {
        m = br.readLine();

        for(char c: m.toCharArray()){
            if(c == '(') st.push(c);
            else{
                if(isBeforecharleft){
                    st.pop();
                    ans += st.size();
                }else{
                    st.pop();
                    ++ans;
                }
            }
            isBeforecharleft = c=='(';
        }
        System.out.println(ans);
    }
}

//3 4 4 1 1 3 1 2 1 1 1 1 1
//3 7 11 12 13 16 17 19 20 21 22 23 24