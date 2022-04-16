package barkingdog.x04;

import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

public class P5397 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static LinkedList<Character> pw = new LinkedList<>();
    static ListIterator<Character> iter;
    static int N;
    static String kl;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        while(N-- > 0){
            iter = pw.listIterator();
            kl = br.readLine();
            for(char c: kl.toCharArray()){
                if(c == '<' ) {
                    if(iter.hasPrevious()) iter.previous();
                }
                else if(c == '>'){
                    if(iter.hasNext()) iter.next();
                }
                else if(c == '-' ){
                    if(iter.hasPrevious()){
                        iter.previous();
                        iter.remove();
                    }
                }
                else iter.add(c);
            }
            for(char c: pw) bw.write(String.valueOf(c));
            bw.write("\n");
            pw.clear();
        }
        bw.flush();
        bw.close();
    }
}
