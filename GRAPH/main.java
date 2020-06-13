import java.util.*;
public class main {
	static int n;
	static int m;
	static int[][] map;
	static boolean[][] visit;
	static int dirs[][] = { {-1,0},{1,0},{0,1},{0,-1}}; //аб ©Л ╩С го
	public static void main(String argv[]) {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		visit = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			String temp = sc.next();
			for(int j=0; j<m; j++) {
				map[i][j] = temp.charAt(j)-48;
			}
		}
		bfs();
		System.out.println(map[n-1][m-1]);
		
	}
	public static void bfs() {
		
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {0,0});
		
		
		while(!queue.isEmpty()) {
			
			int temp[] = queue.poll();
			visit[0][0] = true;
			for(int dir[] : dirs) {
				int x = temp[0]+dir[0];
				int y = temp[1]+dir[1];
				if(x>=0 && x <=n-1 && y >=0 && y <=m-1) {
					if(map[temp[0]+dir[0]][temp[1]+dir[1]] == 1 && visit[temp[0]+dir[0]][temp[1]+dir[1]] == false) {
						visit[temp[0]+dir[0]][temp[1]+dir[1]] = true;
						queue.offer(new int[] {temp[0]+dir[0],temp[1]+dir[1]});
						map[temp[0]+dir[0]][temp[1]+dir[1]] = map[temp[0]][temp[1]] +1;
					}
					
				}
			}
		}
	}
}
