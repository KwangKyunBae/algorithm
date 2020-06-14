import java.util.*;
public class baek1697 {
	static int map[];
	static int n;
	static int k;
	public static void main(String[] args) {
		map = new int[100000];
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		if(n==k) {
			System.out.println(0);
		}else {
			bfs();
		}
		
	}
	
	public static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(n);
		map[n] = 1;
		
		while(!queue.isEmpty()) {
			Integer temp = queue.poll();
			for(int i=0; i<3; i++) {
				int next = 0;
				if(i==0) {
					next = temp-1;
				}else if(i == 1) {
					next = temp+1;
				}else if(i==2) {
					next = temp*2;
				}
				if(next == k) {
					System.out.println(map[temp]);
					return ;
				}
				if(next>=0 && next<map.length && map[next] == 0) {
					queue.offer(next);
					map[next] = map[temp] +1;
				}
			}
		}
	}
}
