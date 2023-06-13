import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 거리두기확인하기 {
    public int[] solution(String[][] places){
        // 1. 거리두기를 확인할 배열 설정
        int[] answer = new int[5];

        // 2. 모든 대기실을 확인
        for (int i = 0; i < 5; i++) {
            if(check(places[i]))
                answer[i] = 1;
            else
                answer[i] = 0;
        }
        return answer;
    }
    // 3. 거리두기를 확인할 메서드 정의 (5개의 String[] 가 주어짐)
    boolean check(String[] place){
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                // 배열의 요소를 하나씩 찾아서 P를 탐색
                if(place[r].charAt(c) == 'P'){
                    // P의 위치에서 BFS 탐색
                    if(bfs(place, r, c)== false) return false;
                }
            }
        }
        return true;
    }
    // 4. bfs탐색 ( 큐를 이용)
    boolean bfs(String[] place, int row, int col){
        boolean[][] visited = new boolean[5][5];
        Queue<Point> q = new LinkedList<>();
        visited[row][col] = true;
        q.add(new Point(row, col, 0));

        while (!q.isEmpty()) {
            Point curr = q.remove();
            
            // 거리가 2 이상이면 pass
            if(curr.dist > 2) continue;
            // 거리가 2 이하이고 P인 위치면 거리두기 위한 false 반환
            if(curr.dist != 0 && place[curr.row].charAt(curr.col) == 'P')
                return false;
            // 4방향으로 이동
            for (int i = 0; i < 4; i++) {
                int nr = curr.row + D[i][0], nc = curr.col + D[i][1];
                // 표밖을 넘어가면 pass
                if(nr < 0 || nr > 4 || nc < 0 || nc > 4) continue;
                // 큐에 넣었다면 중복으로 넣을 필요가 없음
                if(visited[nr][nc]) continue;
                if(place[nr].charAt(nc) == 'X') continue;
                visited[nr][nc] = true;
                q.add(new Point(nr, nc, curr.dist + 1));
            }
        }
        return true;
    }
    // 5. 큐에서 사용할 Point 클래스 생성
    class Point{
        int row;
        int col;
        int dist;
        Point(int r, int c, int d){
            row = r;
            col = c;
            dist = d;
        }
    }
    // 6. 상하좌우로 이동하기위한 배열 생성 (핼
    int[][] D = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    /***********************************************************************************************
     * 모범 풀이
     ***********************************************************************************************/
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visit;

    static int[] answer;

    public void dfs(int num, int x, int y, int count, String[] places){
        if (count > 2) return;
        if (count > 0 && places[x].charAt(y) == 'P'){
            //2칸 범위내에 다른 응시자가 있을 경우 거리두기 미준수로 0처리
            answer[num] = 0;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            //배열 범위 밖으로 초과하는지 여부 검사, 파티션으로 분리되어 있는 경우 상관 없음.
            if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && places[nx].charAt(ny) != 'X') {
                if (visit[nx][ny]) continue; //이미 방문한 곳일 경우 생략
                visit[nx][ny] = true;
                dfs(num, nx, ny, count + 1, places);
                visit[nx][ny] = false;
            }
        }
    }
    public int[] solution2(String[][] places) {
        answer = new int[places.length];
        for (int i = 0; i < places.length; i++) {
            answer[i] = 1;
        }

        for (int i = 0; i < places.length; i++) {
            visit = new boolean[5][5];
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (places[i][j].charAt(k) == 'P'){
                        visit[j][k] = true;
                        dfs(i, j, k, 0, places[i]);
                        visit[j][k] = false;
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        거리두기확인하기 sol = new 거리두기확인하기();
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                             {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                             {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                             {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                             {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};

        System.out.println(Arrays.deepToString(places[0]));
        System.out.println(Arrays.toString(sol.solution(places)));
        System.out.println(Arrays.toString(sol.solution2(places)));
        }
}
