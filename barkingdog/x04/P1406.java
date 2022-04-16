package barkingdog.x04;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class P1406 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static LinkedList<Character> strList = new LinkedList<>();
    static ListIterator<Character> iterator;
    static StringTokenizer st;
    static String str;
    static int N;


    public static void main(String[] args) throws IOException {
        str = br.readLine();
        for(char c : str.toCharArray()) strList.addLast(c);
        iterator = strList.listIterator(str.length());

        N = Integer.parseInt(br.readLine());

        while(N-- > 0){
            st = new StringTokenizer(br.readLine());
            switch(st.nextToken().charAt(0)){
                case 'L':
                    if(iterator.hasPrevious()) iterator.previous();
                    break;
                case 'D':
                    if(iterator.hasNext()) iterator.next();
                    break;
                case 'B':
                    if(iterator.hasPrevious()) {
                        iterator.previous();
                        iterator.remove();
                    }
                    break;
                case 'P':
                    iterator.add(st.nextToken().charAt(0));
                    break;
            }
        }
        for(char c: strList){
            bw.write(String.valueOf(c));
        }
        bw.flush();
        bw.close();
    }
}
