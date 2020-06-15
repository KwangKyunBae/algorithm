import java.util.*;
import java.io.*;

class Baek14502 {
//    static class Dot {
//        int x, y;
//
//        public Dot(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//    }

    static int n;
    static int m;
    static int[][] map;
    static int[][] copyed;
    static List<int[]> virusList = new ArrayList<>();
    static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    static int max = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        copyed = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2)
                    virusList.add(new int[] {i,j});
                	
            }
        }

        setWall(0, 0);
        System.out.println(max);
    }

    // 백트래킹을 이용하여 3개의 벽 세우기
    static void setWall(int start, int depth) {
        if (depth == 3) {
            // 맵 복사
            copyMap();
            
            // 바이러스 퍼트리기
//            for (int[] virus : virusList) {
//                spreadVirus(virus[0], virus[1]);
//            }
            Queue<int[]> queue = new LinkedList<>();
            for (int i = 0; i < n; i++) {
               
                for (int j = 0; j < m; j++) {
                   
                    if (map[i][j] == 2)
                        
                    	queue.offer(new int[] {i,j});
                }
            }
            while(!queue.isEmpty()) {
            	int temp[] = queue.poll();
            	for(int dir[] : dirs) {
            		int nx = temp[0] + dir[0];
                    int ny = temp[1] + dir[1];

                    if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                        if (copyed[nx][ny] == 0) {
                            
                            queue.offer(new int[] {nx,ny});
            copyed[nx][ny] = 2;
                        }
                    }

            	}
            }

            // 안전영역 크기 구하기
            max = Math.max(max, getSafeArea());
            return;
        }

        for (int i = start; i < n * m; i++) {
            int x = i / m;
            int y = i % m;

            if (map[x][y] == 0) {
                map[x][y] = 1;
                setWall(i + 1, depth + 1);
                map[x][y] = 0;
            }
        }
    }

    // 기존 맵을 유지하기 위해 바이러스 퍼트릴 맵 복사하기
    static void copyMap() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copyed[i][j] = map[i][j];
            }
        }
    }

    // DFS 로 바이러스 퍼트리기
    static void spreadVirus(int x, int y) {
        for (int dir[] : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];

            if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                if (copyed[nx][ny] == 0) {
                    copyed[nx][ny] = 2;
                    spreadVirus(nx, ny);
                }
            }
        }
    }
  
    static int getSafeArea() {
        int safe = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copyed[i][j] == 0)
                    safe++;
            }
        }
        return safe;
    }
}