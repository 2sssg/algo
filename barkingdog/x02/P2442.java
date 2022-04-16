package barkingdog.x02;

import java.util.Scanner;

public class P2442 {
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
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
