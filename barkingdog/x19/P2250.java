package barkingdog.x19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P2250 {
    static class Width{
        int height;
        int l;
        int r;

        public Width(int height,int l, int r) {
            this.height = height;
            this.l = l;
            this.r = r;
        }
    }
    static class Node{
        int node;
        int parent;
        int l;
        int r;
        int lsize;
        int rsize;
        int row;
        int col;
        public Node(int node, int l, int r) {
            this.node = node;
            this.l = l;
            this.r = r;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "node=" + node +
                    ", parent=" + parent +
                    ", l=" + l +
                    ", r=" + r +
                    ", lsize=" + lsize +
                    ", rsize=" + rsize +
                    ", row=" + row +
                    ", col=" + col +
                    '}'+
                    "\n";
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static HashMap<Integer,Node> tree = new HashMap<>();
    static HashMap<Integer,Width> w = new HashMap<>();
    static int V,cur,lc,rc;
    static boolean[] visit;

    static int dfs(int target,int parent,int height){
        visit[target] = true;
        tree.get(target).parent = parent;
        tree.get(target).row = height;
        if(tree.get(target).l != -1)
            tree.get(target).lsize = dfs(tree.get(target).l,target,height+1);
        if(tree.get(target).r != -1)
            tree.get(target).rsize = dfs(tree.get(target).r,target,height+1);

        return tree.get(target).lsize + tree.get(target).rsize +1;
    }
    static void dfs(int target){
        tree.get(target).row = 1;
        visit[target] = true;
        if(tree.get(target).l != -1)
            tree.get(target).lsize = dfs(tree.get(target).l,target,2);
        if(tree.get(target).r != -1)
            tree.get(target).rsize = dfs(tree.get(target).r,target,2);
    }

    static void dfs2(int target,int wc){
        //왼쪽 자식으로 들어왔으면
        try{
            if(wc==-1){
                tree.get(target).col = tree.get(tree.get(target).parent).col-tree.get(target).rsize-1;
            }
            else{
                tree.get(target).col = tree.get(tree.get(target).parent).col+tree.get(target).lsize+1;
            }
        }catch (Exception e){
            System.out.println("target: " +target);
            System.out.println();
        }

        if(tree.get(target).l!=-1)
            dfs2(tree.get(target).l,-1);
        if(tree.get(target).r!=-1)
            dfs2(tree.get(target).r,1);
    }
    static void dfs2(int target){
        tree.get(target).col = tree.get(target).lsize+1;
        if(tree.get(target).l!=-1)
            dfs2(tree.get(target).l,-1);
        if(tree.get(target).r!=-1)
            dfs2(tree.get(target).r,1);

    }


    public static void main(String[] args) throws IOException {
        V = Integer.parseInt(br.readLine());
        visit = new boolean[V+1];
        for(int i=0; i<V; ++i){
            st = new StringTokenizer(br.readLine());
            cur = Integer.parseInt(st.nextToken());
            lc = Integer.parseInt(st.nextToken());
            rc = Integer.parseInt(st.nextToken());
            tree.put(cur,new Node(cur,lc,rc));
        }
        int head = -1;
        for(int i=1; i<=V; ++i){
            if(visit[i]) continue;
            dfs(i);
            head = i;
        }
        dfs2(head);
//        System.out.println(tree);
        for(Node no : tree.values()){
            if(w.containsKey(no.row)){
                if(w.get(no.row).l > no.col){
                    w.get(no.row).l = no.col;
                }
                if(w.get(no.row).r<no.col){
                    w.get(no.row).r = no.col;
                }

            }else{
                w.put(no.row,new Width(no.row,no.col,no.col));
            }
        }
        int max = 0;
        int h = 10000;
        for(Width wi : w.values()){

            if(wi.r-wi.l+1 > max){
                max = wi.r-wi.l+1;
                h = wi.height;
            }
        }

        System.out.println(h + " " + max);

    }
}
