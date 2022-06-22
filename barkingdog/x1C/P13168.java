package barkingdog.x1C;

import Constant.Source;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P13168 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Map<String,Integer> m = new HashMap<>();
    /*
    N : 전체 도시 수
    R : 내일로 티켓 가격
    M : 방문할 도시 수
    K : 경로 수
    */
    static int N,R,M,K,price,town1,town2;
    static String[] checkinTownList;
    static int[][] ticket,no_ticket;
    static String type;

    static int ticketPrice(String type, int price){
        if(type.equals("Mugunghwa") || type.equals("ITX-Saemaeul") || type.equals("ITX-Cheongchun")) return 0;
        if(type.equals("S-Train") || type.equals("V-Train")) return price/2;
        else return price;
    }

    public static void main(String[] args) throws IOException {

        //지워야될거
        m.clear();
        br = Source.getBufferedReader();
        //지워야될거

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        String town;
        int idx = 0;
        while(st.hasMoreTokens()){
            town = st.nextToken();
            if(m.containsKey(town)) continue;
            m.put(town,idx++);
        }

        N=m.size();

        M = Integer.parseInt(br.readLine());
        checkinTownList = br.readLine().split(" ");
        K = Integer.parseInt(br.readLine());
        ticket = new int[N][N];
        no_ticket = new int[N][N];
        for(int i=0; i<N; ++i){
            Arrays.fill(ticket[i],300000);
            Arrays.fill(no_ticket[i],300000);
        }

        while(K-->0){
            st = new StringTokenizer(br.readLine());
            type = st.nextToken();
            town1 = m.get(st.nextToken());
            town2 = m.get(st.nextToken());
            price = Integer.parseInt(st.nextToken())*2;

            ticket[town1][town2] = Math.min(ticketPrice(type,price),ticket[town1][town2]);
            ticket[town2][town1] = Math.min(ticketPrice(type,price),ticket[town1][town2]);
            no_ticket[town1][town2] = Math.min(price,no_ticket[town1][town2]);
            no_ticket[town2][town1] = Math.min(price,no_ticket[town1][town2]);
        }

//        for(int i=0; i<m.size(); ++i){
//            ticket[i][i] = 0;
//            no_ticket[i][i] = 0;
//        }
        for(int i=0; i<N; ++i){
            for(int j=0; j<N; ++j){
                for(int k=0; k<N; ++k){
                    ticket[j][k] = Math.min(ticket[j][i]+ticket[i][k],ticket[j][k]);
                    no_ticket[j][k] = Math.min(no_ticket[j][i]+no_ticket[i][k],no_ticket[j][k]);
                }
            }
        }

//        for(int i=0; i<m.size(); ++i){
//            System.out.println(Arrays.toString(ticket[i]));
//        }
//        System.out.println();
//        System.out.println();
//        for(int i=0; i<m.size(); ++i){
//            System.out.println(Arrays.toString(no_ticket[i]));
//        }



        int ticketAns = R*2;
        int no_ticketAns = 0;

        for(int i=0; i<M-1; ++i){
            ticketAns += ticket[m.get(checkinTownList[i])][m.get(checkinTownList[i+1])];
            no_ticketAns += no_ticket[m.get(checkinTownList[i])][m.get(checkinTownList[i+1])];
        }
//        System.out.println("ticketAns : " + ticketAns);
//        System.out.println("no_ticketAns : " + no_ticketAns);

        System.out.println(ticketAns<no_ticketAns?"Yes":"No");





    }
}
