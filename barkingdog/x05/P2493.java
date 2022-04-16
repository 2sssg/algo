package barkingdog.x05;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class P2493 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Stack<Integer> hst = new Stack<>();
    static Stack<Integer> idxst = new Stack<>();
    static StringTokenizer st;
    static int N,idx,curHeight;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        hst.push(Integer.parseInt(st.nextToken()));
        idxst.push(++idx);
        bw.write("0 ");
        while(st.hasMoreTokens()){
            curHeight = Integer.parseInt(st.nextToken());
            while(hst.peek()<curHeight){
                hst.pop();
                idxst.pop();
                if(hst.isEmpty()) break;
            }

            if(hst.isEmpty()) bw.write("0 ");
            else{
                bw.write(String.valueOf(idxst.peek()));
                bw.write(" ");
            }
            hst.push(curHeight);
            idxst.push(++idx);
        }

        bw.flush();
        bw.close();
    }


}
