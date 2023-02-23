package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2378 {
	static int[][] matrix;
	static int r, c;
	public static void main(String[] args) throws IOException {
		int min = IINF;
		int minX = 0;
		int minY = 0;
		matrix = new int[(r = rstn()) + 1][(c = rstn()) + 1];
		if (r % 2 == 0 && c % 2 == 0) {
			for (int i = 1; i < r + 1; i++) {
				for (int j = 1; j < c + 1; j++) {
					int point = rstn();
					matrix[i][j] = point;
					if (((i % 2 == 0 && j % 2 != 0) || (i % 2 != 0 && j % 2 == 0)) && point < min) {
						minX = i;
						minY = j;
						min = point;
					}
				}
			}
		} else {
			for (int i = 1; i < r + 1; i++) {
				for (int j = 1; j < c + 1; j++) {
					int point = rstn();
					matrix[i][j] = point;
				}
			}
		}
		if (r % 2 != 0) {
			boolean trigger = true;
			int i = 1;
			while (true) {
				if (!trigger) {
					for (int j = c; j > 1; j--)
						sb.append("L");
					trigger = true;
				} else {
					for (int j = 1; j < c; j++)
						sb.append("R");
					trigger = false;
				}
				if (i < r) {
					sb.append("D");
					i++;
				} else
					break;
			}
		} else if (c % 2 != 0) {
			boolean trigger = true;
			int j = 1;
			while (true) {
				if (trigger) {
					for (int i = 1; i < r; i++)
						sb.append("D");
					trigger = false;
				} else {
					for (int i = r; i > 1; i--)
						sb.append("U");
					trigger = true;
				}
				if (j < r) {
					sb.append("R");
					j++;
				} else
					break;
			}
		} else {
			int blockRow = minX;
			int blockCol = minY;
			int i = 1;
			int j = 1;
			boolean trigger = false;
			while (true) {
				if (blockRow % 2 != 0) {
					if (i == blockRow) {
						while (true) {
							sb.append("DR");
							i++;
							j++;
							if (i - 1 == blockRow && j == blockCol) {
								if (blockRow != r && blockCol != c) {
									sb.append("RUR");
									i--;
									j += 2;
								} else
									break;
							} else {
								sb.append("UR");
								i--;
								j++;
							}
							if (j >= c) {
								sb.append("D");
								i++;
								break;
							}
						}
						if (i < r) {
							sb.append("D");
							trigger = true;
							i++;
						}
					}
				} else {
					if (i == blockRow - 1) {
						while (true) {
							if (i + 1 == blockRow && j == blockCol) {
								sb.append("R");
								j++;
								if (j < c) {
									sb.append("DR");
									i++;
									j++;
								}
							} else {
								if (j < c) {
									sb.append("DR");
									i++;
									j++;
								}
							}
							if (j < c) {
								sb.append("UR");
								i--;
								j++;
							} else {
								sb.append("D");
								i++;
								break;
							}
						}
						if (i < r) {
							sb.append("D");
							trigger = true;
							i++;
						}
					}
				}
				if (trigger) {
					for (; j > 1; j--)
						sb.append("L");
					trigger = false;
				} else {
					for (; j < c; j++)
						sb.append("R");
					trigger = true;
				}
				if (i < r) {
					sb.append("D");
					i++;
				} else
					break;
			}
		}
		System.out.println(sb);
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
	static final int IINF = Integer.MAX_VALUE;
}