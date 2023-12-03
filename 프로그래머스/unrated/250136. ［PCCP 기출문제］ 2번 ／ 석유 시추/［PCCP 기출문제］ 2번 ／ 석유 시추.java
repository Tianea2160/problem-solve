import java.util.*;

class Solution {
    class Node{
        int y;
        int x;
        
        public Node(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    public int solution(int[][] land) {
        int answer = 0;
        int[] dy = new int[]{1, -1, 0, 0};
        int[] dx = new int[]{0, 0, 1, -1};
        int n = land.length;
        int m = land[0].length;
        boolean[][] visit = new boolean[n][m];
        int[] columns = new int[m];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(land[i][j] == 0) continue;
                if(visit[i][j]) continue;
                
                visit[i][j] = true;
                int count = 1;
                Queue<Node> queue = new LinkedList<Node>();
                queue.add(new Node(i, j));
                Set<Integer> cols = new HashSet<>();
                cols.add(j);
                
                while(!queue.isEmpty()){
                    Node cur = queue.poll();
                    
                    for(int k = 0; k < 4; k++){
                        int ny = cur.y + dy[k];
                        int nx = cur.x + dx[k];
                        
                        if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                        if(visit[ny][nx] || land[ny][nx] == 0) continue;
                        
                        visit[ny][nx] = true;
                        queue.add(new Node(ny, nx));
                        count++;
                        cols.add(nx);
                    }
                }
                
                for(Integer idx : cols) {
                    columns[idx] += count;
                }
            }
        }
        
        
        return Arrays.stream(columns).max().getAsInt();
    }
}