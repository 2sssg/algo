package barkingdog.x08;

import java.io.*;
import java.util.Stack;

public class P3986 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N,ans;
    static String sen;
    static Stack<Character> st = new Stack<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        while(N-- > 0){
            sen = br.readLine();
            st.clear();
            for(char c: sen.toCharArray()){
                if(st.isEmpty()) {
                    st.push(c);
                }
                else if(st.peek() == c) {
                    st.pop();
                }
                else {
                    st.push(c);
                }
            }
            ans = st.size()==0?ans+1:ans;
        }
        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}
