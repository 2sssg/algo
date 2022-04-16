import java.io.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class LittlePrince {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T, x1, y1, x2, y2, n, cnt;
        List<Planet> planetList;
        T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            cnt = 0;
            planetList = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(br.readLine());
            for(int j=0; j<n; j++){
                st = new StringTokenizer(br.readLine());
                planetList.add(new Planet(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
            }
            for(Planet p: planetList){
                p.isIn = (p.distance(x1,y1));
                p.isChanged = (p.isIn^p.distance(x2,y2));
                cnt = p.isChanged?cnt+1:cnt;
            }
            bw.write(String.valueOf(cnt));
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}


class Planet{
    int x;
    int y;
    int r;
    boolean isIn;
    boolean isChanged;
    public Planet(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public boolean distance(int nowX, int nowY){
        return Math.pow(r,2)>Math.pow(nowX-x,2)+Math.pow(nowY-y,2);
    }


}

