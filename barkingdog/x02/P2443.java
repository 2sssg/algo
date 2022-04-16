package barkingdog.x02;

import java.util.*;

public class P2443 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int a = sc.nextInt();
        for(int i=0; i<a; i++){
            for(int j=i; j<a-1; j++){
                sb.append(" ");
            }
            for(int j=0; j<i*2+1; j++){
                sb.append("*");
            }
            for(int j=i; j<a-1; j++){
                sb.append(" ");
            }
            sb.append("\n");
        }
        sb.delete(sb.length()-1,sb.length());
        System.out.println(sb);
        sb.delete(sb.length()-(2+(a*2)-2),sb.length());
        sb.reverse();
        System.out.println(sb);
    }
}
