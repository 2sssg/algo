package class3;

import java.io.*;
import java.util.*;

public class Pocketmon {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String question,tmp;
        int pocketmonNum, questionNum;


        TreeSet<String> pocketmonArr = new TreeSet<>();
        List<String> po = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        pocketmonNum = Integer.parseInt(st.nextToken());
        questionNum = Integer.parseInt(st.nextToken());
        for(int i=0; i<pocketmonNum; i++) {
            tmp = br.readLine();
            po.add(tmp);
            pocketmonArr.add(tmp);
        }

        for(int i=0; i<questionNum; i++){
            question = br.readLine();
            if(Character.isDigit(question.charAt(0))) {
                System.out.println(po.get(Integer.parseInt(question)+1));
            }
            else {
                bw.write(String.valueOf(pocketmonArr.ceiling(question)+1));
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
