package baek7576;
import java.util.*;
import java.io.*;
public class baek7576 {
	static int m,n;
	static int[][] box;
	static int[][] dirs = { {-1,0},{1,0},{0,-1},{0,1}};
	static Queue<int[]> q;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		q = new LinkedList<int[]>();
		n = sc.nextInt();//가로
		m = sc.nextInt();//세로
		box = new int[m][n];
		for(int i=0; i<m; i++) {
			
			for(int j=0; j<n; j++) {
				box[i][j] = sc.nextInt();
			}
		}
		for(int i=0; i<m; i++) {
			
			for(int j=0; j<n; j++) {
				if(box[i][j] == 1) {
					q.offer(new int[] {i,j });
				}
			}	
		}
		bfs();
		for(int i=0; i<m; i++) {
			
			for(int j=0; j<n; j++) {
				System.out.print(box[i][j]);
			}
			System.out.println();
		}
		
	}
	
	static void bfs() {
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			for(int dir[] : dirs) {
				int x = temp[0] + dir[0];
				int y = temp[1] + dir[1];
				if(x>=0 && x<m && y>=0 && y<n) {
					if(box[x][y] == 0) {
						q.offer(new int[] {x,y});
						box[x][y] = box[temp[0]][temp[1]] + 1;
					}
				}
			}
		}
	}
}
