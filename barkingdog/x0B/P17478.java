package barkingdog.x0B;

import java.io.*;
import java.util.StringTokenizer;

public class P17478 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int rn() throws IOException {return Integer.parseInt(br.readLine());}
    static void pro(int cnt) throws IOException {
        if(cnt==N){
            tab(cnt);
            bw.write("\"재귀함수가 뭔가요?\"\n");
            tab(cnt);
            bw.write("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
            tab(cnt);
            bw.write("라고 답변하였지.\n");
            return;
        }
        tab(cnt);
        bw.write("\"재귀함수가 뭔가요?\"\n");
        tab(cnt);
        bw.write("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
        tab(cnt);
        bw.write("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
        tab(cnt);
        bw.write("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
        pro(cnt+1);
        tab(cnt);
        bw.write("라고 답변하였지.\n");
    }
    static void tab(int cnt) throws IOException {
        if(cnt==0) return;
        bw.write("____");
        tab(cnt-1);
    }
    static int N;
    public static void main(String[] args) throws IOException {
        N = rn();
        bw.write("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
        pro(0);
        bw.flush();
        bw.close();
    }
}
