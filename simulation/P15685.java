package simulation;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class P15685 {
	static class Dragon{
		int x,y;
		LinkedList<Integer> dragonCurve = new LinkedList<>();
		public Dragon(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static List<Integer> dragonCurve = new ArrayList<>();
						//우 상  좌  하
	static int[] direc = {0, 1, 2, 3};
	static int[] dx = {0,-1,0,1};
	static int[] dy = {1,0,-1,0};
	static boolean[][] arr;
	static int N,d,g;

	public static <T> Collector<T, ?, Stream<T>> reverse()
	{
		return Collectors.collectingAndThen(Collectors.toList(), list -> {
			Collections.reverse(list);
			return list.stream();
		});
	}

	static void makeDragonCurve(){
		dragonCurve.clear();
		dragonCurve.add(0);
		for(int i=0; i<10; ++i){
			dragonCurve.addAll(dragonCurve.stream().map(p->p==3?0:p+1).collect(reverse()).collect(
				Collectors.toList()));
		}
	}

	static void makearr(int x, int y, int cur){
		if(g==cur) return;
		int dir = dragonCurve.get(cur);
		dir = (dir+d)%4;
		int nx = x+dx[dir];
		int ny = y+dy[dir];
		if(nx<0 || ny<0 || nx>100 || ny >100) return;
		arr[nx][ny] = true;
		makearr(nx,ny,cur+1);
	}


	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		N = Integer.parseInt(br.readLine());
		arr = new boolean[101][101];
		makeDragonCurve();
		while(N-->0){
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			arr[x][y] = true;
			d = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			g = 1<<g;
			makearr(x,y,0);
		}

		for(int i=0; i<10; ++i){
			for(int j=0; j<10; ++j){
				if(arr[i][j]){
					System.out.print("1 ");
				}else{
					System.out.print("0 ");
				}
			}
			System.out.println();
		}

		int answer = 0;
		for(int i=0; i<100; ++i){
			for(int j=0; j<100; ++j){
				if(arr[i][j] && arr[i][j+1] && arr[i+1][j] && arr[i+1][j+1]){
					answer++;
				}
			}
		}
		System.out.println(answer);

	}
}

// 상 좌 하 우

// 상 좌 하 좌
//