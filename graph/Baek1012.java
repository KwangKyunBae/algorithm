import java.util.*;
public class Baek1012 {
	static int t,n,m,k;
	static int[][] map;
	static int[][] dirs = { {-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		
		
		for(int tc=0; tc<t; tc++) {
			m = sc.nextInt();//가로
			n = sc.nextInt();//세로
			k = sc.nextInt();
			map = new int[n][m];
			int count = 0;
			for(int i=0; i<k; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				map[y][x] = 1;
			}
			for(int a=0; a<n; a++) {
				for(int b=0; b<m; b++) {
					if(map[a][b] == 1) {
						count++;
						bfs(a,b);
					}
				}
			}
			System.out.println(count);
		}
	}
	
	public static void bfs(int a,int b) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {a,b});
		map[a][b] = 0;
		
		while(!queue.isEmpty()) {
			int temp[] = queue.poll();
			for(int[] dir:dirs) {
				int x = temp[0]+dir[0];
				int y = temp[1]+dir[1];
				if(x>=0 && x<n && y>=0 && y<m) {
					if(map[x][y] == 1) {
						queue.offer(new int[] {x,y});
						map[x][y] = 0;
					}
				}
			}
		}
	}
}
