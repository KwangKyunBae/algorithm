package baek1260;
import java.util.*;
public class baek1260 {
	static int n; //정점의개수
	static int m; //간선의개수
	static int v; //시작정점
	static ArrayList<ArrayList<Integer>> a;
	static boolean[] visit = new boolean[n+1];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		v = sc.nextInt();
		visit = new boolean[n+1];
		a = new ArrayList<>();
		for(int i=0; i<n+1; i++) {
			a.add(new ArrayList<Integer>());
		}
		for(int i=0; i<m; i++) {
			Integer x = sc.nextInt();
			Integer y = sc.nextInt();
			a.get(x).add(y);
			a.get(y).add(x);
		}
		for(int i=0; i<n; i++) {
			Collections.sort(a.get(i));
		}
		dfs(v);
		Arrays.fill(visit, false);
		System.out.println();
		bfs(v);
		
		
	}
	public static void dfs(int v) {
		visit[v] = true;
		System.out.print(v+" ");
		for(int i=0; i<a.get(v).size(); i++) {
			if(visit[a.get(v).get(i)] == false) {
				dfs(a.get(v).get(i));
			}
		}
	}
	
	public static void bfs(int v) {
		visit[v] = true; 
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(v); 
		
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			
			System.out.print(temp+" ");
			for(int x:a.get(temp)) {
			
				if(visit[x] == false) {
					
					queue.offer(x);
					visit[x] = true;
				}
			}
//			for(int i=0; i<a.get(v).size(); i++ ) {
//				if(visit[a.get(v).get(i)] == false ) {
//					queue.offer(a.get(v).get(i));
//					System.out.print(a.get(v).get(i)+"넣었다 ");
//					visit[a.get(v).get(i)] = true;
//					
//				}
//			}
		}
	}
}
