package barkingdog.x02;
import java.util.Scanner;
public class P2441 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int a = sc.nextInt();
        for(int i=0; i<a; i++){
            for(int j=0; j<i; j++){
                sb.append(" ");
            }
            for(int j=i; j<a; j++){
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
