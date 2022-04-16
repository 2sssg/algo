package extra;


import java.util.*;
import java.io.*;

public class Rightnum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> ans = new Stack();
        Stack<Integer> st = new Stack();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            st.push(Integer.parseInt(token.nextToken()));

        }

        int max = 0;// 오른쪽 수들중 젤 큰 수
        int before = 0;// 해당 원소의 바로 오른쪽 원소
        while (!st.isEmpty()) {
            if (st.peek() < max) {// 현재 원소가 max보다 작을때,
                if (st.peek() < before) {// 현재 원소의 바로 오른쪽 수 보다 현재 원소가 작으면 max에 관계없이 before가 오큰수가 된다.
                    // -> before 수 보다 오른쪽에 있는 원소들은 어차피 max가 오큰수가 될 것이다.
                    ans.push(before);// 오큰수 입력
                } else {
                    ans.push(max);// before 가 현재원소보다 작으므로 max가 오큰수 됨
                }
                before = st.pop();// before를 현재원소로 갱신.
                max = Math.max(before, max);// max 값을 before까지 범위 안에 넣어 갱신해줌.
            } else {// 현재 원소가 max보다 큰 경우.
                // 오큰수가 없다.
                max = st.pop();
                ans.push(-1);
            }
        }
        for (int i = 0; i < N; i++) {
            bw.write(ans.pop().toString() + " ");
        }
        bw.close();
        br.close();
    }

}
