import java.util.*;
public class Main {
	static int n;
	static int[][] map;
	static boolean[][] visit;
	static int[][] dirs = { {-1,0},{1,0},{0,-1},{0,1} }; //╩С го аб ©Л
	static List<Integer> list = new LinkedList<Integer>();
	public static void main(String[] args) {
		int island = 0;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		visit = new boolean[n][n];
		for(int i=0; i<n; i++) {
			String temp = sc.next();
			for(int j=0; j<n; j++) {
				map[i][j] = temp.charAt(j) - 48;
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j] ==1) {
					island++;
					bfs(i,j);
				}
			}
		}
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		
	}
	public static void bfs(int i,int j) {
		int count=0;
		map[i][j] = 0;
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {i,j});
		
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			for(int[] dir: dirs) {
				int x = temp[0] + dir[0];
				int y = temp[1] + dir[1];
				if(x>=0 && x<n && y>=0 && y<n && map[x][y] == 1) {
					queue.offer(new int[] {x,y});
					map[x][y] = 0;
					count++;
				}
			}
		}
		list.add(count+1);
	}
}
