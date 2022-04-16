import java.io.*;
import java.util.Arrays;

public class Tomato {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int M,N;

        int[][] tomato;
        M = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());

        tomato = new int[N][M];

        for(int i=0; i<N; i++) tomato[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        



    }
}
