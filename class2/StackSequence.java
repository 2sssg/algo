package class2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class StackSequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stk = new Stack<>();
        ArrayList<Integer> target = new ArrayList<>();
        ArrayList<Integer> sequence = new ArrayList<>();
        StringBuilder ans = new StringBuilder();
        int n, idx;

        n = Integer.parseInt(br.readLine());
        idx = 0;
        for (int i = 0; i < n; i++){
            target.add(Integer.parseInt(br.readLine()));
        }
        for (int i = 1; i <= n; i++){
            stk.push(i);
            ans.append("+\n");
            if (i == target.get(idx)){
                while (!stk.isEmpty()){
                    if (stk.peek().equals(target.get(idx))){
                        sequence.add(stk.pop());
                        ans.append("-\n");
                        idx += 1;
                    }
                    else{
                        break;
                    }
                }
            }
        }
        if (target.equals(sequence)){
            System.out.print(ans);
        }
        else{
            System.out.println("NO");
        }
    }
}


